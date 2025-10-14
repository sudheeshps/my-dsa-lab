package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Array.Array;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayTests {

    @Test
    public void testSize_afterOneAdd_isOne() {
        // given
        Array<Integer> array = new Array<>(Integer.class);

        // when
        array.add(10);

        // then
        assertEquals("Array size should be 1 after one addition.", 1, array.size());
    }

    @Test
    public void testGet_afterOneAdd_returnsElement() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        Integer element = array.get(0);

        // then
        assertEquals("First element should be 10.", Integer.valueOf(10), element);
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
        assertEquals("First element should be 10.", Integer.valueOf(10), firstElement);
        assertEquals("Second element should be 20.", Integer.valueOf(20), secondElement);
    }

    @Test
    public void testRemove_reducesSize() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        array.remove(0);

        // then
        assertEquals("Array size should be 0 after removing the only element.", 0, array.size());
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
        assertEquals("Element at index 0 should now be 20.", Integer.valueOf(20), array.get(0));
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
        assertEquals("Removed element should be 10.", Integer.valueOf(10), removedElement);
    }

    @Test
    public void testSize_ofNewArray_isZero() {
        // given
        Array<Integer> array = new Array<>(Integer.class);

        // when
        int size = array.size();

        // then
        assertEquals("Size of new array should be 0.", 0, size);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_whenIndexIsOutOfBounds_throwsException() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        array.get(1); // Should throw
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove_whenIndexIsOutOfBounds_throwsException() {
        // given
        Array<Integer> array = new Array<>(Integer.class);
        array.add(10);

        // when
        array.remove(1); // Should throw
    }
}
