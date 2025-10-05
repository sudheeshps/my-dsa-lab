package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>(Integer.class);
    }

    @Test
    void givenEmptyStack_whenPush_thenStackIsNotEmptyAndSizeIsOne() {
        // When
        stack.push(10);

        // Then
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void givenStackWithElements_whenPush_thenElementIsAddedOnTop() {
        // Given
        stack.push(10);
        stack.push(20);

        // When
        stack.push(30);

        // Then
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
    }

    @Test
    void givenStackWithElements_whenPop_thenElementIsRemovedAndSizeIsDecremented() {
        // Given
        stack.push(10);
        stack.push(20);

        // When
        Integer poppedElement = stack.pop();

        // Then
        assertEquals(20, poppedElement);
        assertEquals(1, stack.size());
    }

    @Test
    void givenEmptyStack_whenPop_thenThrowsException() {
        // When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void givenStackWithElements_whenPeek_thenReturnsTopElementWithoutRemoving() {
        // Given
        stack.push(10);
        stack.push(20);

        // When
        Integer topElement = stack.peek();

        // Then
        assertEquals(20, topElement);
        assertEquals(2, stack.size());
    }

    @Test
    void givenEmptyStack_whenPeek_thenThrowsException() {
        // When & Then
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.peek();
        });
    }

    @Test
    void givenEmptyStack_whenIsEmpty_thenReturnsTrue() {
        // When & Then
        assertTrue(stack.isEmpty());
    }

    @Test
    void givenStackWithElements_whenIsEmpty_thenReturnsFalse() {
        // Given
        stack.push(10);

        // When & Then
        assertFalse(stack.isEmpty());
    }

    @Test
    void givenEmptyStack_whenSize_thenReturnsZero() {
        // When & Then
        assertEquals(0, stack.size());
    }

    @Test
    void givenStackWithElements_whenSize_thenReturnsCorrectSize() {
        // Given
        stack.push(10);
        stack.push(20);

        // When & Then
        assertEquals(2, stack.size());
    }
}
