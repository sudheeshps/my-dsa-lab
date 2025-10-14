package com.sudhi.dsa.algorithms.sorting.BubbleSort;

import java.util.Comparator;

// Runtimes -> Best: O(n^2), Average: O(n^2), Worst: O(n^2)
// Space -> O(1)
public class BubbleSort<T extends Comparable<T>> extends com.sudhi.dsa.algorithms.sorting.SortingAlgorithm<T> {
    public BubbleSort(T[] elements, Comparator<T> comparator) {
        super(elements, comparator);
    }

    @Override
    public T[] sort() {
        int len = elements.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (comparator.compare(elements[i], elements[j]) > 0) {
                    swap(elements, i, j);
                }
            }
        }
        return elements;
    }
}
