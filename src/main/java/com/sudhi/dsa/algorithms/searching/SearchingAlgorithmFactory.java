package com.sudhi.dsa.algorithms.searching;

import com.sudhi.dsa.algorithms.searching.IterativeBinarySearch;
import com.sudhi.dsa.algorithms.searching.LinearSearch;
import com.sudhi.dsa.algorithms.searching.RecursiveBinarySearch;

public class SearchingAlgorithmFactory <T extends Comparable<T>> {
    public enum SearchingAlgorithmType {
        LinearSearch,
        IterativeBS,
        RecursiveBS
    }
    public com.sudhi.dsa.algorithms.searching.SearchAlgorithm<T> getSearchingAlgorithm(SearchingAlgorithmType algorithmType,
                                                                                       T[] elements) {
        switch (algorithmType) {
            case LinearSearch -> {
                return new LinearSearch<>(elements);
            }
            case IterativeBS -> {
                return new IterativeBinarySearch<>(elements);
            }
            case RecursiveBS -> {
                return new RecursiveBinarySearch<>(elements);
            }
        }
        return new RecursiveBinarySearch<>(elements);
    }
}
