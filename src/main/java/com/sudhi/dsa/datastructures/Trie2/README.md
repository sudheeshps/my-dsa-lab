# Trie2 Data Structure

This is an advanced Trie (prefix tree) implementation that not only stores strings but also keeps track of the number of words with a given prefix and the number of times a specific word has been inserted. It also includes a method to erase words from the trie.

## Usage

To use the `Trie2` class, you first need to create an instance of it:

```java
Trie2 myTrie = new Trie2();
```

You can then insert words into the trie:

```java
myTrie.insert("apple");
myTrie.insert("apple");
myTrie.insert("app");
```

## Method Descriptions

*   `insert(String word)`: Inserts a word into the trie. If the word already exists, its end count is incremented.

*   `countOfWord(String word)`: Returns the number of times the specified word has been inserted into the trie.

*   `countStartsWith(String prefix)`: Returns the number of words in the trie that start with the given prefix.

*   `erase(String word)`: Decrements the counts for the given word. If the word's prefix and end counts become zero, it is effectively removed from the trie.
