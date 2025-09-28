package test.java.com.sudhi.dsa.datastructures;

import main.java.com.sudhi.dsa.datastructures.Hashtable;
import org.junit.Assert;
import org.junit.Test;

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
            hashtable.put(300, "Nana");
            Assert.assertFalse(hashtable.isEmpty());
            Assert.assertEquals(6, hashtable.size());
            Assert.assertEquals("Ahan", hashtable.get(100));
            Assert.assertEquals("Aju", hashtable.get(300));
            Assert.assertEquals("Bob", hashtable.get(400));
            Assert.assertNull(hashtable.get(1000));
        }catch (Exception ex) {
            Assert.assertNotNull(ex);
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
            hashtable.put("300", "Nana");
            Assert.assertFalse(hashtable.isEmpty());
            Assert.assertEquals(6, hashtable.size());
            Assert.assertEquals("Ahan", hashtable.get("100"));
            Assert.assertEquals("Aju", hashtable.get("300"));
            Assert.assertEquals("Bob", hashtable.get("400"));
            Assert.assertNull(hashtable.get("1000"));
        }catch (Exception ex) {
            Assert.assertNotNull(ex);
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
            Integer[] keys = {100, 121, 300, 501, 400, 300};
            var keySet = hashtable.getKeySet();
            Assert.assertTrue(keySet.containsAll(List.of(keys)));
        }catch (Exception ex) {
            Assert.assertNotNull(ex);
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
            hashtable.put(300, "Nana");
            String[] values = {"Ahan", "Amol", "Aju", "Bob", "Anu", "Nana"};
            var keySet = hashtable.getValues();
            Assert.assertTrue(keySet.containsAll(List.of(values)));
        }catch (Exception ex) {
            Assert.assertNotNull(ex);
        }
    }
}
