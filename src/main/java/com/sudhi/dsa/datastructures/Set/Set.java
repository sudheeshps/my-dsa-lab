package main.java.com.sudhi.dsa.datastructures.Set;

import main.java.com.sudhi.dsa.datastructures.Hashtable.Hashtable;

public class Set<T extends Comparable<T>> {
    private final Hashtable<T, Object> hashtable;
    private static final Object DUMMY = new Object();

    public Set(int capacity) {
        this.hashtable = new Hashtable<>(capacity);
    }

    public void add(T item) throws Exception {
        hashtable.put(item, DUMMY);
    }

    public void remove(T item) {
        hashtable.remove(item);
    }

    public boolean contains(T item) {
        return hashtable.get(item) != null;
    }

    public boolean isEmpty() {
        return hashtable.isEmpty();
    }

    public int size() {
        return hashtable.size();
    }
}
