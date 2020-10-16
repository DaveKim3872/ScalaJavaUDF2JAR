package com.spark.list;

import scala.Serializable;

import java.util.Arrays;

public class String2Array implements Serializable{
    public static int[] stringToIntegerArray(String str) {
        String[] s1 = str.replaceAll("\\[", "").replaceAll("]", "").split(",");
        return Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] stringTo2dIntegerArray(String str) {
        String[] s1 = str.replaceAll("],\\[", "#").replaceAll("\\[\\[", "").replaceAll("]]", "").split("#");
        int[][] arr = new int[s1.length][];
        for(int i=0;i<arr.length;i++) {
            int[] s2 = Arrays.stream(s1[i].split(",")).mapToInt(Integer::parseInt).toArray();
            arr[i] = new int[s2.length];
            System.arraycopy(s2, 0, arr[i], 0, s2.length);
        }
        return arr;
    }

    public static double[] stringToDoubleArray(String str) {
        String[] s1 = str.replaceAll("\\[", "").replaceAll("]", "").split(",");
        return Arrays.stream(s1).mapToDouble(Double::parseDouble).toArray();
    }

    public static double[][] stringTo2dDoubleArray(String str) {
        String[] s1 = str.replaceAll("],\\[", "#").replaceAll("\\[\\[", "").replaceAll("]]", "").split("#");
        double[][] arr = new double[s1.length][];
        for(int i=0;i<arr.length;i++) {
            double[] s2 = Arrays.stream(s1[i].split(",")).mapToDouble(Double::parseDouble).toArray();
            arr[i] = new double[s2.length];
            System.arraycopy(s2, 0, arr[i], 0, s2.length);
        }
        return arr;
    }
}
