package test.java.com.sudhi.dsa.datastructures;

import main.java.com.sudhi.dsa.datastructures.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTests {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void givenLinkedList_whenAddAndGet_thenCorrect() {
        list.add(10);
        list.add(20);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void givenLinkedList_whenAddAtFirst_thenCorrect() {
        list.add(10);
        list.add(20);
        list.addFirst(5);
        assertEquals(3, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(2));
    }

    @Test
    void givenLinkedList_whenRemove_thenCorrect() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }
    
    @Test
    void givenLinkedList_whenRemoveFirst_thenCorrect() {
        list.add(10);
        list.add(20);
        assertEquals(10, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(20, list.get(0));
    }

    @Test
    void givenLinkedList_whenGetOutOfBounds_thenThrowsException() {
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void givenLinkedList_whenRemoveOutOfBounds_thenThrowsException() {
        list.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void givenLinkedList_whenAddAndRemove_thenSizeIsCorrect() {
        assertEquals(0, list.size());
        list.add(10);
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }
}
