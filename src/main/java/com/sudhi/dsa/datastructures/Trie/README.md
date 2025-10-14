# Trie Data Structure

## Introduction

A Trie, also known as a prefix tree or digital tree, is a specialized tree-like data structure used for storing and retrieving keys in a dataset of strings. Unlike a binary search tree, no node in the tree stores the key associated with that node; instead, its position in the tree defines the key with which it is associated. All the descendants of a node have a common prefix of the string associated with that node, and the root is associated with the empty string.

---

## History

The concept of a Trie was first described by **René de la Briandais** in 1959. The term "Trie" was coined two years later by **Edward Fredkin**, who pronounced it "tree" as in "retrieval." Tries have become a fundamental data structure for string-related problems, especially in areas like information retrieval and bioinformatics.

---

## Properties

-   **Node-based Structure**: The Trie consists of nodes, where each node represents a single character of a string.
-   **Root Node**: The root of the Trie represents an empty string.
-   **Children**: Each node can have multiple children, one for each possible character in the alphabet being used. For example, a Trie storing English words would have nodes with up to 26 children.
-   **End of Word Marker**: Each node has a boolean flag (e.g., `isEndOfWord`) that indicates whether the path from the root to this node represents a complete word in the dataset.

---

## How the Data Structure is Implemented

This implementation uses a `Node` class which contains:

-   A `Map<Character, Node>` to store its children.
-   A boolean `isEnd` to mark the completion of a word.

The `insert` operation traverses the Trie from the root, creating new nodes for characters that do not yet exist. When the end of the word is reached, the `isEnd` flag of the final node is set to `true`. The `search` and `startsWith` methods work by traversing the tree in a similar fashion.

---

## Complexity of operations

Let *L* be the length of the key (word or prefix).

| Operation      | Average Case | Worst Case |
| -------------- | ------------ | ---------- |
| **Insert**     | O(L)         | O(L)       |
| **Search**     | O(L)         | O(L)       |
| **StartsWith** | O(L)         | O(L)       |
| **Space**      | O(N * L_avg) | O(N * L_max) |

*Space complexity depends on the number of words (N) and the average (L_avg) or maximum (L_max) length of the words.*

---

## Known Applications

-   **Autocomplete and Predictive Text**: Suggesting words as a user types.
-   **Spell Checkers**: Efficiently checking if a word is valid.
-   **IP Routing**: Storing and searching routing tables.
-   **Bioinformatics**: Storing and searching DNA sequences.

---

## Comparisons

| Feature        | Trie                                      | Hashtable                                |
| -------------- | ----------------------------------------- | ---------------------------------------- |
| **Search Time**| O(L) - depends on key length.             | O(1) on average, but O(L) to hash the key. |
| **Prefix Search**| Efficiently supports `startsWith` queries.  | Not designed for prefix searches.        |
| **Space**      | Can be space-intensive if keys are long and diverse. | More space-efficient for small numbers of long keys. |

---

## API Documentation

### `public void insert(String word)`
Inserts a word into the Trie.
-   **Parameters**:
    -   `word`: The string to be added.

### `public boolean search(String word)`
Searches for the presence of a complete word in the Trie.
-   **Parameters**:
    -   `word`: The string to search for.
-   **Returns**: `true` if the exact word exists in the Trie, `false` otherwise.

### `public boolean startsWith(String prefix)`
Searches for any word in the Trie that starts with the given prefix.
-   **Parameters**:
    -   `prefix`: The prefix to search for.
-   **Returns**: `true` if there is any word in the Trie that starts with the given prefix, `false` otherwise.
