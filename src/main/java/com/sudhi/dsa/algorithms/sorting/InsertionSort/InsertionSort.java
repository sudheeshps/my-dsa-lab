package com.sudhi.dsa.algorithms.sorting.InsertionSort;

import java.util.Comparator;

// Runtimes -> Best: O(n), Average: O(n^2), Worst: O(n^2)
// Space -> O(1)
public class InsertionSort<T extends Comparable<T>> extends com.sudhi.dsa.algorithms.sorting.SortingAlgorithm<T> {
    public InsertionSort(T[] elements, Comparator<T> comparator) {
        super(elements, comparator);
    }

    @Override
    public T[] sort() {
        int length = elements.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && (comparator.compare(elements[j - 1], elements[j]) > 0)) {
                swap(elements, j, j - 1);
                j--;
            }
        }
        return elements;
    }
}