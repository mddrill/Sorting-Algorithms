package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Utils {

    /**
     * Gets the average of all numbers in an array
     *
     * @param arr the array to get the average of
     * @return the average of all numbers in the array
     */
    public static double avg(int[] arr) {
        double sum = 0.0;
        for (int a : arr) sum += a;
        return sum / arr.length;
    }

    public static double avg(double[] arr) {
        double sum = 0.0;
        for (double a : arr) sum += a;
        return sum / arr.length;
    }

    public static double avg(long[] arr) {
        double sum = 0.0;
        for (long a : arr) sum += a;
        return sum / arr.length;
    }

    /**
     * Creates an array of length <b>length</b> of random numbers
     *
     * @param length the length of the array to be created
     * @return an array of random numbers between 1 and 1000
     * @throws
     */
    public static int[] createRandomIntArray(int length) {

        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000 + 1);
        }
        return arr;
    }

    /**
     * Copies an array.
     *
     * @param arr the array to be copied
     * @return
     */
    public static int[] copy(int[] arr) {
        int[] arrcopy = new int[arr.length];
        System.arraycopy(arr, 0, arrcopy, 0, arr.length);
        return arrcopy;
    }

    public static double[] copy(double[] arr) {
        double[] arrcopy = new double[arr.length];
        System.arraycopy(arr, 0, arrcopy, 0, arr.length);
        return arrcopy;
    }

    public static long[] copy(long[] arr) {
        long[] arrcopy = new long[arr.length];
        System.arraycopy(arr, 0, arrcopy, 0, arr.length);
        return arrcopy;
    }
}
