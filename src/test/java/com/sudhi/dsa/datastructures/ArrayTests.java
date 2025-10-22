package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Array;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayTests {

    @Test
    public void testSize_afterOneAdd_isOne() {
        // given
        Array<Integer> array = new Array<>(Integer.class);

        // when
        array.add(10);

        // then
        assertEquals(1, array.size(), "Array size should be 1 after one addition.");
    }

    @Test
    public void testGet_afterOneAdd_returnsElement() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        Integer element = array.get(0);

        // then
        assertEquals(Integer.valueOf(10), element, "First element should be 10.");
    }

    @Test
    public void testGet_afterMultipleAdds_returnsCorrectElements() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);
        array.add(20);

        // when
        Integer firstElement = array.get(0);
        Integer secondElement = array.get(1);

        // then
        assertEquals(Integer.valueOf(10), firstElement, "First element should be 10.");
        assertEquals(Integer.valueOf(20), secondElement, "Second element should be 20.");
    }

    @Test
    public void testRemove_reducesSize() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        array.remove(0);

        // then
        assertEquals(0, array.size(), "Array size should be 0 after removing the only element.");
    }

    @Test
    public void testRemove_shiftsElements() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);
        array.add(20);

        // when
        array.remove(0);

        // then
        assertEquals(Integer.valueOf(20), array.get(0), "Element at index 0 should now be 20.");
    }
    
    @Test
    public void testRemove_returnsRemovedElement() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);
        array.add(20);

        // when
        Integer removedElement = array.remove(0);

        // then
        assertEquals(Integer.valueOf(10), removedElement, "Removed element should be 10.");
    }

    @Test
    public void testSize_ofNewArray_isZero() {
        // given
        Array<Integer> array = new Array<>(Integer.class);

        // when
        int size = array.size();

        // then
        assertEquals(0, size, "Size of new array should be 0.");
    }

    @Test
    public void testGet_whenIndexIsOutOfBounds_throwsException() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(1)); // Should throw
    }

    @Test
    public void testRemove_whenIndexIsOutOfBounds_throwsException() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(1)); // Should throw
    }
}
