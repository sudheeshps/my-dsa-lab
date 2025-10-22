package com.sudhi.dsa.datastructures;

import java.util.NoSuchElementException;

public class Deque<T> {
    private DoublyLinkedList<T> list;

    public Deque() {
        list = new DoublyLinkedList<>();
    }

    public void addFirst(T data) {
        list.addFirst(data);
    }

    public void addLast(T data) {
        list.addLast(data);
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        return list.removeFirst();
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        return list.removeLast();
    }

    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public T peekLast() {
        if (isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
