package main.java.com.sudhi.dsa.datastructures.Trie;

import java.util.HashMap;
import java.util.Map;

class Node {
    private Map<Character, Node> links;
    private boolean isEnd = false;
    public Node() {
        links = new HashMap<>();
    }
    public boolean contains(char c) {
        return links.containsKey(c);
    }
    public void put(char c, Node node) {
        links.put(c, node);
    }
    public Node get(char c) {
        return links.get(c);
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
public class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    public boolean search(String word) {
        Node node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) return false;
            node = node.get(c);
        }
        return node.isEnd();
    }
    public boolean startsWith(String prefix) {
        Node node = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            if (!node.contains(c)) return false;
            node = node.get(c);
        }
        return true;
    }
}
