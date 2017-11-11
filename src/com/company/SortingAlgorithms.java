package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingAlgorithms {

    private enum AlgType {
        InsertionSort,
        MergeSort,
        Quicksort
    }

    /**
     * Implementation of the Insertion Sort algorithm learned in class. Sorts the given array in place.
     *
     * @param A the array to be sorted
     */
    public static void insertionSort(int[] A){
        for (int j=0; j < A.length; j++){
            int key = A[j];
            int i = j-1;
            while (i >= 0 && A[i] > key){
                A[i+1] = A[i];
                i = i-1;
            }
            A[i+1] = key;
        }
    }

    /**
     * Implementation of the Merge Sort algorithm learned in class. Sorts the given array in place.
     * This is the mergeSort that will be called from outside this class, it sets the left and right
     * indices using the length of the array.
     *
     * @param A the array to be sorted
     */
    public static void mergeSort(int[] A){
        int p = 0;
        int r = A.length - 1;
        if (p < r) {
            int q = (r - p) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    /**
     * Implementation of the Merge Sort algorithm learned in class. Sorts the given array in place.
     * This is the mergeSort that will be called from inside this class, it expects the left
     * and right indices to be passed to it as parameters
     *
     * @param A the array to be sorted
     * @param p  the left index of the subarray to be sorted in this call.
     * @param r the right index of the subarray to be sorted in this call
     */
    private static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    /**
     * The merge part of the Merge-Sort algorithm. Merges the two sorted subarrays together.
     *
     * @param A the full array being sorted.
     * @param p the left index of the first subarray to be merged in this call.
     * @param q the index splitting the two subarrays to be merged in this call.
     * @param r the right index of the second subarray to be merged in this call.
     */
    private static void merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for (int i = 0; i < n1; i++){
            L[i] = A[p+i];
        }
        for (int j = 0; j < n2; j++){
            R[j] = A[q+1+j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++){
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    /**
     * Implementation of the Quicksort algorithm learned in class. Sorts the given array in place.
     * This is the quicksort that will be called from outside this class, it sets p and q based on the
     * length of the array.
     *
     * @param A the array to be sorted
     */
    public static void quicksort(int[] A){
        int p = 0;
        int r = A.length - 1;
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A,q+1,  r);
        }
    }

    /**
     * Implementation of the Quicksort algorithm learned in class. Sorts the given array in place.
     * This is the quicksort that will be called from inside this class, it expects p and q to be
     * passed as parameters
     *
     * @param A the array to be sorted
     * @param p the index of the first cell in the subarray to be sorted.
     * @param r the index of the "pivot" cell which will be used to divide A into subarrays.
     */
    private static void quicksort(int[] A, int p, int r){
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A, q+1, r);
        }
    }

    /**
     * The partition part of the Quicksort algorithm.
     * Splits the array based on whether it is greater than or less than the pivot.
     *
     * @param A the array to be sorted
     * @param p the index of the first cell in the subarray to be sorted.
     * @param r the index of the "pivot" cell which will be used to divide `A` into subarrays.
     * @return The index which the pivot has been moved to.
     */
    private static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (A[j] <= x){
                i++;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        A[r] = A[i+1];
        A[i+1] = x;
        return i + 1;
    }
}
