package com.spark.list;

import java.util.ArrayList;
import java.util.Arrays;
import scala.Serializable;

public class CalcListEntropy implements Serializable{
    public static double calc(double[] list) {
        double sum = 0;
        PandasCut pd = new PandasCut();
        pd.cut(list, 4);
        pd.count();
        pd.percent();
        for(double i: pd.bin_percent) {
            if(i > 0) {
                sum = sum + i * (Math.log(i)/Math.log(2));
            }
            else {
                sum = sum + 0;
            }
        }
        sum = -sum;
        return sum;
    }
}
