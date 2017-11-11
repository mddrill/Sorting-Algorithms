package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static com.company.TimeIt.timeIt;
import static com.company.Utils.*;
import static com.company.SortingAlgorithms.*;

public class Main {

    public static void main(String[] args) {
        int ns = 5000;
        int nf = 100000;
        int delta = 5000;
        int m = 10;
        int numPasses = (nf-ns)/delta + 1;
        long[] insertionSortTimes = new long[m];
        long[] mergeSortTimes = new long[m];
        long[] quicksortTimes = new long[m];
        double[] insertionSortAvgs = new double[numPasses];
        double[] mergeSortAvgs = new double[numPasses];
        double[] quicksortAvgs = new double[numPasses];
        for (int n = ns; n <= nf; n += delta) {
            System.out.print('#');
            int[] A = createRandomIntArray(n);
            for (int i = 0; i < m; i++) {
                insertionSortTimes[i] = timeIt(() -> insertionSort(copy(A)));
                mergeSortTimes[i] = timeIt(() -> mergeSort(copy(A)));
                quicksortTimes[i] = timeIt(() -> quicksort(copy(A)));
            }
            insertionSortAvgs[(n - ns) / delta] = avg(insertionSortTimes);
            mergeSortAvgs[(n-ns)/delta] = avg(mergeSortTimes);
            quicksortAvgs[(n-ns)/delta] = avg(quicksortTimes);

        }
        System.out.print('\n');
        System.out.println("Results:");
        for (int i = 0; i < insertionSortAvgs.length; i++){
            System.out.println("With " + (i*delta+ns) + " elements Insertion Sort took " + insertionSortAvgs[i] + " milliseconds");
        }
        for (int i = 0; i < mergeSortAvgs.length; i++){
            System.out.println("With " + (i*delta+ns) + " elements Merge Sort took " + mergeSortAvgs[i] + " milliseconds");
        }
        for (int i = 0; i < quicksortAvgs.length; i++){
            System.out.println("With " + (i*delta+ns) + " elements Quicksort took " + quicksortAvgs[i] + " milliseconds");
        }
        String arg1 = "";
        for (double item : insertionSortAvgs){
            arg1 += item + ",";
        }
        arg1 = arg1.substring(0, arg1.length() - 1);
        String arg2 = "";
        for (double item : mergeSortAvgs){
            arg2 += item + ",";
        }
        arg2 = arg2.substring(0, arg2.length() - 1);
        String arg3 = "";
        for (double item : quicksortAvgs){
            arg3 += item + ",";
        }
        arg3 = arg3.substring(0, arg3.length() - 1);
        ProcessBuilder pb = new ProcessBuilder("python","src/com/company/graph_results.py", arg1, arg2, arg3);
        System.out.println("arg1 = " + arg1);
        System.out.println("arg2 = " + arg2);
        System.out.println("arg3 = " + arg3);
        try {
            Process process = pb.start();
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(process.getErrorStream()));
            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
           throw new RuntimeException("Invalid command when trying to run python script");
        }
        System.out.println("Done");
    }
}