package main;

public class LogarithmicFuncs {
    public double ln(double x) {
        double x1 = (x - 1) / (x + 1);
        double current = x1;
        double result = 0;
        int n = 3;

        while (Math.abs(2 * current) > 1E-8) {
            result += 2 * current;
            current *= Math.pow(x1, 2) / n * (n - 2);
            n += 2;
        }

        return result;
    }

    public double log_2(double x) {
        return ln(x) / ln(2);
    }

    public double log_3(double x) {
        return ln(x) / ln(3);
    }

    public double log_5(double x) {
        return ln(x) / ln(5);
    }

    public double log_10(double x) {
        return ln(x) / ln(10);
    }
}