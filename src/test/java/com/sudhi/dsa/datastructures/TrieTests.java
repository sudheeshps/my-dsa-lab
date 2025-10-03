package test.java.com.sudhi.dsa.datastructures;

import main.java.com.sudhi.dsa.datastructures.Trie;
import org.junit.Assert;
import org.junit.Test;

public class TrieTests {
    @Test
    public void givenTrie_whenSearch_thenReturnsCorrectResult() {
        String[] words = {"apple", "apps", "api", "ba", "base"};
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        Assert.assertTrue(trie.search("apple"));
        Assert.assertTrue(trie.search("apps"));
        Assert.assertFalse(trie.search("appx"));
        Assert.assertTrue(trie.search("base"));
    }
    @Test
    public void givenTrie_whenStartsWith_thenReturnsCorrectResult() {
        String[] words = {"apple", "apps", "api", "ba", "base"};
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        Assert.assertTrue(trie.startsWith("app"));
        Assert.assertTrue(trie.startsWith("api"));
        Assert.assertFalse(trie.startsWith("ca"));
        Assert.assertTrue(trie.startsWith("bas"));
        Assert.assertFalse(trie.startsWith("da"));
    }
}
