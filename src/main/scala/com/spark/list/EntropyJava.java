package com.spark.list;

import scala.Serializable;
import static com.spark.list.String2Array.*;

import java.util.ArrayList;
import java.util.Arrays;

public class EntropyJava implements Serializable{
    public Double calcListEntropy(String list_input, double lower_bound, double upper_bound, int num_bins) {
        double[] list_in = stringToDoubleArray(list_input);
        if(list_in.length == 0) {
            return null;
        }
        ArrayList<Double> list_value = new ArrayList<>();
        for(double i:list_in) {
            double item = (double) Math.round(i * 1000) / 1000;
            if (lower_bound < item && upper_bound > item) {
                list_value.add(item);
            }
        }
        if(list_value.size() > 0) {
        }
        return 0.0;
    }
}
