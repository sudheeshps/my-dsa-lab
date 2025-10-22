package com.sudhi.dsa.datastructures;

public class Array<T> {
    private T[] arr;
    private int size;
    private int capacity;
    private Class<T> clazz;

    public Array(Class<T> clazz) {
        this(clazz, 10);
    }

    public Array(Class<T> clazz, int capacity) {
        this.clazz = clazz;
        this.capacity = capacity;
        this.arr = (T[]) java.lang.reflect.Array.newInstance(clazz, capacity);
        this.size = 0;
    }

    public void add(T item) {
        if (size == capacity) {
            resize();
        }
        arr[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return arr[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        T removedItem = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null; // Clear the last element and decrement size
        return removedItem;
    }

    public int size() {
        return size;
    }

    private void resize() {
        capacity *= 2;
        T[] newArr = (T[]) java.lang.reflect.Array.newInstance(clazz, capacity);
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
