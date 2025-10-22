package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Trie2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Trie2Tests {
    @Test
    public void givenTrie_whenCountWords_thenCorrectCount() {
        Trie2 trie2 = new Trie2();
        String[] words = {"apple", "apple", "apps", "apps", "word", "wo", "ap"};
        for (String word: words) {
            trie2.insert(word);
        }
        Assertions.assertEquals(2, trie2.countOfWord("apple"));
        Assertions.assertEquals(1, trie2.countOfWord("word"));
        Assertions.assertEquals(1, trie2.countOfWord("ap"));
        Assertions.assertEquals(2, trie2.countOfWord("apps"));
        Assertions.assertEquals(0, trie2.countOfWord("world"));
    }
    @Test
    public void givenTrie_whenCountPrefix_thenCorrectCount() {
        Trie2 trie2 = new Trie2();
        String[] words = {"apple", "apple", "apps", "apps", "word", "wo", "ap"};
        for (String word: words) {
            trie2.insert(word);
        }
        Assertions.assertEquals(4, trie2.countStartsWith("app"));
        Assertions.assertEquals(2, trie2.countStartsWith("wo"));
        Assertions.assertEquals(5, trie2.countStartsWith("ap"));
        Assertions.assertEquals(0, trie2.countStartsWith("foo"));
    }
    @Test
    public void givenTrie_whenEraseWord_thenWordIsRemoved() {
        Trie2 trie2 = new Trie2();
        String[] words = {"apple", "apple", "apps", "apps", "word", "wo", "ap"};
        for (String word: words) {
            trie2.insert(word);
        }
        Assertions.assertEquals(2, trie2.countOfWord("apple"));
        Assertions.assertEquals(1, trie2.countOfWord("word"));
        Assertions.assertEquals(1, trie2.countOfWord("ap"));

        trie2.erase("apple");
        trie2.erase("apple");
        trie2.erase("apps");
        Assertions.assertEquals(0, trie2.countOfWord("apple"));
        Assertions.assertEquals(1, trie2.countOfWord("apps"));
        Assertions.assertEquals(1, trie2.countStartsWith("app"));
        Assertions.assertEquals(2, trie2.countStartsWith("ap"));
        Assertions.assertEquals(0, trie2.countStartsWith("foo"));
    }
}
