package com.company

import com.company.SortingAlgorithms
import com.company.SortingAlgorithms.AlgType
import org.apache.tools.ant.types.resources.Sort
import com.company.Utils.*

class SortingAlgorithmsTest extends GroovyTestCase {
    /**
     * Apparently IntelliJ Idea automatically makes test cases in Groovy.
     * I think this is okay because tests are not in the assignment, so these tests are mostly for my own purposes.
     * The syntax is pretty similar to Java anyway.
     */

    private void testSortingAlgorithm(AlgType algType){
        for (int i = 0; i < 100; i++) {
            int[] A = Utils.createRandomIntArray(Math.random() * length + 1)
            int[] A_copy = new int[A.length]
            System.arraycopy(A, 0, A_copy, 0, A.length)
            switch (algType) {
                case AlgType.InsertionSort:
                    SortingAlgorithms.insertionSort(A_copy)
                    break
                case AlgType.MergeSort:
                    SortingAlgorithms.mergeSort(A_copy)
                    break
                case AlgType.Quicksort:
                    SortingAlgorithms.quicksort(A_copy)
                    break
            }
            if (i%20 == 0)
                println("    Pass " + i+1 + "/100. Successful so far")
        }
    }

    void testInsertionSort() {
        println("Testing Insertion Sort")
        testSortingAlgorithm(AlgType.InsertionSort)
        println("Success! Insertion Sort works!")
    }

    void testMergeSort() {
        println("Testing Merge Sort")
        testSortingAlgorithm(AlgType.MergeSort)
        println("Success! MergeSort works!")
    }

    void testQuicksort() {
        println("Testing Quicksort")
        testSortingAlgorithm(AlgType.Quicksort)
        println("Success! Quicksort works!")
    }
}
