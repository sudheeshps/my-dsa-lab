package test.java.com.sudhi.dsa.datastructures;

import main.java.com.sudhi.dsa.datastructures.Trie2;
import org.junit.Assert;
import org.junit.Test;

public class Trie2Tests {
    @Test
    public void givenTrie_whenCountWords_thenCorrectCount() {
        Trie2 trie2 = new Trie2();
        String[] words = {"apple", "apple", "apps", "apps", "word", "wo", "ap"};
        for (String word: words) {
            trie2.insert(word);
        }
        Assert.assertEquals(2, trie2.countOfWord("apple"));
        Assert.assertEquals(1, trie2.countOfWord("word"));
        Assert.assertEquals(1, trie2.countOfWord("ap"));
        Assert.assertEquals(2, trie2.countOfWord("apps"));
        Assert.assertEquals(0, trie2.countOfWord("world"));
    }
    @Test
    public void givenTrie_whenCountPrefix_thenCorrectCount() {
        Trie2 trie2 = new Trie2();
        String[] words = {"apple", "apple", "apps", "apps", "word", "wo", "ap"};
        for (String word: words) {
            trie2.insert(word);
        }
        Assert.assertEquals(4, trie2.countStartsWith("app"));
        Assert.assertEquals(2, trie2.countStartsWith("wo"));
        Assert.assertEquals(5, trie2.countStartsWith("ap"));
        Assert.assertEquals(0, trie2.countStartsWith("foo"));
    }
    @Test
    public void givenTrie_whenEraseWord_thenWordIsRemoved() {
        Trie2 trie2 = new Trie2();
        String[] words = {"apple", "apple", "apps", "apps", "word", "wo", "ap"};
        for (String word: words) {
            trie2.insert(word);
        }
        Assert.assertEquals(2, trie2.countOfWord("apple"));
        Assert.assertEquals(1, trie2.countOfWord("word"));
        Assert.assertEquals(1, trie2.countOfWord("ap"));

        trie2.erase("apple");
        trie2.erase("apple");
        trie2.erase("apps");
        Assert.assertEquals(0, trie2.countOfWord("apple"));
        Assert.assertEquals(1, trie2.countOfWord("apps"));
        Assert.assertEquals(1, trie2.countStartsWith("app"));
        Assert.assertEquals(2, trie2.countStartsWith("ap"));
        Assert.assertEquals(0, trie2.countStartsWith("foo"));
    }
}
