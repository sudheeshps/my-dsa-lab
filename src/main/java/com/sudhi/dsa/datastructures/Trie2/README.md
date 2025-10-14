# Trie Data Structure (Advanced)

## Introduction

A Trie, also known as a digital tree or prefix tree, is a tree-like data structure that specializes in storing and retrieving strings. Each node in the Trie represents a single character of a string. This particular implementation (`Trie2`) is an advanced version that not only tracks the existence of words but also maintains counts for both complete words and prefixes.

## History

The concept of a Trie was first described by René de la Briandais in 1959. The name "Trie" was coined by Edward Fredkin a couple of years later, from the middle syllable of "retrieval." Donald Knuth, a prominent computer scientist, was instrumental in popularizing the data structure.

## Properties

*   **Prefix-Based Structure**: The structure of the tree is based on the prefixes of the stored words.
*   **Character-Based Nodes**: Each node contains links to child nodes, where each link corresponds to a character.
*   **Efficient Prefix Operations**: Tries excel at operations involving prefixes, such as autocomplete and counting words with a common prefix.
*   **Word and Prefix Counts**: This implementation tracks how many times a full word is inserted (`endCount`) and how many words share a certain prefix (`prefixCount`).

## How the Data Structure is Implemented

This Trie is implemented using a `Node2` class.

*   **Node Class**: Each `Node2` contains a `Map<Character, Node2>` to store links to its children. It also has two integer fields: `endCount` and `prefixCount`.
*   **Insertion**: To insert a word, the algorithm traverses the Trie character by character. For each character, it follows the corresponding link. If a link does not exist, a new node is created. At each node along the path, the `prefixCount` is incremented. When the end of the word is reached, the `endCount` of the final node is incremented.
*   **Counting**: The `countOfWord` and `countStartsWith` methods traverse the Trie based on the input string and return the `endCount` or `prefixCount` of the final node, respectively.
*   **Deletion (`erase`)**: To erase a word, the algorithm traverses the Trie, decrementing the `prefixCount` at each node. At the final node, it decrements the `endCount`.

## Complexity of operations

The performance of a Trie is dependent on the length of the words being processed, denoted as `L`.

| Operation | Average Case | Worst Case |
| :-------- | :----------: | :--------: |
| **Insertion** | O(L) | O(L) |
| **Search/Counting** | O(L) | O(L) |
| **Deletion (`erase`)** | O(L) | O(L) |

## Known Applications

*   **Autocomplete/Typeahead**: Suggesting words as a user types, used in search engines and text editors.
*   **Spell Checkers**: Efficiently checking if a word is in a dictionary.
*   **IP Routing**: Storing and searching routing tables for the longest prefix match.
*   **Bioinformatics**: Storing and searching for DNA sequences.

## Comparisons

*   **Trie vs. Hashtable**:
    *   **Prefix Operations**: Tries are far superior for prefix-based searches (e.g., `startsWith`). Hashtables cannot perform such operations efficiently.
    *   **Space**: Tries can be more space-efficient than hashtables if there are many words with common prefixes.
    *   **Collisions**: Tries do not have key collisions, unlike hashtables.

## API documentation

### `public Trie2()`
Creates a new, empty Trie with a root node.

### `public void insert(String word)`
Inserts a word into the Trie. If the word already exists, its counts are incremented.

*   **Parameters**:
    *   `word`: The string to be inserted.

### `public int countOfWord(String word)`
Counts the number of times a specific word has been inserted into the Trie.

*   **Parameters**:
    *   `word`: The word to count.
*   **Returns**: The number of times the word appears in the Trie.

### `public int countStartsWith(String prefix)`
Counts the number of words in the Trie that start with the given prefix.

*   **Parameters**:
    *   `prefix`: The prefix to search for.
*   **Returns**: The number of words that start with the prefix.

### `public void erase(String word)`
Decrements the counts for a given word in the Trie. This effectively "removes" one instance of the word.

*   **Parameters**:
    *   `word`: The word to erase.