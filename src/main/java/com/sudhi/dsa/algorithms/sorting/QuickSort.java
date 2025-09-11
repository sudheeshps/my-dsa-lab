package main.java.com.sudhi.dsa.algorithms.sorting;

import java.util.Comparator;

// Runtimes -> Best: O(n log (n)), Average: O(n log (n)), Worst: O(n^2)
// Space -> O(n)
public class QuickSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    public QuickSort(T[] elements, Comparator<T> comparator) {
        super(elements, comparator);
    }

    @Override
    public T[] sort() {
        return sort(elements, 0, elements.length - 1);
    }

    private T[] sort(T[] elements, int low, int high) {
        if (low < high) {
            int p = partition(elements, low, high, comparator);
            sort(elements, low, p - 1);
            sort(elements, p + 1, high);
        }
        return elements;
    }

    private int partition(T[] elements, int low, int high, Comparator<T> comparator) {
        int i = low;
        int j = high;
        T pivot = elements[low];
        while (i < j) {
            while (i <= high && comparator.compare(pivot, elements[i]) >= 0) i++;
            while (j >= low && comparator.compare(pivot, elements[j]) < 0) j--;
            if (i < j) swap(elements, i, j);
        }
        swap(elements, low, j);
        return j;
    }
}
