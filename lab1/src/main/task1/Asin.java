package main.task1;

import test.TestTask1;

public class Asin {
    private static double doubleFact(double n){
        if (n <= 0)
            return 1;
        else
            return (n - 1) / n * doubleFact(n-2);
    }

    private static double teilorSeries(double x, double eps) {
        double result = x;
        double previousResult;
        long n = 1;

        do {
            previousResult = result;
            result += doubleFact(2 * n) * Math.pow(x, 2 * n + 1) / (2 * n + 1);
            n++;
        } while (Math.abs(result - previousResult) > eps);

        return result;
    }

    public static double asin(double x, double eps) {
        if(Math.abs(x) > 1) {
            return Double.NaN;
        } else {
            if (Math.abs(x) >= 0.962){
                double newX = Math.sqrt(1 - x*x);
                return (Math.PI/2 - teilorSeries(newX, eps)) * Math.signum(x);
            } else {
                return teilorSeries(x, eps);
            }
        }
    }

    public static void main(String[] args) {
        // для разложения asin(x) в степенной ряд будем использовать формулу
        // asin(x) = teilorSeries(x)
        // для этого разложения есть 2 промежутка, в которых точность резко падает
        // найдём границы таких промежутков и будем использовать формулу
        // asin(x) = PI/2 - teilorSeries((1-x^2)^0.5)
        for (double i = 0.9; i <= 1; i += 0.001) {
            double mathResult = Math.asin(i);
            double myResult = teilorSeries(i, TestTask1.EPS);

            if (Math.abs(mathResult - myResult) > TestTask1.DELTA) {
                System.out.println("i = " + i);
                System.out.println("diff = " + (asin(i, TestTask1.EPS) - teilorSeries(i, TestTask1.EPS)));
                break;
            }
        }
    }
}