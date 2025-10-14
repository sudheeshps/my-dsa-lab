package com.sudhi.dsa.algorithms.sorting.SelectionSort;

import java.util.Comparator;

// Runtimes -> Best: O(n^2), Average: O(n^2), Worst: O(n^2)
// Space -> O(1)
public class SelectionSort<T extends Comparable<T>> extends com.sudhi.dsa.algorithms.sorting.SortingAlgorithm<T> {
    public SelectionSort(T[] elements, Comparator<T> comparator) {
        super(elements, comparator);
    }

    @Override
    public T[] sort() {
        int length = elements.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (comparator.compare(elements[min], elements[j]) > 0) min = j;
            }
            swap(elements, i, min);
        }
        return elements;
    }
}
