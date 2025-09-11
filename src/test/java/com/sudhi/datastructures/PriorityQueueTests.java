package test.java.com.sudhi.datastructures;

import main.java.com.sudhi.dsa.datastructures.PriorityQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class PriorityQueueTests {
    @Test
    public void isEmptyTest() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assert.assertTrue(pq.isEmpty());
    }
    @Test
    public void sizeTest() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assert.assertEquals(0, pq.size());
    }
    @Test
    public void emptyPeekTest() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assert.assertNull(pq.peek());
    }
    @Test
    public void emptyPollTest() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Assert.assertNull(pq.poll());
    }
    @Test
    public void assertAscendingOrderTest() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Integer[] nums = {3, 2, 1, 5, 4, 8, 7, 6, 9, 10};
        for (int i = 0; i < 10; i++) {
            pq.add(nums[i]);
        }
        for (int i = 1; i <= 10; i++) {
            var elem = pq.poll();
            Assert.assertEquals(Integer.valueOf(i), elem);
        }
    }
    @Test
    public void assertDescendingOrderTest() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Comparator.reverseOrder());
        Integer[] nums = {3, 2, 1, 5, 4, 8, 7, 6, 9, 10};
        for (int i = 0; i < 10; i++) {
            pq.add(nums[i]);
        }
        for (int i = 10; i >= 1; i--) {
            var elem = pq.poll();
            Assert.assertEquals(Integer.valueOf(i), elem);
        }
    }
}
