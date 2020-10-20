package com.spark.list;

import java.util.ArrayList;
import java.util.Arrays;
import scala.Serializable;

public class PandasCut implements Serializable {

    public ArrayList<ArrayList<Double>> cut_res = new ArrayList<>();
    public ArrayList<Integer> count_res = new ArrayList<>();
    public ArrayList<Double> bin_percent = new ArrayList<>();

    public void cut(double[] list_input, int bin_nums) {
        Arrays.sort(list_input);
        double list_min = list_input[0];
        double list_max = list_input[list_input.length - 1];
        float interval = (float)(list_max - list_min) / (float)bin_nums;
        int pointer = 0;
        for(int i = 0; i < bin_nums; i++) {
            int count = 0;
            ArrayList<Double> arr = new ArrayList<>();
            while(pointer < list_input.length && list_input[pointer] <= list_min + interval * (i+1)) {
                arr.add(list_input[pointer]);
                pointer++;
            }
            this.cut_res.add(arr);
        }
    }

    public void count() {
        for(ArrayList<Double> i: this.cut_res) {
            this.count_res.add(i.size());
        }
    }

    public void percent() {
        int sum = this.count_res.stream().mapToInt(Integer::intValue).sum();
        for(Integer i: this.count_res) {
            this.bin_percent.add((double) i / sum);
        }
    }

    public double calc_list_entropy() {
        double sum = 0;
        for(double i: this.bin_percent) {
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
