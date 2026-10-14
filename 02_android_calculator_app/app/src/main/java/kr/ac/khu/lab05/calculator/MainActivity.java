package kr.ac.khu.lab05.calculator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Lab05 - 사칙연산을 수행하는 안드로이드 앱.
 * 숫자 두 개를 입력하고 + − × ÷ 버튼을 누르면 FourBasicOpt 로 계산해 결과를 보여 준다.
 */
public class MainActivity extends Activity {

    private static final int MAX_HISTORY = 6;

    private final FourBasicOpt fourOpt = new FourBasicOpt();
    private final Deque<String> history = new ArrayDeque<>();

    private EditText inputA;
    private EditText inputB;
    private TextView resultText;
    private TextView historyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        resultText = findViewById(R.id.resultText);
        historyText = findViewById(R.id.historyText);

        findViewById(R.id.btnAdd).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> calculate('*'));
        findViewById(R.id.btnDivide).setOnClickListener(v -> calculate('/'));
        findViewById(R.id.btnClear).setOnClickListener(v -> clearAll());

        // Android 15(API 35)+ edge-to-edge: 시스템 바 크기만큼 여백을 준다.
        View root = findViewById(R.id.root);
        root.setOnApplyWindowInsetsListener((v, insets) -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                Insets bars = insets.getInsets(WindowInsets.Type.systemBars());
                v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            } else {
                v.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(),
                        insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            }
            return insets;
        });
    }

    private void calculate(char op) {
        hideKeyboard();
        Double a = parse(inputA);
        Double b = parse(inputB);
        if (a == null || b == null) {
            resultText.setText(R.string.error_input);
            return;
        }

        double result;
        String symbol;
        switch (op) {
            case '+': result = fourOpt.add(a, b); symbol = "+"; break;
            case '-': result = fourOpt.subtract(a, b); symbol = "−"; break;
            case '*': result = fourOpt.multiply(a, b); symbol = "×"; break;
            default: result = fourOpt.divide(a, b); symbol = "÷"; break;
        }

        String line = FourBasicOpt.format(a) + " " + symbol + " " + FourBasicOpt.format(b)
                + " = " + FourBasicOpt.format(result);
        if (op == '/' && b == 0) {
            line += getString(R.string.divide_by_zero_note);
        }
        resultText.setText(line);

        history.addFirst(line);
        while (history.size() > MAX_HISTORY) {
            history.removeLast();
        }
        historyText.setText(String.join("\n", history));
    }

    private Double parse(EditText field) {
        String s = field.getText().toString().trim();
        if (s.isEmpty()) {
            field.setError(getString(R.string.error_empty));
            return null;
        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            field.setError(getString(R.string.error_number));
            return null;
        }
    }

    private void clearAll() {
        inputA.setText("");
        inputB.setText("");
        resultText.setText(R.string.result_placeholder);
        history.clear();
        historyText.setText("");
        inputA.requestFocus();
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View focus = getCurrentFocus();
        if (imm != null && focus != null) {
            imm.hideSoftInputFromWindow(focus.getWindowToken(), 0);
        }
    }
}
