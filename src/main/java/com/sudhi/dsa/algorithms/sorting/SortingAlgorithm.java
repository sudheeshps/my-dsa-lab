package com.sudhi.dsa.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

public abstract class SortingAlgorithm<T extends Comparable<T>> {
    protected T[] elements;
    protected Comparator<T> comparator;

    public SortingAlgorithm(T[] elements, Comparator<T> comparator) {
        this.elements = Arrays.copyOf(elements, elements.length);
        this.comparator = comparator == null ? new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        } : comparator;
    }

    public abstract T[] sort();

    protected void swap(T[] elements, int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
