package com.sudhi.dsa.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.Integer;

// Count sort only works for integers.
// Also, this implementation works for ascending order sorting
// Runtimes -> Best: O(n + k), Average: O(n + k), Worst: O(n^2)
// Space -> O(n)
public class CountSort<T extends Comparable<Integer>> extends SortingAlgorithm<Integer> {

    public CountSort(Integer[] elements, Comparator<Integer> comparator) {
        super(elements, comparator);
    }

    @Override
    public Integer[] sort() {
        int min = Arrays.stream(elements).min(comparator).orElse(0);
        int max = Arrays.stream(elements).max(comparator).orElse(Integer.MAX_VALUE);
        int[] countArray = new int[max - min + 1];
        for(int value: elements) {
            countArray[value - min]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < max - min + 1; i++) {
            while (countArray[i] > 0) {
                elements[arrayIndex++] = i + min;
                countArray[i]--;
            }
        }
        return elements;
    }
}
