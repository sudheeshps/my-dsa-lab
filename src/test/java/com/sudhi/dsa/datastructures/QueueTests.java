package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTests {

    @Test
    public void givenEmptyQueue_whenIsEmpty_thenReturnsTrue() {
        Queue<Integer> queue = new Queue<>();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void givenNonEmptyQueue_whenIsEmpty_thenReturnsFalse() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    public void givenEmptyQueue_whenSize_thenReturnsZero() {
        Queue<Integer> queue = new Queue<>();
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    public void givenQueueWithElements_whenSize_thenReturnsCorrectSize() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void givenQueue_whenEnqueue_thenElementIsAdded() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test
    public void givenQueueWithElements_whenDequeue_thenReturnsFirstElement() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Assertions.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assertions.assertEquals(1, queue.size());
    }

    @Test
    public void givenEmptyQueue_whenDequeue_thenThrowsException() {
        Queue<Integer> queue = new Queue<>();
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void givenQueueWithElements_whenPeek_thenReturnsFirstElement() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Assertions.assertEquals(Integer.valueOf(1), queue.peek());
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void givenEmptyQueue_whenPeek_thenReturnsNull() {
        Queue<Integer> queue = new Queue<>();
        Assertions.assertNull(queue.peek());
    }
}
