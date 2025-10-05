package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Set.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTests {

    private Set<Integer> set;

    @BeforeEach
    void setUp() {
        set = new Set<>(10);
    }

    @Test
    void givenEmptySet_whenAddElement_thenElementIsPresent() throws Exception {
        // Given
        assertTrue(set.isEmpty());

        // When
        set.add(10);

        // Then
        assertFalse(set.isEmpty());
        assertEquals(1, set.size());
        assertTrue(set.contains(10));
    }

    @Test
    void givenSetWithElement_whenAddSameElement_thenSetSizeIsUnchanged() throws Exception {
        // Given
        set.add(10);
        assertEquals(1, set.size());

        // When
        set.add(10);

        // Then
        assertEquals(1, set.size());
    }

    @Test
    void givenSetWithElements_whenRemoveElement_thenElementIsRemoved() throws Exception {
        // Given
        set.add(10);
        set.add(20);
        assertEquals(2, set.size());

        // When
        set.remove(10);

        // Then
        assertEquals(1, set.size());
        assertFalse(set.contains(10));
        assertTrue(set.contains(20));
    }

    @Test
    void givenEmptySet_whenRemoveElement_thenSetRemainsEmpty() {
        // Given
        assertTrue(set.isEmpty());

        // When
        set.remove(10);

        // Then
        assertTrue(set.isEmpty());
    }

    @Test
    void givenSet_whenContainsExistingElement_thenReturnsTrue() throws Exception {
        // Given
        set.add(10);

        // When & Then
        assertTrue(set.contains(10));
    }

    @Test
    void givenSet_whenContainsNonExistingElement_thenReturnsFalse() throws Exception {
        // Given
        set.add(10);

        // When & Then
        assertFalse(set.contains(20));
    }

    @Test
    void givenEmptySet_whenCheckIsEmpty_thenReturnsTrue() {
        // Given, When & Then
        assertTrue(set.isEmpty());
    }

    @Test
    void givenNonEmptySet_whenCheckIsEmpty_thenReturnsFalse() throws Exception {
        // Given
        set.add(10);

        // When & Then
        assertFalse(set.isEmpty());
    }

    @Test
    void givenSet_whenAddAndRemove_thenSizeIsCorrect() throws Exception {
        // Given
        assertTrue(set.isEmpty());

        // When
        set.add(10);
        set.add(20);
        set.add(30);

        // Then
        assertEquals(3, set.size());

        // When
        set.remove(20);

        // Then
        assertEquals(2, set.size());

        // When
        set.remove(10);
        set.remove(30);

        // Then
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }
}
