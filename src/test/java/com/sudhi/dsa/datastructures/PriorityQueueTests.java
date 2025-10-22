package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class PriorityQueueTests {
    @Test
    public void givenEmptyPriorityQueue_whenIsEmpty_thenReturnsTrue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assertions.assertTrue(pq.isEmpty());
    }
    @Test
    public void givenEmptyPriorityQueue_whenSize_thenReturnsZero() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assertions.assertEquals(0, pq.size());
    }
    @Test
    public void givenEmptyPriorityQueue_whenPeek_thenReturnsNull() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assertions.assertNull(pq.peek());
    }
    @Test
    public void givenEmptyPriorityQueue_whenPoll_thenReturnsNull() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assertions.assertNull(pq.poll());
    }
    @Test
    public void givenPriorityQueue_whenPoll_thenReturnsElementsInAscendingOrder() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Integer[] nums = {3, 2, 1, 5, 4, 8, 7, 6, 9, 10};
        for (int i = 0; i < 10; i++) {
            pq.add(nums[i]);
        }
        for (int i = 1; i <= 10; i++) {
            var elem = pq.poll();
            Assertions.assertEquals(Integer.valueOf(i), elem);
        }
    }
    @Test
    public void givenPriorityQueueWithReverseOrder_whenPoll_thenReturnsElementsInDescendingOrder() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Comparator.reverseOrder());
        Integer[] nums = {3, 2, 1, 5, 4, 8, 7, 6, 9, 10};
        for (int i = 0; i < 10; i++) {
            pq.add(nums[i]);
        }
        for (int i = 10; i >= 1; i--) {
            var elem = pq.poll();
            Assertions.assertEquals(Integer.valueOf(i), elem);
        }
    }
}
