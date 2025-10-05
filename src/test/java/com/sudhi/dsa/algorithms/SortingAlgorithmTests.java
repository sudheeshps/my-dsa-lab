package com.sudhi.dsa.algorithms;

import com.sudhi.dsa.algorithms.sorting.SortingAlgorithm;
import com.sudhi.dsa.algorithms.sorting.SortingAlgorithmFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingAlgorithmTests {
    @ParameterizedTest
    @EnumSource(value = SortingAlgorithmFactory.SortingAlgorithmType.class,
            names = {"BubbleSort", "InsertionSort", "MergeSort",
                    "QuickSort", "SelectionSort", "ShellSort","HeapSort"})
    void sortCharactersAscending(SortingAlgorithmFactory.SortingAlgorithmType algorithmType) {
        var factory = new SortingAlgorithmFactory<Character>();
        SortingAlgorithm<Character> sortingAlgorithm =
                factory.getSortingAlgorithm(algorithmType,
                        "INSERTIONSORT".chars().mapToObj(c -> (char) c).toArray(Character[]::new), null);
        assertArrayEquals(sortingAlgorithm.sort(), "EIINNOORRSSTT".chars().mapToObj(c -> (char) c).toArray(Character[]::new));
    }

    @ParameterizedTest
    @EnumSource(value = SortingAlgorithmFactory.SortingAlgorithmType.class,
            names = {"BubbleSort", "InsertionSort", "MergeSort",
                    "QuickSort", "SelectionSort", "ShellSort"})
    void sortCharactersDescending(SortingAlgorithmFactory.SortingAlgorithmType algorithmType) {
        var factory = new SortingAlgorithmFactory<Character>();
        SortingAlgorithm<Character> sortingAlgorithm =
                factory.getSortingAlgorithm(algorithmType,
                        "INSERTIONSORT".chars().mapToObj(c -> (char) c).toArray(Character[]::new), Comparator.reverseOrder());
        assertArrayEquals(sortingAlgorithm.sort(),
                new Character[]{'T', 'T', 'S', 'S', 'R', 'R', 'O', 'O', 'N', 'N', 'I', 'I', 'E'});

    }

    @ParameterizedTest
    @EnumSource(value = SortingAlgorithmFactory.SortingAlgorithmType.class,
            names = {"BubbleSort", "InsertionSort", "MergeSort",
                    "QuickSort", "SelectionSort", "ShellSort","HeapSort",
                    "CountSort"})
    void sortIntegersAscending(SortingAlgorithmFactory.SortingAlgorithmType algorithmType) {
        var factory = new SortingAlgorithmFactory<Integer>();
        SortingAlgorithm<Integer> sortingAlgorithm =
                factory.getSortingAlgorithm(algorithmType,
                        new Integer[]{1, 4, 3, 5, 8, 2, 0}, null);
        assertArrayEquals(sortingAlgorithm.sort(), new Integer[]{0, 1, 2, 3, 4, 5, 8});
    }

    @ParameterizedTest
    @EnumSource(value = SortingAlgorithmFactory.SortingAlgorithmType.class,
            names = {"BubbleSort", "InsertionSort", "MergeSort",
                    "QuickSort", "SelectionSort", "ShellSort","HeapSort"})
    void sortIntegersDescending(SortingAlgorithmFactory.SortingAlgorithmType algorithmType) {
        var factory = new SortingAlgorithmFactory<Integer>();
        SortingAlgorithm<Integer> sortingAlgorithm =
                factory.getSortingAlgorithm(algorithmType,
                        new Integer[]{1, 4, 3, 5, 8, 2, 0}, Comparator.reverseOrder());
        assertArrayEquals(sortingAlgorithm.sort(), new Integer[]{8, 5, 4, 3, 2, 1, 0});
    }

    @ParameterizedTest
    @EnumSource(value = SortingAlgorithmFactory.SortingAlgorithmType.class,
            names = {"BubbleSort", "InsertionSort", "MergeSort",
                    "QuickSort", "SelectionSort", "ShellSort","HeapSort"})
    void sortStringsAscending(SortingAlgorithmFactory.SortingAlgorithmType algorithmType) {
        var factory = new SortingAlgorithmFactory<String>();
        SortingAlgorithm<String> sortingAlgorithm =
                factory.getSortingAlgorithm(algorithmType,
                        new String[]{"hello", "how", "are", "you"}, null);
        assertArrayEquals(sortingAlgorithm.sort(), new String[]{"are", "hello", "how", "you"});
    }

    @ParameterizedTest
    @EnumSource(value = SortingAlgorithmFactory.SortingAlgorithmType.class,
            names = {"BubbleSort", "InsertionSort", "MergeSort",
                    "QuickSort", "SelectionSort", "ShellSort"})
    void sortStringsDescending(SortingAlgorithmFactory.SortingAlgorithmType algorithmType) {
        var factory = new SortingAlgorithmFactory<String>();
        SortingAlgorithm<String> sortingAlgorithm =
                factory.getSortingAlgorithm(algorithmType,
                        new String[]{"hello", "how", "are", "you"}, Comparator.reverseOrder());
        assertArrayEquals(sortingAlgorithm.sort(),
                new String[]{"you", "how", "hello", "are"});
    }
}