package main;

public class TrigonometricFuncs {
    public double sin(double x) {
        double newX = normalizeX(x);
        double prevValue;
        double value = 0;
        int n = 0;

        do {
            prevValue = value;
            value += Math.pow(-1, n) * Math.pow(newX, 2 * n + 1) / fact(2 * n + 1);
            n++;
        } while (Math.abs(prevValue - value) > 1E-8);

        return value;
    }

    public double cos(double x) {
        double newX = normalizeX(x);
        int sign = ((newX > -Math.PI / 2) && (newX < Math.PI / 2)) ? 1 : -1;

        return sign * Math.pow(1 - Math.pow(sin(x), 2), 0.5);
    }

    public double cot(double x) {
        return cos(x) / sin(x);
    }

    public double csc(double x) {
        return 1 / sin(x);
    }

    private double fact(int n) {
        if (n <= 1)
            return 1;
        else
            return n * fact(n - 1);
    }

    private double normalizeX(double x) {
        return x % (2 * Math.PI);
    }
}