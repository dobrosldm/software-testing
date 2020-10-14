package main;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteResultsToCSV {
    public static void main(String[] args) {
        SystemOfFuncs sof = new SystemOfFuncs();
        LogarithmicFuncs lf = new LogarithmicFuncs();
        TrigonometricFuncs tf = new TrigonometricFuncs();
        File file = new File("./output.csv");

        try {
            FileWriter output = new FileWriter(file);
            CSVWriter write = new CSVWriter(output);

            String[] header = {"x","system","sin","cos","cot","csc","ln","log_2","log_3","log_5","log_10"};
            write.writeNext(header);

            for (double x = -2 * Math.PI; x <= 0; x += 0.01) {
                String[] str = { Double.toString(x),
                        Double.toString(sof.system(x)),
                        Double.toString(tf.sin(x)),
                        Double.toString(tf.cos(x)),
                        Double.toString(tf.cot(x)),
                        Double.toString(tf.csc(x)),
                        "", "", "", "", ""
                };
                write.writeNext(str);
            }

            for (double x = 0.01; x <= 3; x += 0.01) {
                String[] str = { Double.toString(x),
                        Double.toString(sof.system(x)),
                        "", "", "", "",
                        Double.toString(lf.ln(x)),
                        Double.toString(lf.log_2(x)),
                        Double.toString(lf.log_3(x)),
                        Double.toString(lf.log_5(x)),
                        Double.toString(lf.log_10(x)),
                };
                write.writeNext(str);
            }

            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
