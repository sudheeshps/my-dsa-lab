package main.java.com.sudhi.dsa.algorithms.sorting;

import java.util.Comparator;

// Runtimes -> Best: O(n log (n)), Average: O(n log (n)), Worst: O(n^2)
// Space -> O(1)
public class ShellSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    public ShellSort(T[] elements, Comparator<T> comparator) {
        super(elements, comparator);
    }

    @Override
    public T[] sort() {
        int len = elements.length;
        for (int interval = len / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < len; i++) {
                int j = i;
                while (j >= interval && comparator.compare(elements[j - interval],
                        elements[j]) > 0) {
                    swap(elements, j - interval, j);
                    j -= interval;
                }
            }
        }
        return elements;
    }
}
