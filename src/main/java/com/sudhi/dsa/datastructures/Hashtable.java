package main.java.com.sudhi.dsa.datastructures;

import java.io.InvalidObjectException;
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
public class Hashtable <K extends Comparable<K>, V> {
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
        if (size >= capacity) throw new Exception("Not enough capacity");
        int index = getIndex(key);
        List<Entry<K,V>> list = getValueList(index);
        list.add(new Entry<>(key, value));
        table.set(index, list);
        size++;
    }
    public V get(K key) {
        int index = getIndex(key);
        List<Entry<K,V>> list = getValueList(index);
        for (var entry: list) {
            if (entry.getKey().equals(key)) return entry.getValue();
        }
        return null;
    }
    public List<K> getKeySet() {
        List<K> keys = new ArrayList<>();
        for(var entryList: table) {
            for (var entry: entryList) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
    public List<V> getValues() {
        List<V> values = new ArrayList<>();
        for(var entryList: table) {
            for (var entry: entryList) {
                values.add(entry.getValue());
            }
        }
        return values;
    }
    private int getIndex(K key) {
        int hash = key.hashCode();
        return hash % capacity;
    }
    private List<Entry<K, V>> getValueList(int index) {
        var list = index < table.size() ? table.get(index) : null;
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }
}
