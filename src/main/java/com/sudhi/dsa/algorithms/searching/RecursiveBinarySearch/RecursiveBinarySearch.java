package com.sudhi.dsa.algorithms.searching.RecursiveBinarySearch;

public class RecursiveBinarySearch <T extends Comparable<T>> extends com.sudhi.dsa.algorithms.searching.SearchAlgorithm<T> {
    public RecursiveBinarySearch(T[] elements) {
        super(elements);
    }
    @Override
    public int search(T key) {
        return bs (key, 0, elements.length - 1);
    }

    private int bs(T key, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        T midElement = elements[mid];
        if (midElement.equals(key)) return mid;
        if (key.compareTo(midElement) < 0) return bs(key, low, mid - 1);
        else return bs(key, mid + 1, high);
    }
}
