package com.sudhi.dsa.algorithms.searching.IterativeBinarySearch;

public class IterativeBinarySearch <T extends Comparable<T>> extends com.sudhi.dsa.algorithms.searching.SearchAlgorithm<T> {
    public IterativeBinarySearch(T[] elements) {
        super(elements);
    }
    @Override
    public int search(T key) {
        int low = 0;
        int high = elements.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            T midElement = elements[mid];
            if (midElement.equals(key)) return mid;
            if (key.compareTo(midElement) < 0) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
