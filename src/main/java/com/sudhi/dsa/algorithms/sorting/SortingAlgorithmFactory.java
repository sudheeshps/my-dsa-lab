package main.java.com.sudhi.dsa.algorithms.sorting;

import java.util.Comparator;

public class SortingAlgorithmFactory<T extends Comparable<T>> {
    public SortingAlgorithm<T> getSortingAlgorithm(SortingAlgorithmType algorithm,
                                                   T[] elements,
                                                   Comparator<T> comparator) {
        switch (algorithm) {
            case BubbleSort -> {
                return new BubbleSort<>(elements, comparator);
            }
            case InsertionSort -> {
                return new InsertionSort<>(elements, comparator);
            }
            case MergeSort -> {
                return new MergeSort<>(elements, comparator);
            }
            case QuickSort -> {
                return new QuickSort<>(elements, comparator);
            }
            case SelectionSort -> {
                return new SelectionSort<>(elements, comparator);
            }
            case ShellSort -> {
                return new ShellSort<>(elements, comparator);
            }
            case HeapSort ->  {
                return new HeapSort<>(elements, comparator);
            }
            case CountSort -> {
                return (SortingAlgorithm<T>) new CountSort<>((Integer[]) elements,
                        (Comparator<Integer>) comparator);
            }
        }
        return new QuickSort<>(elements, comparator);
    }


    public enum SortingAlgorithmType {
        BubbleSort,
        InsertionSort,
        MergeSort,
        QuickSort,
        SelectionSort,
        ShellSort,
        HeapSort,
        CountSort
    }
}
