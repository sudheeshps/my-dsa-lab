package main.java.com.sudhi.dsa.datastructures.Stack;

import main.java.com.sudhi.dsa.datastructures.Array.Array;

public class Stack<T extends Comparable<T>> {

    private Array<T> array;

    public Stack(Class<T> clazz) {
        this.array = new Array<>(clazz);
    }

    public Stack(Class<T> clazz, int capacity) {
        this.array = new Array<>(clazz, capacity);
    }

    public void push(T item) {
        array.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array.remove(array.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array.get(array.size() - 1);
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    public int size() {
        return array.size();
    }
}
