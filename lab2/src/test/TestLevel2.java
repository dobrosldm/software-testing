package test;

import main.LogarithmicFuncs;
import main.SystemOfFuncs;
import main.TrigonometricFuncs;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLevel2 {
    public static double EPSILON = 1E-10;
    public static double PERIOD = 2 * Math.PI;
    public double DELTA = 1E-4;
    public static SystemOfFuncs sof;
    public static LogarithmicFuncs lf;
    public static TrigonometricFuncs tf;

    @BeforeClass
    public static void prepare() {
        sof = new SystemOfFuncs();
        tf = mock(TrigonometricFuncs.class, CALLS_REAL_METHODS);
        lf = mock(LogarithmicFuncs.class, CALLS_REAL_METHODS);
        sof.setTrigFunc(tf);
        sof.setLogFunc(lf);

        // положительная часть функции
        // пересекает ох 2 раза
        // при х=0 стремится к бесконечности
        // левая граничная точка
        when(lf.ln(0 + EPSILON)).thenReturn(-20.307578654910635);
        when(lf.log_2(0 + EPSILON)).thenReturn(-29.297643453424314);
        when(lf.log_3(0 + EPSILON)).thenReturn(-18.484754741732942);
        when(lf.log_5(0 + EPSILON)).thenReturn(-12.617808149212413);
        when(lf.log_10(0 + EPSILON)).thenReturn(-8.819469436218975);
        // точка из возрастающего интервала (0; 1)
        when(lf.ln(0.65)).thenReturn(-0.43078290869747976);
        when(lf.log_2(0.65)).thenReturn(-0.6214883753162713);
        when(lf.log_3(0.65)).thenReturn(-0.3921155027646643);
        when(lf.log_5(0.65)).thenReturn(-0.2676604723916755);
        when(lf.log_10(0.65)).thenReturn(-0.1870866419608434);
        // выколотая точка на ох
        when(lf.ln(1.0)).thenReturn(0.0);
        when(lf.log_2(1.0)).thenReturn(0.0);
        when(lf.log_3(1.0)).thenReturn(0.0);
        when(lf.log_5(1.0)).thenReturn(0.0);
        when(lf.log_10(1.0)).thenReturn(0.0);
        // точка из возрастающего интервала (1; 1.290874)
        when(lf.ln(1.15)).thenReturn(0.13976194006761902);
        when(lf.log_2(1.15)).thenReturn(0.20163386083794926);
        when(lf.log_3(1.15)).thenReturn(0.12721680059843082);
        when(lf.log_5(1.15)).thenReturn(0.08683897653689529);
        when(lf.log_10(1.15)).thenReturn(0.0606978399404091);
        // 1-ый экстремум
        when(lf.ln(1.29087)).thenReturn(0.25531640772893405);
        when(lf.log_2(1.29087)).thenReturn(0.36834372076370686);
        when(lf.log_3(1.29087)).thenReturn(0.23239901017290449);
        when(lf.log_5(1.29087)).thenReturn(0.15863700467759975);
        when(lf.log_10(1.29087)).thenReturn(0.11088250809192618);
        // точка из убывающего интервала (1.290874; 2.151058)
        when(lf.ln(1.95)).thenReturn(0.6678293664774654);
        when(lf.log_2(1.95)).thenReturn(0.9634741294995182);
        when(lf.log_3(1.95)).thenReturn(0.6078844877785435);
        when(lf.log_5(1.95)).thenReturn(0.4149457188282306);
        when(lf.log_10(1.95)).thenReturn(0.2900346115283041);
        // пересечение с ох (он же 2-ой экстремум)
        when(lf.ln(2.15)).thenReturn(0.7654678372822004);
        when(lf.log_2(2.15)).thenReturn(1.104336669223474);
        when(lf.log_3(2.15)).thenReturn(0.6967588541839618);
        when(lf.log_5(2.15)).thenReturn(0.47561191215102316);
        when(lf.log_10(2.15)).thenReturn(0.3324384610317154);
        // точка из возрастающего интервала (2.151058; +inf)
        when(lf.ln(3.55)).thenReturn(1.2669475985058474);
        when(lf.log_2(3.55)).thenReturn(1.82781904460189);
        when(lf.log_3(3.55)).thenReturn(1.1532254054988016);
        when(lf.log_5(3.55)).thenReturn(0.7871988091099444);
        when(lf.log_10(3.55)).thenReturn(0.5502283562305139);

        // отрицательная часть функции
        // правая граничная точка (в эпсилон окрестности и -период)
        when(tf.sin(0.0)).thenReturn(0.0);
        when(tf.cos(0.0)).thenReturn(1.0);
        when(tf.cot(0.0)).thenReturn(Double.NaN);
        when(tf.csc(0.0)).thenReturn(Double.NaN);
        when(tf.sin(0.0 - EPSILON)).thenReturn(-1.0E-10);
        when(tf.cos(0.0 - EPSILON)).thenReturn(1.0);
        when(tf.cot(0.0 - EPSILON)).thenReturn(-1.0E10);
        when(tf.csc(0.0 - EPSILON)).thenReturn(-1.0E10);
        when(tf.sin(0.0 - 10 * PERIOD)).thenReturn(0.0);
        when(tf.cos(0.0 - 10 * PERIOD)).thenReturn(1.0);
        when(tf.cot(0.0 - 10 * PERIOD)).thenReturn(Double.NaN);
        when(tf.csc(0.0 - 10 * PERIOD)).thenReturn(Double.NaN);
        // за один свой период 2pi пересекает ох 2 раза
        when(tf.sin(-0.63641)).thenReturn(-0.5943120754232475);
        when(tf.cos(-0.63641)).thenReturn(0.8042345161743011);
        when(tf.cot(-0.63641)).thenReturn(-1.3532192082779986);
        when(tf.csc(-0.63641)).thenReturn(-1.6826176706704745);
        when(tf.sin(-0.63641 - 10 * PERIOD)).thenReturn(-0.5943120754232458);
        when(tf.cos(-0.63641 - 10 * PERIOD)).thenReturn(0.8042345161743023);
        when(tf.cot(-0.63641 - 10 * PERIOD)).thenReturn(-1.3532192082780043);
        when(tf.csc(-0.63641 - 10 * PERIOD)).thenReturn(-1.6826176706704792);
        when(tf.sin(-3.77801)).thenReturn(0.5943179836613856);
        when(tf.cos(-3.77801)).thenReturn(-0.8042301500793569);
        when(tf.cot(-3.77801)).thenReturn(-1.3531984092501725);
        when(tf.csc(-3.77801)).thenReturn(1.682600943419799);
        when(tf.sin(-3.77801 - 10 * PERIOD)).thenReturn(0.5943179836613819);
        when(tf.cos(-3.77801 - 10 * PERIOD)).thenReturn(-0.8042301500793597);
        when(tf.cot(-3.77801 - 10 * PERIOD)).thenReturn(-1.3531984092501854);
        when(tf.csc(-3.77801 - 10 * PERIOD)).thenReturn(1.6826009434198093);
        // имеет 2 экстремума на одном периоде
        // первый экстремум
        when(tf.sin(-1.8275)).thenReturn(-0.967232147751734);
        when(tf.cos(-1.8275)).thenReturn(-0.2538936240939652);
        when(tf.cot(-1.8275)).thenReturn(0.2624950221972293);
        when(tf.csc(-1.8275)).thenReturn(-1.0338779602440145);
        when(tf.sin(-1.8275 - 10 * PERIOD)).thenReturn(-0.9672321477517337);
        when(tf.cos(-1.8275 - 10 * PERIOD)).thenReturn(-0.25389362409396654);
        when(tf.cot(-1.8275 - 10 * PERIOD)).thenReturn(0.26249502219723075);
        when(tf.csc(-1.8275 - 10 * PERIOD)).thenReturn(-1.033877960244015);
        // второй экстремум
        when(tf.sin(-4.9697)).thenReturn(0.967077768084893);
        when(tf.cos(-4.9697)).thenReturn(-0.25448102183845056);
        when(tf.cot(-4.9697)).thenReturn(-0.2631443201743745);
        when(tf.csc(-4.9697)).thenReturn(1.0340430035738521);
        when(tf.sin(-4.9697 - 10 * PERIOD)).thenReturn(0.9670777680848944);
        when(tf.cos(-4.9697 - 10 * PERIOD)).thenReturn(-0.2544810218384451);
        when(tf.cot(-4.9697 - 10 * PERIOD)).thenReturn(-0.26314432017436845);
        when(tf.csc(-4.9697 - 10 * PERIOD)).thenReturn(1.0340430035738506);
        // на одном своём периоде имеет 2 интревала возрастания
        // первый
        when(tf.sin(-5.65)).thenReturn(0.5917155806067156);
        when(tf.cos(-5.65)).thenReturn(-0.8061468052825475);
        when(tf.cot(-5.65)).thenReturn(-1.3623890120587407);
        when(tf.csc(-5.65)).thenReturn(1.6900011302299154);
        when(tf.sin(-5.65 - 10 * PERIOD)).thenReturn(0.5917155806067003);
        when(tf.cos(-5.65 - 10 * PERIOD)).thenReturn(-0.8061468052825587);
        when(tf.cot(-5.65 - 10 * PERIOD)).thenReturn(-1.362389012058795);
        when(tf.csc(-5.65 - 10 * PERIOD)).thenReturn(1.6900011302299593);
        // второй
        when(tf.sin(-0.69)).thenReturn(-0.6365371822206805);
        when(tf.cos(-0.69)).thenReturn(0.7712460149981692);
        when(tf.cot(-0.69)).thenReturn(-1.2116275946481736);
        when(tf.csc(-0.69)).thenReturn(-1.5710001362549013);
        when(tf.sin(-0.69 - 10 * PERIOD)).thenReturn(-0.6365371822206786);
        when(tf.cos(-0.69 - 10 * PERIOD)).thenReturn(0.7712460149981708);
        when(tf.cot(-0.69 - 10 * PERIOD)).thenReturn(-1.2116275946481796);
        when(tf.csc(-0.69 - 10 * PERIOD)).thenReturn(-1.571000136254906);
        // и один интервал убывания
        when(tf.sin(-2.92)).thenReturn(-0.2197836121109823);
        when(tf.cos(-2.92)).thenReturn(-0.9755486476067963);
        when(tf.cot(-2.92)).thenReturn(4.438677835152612);
        when(tf.csc(-2.92)).thenReturn(-4.549929771356376);
        when(tf.sin(-2.92 - 10 * PERIOD)).thenReturn(-0.2197836121109801);
        when(tf.cos(-2.92 - 10 * PERIOD)).thenReturn(-0.9755486476067968);
        when(tf.cot(-2.92 - 10 * PERIOD)).thenReturn(4.438677835152658);
        when(tf.csc(-2.92 - 10 * PERIOD)).thenReturn(-4.549929771356421);
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
