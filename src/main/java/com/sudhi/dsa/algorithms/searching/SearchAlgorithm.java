package com.sudhi.dsa.algorithms.searching;

public abstract class SearchAlgorithm <T extends Comparable<T>> {
    protected T[] elements;
    public SearchAlgorithm(T[] elements) {
        this.elements = elements;
    }
    public abstract int search(T key);
}
