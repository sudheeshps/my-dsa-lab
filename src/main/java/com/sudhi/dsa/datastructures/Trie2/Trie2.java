package main.java.com.sudhi.dsa.datastructures.Trie2;

import java.util.HashMap;
import java.util.Map;

class Node2 {
    private Map<Character, Node2> links;
    private int endCount;
    private int prefixCount;
    public Node2() {
        links = new HashMap<>();
    }
    public boolean contains(char c) {
        return links.containsKey(c);
    }
    public void put(char c, Node2 node) {
        links.put(c, node);
    }
    public Node2 get(char c) {
        return links.get(c);
    }

    public void increasePrefixCount() {
        prefixCount++;
    }

    public void increaseEndCount() {
        endCount++;
    }
    public int getEndCount() {
        return endCount;
    }

    public int getPrefixCount() {
        return prefixCount;
    }

    public void reducePrefixCount() {
        prefixCount--;
    }

    public void reduceEndCount() {
        endCount--;
    }
}
public class Trie2 {
    private Node2 root;
    public Trie2() {
        root = new Node2();
    }
    public void insert(String word) {
        Node2 node = root;
        for (char c: word.toCharArray()) {
            if (!node.contains(c)) {
                node.put(c, new Node2());
            }
            node = node.get(c);
            node.increasePrefixCount();
        }
        node.increaseEndCount();
    }
    public int countOfWord(String word) {
        Node2 node = root;
        for (char c: word.toCharArray()) {
            if (!node.contains(c)) return 0;
            node = node.get(c);
        }
        return node.getEndCount();
    }
    public int countStartsWith(String prefix) {
        Node2 node = root;
        for (char c: prefix.toCharArray()) {
            if (!node.contains(c)) return 0;
            node = node.get(c);
        }
        return node.getPrefixCount();
    }
    public void erase(String word) {
        Node2 node = root;
        for (char c: word.toCharArray()) {
            if (!node.contains(c)) return;
            node.reducePrefixCount();
            node = node.get(c);
        }
        node.reduceEndCount();
    }
}
