package com.sudhi.dsa.datastructures.Queue;

import com.sudhi.dsa.datastructures.LinkedList.LinkedList;

public class Queue<T> {

    private final LinkedList<T> list;

    public Queue() {
        this.list = new LinkedList<>();
    }

    /**
     * Adds an item to the end of the queue.
     * @param data the item to be added.
     */
    public void enqueue(T data) {
        list.add(data);
    }

    /**
     * Removes and returns the item at the front of the queue.
     * @return the item at the front of the queue.
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return list.removeFirst();
    }

    /**
     * Returns the item at the front of the queue without removing it.
     * @return the item at the front of the queue, or null if the queue is empty.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of items in the queue.
     * @return the number of items in the queue.
     */
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
