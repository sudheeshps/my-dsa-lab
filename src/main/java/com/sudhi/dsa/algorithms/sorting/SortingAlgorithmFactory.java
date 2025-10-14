package com.sudhi.dsa.algorithms.sorting;

import java.util.Comparator;

public class SortingAlgorithmFactory<T extends Comparable<T>> {
    public SortingAlgorithm<T> getSortingAlgorithm(SortingAlgorithmType algorithm,
                                                                                    T[] elements,
                                                                                    Comparator<T> comparator) {
        switch (algorithm) {
            case BubbleSort -> {
                return new com.sudhi.dsa.algorithms.sorting.BubbleSort.BubbleSort<>(elements, comparator);
            }
            case InsertionSort -> {
                return new com.sudhi.dsa.algorithms.sorting.InsertionSort.InsertionSort<>(elements, comparator);
            }
            case MergeSort -> {
                return new com.sudhi.dsa.algorithms.sorting.MergeSort.MergeSort<>(elements, comparator);
            }
            case QuickSort -> {
                return new com.sudhi.dsa.algorithms.sorting.QuickSort.QuickSort<>(elements, comparator);
            }
            case SelectionSort -> {
                return new com.sudhi.dsa.algorithms.sorting.SelectionSort.SelectionSort<>(elements, comparator);
            }
            case ShellSort -> {
                return new com.sudhi.dsa.algorithms.sorting.ShellSort.ShellSort<>(elements, comparator);
            }
            case HeapSort ->  {
                return new com.sudhi.dsa.algorithms.sorting.HeapSort.HeapSort<>(elements, comparator);
            }
            case CountSort -> {
                return (com.sudhi.dsa.algorithms.sorting.SortingAlgorithm<T>) new com.sudhi.dsa.algorithms.sorting.CountSort.CountSort<>((Integer[]) elements,
                        (Comparator<Integer>) comparator);
            }
        }
        return null;
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
