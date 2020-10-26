package com.spark.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scala.Serializable;

public class CalcListEntropy implements Serializable{
    public static double calc(List<Double> list_str, double lower_bound, double upper_bound, int num_bins) {
//        double[] list = String2Array.stringToDoubleArray(list_str);
        List<Double> list_value = new ArrayList<>();
        for(double item: list_str) {
            if(lower_bound < item && upper_bound > item) {
                list_value.add(item);
            }
        }
        double sum = 0;
        PandasCut pd = new PandasCut();
        pd.cut(list_value.stream().mapToDouble(i->i).toArray(), num_bins);
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
