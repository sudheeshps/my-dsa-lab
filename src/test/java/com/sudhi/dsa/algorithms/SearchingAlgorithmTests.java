package test.java.com.sudhi.dsa.algorithms;

import main.java.com.sudhi.dsa.algorithms.searching.SearchingAlgorithmFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class SearchingAlgorithmTests {
    @ParameterizedTest
    @EnumSource(value = SearchingAlgorithmFactory.SearchingAlgorithmType.class,
            names = {"LinearSearch", "IterativeBS", "RecursiveBS"})
    public void testSearchIntegerSuccess(SearchingAlgorithmFactory.SearchingAlgorithmType algorithmType) {
        Integer[] arr = {20, 30, 40, 50, 60, 70, 80, 90};
        var searchAlgorithm = new SearchingAlgorithmFactory<Integer>().getSearchingAlgorithm(algorithmType, arr);
        int index = searchAlgorithm.search(30);
        Assertions.assertEquals(index, 1);
    }

    @ParameterizedTest
    @EnumSource(value = SearchingAlgorithmFactory.SearchingAlgorithmType.class,
            names = {"LinearSearch", "IterativeBS", "RecursiveBS"})
    public void testSearchIntegerFailure(SearchingAlgorithmFactory.SearchingAlgorithmType algorithmType) {
        Integer[] arr = {20, 30, 40, 50, 60, 70, 80, 90};
        var searchAlgorithm = new SearchingAlgorithmFactory<Integer>().getSearchingAlgorithm(algorithmType, arr);
        int index = searchAlgorithm.search(12);
        Assertions.assertEquals(index, -1);
    }

    @ParameterizedTest
    @EnumSource(value = SearchingAlgorithmFactory.SearchingAlgorithmType.class,
            names = {"LinearSearch", "IterativeBS", "RecursiveBS"})
    public void testSearchCharacterSuccess(SearchingAlgorithmFactory.SearchingAlgorithmType algorithmType) {
        Character[] arr = {'a', 'b', 'd', 'f', 'g', 'h'};
        var searchAlgorithm = new SearchingAlgorithmFactory<Character>().getSearchingAlgorithm(algorithmType, arr);
        int index = searchAlgorithm.search('d');
        Assertions.assertEquals(index, 2);
    }

    @ParameterizedTest
    @EnumSource(value = SearchingAlgorithmFactory.SearchingAlgorithmType.class,
            names = {"LinearSearch", "IterativeBS", "RecursiveBS"})
    public void testSearchCharacterFailure(SearchingAlgorithmFactory.SearchingAlgorithmType algorithmType) {
        Character[] arr = {'a', 'b', 'd', 'f', 'g', 'h'};
        var searchAlgorithm = new SearchingAlgorithmFactory<Character>().getSearchingAlgorithm(algorithmType, arr);
        int index = searchAlgorithm.search('s');
        Assertions.assertEquals(index, -1);
    }

    @ParameterizedTest
    @EnumSource(value = SearchingAlgorithmFactory.SearchingAlgorithmType.class,
            names = {"LinearSearch", "IterativeBS", "RecursiveBS"})
    public void testSearchStringSuccess(SearchingAlgorithmFactory.SearchingAlgorithmType algorithmType) {
        String[] arr = {"Adam", "Bob", "Martin", "Nina", "Tina"};
        var searchAlgorithm = new SearchingAlgorithmFactory<String>().getSearchingAlgorithm(algorithmType, arr);
        int index = searchAlgorithm.search("Tina");
        Assertions.assertEquals(index, 4);
    }

    @ParameterizedTest
    @EnumSource(value = SearchingAlgorithmFactory.SearchingAlgorithmType.class,
            names = {"LinearSearch", "IterativeBS", "RecursiveBS"})
    public void testSearchStringFailure(SearchingAlgorithmFactory.SearchingAlgorithmType algorithmType) {
        String[] arr = {"Adam", "Bob", "Martin", "Nina", "Tina"};
        var searchAlgorithm = new SearchingAlgorithmFactory<String>().getSearchingAlgorithm(algorithmType, arr);
        int index = searchAlgorithm.search("John Doe");
        Assertions.assertEquals(index, -1);
    }
}
