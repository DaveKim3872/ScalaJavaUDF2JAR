package com.spark.list;

import scala.Serializable;

import java.util.Arrays;

import static com.spark.list.String2Array.*;

public class AddJava implements Serializable {
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
