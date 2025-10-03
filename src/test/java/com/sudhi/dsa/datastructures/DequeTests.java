package test.java.com.sudhi.dsa.datastructures;

import main.java.com.sudhi.dsa.datastructures.Deque;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DequeTests {

    @Test
    public void givenEmptyDeque_whenIsEmpty_thenReturnsTrue() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void givenNonEmptyDeque_whenIsEmpty_thenReturnsFalse() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void givenEmptyDeque_whenSize_thenReturnsZero() {
        Deque<Integer> deque = new Deque<>();
        assertEquals(0, deque.size());
    }

    @Test
    public void givenDequeWithElements_whenSize_thenReturnsCorrectSize() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(2, deque.size());
    }

    @Test
    public void givenDeque_whenAddFirst_thenElementIsAtFront() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(2, deque.peekFirst());
    }

    @Test
    public void givenDeque_whenAddLast_thenElementIsAtBack() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        assertEquals(2, deque.peekLast());
    }

    @Test
    public void givenDequeWithElements_whenRemoveFirst_thenRemovesFrontElement() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(1, deque.removeFirst());
        assertEquals(2, deque.peekFirst());
    }

    @Test
    public void givenDequeWithElements_whenRemoveLast_thenRemovesBackElement() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.peekLast());
    }

    @Test
    public void givenEmptyDeque_whenRemoveFirst_thenThrowsException() {
        Deque<Integer> deque = new Deque<>();
        assertThrows(IndexOutOfBoundsException.class, deque::removeFirst);
    }

    @Test
    public void givenEmptyDeque_whenRemoveLast_thenThrowsException() {
        Deque<Integer> deque = new Deque<>();
        assertThrows(IndexOutOfBoundsException.class, deque::removeLast);
    }

    @Test
    public void givenDequeWithElements_whenPeekFirst_thenReturnsFrontElement() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(1, deque.peekFirst());
    }

    @Test
    public void givenDequeWithElements_whenPeekLast_thenReturnsBackElement() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(2, deque.peekLast());
    }

    @Test
    public void givenEmptyDeque_whenPeekFirst_thenReturnsNull() {
        Deque<Integer> deque = new Deque<>();
        assertNull(deque.peekFirst());
    }

    @Test
    public void givenEmptyDeque_whenPeekLast_thenReturnsNull() {
        Deque<Integer> deque = new Deque<>();
        assertNull(deque.peekLast());
    }
}
