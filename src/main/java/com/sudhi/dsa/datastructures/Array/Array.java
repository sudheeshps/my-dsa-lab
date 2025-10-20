package com.sudhi.dsa.datastructures.Array;

public class Array<T> {
    private int capacity = 10; // Default capacity
    private int size = 0;
    private T[] array;
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public Array(Class<T> clazz) {
        this.clazz = clazz;
        this.array = (T[]) java.lang.reflect.Array.newInstance(clazz, capacity);
    }
    
    @SuppressWarnings("unchecked")
    public Array(Class<T> clazz, int capacity) {
        this.clazz = clazz;
        this.capacity = capacity;
        this.array = (T[]) java.lang.reflect.Array.newInstance(clazz, capacity);
    }

    public void add(T item) {
        if (size == capacity) {
            resize();
        }
        array[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T item = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null; // to let GC do its work
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(clazz, capacity);
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
