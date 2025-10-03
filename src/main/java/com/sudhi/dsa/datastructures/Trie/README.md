# Trie Data Structure

This is a Trie (prefix tree) implementation that can be used to store and search for strings efficiently. A trie is a tree-like data structure where each node represents a single character of a string.

## Usage

To use the `Trie` class, you first need to create an instance of it:

```java
Trie myTrie = new Trie();
```

You can then insert words into the trie:

```java
myTrie.insert("apple");
myTrie.insert("app");
```

## Method Descriptions

*   `insert(String word)`: Inserts a word into the trie.

*   `search(String word)`: Searches for a word in the trie and returns `true` if the exact word is found, `false` otherwise.

*   `startsWith(String prefix)`: Searches for a prefix in the trie and returns `true` if there is any word in the trie that starts with the given prefix, `false` otherwise.
