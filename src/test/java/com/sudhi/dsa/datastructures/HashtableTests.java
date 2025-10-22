package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Hashtable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HashtableTests {
    @Test
    public void givenHashtable_whenPutAndGetWithIntegerKey_thenCorrect() {
        try {
            Hashtable<Integer, String> hashtable = new Hashtable<>(10);
            hashtable.put(100, "Ahan");
            hashtable.put(121, "Amol");
            hashtable.put(300, "Aju");
            hashtable.put(501, "Anu");
            hashtable.put(400, "Bob");
            hashtable.put(300, "Nana"); // This should update the value for key 300
            Assertions.assertFalse(hashtable.isEmpty());
            Assertions.assertEquals(5, hashtable.size()); // Size should be 5 because a key was updated, not added
            Assertions.assertEquals("Ahan", hashtable.get(100));
            Assertions.assertEquals("Nana", hashtable.get(300)); // The new value should be returned
            Assertions.assertEquals("Bob", hashtable.get(400));
            Assertions.assertNull(hashtable.get(1000));
        }catch (Exception ex) {
            Assertions.fail("Test threw an exception: " + ex.getMessage());
        }
    }
    @Test
    public void givenHashtable_whenPutAndGetWithStringKey_thenCorrect() {
        try {
            Hashtable<String, String> hashtable = new Hashtable<>(10);
            hashtable.put("100", "Ahan");
            hashtable.put("121", "Amol");
            hashtable.put("300", "Aju");
            hashtable.put("501", "Anu");
            hashtable.put("400", "Bob");
            hashtable.put("300", "Nana"); // This should update the value for key "300"
            Assertions.assertFalse(hashtable.isEmpty());
            Assertions.assertEquals(5, hashtable.size()); // Size should be 5
            Assertions.assertEquals("Ahan", hashtable.get("100"));
            Assertions.assertEquals("Nana", hashtable.get("300")); // The new value should be returned
            Assertions.assertEquals("Bob", hashtable.get("400"));
            Assertions.assertNull(hashtable.get("1000"));
        }catch (Exception ex) {
            Assertions.fail("Test threw an exception: " + ex.getMessage());
        }
    }
    @Test
    public void givenHashtable_whenGetKeySet_thenReturnsAllKeys() {
        try {
            Hashtable<Integer, String> hashtable = new Hashtable<>(10);
            hashtable.put(100, "Ahan");
            hashtable.put(121, "Amol");
            hashtable.put(300, "Aju");
            hashtable.put(501, "Anu");
            hashtable.put(400, "Bob");
            hashtable.put(300, "Nana");
            // The keys are unique, so there should be 5 keys.
            Integer[] keys = {100, 121, 300, 501, 400};
            var keySet = hashtable.getKeySet();
            Assertions.assertEquals(5, keySet.size());
            Assertions.assertTrue(keySet.containsAll(List.of(keys)));
            Assertions.assertTrue(List.of(keys).containsAll(keySet));
        }catch (Exception ex) {
            Assertions.fail("Test threw an exception: " + ex.getMessage());
        }
    }
    @Test
    public void givenHashtable_whenGetValueSet_thenReturnsAllValues() {
        try {
            Hashtable<Integer, String> hashtable = new Hashtable<>(10);
            hashtable.put(100, "Ahan");
            hashtable.put(121, "Amol");
            hashtable.put(300, "Aju");
            hashtable.put(501, "Anu");
            hashtable.put(400, "Bob");
            hashtable.put(300, "Nana"); // "Aju" is replaced by "Nana"
            // The values should reflect the final state of the hashtable.
            String[] values = {"Ahan", "Amol", "Nana", "Anu", "Bob"};
            var valueSet = hashtable.getValues();
            Assertions.assertEquals(5, valueSet.size());
            Assertions.assertTrue(valueSet.containsAll(List.of(values)));
            Assertions.assertTrue(List.of(values).containsAll(valueSet));
        }catch (Exception ex) {
            Assertions.fail("Test threw an exception: " + ex.getMessage());
        }
    }
}
