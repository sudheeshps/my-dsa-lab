package test.java.com.sudhi.dsa.datastructures;

import main.java.com.sudhi.dsa.datastructures.Queue.Queue;
import org.junit.Assert;
import org.junit.Test;

public class QueueTests {

    @Test
    public void givenEmptyQueue_whenIsEmpty_thenReturnsTrue() {
        Queue<Integer> queue = new Queue<>();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void givenNonEmptyQueue_whenIsEmpty_thenReturnsFalse() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void givenEmptyQueue_whenSize_thenReturnsZero() {
        Queue<Integer> queue = new Queue<>();
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void givenQueueWithElements_whenSize_thenReturnsCorrectSize() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertEquals(2, queue.size());
    }

    @Test
    public void givenQueue_whenEnqueue_thenElementIsAdded() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        Assert.assertEquals(1, queue.size());
        Assert.assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test
    public void givenQueueWithElements_whenDequeue_thenReturnsFirstElement() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertEquals(Integer.valueOf(1), queue.dequeue());
        Assert.assertEquals(1, queue.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void givenEmptyQueue_whenDequeue_thenThrowsException() {
        Queue<Integer> queue = new Queue<>();
        queue.dequeue();
    }

    @Test
    public void givenQueueWithElements_whenPeek_thenReturnsFirstElement() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertEquals(Integer.valueOf(1), queue.peek());
        Assert.assertEquals(2, queue.size());
    }

    @Test
    public void givenEmptyQueue_whenPeek_thenReturnsNull() {
        Queue<Integer> queue = new Queue<>();
        Assert.assertNull(queue.peek());
    }
}
