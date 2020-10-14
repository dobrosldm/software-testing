package test;

import main.LogarithmicFuncs;
import main.SystemOfFuncs;
import main.TrigonometricFuncs;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLevel1 {
    public static double EPSILON = 1E-10;
    public static double PERIOD = 2 * Math.PI;
    public double DELTA = 1E-4;
    public static SystemOfFuncs sof;

    @BeforeClass
    public static void prepare() {
        sof = mock(SystemOfFuncs.class, CALLS_REAL_METHODS);
        sof.setLogFunc(new LogarithmicFuncs());
        sof.setTrigFunc(new TrigonometricFuncs());

        // положительная часть функции
        // пересекает ох 2 раза
        // при х=0 стремится к бесконечности
        // левая граничная точка
        when(sof.function2(0 + EPSILON)).thenReturn(Double.NEGATIVE_INFINITY);
        // точка из возрастающего интервала (0; 1)
        when(sof.function2(0.65)).thenReturn(-1.15529);
        // выколотая точка на ох
        when(sof.function2(1.0)).thenReturn(Double.NaN);
        // точка из возрастающего интервала (1; 1.290874)
        when(sof.function2(1.15)).thenReturn(0.10262);
        // 1-ый экстремум
        when(sof.function2(1.29087)).thenReturn(0.12466);
        // точка из убывающего интервала (1.290874; 2.151058)
        when(sof.function2(1.95)).thenReturn(0.01204);
        // пересечение с ох (он же 2-ой экстремум)
        when(sof.function2(2.15)).thenReturn(0.0);
        // точка из возрастающего интервала (2.151058; +inf)
        when(sof.function2(3.55)).thenReturn(0.59545);

        // отрицательная часть функции
        // правая граничная точка (в эпсилон окрестности и -период)
        when(sof.function1(0.0)).thenReturn(Double.NaN);
        when(sof.function1(0.0 - EPSILON)).thenReturn(0.99999);
        when(sof.function1(0.0 - PERIOD)).thenReturn(Double.NaN);
        when(sof.function1(0.0 - EPSILON - PERIOD)).thenReturn(0.99999);
        when(sof.function1(0.0 - 10 * PERIOD)).thenReturn(Double.NaN);
        when(sof.function1(0.0 - EPSILON - 10 * PERIOD)).thenReturn(0.99999);
        // за один свой период 2pi пересекает ох 2 раза
        when(sof.function1(-0.63641)).thenReturn(0.0);
        when(sof.function1(-0.63641 - PERIOD)).thenReturn(0.0);
        when(sof.function1(-0.63641 - 10 * PERIOD)).thenReturn(0.0);
        when(sof.function1(-3.77801)).thenReturn(0.0);
        when(sof.function1(-3.77801 - PERIOD)).thenReturn(0.0);
        when(sof.function1(-3.77801 - 10 * PERIOD)).thenReturn(0.0);
        // имеет 2 экстремума на одном периоде
        // первый экстремум
        when(sof.function1(-1.8275)).thenReturn(2.12601);
        when(sof.function1(-1.8275 - PERIOD)).thenReturn(2.12601);
        when(sof.function1(-1.8275 - 10 * PERIOD)).thenReturn(2.12601);
        // второй экстремум
        when(sof.function1(-4.9697)).thenReturn(-2.12601);
        when(sof.function1(-4.9697 - PERIOD)).thenReturn(-2.12601);
        when(sof.function1(-4.9697 - 10 * PERIOD)).thenReturn(-2.12601);
        // на одном своём периоде имеет 2 интревала возрастания (по 2 точки для каждого)
        // первый
        when(sof.function1(-6.01)).thenReturn(1.50252);
        when(sof.function1(-6.01 - PERIOD)).thenReturn(1.50252);
        when(sof.function1(-6.01 - 10 * PERIOD)).thenReturn(1.50252);
        when(sof.function1(-5.65)).thenReturn(1.98958);
        when(sof.function1(-5.65 - PERIOD)).thenReturn(1.98958);
        when(sof.function1(-5.65 - 10 * PERIOD)).thenReturn(1.98958);
        // второй
        when(sof.function1(-1.62)).thenReturn(-2.04676);
        when(sof.function1(-1.62 - PERIOD)).thenReturn(-2.04676);
        when(sof.function1(-1.62 - 10 * PERIOD)).thenReturn(-2.04676);
        when(sof.function1(-0.69)).thenReturn(0.50183);
        when(sof.function1(-0.69 - PERIOD)).thenReturn(0.50183);
        when(sof.function1(-0.69 - 10 * PERIOD)).thenReturn(0.50183);
        // и один интервал убывания
        when(sof.function1(-4.59)).thenReturn(1.86296);
        when(sof.function1(-4.59 - PERIOD)).thenReturn(1.86296);
        when(sof.function1(-4.59 - 10 * PERIOD)).thenReturn(1.86296);
        when(sof.function1(-2.92)).thenReturn(-1.41512);
        when(sof.function1(-2.92 - PERIOD)).thenReturn(-1.41512);
        when(sof.function1(-2.92 - 10 * PERIOD)).thenReturn(-1.41512);
    }

    @Test
    public void testUpInterval1() {
        assertEquals(-1.15529, sof.system(0.65), DELTA);
    }

    @Test
    public void testNotIncludedPoint() {
        assertEquals(Double.NaN, sof.system(1.0), DELTA);
    }

    @Test
    public void testUpInterval2() {
        assertEquals(0.10262, sof.system(1.15), DELTA);
    }

    @Test
    public void testExtremum1() {
        assertEquals(0.12466, sof.system(1.29087), DELTA);
    }

    @Test
    public void testUpInterval3() {
        assertEquals(0.01204, sof.system(1.95), DELTA);
    }

    @Test
    public void testExtremum2() {
        assertEquals(0.0, sof.system(2.15), DELTA);
    }

    @Test
    public void testUpInterval4() {
        assertEquals(0.59545, sof.system(3.55), DELTA);
    }

    @Test
    public void testRightBorder() {
        assertEquals(Double.NaN, sof.system(0.0), DELTA);
    }

    @Test
    public void testRightBorderMinusEps() {
        assertEquals(0.99999, sof.system(0.0 - EPSILON), DELTA);
    }

    @Test
    public void testRightBorderMinusPeriod() {
        assertEquals(Double.NaN, sof.system(0.0 - PERIOD), DELTA);
    }

    @Test
    public void testRightBorderMinusEpsMinusPeriod() {
        assertEquals(0.99999, sof.system(0.0 - EPSILON - PERIOD), DELTA);
    }

    @Test
    public void testRightBorderMinusTenPeriod() {
        assertEquals(Double.NaN, sof.system(0.0 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testRightBorderMinusEpsMinusTenPeriod() {
        assertEquals(0.99999, sof.system(0.0 - EPSILON - 10 * PERIOD), DELTA);
    }

    @Test
    public void testCrossXPoint1() {
        assertEquals(0.0, sof.system(-0.63641), DELTA);
    }

    @Test
    public void testCrossXPoint1MinusPeriod() {
        assertEquals(0.0, sof.system(-0.63641 - PERIOD), DELTA);
    }

    @Test
    public void testCrossXPoint1Minus10Period() {
        assertEquals(0.0, sof.system(-0.63641 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testCrossXPoint2() {
        assertEquals(0.0, sof.system(-3.77801), DELTA);
    }

    @Test
    public void testCrossXPoint2MinusPeriod() {
        assertEquals(0.0, sof.system(-3.77801 - PERIOD), DELTA);
    }

    @Test
    public void testCrossXPoint2Minus10Period() {
        assertEquals(0.0, sof.system(-3.77801 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testFirstExtremum() {
        assertEquals(2.12601, sof.system(-1.8275), DELTA);
    }

    @Test
    public void testFirstExtremumMinusPeriod() {
        assertEquals(2.12601, sof.system(-1.8275 - PERIOD), DELTA);
    }

    @Test
    public void testFirstExtremumMinusTenPeriod() {
        assertEquals(2.12601, sof.system(-1.8275 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testSecondExtremum() {
        assertEquals(-2.12601, sof.system(-4.9697), DELTA);
    }

    @Test
    public void testSecondExtremumMinusPeriod() {
        assertEquals(-2.12601, sof.system(-4.9697 - PERIOD), DELTA);
    }

    @Test
    public void testSecondExtremumMinusTenPeriod() {
        assertEquals(-2.12601, sof.system(-4.9697 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point1() {
        assertEquals(1.50252, sof.system(-6.01), DELTA);
    }

    @Test
    public void testUpInterval1Point1MinusPeriod() {
        assertEquals(1.50252, sof.system(-6.01 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point1MinusTenPeriod() {
        assertEquals(1.50252, sof.system(-6.01 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point2() {
        assertEquals(1.98958, sof.system(-5.65), DELTA);
    }

    @Test
    public void testUpInterval1Point2MinusPeriod() {
        assertEquals(1.98958, sof.system(-5.65 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point2MinusTenPeriod() {
        assertEquals(1.98958, sof.system(-5.65 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point1() {
        assertEquals(-2.04676, sof.system(-1.62), DELTA);
    }

    @Test
    public void testUpInterval2Point1MinusPeriod() {
        assertEquals(-2.04676, sof.system(-1.62 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point1MinusTenPeriod() {
        assertEquals(-2.04676, sof.system(-1.62 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point2() {
        assertEquals(0.50183, sof.system(-0.69), DELTA);
    }

    @Test
    public void testUpInterval2Point2MinusPeriod() {
        assertEquals(0.50183, sof.system(-0.69 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point2MinusTenPeriod() {
        assertEquals(0.50183, sof.system(-0.69 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint1() {
        assertEquals(1.86296, sof.system(-4.59), DELTA);
    }

    @Test
    public void testDownIntervalPoint1MinusPeriod() {
        assertEquals(1.86296, sof.system(-4.59 - PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint1MinusTenPeriod() {
        assertEquals(1.86296, sof.system(-4.59 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint2() {
        assertEquals(-1.41512, sof.system(-2.92), DELTA);
    }

    @Test
    public void testDownIntervalPoint2MinusPeriod() {
        assertEquals(-1.41512, sof.system(-2.92 - PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint2MinusTenPeriod() {
        assertEquals(-1.41512, sof.system(-2.92 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testLeftBorderPlusEps() {
        assertEquals(Double.NEGATIVE_INFINITY, sof.system(0 + EPSILON), DELTA);
    }
}
