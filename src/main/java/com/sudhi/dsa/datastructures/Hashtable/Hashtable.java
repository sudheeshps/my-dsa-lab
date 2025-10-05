package com.sudhi.dsa.datastructures.Hashtable;

import java.util.ArrayList;
import java.util.List;

class Entry<K extends Comparable<K>, V> {
    private final K key;
    private final V value;
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
}

public class Hashtable<K extends Comparable<K>, V> {
    private final int capacity;
    private int size = 0;
    private final List<List<Entry<K, V>>> table;

    public Hashtable(int capacity) {
        this.capacity = capacity;
        this.table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.table.add(new ArrayList<>());
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) throws Exception {
        int index = getIndex(key);
        List<Entry<K, V>> list = getValueList(index);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                list.set(i, new Entry<>(key, value));
                return;
            }
        }

        if (size >= capacity) {
            throw new Exception("Not enough capacity");
        }

        list.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> list = getValueList(index);
        for (var entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> list = getValueList(index);
        for (int i = 0; i < list.size(); i++) {
            Entry<K, V> entry = list.get(i);
            if (entry.getKey().equals(key)) {
                list.remove(i);
                size--;
                return entry.getValue();
            }
        }
        return null;
    }

    public List<K> getKeySet() {
        List<K> keys = new ArrayList<>();
        for (var entryList : table) {
            for (var entry : entryList) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public List<V> getValues() {
        List<V> values = new ArrayList<>();
        for (var entryList : table) {
            for (var entry : entryList) {
                values.add(entry.getValue());
            }
        }
        return values;
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        return Math.abs(hash % capacity);
    }

    private List<Entry<K, V>> getValueList(int index) {
        return table.get(index);
    }
}
