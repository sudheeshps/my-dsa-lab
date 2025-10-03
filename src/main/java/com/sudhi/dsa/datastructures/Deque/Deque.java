package main.java.com.sudhi.dsa.datastructures.Deque;

import main.java.com.sudhi.dsa.datastructures.DoublyLinkedList.DoublyLinkedList;

public class Deque<T> {
    private final DoublyLinkedList<T> list;

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
        return list.removeFirst();
    }

    public T removeLast() {
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
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
