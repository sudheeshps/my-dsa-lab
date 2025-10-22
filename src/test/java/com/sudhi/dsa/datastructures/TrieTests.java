package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrieTests {
    @Test
    public void givenTrie_whenSearch_thenReturnsCorrectResult() {
        String[] words = {"apple", "apps", "api", "ba", "base"};
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("apps"));
        Assertions.assertFalse(trie.search("appx"));
        Assertions.assertTrue(trie.search("base"));
    }
    @Test
    public void givenTrie_whenStartsWith_thenReturnsCorrectResult() {
        String[] words = {"apple", "apps", "api", "ba", "base"};
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        Assertions.assertTrue(trie.startsWith("app"));
        Assertions.assertTrue(trie.startsWith("api"));
        Assertions.assertFalse(trie.startsWith("ca"));
        Assertions.assertTrue(trie.startsWith("bas"));
        Assertions.assertFalse(trie.startsWith("da"));
    }
}
