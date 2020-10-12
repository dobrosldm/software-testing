package test;

import main.task1.Asin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTask1 {
    public static final double EPS  = 1E-7;
    public static final double DELTA = 1E-6;

    @Test
    public void testNegativeInfinity(){
        double x = Double.NEGATIVE_INFINITY;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testBelowNegativeOne(){
        double x = -13;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testNegativeOne(){
        double x = -1;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = -1 + DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = -1 - DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testNegativeZone1(){
        double x = -0.97;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testNegativeZone2(){
        double x = -0.96;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testNegativeBorder(){
        double x = -0.8;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = -0.8 + DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = -0.8 - DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testNegativeZone3(){
        double x = -0.7;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testNegativeZone4(){
        double x = -0.3;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testZero(){
        double x = 0;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = 0 + DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = 0 - DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testPositiveZone4(){
        double x = 0.3;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testPositiveZone3(){
        double x = 0.7;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testPositiveBorder(){
        double x = 0.8;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = 0.8 + DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = 0.8 - DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testPositiveZone2(){
        double x = 0.96;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testPositiveZone1(){
        double x = 0.97;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testPositiveOne(){
        double x = 1;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = 1 + DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
        x = 1 - DELTA;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testAbovePositiveOne(){
        double x = 7;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testPositiveInfinity(){
        double x = Double.POSITIVE_INFINITY;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }

    @Test
    public void testNaN(){
        double x = Double.NaN;
        assertEquals(Math.asin(x), Asin.asin(x, EPS), DELTA);
    }
}
