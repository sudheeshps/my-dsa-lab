package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.DoublyLinkedList.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTests {

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void givenDoublyLinkedList_whenAddAndGet_thenCorrect() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void givenDoublyLinkedList_whenAddFirst_thenCorrect() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void givenDoublyLinkedList_whenAddLast_thenCorrect() {
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void givenDoublyLinkedList_whenRemove_thenCorrect() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(3, list.get(1));
    }

    @Test
    public void givenDoublyLinkedList_whenRemoveFirst_thenCorrect() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    public void givenDoublyLinkedList_whenRemoveLast_thenCorrect() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.removeLast());
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void givenDoublyLinkedList_whenAddAndRemove_thenSizeIsCorrect() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.removeFirst();
        assertEquals(0, list.size());
    }

    @Test
    public void givenDoublyLinkedList_whenGetOutOfBounds_thenThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void givenEmptyDoublyLinkedList_whenRemove_thenThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeFirst());
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeLast());
    }
}
