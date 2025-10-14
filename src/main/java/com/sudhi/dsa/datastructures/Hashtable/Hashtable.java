package com.sudhi.dsa.datastructures.Hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hashtable<K, V> {

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size = 0;
    private final float loadFactor;
    private int threshold;

    public Hashtable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public Hashtable(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public Hashtable(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.table = new Entry[initialCapacity];
        this.threshold = (int) (initialCapacity * loadFactor);
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (Objects.equals(key, entry.key)) {
                return entry.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        if (size >= threshold) {
            resize(2 * table.length);
        }

        int index = hash(key);
        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (Objects.equals(key, entry.key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        Entry<K, V> newEntry = new Entry<>(key, value, table[index]);
        table[index] = newEntry;
        size++;
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> prev = null;
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (Objects.equals(key, entry.key)) {
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    private void resize(int newCapacity) {
        Entry<K, V>[] newTable = new Entry[newCapacity];
        for (Entry<K, V> oldEntry : table) {
            while (oldEntry != null) {
                Entry<K, V> next = oldEntry.next;
                int index = Math.abs(oldEntry.key.hashCode() % newCapacity);
                oldEntry.next = newTable[index];
                newTable[index] = oldEntry;
                oldEntry = next;
            }
        }
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    public List<K> getKeySet() {
        List<K> keys = new ArrayList<>(size);
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                keys.add(entry.key);
                entry = entry.next;
            }
        }
        return keys;
    }

    public List<V> getValues() {
        List<V> values = new ArrayList<>(size);
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                values.add(entry.value);
                entry = entry.next;
            }
        }
        return values;
    }
}
