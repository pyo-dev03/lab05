package kr.ac.khu.lab05.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** 실습 1 test_FourBasicOpt.py 와 같은 테스트 케이스 (./gradlew testDebugUnitTest). */
public class FourBasicOptTest {

    private static final double EPS = 1e-9;
    private final FourBasicOpt fourOpt = new FourBasicOpt();

    @Test public void add01() { assertEquals(110, fourOpt.add(100, 10), EPS); }
    @Test public void add02() { assertEquals(90, fourOpt.add(100, -10), EPS); }
    @Test public void subtract01() { assertEquals(90, fourOpt.subtract(100, 10), EPS); }
    @Test public void subtract02() { assertEquals(110, fourOpt.subtract(100, -10), EPS); }
    @Test public void divide01() { assertEquals(10, fourOpt.divide(100, 10), EPS); }
    @Test public void divide02() { assertEquals(0, fourOpt.divide(100, 0), EPS); }
    @Test public void multiply01() { assertEquals(1000, fourOpt.multiply(100, 10), EPS); }
    @Test public void multiply02() { assertEquals(100, fourOpt.multiply(100, 1), EPS); }

    @Test public void format01() { assertEquals("17", FourBasicOpt.format(17.0)); }
    @Test public void format02() { assertEquals("2.4", FourBasicOpt.format(12.0 / 5.0)); }
}
