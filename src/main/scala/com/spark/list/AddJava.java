package com.spark.list;

import scala.Serializable;

import java.util.Arrays;

public class AddJava implements Serializable {
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

    public static int[] addIntegerArray(int[] a, int[] b) {
        int[] c = new int[a.length];
        for(int i=0;i<a.length;i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static int[][] add2dIntegerArray(int[][] a, int[][] b) {
        int[][] c = new int[a.length][];
        for(int i=0;i<a.length;i++) {
            c[i] = new int[a[i].length];
            for(int j=0;j<a[i].length;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }

    public static double[] addDoubleArray(double[] a, double[] b) {
        double[] c = new double[a.length];
        for(int i=0;i<a.length;i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static double[][] add2dDoubleArray(double[][] a, double[][] b) {
        double[][] c = new double[a.length][];
        for(int i=0;i<a.length;i++) {
            c[i] = new double[a[i].length];
            for(int j=0;j<a[i].length;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }

    public static String Adder(String a, String b, Boolean doubleOrNot) {
        a = a.replace(" ", "");
        b = b.replace(" ", "");
        int lengthA = a.split(",").length;
        int lengthB = b.split(",").length;
        if(lengthA > lengthB) {
            return a;
        }
        else if(lengthB > lengthA) {
            return b;
        }
        else {
            if(a.startsWith("[[")) {
                if(doubleOrNot) {
                    return Arrays.deepToString(add2dDoubleArray(stringTo2dDoubleArray(a), stringTo2dDoubleArray(b)));
                }
                else {
                    return Arrays.deepToString(add2dIntegerArray(stringTo2dIntegerArray(a), stringTo2dIntegerArray(b)));
                }

            }
            else {
                if(doubleOrNot) {
                    return Arrays.toString(addDoubleArray(stringToDoubleArray(a), stringToDoubleArray(b)));
                }
                else {
                    return Arrays.toString(addIntegerArray(stringToIntegerArray(a), stringToIntegerArray(b)));
                }
            }
        }
    }
}
