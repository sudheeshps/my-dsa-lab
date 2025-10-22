# Trie (Prefix Tree) - Array-based

## Introduction

A Trie, also known as a prefix tree, is a tree-like data structure used to store a dynamic set or associative array where the keys are usually strings. This particular implementation uses an array-based approach for its nodes, which can be more memory-efficient and faster for certain character sets (like lowercase English letters) compared to `HashMap`-based implementations.

---

## History

The term "trie" was coined by **Edward Fredkin** in 1964, derived from the word "retrieval." However, the data structure itself dates back to work by **René de la Briandais** in 1959 and **Axel Thue** in 1912. Fredkin popularized its use in computer science.

---

## Behaviour of an Array-based Trie

-   **Prefix-based**: Efficiently supports operations involving prefixes, such as finding all words with a given prefix.
-   **Nodes represent characters**: Each node typically represents a single character of a key. Paths from the root to a node represent prefixes.
-   **Array for Children**: Instead of a `HashMap`, each node uses a fixed-size array (e.g., `children[26]` for English alphabet) to store pointers to its children. The index in the array corresponds to a character (e.g., `0` for 'a', `1` for 'b').
-   **End-of-word marker**: Nodes that represent the end of a complete word are usually marked.
-   **Space-Time Tradeoff**: Can be very space-efficient if the character set is small and keys share common prefixes. Can be space-inefficient if the character set is large or keys are very diverse, leading to many empty array slots.

---

## Data Structure Operations

-   **Insertion**: `O(L)` - Where `L` is the length of the key. Involves traversing the tree and creating new nodes for characters not yet present.
-   **Search**: `O(L)` - Where `L` is the length of the key. Involves traversing the tree based on the characters of the key.
-   **Deletion**: `O(L)` - Where `L` is the length of the key. Involves traversing and potentially removing nodes that are no longer part of any key.
-   **`startsWith(prefix)`**: `O(L)` - Where `L` is the length of the prefix. Efficiently checks if any key in the trie has the given prefix.

---

## Comparison

-   **vs. HashMap-based Trie**: Array-based tries can be faster due to direct array access (no hashing overhead) and better cache locality, especially for small, contiguous character sets. However, they can consume more memory if the character set is large and sparse.
-   **vs. Hash Table**: Tries offer `O(L)` worst-case performance for operations (where `L` is key length), which can be better than `O(L * N)` for hash tables in worst-case collisions. Tries also support prefix-based searches, which hash tables do not natively. Hash tables can be more space-efficient for diverse keys.

---

## How the Data Structure is Implemented

This `Trie` implementation uses a nested `TrieNode` class. Each `TrieNode` contains:

-   An array of `TrieNode` references (e.g., `TrieNode[] children = new TrieNode[26]`) for its children.
-   A `boolean isEndOfWord`: A flag indicating if the path to this node forms a complete word.

The `Trie` class maintains a `root` `TrieNode`. Methods like `insert`, `search`, and `startsWith` convert characters to array indices and traverse the tree.

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
