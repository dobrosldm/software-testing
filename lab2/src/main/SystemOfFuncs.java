package main;

public class SystemOfFuncs {
    private LogarithmicFuncs logFunc = new LogarithmicFuncs();
    private TrigonometricFuncs trigFunc = new TrigonometricFuncs();

    public double system(double x) {
        if (x <= 0)
            return function1(x);
        else
            return function2(x);
    }

    public double function1(double x) {
        return trigFunc.sin(x) * trigFunc.cot(x) + trigFunc.cos(x) - trigFunc.cos(x)
                + trigFunc.sin(x) + trigFunc.sin(x) / Math.pow(trigFunc.csc(x), 2);
    }

    public double function2(double x) {
        return Math.pow(((logFunc.ln(x) + logFunc.log_10(x)) * logFunc.log_3(x) - logFunc.ln(x)), 2)
                * (logFunc.log_5(x) / (logFunc.log_2(x) - logFunc.log_2(x) + logFunc.log_5(x)) / logFunc.log_3(x));
    }

    public void setLogFunc(LogarithmicFuncs logFunc) {
        this.logFunc = logFunc;
    }

    public void setTrigFunc(TrigonometricFuncs trigFunc) {
        this.trigFunc = trigFunc;
    }
}