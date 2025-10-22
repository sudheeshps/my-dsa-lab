package com.sudhi.dsa.datastructures;

import java.util.EmptyStackException;

public class Stack<T> {
    private Array<T> array;

    public Stack(Class<T> clazz) {
        array = new Array<>(clazz);
    }

    public Stack(Class<T> clazz, int capacity) {
        array = new Array<>(clazz, capacity);
    }

    public void push(T item) {
        array.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return array.remove(array.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return array.get(array.size() - 1);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int size() {
        return array.size();
    }
}
