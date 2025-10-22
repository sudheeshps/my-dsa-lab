package com.sudhi.dsa.datastructures;

import java.util.HashMap;
import java.util.Map;

public class Trie2 {

    private Node root;

    private static class Node {
        Map<Character, Node> children;
        int endCount; // How many words end at this node
        int prefixCount; // How many words have this prefix

        public Node() {
            children = new HashMap<>();
            endCount = 0;
            prefixCount = 0;
        }
    }

    public Trie2() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new Node());
            current = current.children.get(ch);
            current.prefixCount++;
        }
        current.endCount++;
    }

    public int countOfWord(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return 0;
            }
            current = current.children.get(ch);
        }
        return current.endCount;
    }

    public int countStartsWith(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return 0;
            }
            current = current.children.get(ch);
        }
        return current.prefixCount;
    }

    public void erase(String word) {
        eraseRecursive(root, word, 0);
    }

    private boolean eraseRecursive(Node current, String word, int index) {
        if (current == null) {
            return false;
        }

        if (index == word.length()) {
            if (current.endCount > 0) {
                current.endCount--;
                current.prefixCount--;
                return true; // Word successfully erased
            }
            return false; // Word not found
        }

        char ch = word.charAt(index);
        Node child = current.children.get(ch);

        if (child == null) {
            return false; // Word not found
        }

        boolean erased = eraseRecursive(child, word, index + 1);

        if (erased) {
            current.prefixCount--; // Decrement prefixCount for current node
            // If child node is no longer a prefix for any word and no word ends at it, remove it
            if (child.prefixCount == 0 && child.endCount == 0) {
                current.children.remove(ch);
            }
        }
        return erased;
    }
}
