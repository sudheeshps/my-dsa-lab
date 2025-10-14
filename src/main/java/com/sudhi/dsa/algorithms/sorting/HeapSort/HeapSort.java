package com.sudhi.dsa.algorithms.sorting.HeapSort;

import java.util.Comparator;

// Runtimes -> Best: O(n log (n)), Average: O(n log (n)), Worst: O(n log (n))
// Space -> O(1)
public class HeapSort<T extends Comparable<T>> extends com.sudhi.dsa.algorithms.sorting.SortingAlgorithm<T>{
    public HeapSort(T[] elements, Comparator<T> comparator) {
        super(elements, comparator);
    }
    @Override
    public T[] sort() {
        int len = elements.length;
        heapify(len);
        sort(len);
        return elements;
    }
    private void heapify(int len) {
        for (int i = Math.max(0, (len/2) - 1); i >= 0; i--) {
            sink(len, i);
        }
    }
    private void sort(int len) {
        for (int i = len - 1; i >= 0; i--) {
            swap(elements, 0, i);
            sink(i, 0);
        }
    }
    private void sink(int len, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (right < len && comparator.compare(elements[right], elements[largest]) > 0) {
                largest = right;
            }
            if (left < len && comparator.compare(elements[left], elements[largest]) > 0) {
                largest = left;
            }
            if (i != largest) {
                swap(elements, i, largest);
                 i = largest;
            }else break;
        }
    }
}
