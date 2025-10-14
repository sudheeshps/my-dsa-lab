package com.sudhi.dsa.algorithms.searching;

import com.sudhi.dsa.algorithms.searching.IterativeBinarySearch.IterativeBinarySearch;
import com.sudhi.dsa.algorithms.searching.LinearSearch.LinearSearch;
import com.sudhi.dsa.algorithms.searching.RecursiveBinarySearch.RecursiveBinarySearch;
import com.sudhi.dsa.algorithms.searching.IterativeBinarySearch.IterativeBinarySearch;
import com.sudhi.dsa.algorithms.searching.RecursiveBinarySearch.RecursiveBinarySearch;
import static com.sudhi.dsa.algorithms.searching.SearchingAlgorithmFactory.SearchingAlgorithmType.LinearSearch;

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
