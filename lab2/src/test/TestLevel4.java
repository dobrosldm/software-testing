package test;

import main.SystemOfFuncs;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLevel4 {
    public static double EPSILON = 1E-10;
    public static double PERIOD = 2 * Math.PI;
    public double DELTA = 1E-4;
    public static SystemOfFuncs sof;

    @BeforeClass
    public static void prepare() {
        sof = new SystemOfFuncs();
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
        assertEquals(-2.1260, sof.system(-1.8275), DELTA);
    }

    @Test
    public void testFirstExtremumMinusPeriod() {
        assertEquals(-2.12600, sof.system(-1.8275 - PERIOD), DELTA);
    }

    @Test
    public void testFirstExtremumMinusTenPeriod() {
        assertEquals(-2.1260, sof.system(-1.8275 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testSecondExtremum() {
        assertEquals(1.617045, sof.system(-4.9697), DELTA);
    }

    @Test
    public void testSecondExtremumMinusPeriod() {
        assertEquals(1.617045, sof.system(-4.9697 - PERIOD), DELTA);
    }

    @Test
    public void testSecondExtremumMinusTenPeriod() {
        assertEquals(1.61704598, sof.system(-4.9697 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point1() {
        assertEquals(-0.6734, sof.system(-6.01), DELTA);
    }

    @Test
    public void testUpInterval1Point1MinusPeriod() {
        assertEquals(-0.673477, sof.system(-6.01 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point1MinusTenPeriod() {
        assertEquals(-0.6734, sof.system(-6.01 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point2() {
        assertEquals(-0.007255, sof.system(-5.65), DELTA);
    }

    @Test
    public void testUpInterval1Point2MinusPeriod() {
        assertEquals(-0.00725, sof.system(-5.65 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval1Point2MinusTenPeriod() {
        assertEquals(-0.007255, sof.system(-5.65 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point1() {
        assertEquals(-2.0443471, sof.system(-1.62), DELTA);
    }

    @Test
    public void testUpInterval2Point1MinusPeriod() {
        assertEquals(-2.04434, sof.system(-1.62 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point1MinusTenPeriod() {
        assertEquals(-2.0443471883, sof.system(-1.62 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point2() {
        assertEquals(-0.123203, sof.system(-0.69), DELTA);
    }

    @Test
    public void testUpInterval2Point2MinusPeriod() {
        assertEquals(-0.1232, sof.system(-0.69 - PERIOD), DELTA);
    }

    @Test
    public void testUpInterval2Point2MinusTenPeriod() {
        assertEquals(-0.1232030, sof.system(-0.69 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint1() {
        assertEquals(1.84816, sof.system(-4.59), DELTA);
    }

    @Test
    public void testDownIntervalPoint1MinusPeriod() {
        assertEquals(1.84816, sof.system(-4.59 - PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint1MinusTenPeriod() {
        assertEquals(1.848163, sof.system(-4.59 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint2() {
        assertEquals(-1.20594, sof.system(-2.92), DELTA);
    }

    @Test
    public void testDownIntervalPoint2MinusPeriod() {
        assertEquals(-1.20594, sof.system(-2.92 - PERIOD), DELTA);
    }

    @Test
    public void testDownIntervalPoint2MinusTenPeriod() {
        assertEquals(-1.20594, sof.system(-2.92 - 10 * PERIOD), DELTA);
    }

    @Test
    public void testLeftBorderPlusEps() {
        assertEquals(-16887.4971, sof.system(0 + EPSILON), DELTA);
    }
}
