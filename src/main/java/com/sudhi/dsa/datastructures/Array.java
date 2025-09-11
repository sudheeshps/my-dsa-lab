package main.java.com.sudhi.dsa.datastructures;

public class Array <T extends Comparable<T>> {
    private int capacity = 0;
    private int capacityMultiplier = 2;
    private T[] array;
    public Array(int capacity, int capacityMultiplier) {
        this.capacity = capacity;
        this.capacityMultiplier = capacityMultiplier;
        Class<T> tClass = null;
        this.array = (T[]) java.lang.reflect.Array.newInstance(tClass, capacity);
    }
}
