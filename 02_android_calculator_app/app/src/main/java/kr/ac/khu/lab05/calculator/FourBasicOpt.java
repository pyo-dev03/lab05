package kr.ac.khu.lab05.calculator;

/**
 * 사칙연산 클래스 - 실습 1(TDD)의 FourBasicOpt.py 를 Java 로 옮긴 것.
 * 0으로 나누면 예외 대신 0 을 반환한다 (test_divide_02 와 같은 규칙).
 */
public class FourBasicOpt {

    public double add(double x, double y) {
        return x + y;
    }

    public double subtract(double x, double y) {
        return x - y;
    }

    public double divide(double x, double y) {
        if (y == 0) {
            return 0;
        }
        return x / y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }

    /** 결과를 화면용 문자열로 변환 (정수면 소수점 없이, 아니면 불필요한 0 제거). */
    public static String format(double value) {
        if (value == Math.rint(value) && Math.abs(value) < 1e15) {
            return String.valueOf((long) value);
        }
        String s = String.format(java.util.Locale.US, "%.10f", value);
        s = s.replaceAll("0+$", "");
        if (s.endsWith(".")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
