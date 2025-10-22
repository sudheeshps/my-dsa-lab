# Trie (Prefix Tree)

## Introduction

A Trie, also known as a prefix tree, is a tree-like data structure used to store a dynamic set or associative array where the keys are usually strings. Unlike a binary search tree, nodes in a trie do not store the key directly. Instead, the position of a node in the tree defines the key with which it is associated. All descendants of a node have a common prefix of the string associated with that node.

---

## History

The term "trie" was coined by **Edward Fredkin** in 1964, derived from the word "retrieval." However, the data structure itself dates back to work by **René de la Briandais** in 1959 and **Axel Thue** in 1912. Fredkin popularized its use in computer science.

---

## Behaviour of a Trie

-   **Prefix-based**: Efficiently supports operations involving prefixes, such as finding all words with a given prefix.
-   **Nodes represent characters**: Each node typically represents a single character of a key. Paths from the root to a node represent prefixes.
-   **End-of-word marker**: Nodes that represent the end of a complete word are usually marked.
-   **Space-Time Tradeoff**: Can be very space-efficient if many keys share common prefixes, but can be space-inefficient if keys are very diverse and long.

---

## Data Structure Operations

-   **Insertion**: `O(L)` - Where `L` is the length of the key. Involves traversing the tree and creating new nodes for characters not yet present.
-   **Search**: `O(L)` - Where `L` is the length of the key. Involves traversing the tree based on the characters of the key.
-   **Deletion**: `O(L)` - Where `L` is the length of the key. Involves traversing and potentially removing nodes that are no longer part of any key.
-   **`startsWith(prefix)`**: `O(L)` - Where `L` is the length of the prefix. Efficiently checks if any key in the trie has the given prefix.

---

## Comparison

-   **vs. Hash Table**: Tries offer `O(L)` worst-case performance for operations (where `L` is key length), which can be better than `O(L * N)` for hash tables in worst-case collisions. Tries also support prefix-based searches, which hash tables do not natively. Hash tables can be more space-efficient for diverse keys.
-   **vs. Binary Search Tree**: Tries are generally faster for string operations than BSTs, especially for prefix searches. BSTs store entire keys in nodes, while tries distribute keys across paths.

---

## How the Data Structure is Implemented

This `Trie` implementation uses a nested `TrieNode` class. Each `TrieNode` contains:

-   A `HashMap<Character, TrieNode>`: To store children nodes, where the character is the key to the next node.
-   A `boolean isEndOfWord`: A flag indicating if the path to this node forms a complete word.

The `Trie` class maintains a `root` `TrieNode`. Methods like `insert`, `search`, and `startsWith` recursively or iteratively traverse the tree based on the characters of the input string.

---

## Known Applications

-   **Autocomplete and Predictive Text**: Suggesting words based on a prefix.
-   **Spell Checkers**: Efficiently checking if a word exists in a dictionary.
-   **IP Routing**: Storing IP addresses and finding the longest prefix match.
-   **Dictionary Search**: Storing and searching for words.
-   **Bioinformatics**: Storing DNA sequences.

---

## API Documentation

### `public void insert(String word)`

Inserts a `word` into the trie.

-   **Parameters:**
    -   `word`: The word to be inserted.

### `public boolean search(String word)`

Searches for a `word` in the trie.

-   **Parameters:**
    -   `word`: The word to search for.
-   **Returns:**
    -   `true` if the word is found, `false` otherwise.

### `public boolean startsWith(String prefix)`

Checks if there is any word in the trie that starts with the given `prefix`.

-   **Parameters:**
    -   `prefix`: The prefix to check for.
-   **Returns:**
    -   `true` if any word starts with the prefix, `false` otherwise.
