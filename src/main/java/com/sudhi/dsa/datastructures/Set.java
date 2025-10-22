package com.sudhi.dsa.datastructures;

public class Set<T> {
    private Hashtable<T, Object> hashtable;
    private static final Object DUMMY = new Object(); // Dummy value for the hashtable

    public Set() {
        hashtable = new Hashtable<>();
    }

    public Set(int capacity) {
        hashtable = new Hashtable<>(capacity);
    }

    public void add(T item) {
        hashtable.put(item, DUMMY);
    }

    public void remove(T item) {
        hashtable.remove(item);
    }

    public boolean contains(T item) {
        return hashtable.containsKey(item);
    }

    public boolean isEmpty() {
        return hashtable.isEmpty();
    }

    public int size() {
        return hashtable.size();
    }
}
