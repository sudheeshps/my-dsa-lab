package com.sudhi.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hashtable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;
    private int capacity;
    private double loadFactor;
    private int threshold; // capacity * loadFactor

    public Hashtable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public Hashtable(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public Hashtable(int capacity, double loadFactor) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        if (loadFactor <= 0 || Double.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Load factor must be positive");
        }

        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.threshold = (int) (this.capacity * this.loadFactor);
        this.table = new Entry[this.capacity];
        this.size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (size >= threshold) {
            resize();
        }

        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing key
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value; // Update existing key at the end of list
                return;
            }
            newEntry.next = table[index]; // Add to the front of the list
            table[index] = newEntry;
        }
        size++;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hash(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        threshold = (int) (capacity * loadFactor);
        Entry<K, V>[] oldTable = table;
        table = new Entry[capacity];
        size = 0; // Reset size, will be re-incremented by put

        for (int i = 0; i < oldCapacity; i++) {
            Entry<K, V> current = oldTable[i];
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }

    public List<K> getKeySet() {
        List<K> keys = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> current = table[i];
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }

    public List<V> getValues() {
        List<V> values = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> current = table[i];
            while (current != null) {
                values.add(current.value);
                current = current.next;
            }
        }
        return values;
    }
}
