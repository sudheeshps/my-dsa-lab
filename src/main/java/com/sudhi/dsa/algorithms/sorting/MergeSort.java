package main.java.com.sudhi.dsa.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

// Runtimes -> Best: O(n log (n)), Average: O(n log (n)), Worst: O(n log (n))
// Space -> O(n)
public class MergeSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    public MergeSort(T[] elements, Comparator<T> comparator) {
        super(elements, comparator);
    }

    @Override
    public T[] sort() {
        return sort(elements);
    }

    public T[] sort(T[] array) {
        int n = array.length;
        if (n < 2) return array;
        int mid = n / 2;
        T[] leftArr = Arrays.copyOfRange(array, 0, mid);
        T[] rightArr = Arrays.copyOfRange(array, mid, n);
        sort(leftArr);
        sort(rightArr);
        merge(array, leftArr, rightArr);
        return array;
    }

    private void merge(T[] elements, T[] leftArr, T[] rightArr) {
        int m = leftArr.length;
        int n = rightArr.length;
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (comparator.compare(leftArr[i], rightArr[j]) < 0) {
                elements[k++] = leftArr[i++];
            } else {
                elements[k++] = rightArr[j++];
            }
        }
        while (i < m) {
            elements[k++] = leftArr[i++];
        }
        while (j < n) {
            elements[k++] = rightArr[j++];
        }
    }
}