package main.java.com.sudhi.dsa.algorithms.searching;

public class SearchingAlgorithmFactory <T extends Comparable<T>> {
    public enum SearchingAlgorithmType {
        LinearSearch,
        IterativeBS,
        RecursiveBS
    }
    public SearchAlgorithm<T> getSearchingAlgorithm(SearchingAlgorithmType algorithmType,
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
