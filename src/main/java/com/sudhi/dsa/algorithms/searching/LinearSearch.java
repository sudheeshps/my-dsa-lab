package main.java.com.sudhi.dsa.algorithms.searching;

public class LinearSearch <T extends Comparable<T>> extends SearchAlgorithm<T>{
    public LinearSearch(T[] elements) {
        super(elements);
    }
    @Override
    public int search(T key) {
        int len = elements.length;
        for (int i = 0; i < len; i++) {
            if (elements[i].equals(key)) return i;
        }
        return -1;
    }
}
