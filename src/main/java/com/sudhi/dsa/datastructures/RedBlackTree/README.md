# Red-Black Tree Data Structure

## Introduction

A Red-Black Tree is a type of self-balancing Binary Search Tree (BST). While not perfectly balanced like an AVL tree, it maintains a sufficient balance to guarantee that major operations like search, insertion, and deletion have a worst-case time complexity of O(log n). This balance is achieved by coloring each node in the tree with either "red" or "black" and enforcing a set of rules that govern how the colors are arranged.

---

## History

The Red-Black Tree was invented in 1972 by **Rudolf Bayer**, who called them "symmetric binary B-trees." The modern name and the properties as we know them today were introduced in a 1978 paper, "A Dichromatic Framework for Balanced Trees," by **Leonidas J. Guibas and Robert Sedgewick**. They were the ones who first used the red and black color convention.

---

## Properties

The self-balancing property is maintained through a set of strict rules, or invariants, that govern the coloring of the nodes:

1.  **Node Color**: Every node is either red or black.
2.  **Root Property**: The root node is always black.
3.  **Leaf Property**: All leaves (NIL nodes) are considered black.
4.  **Red Property**: If a node is red, then both its children must be black. This means you will never find two consecutive red nodes on a path.
5.  **Black-Height Property**: Every path from a given node to any of its descendant NIL leaves contains the same number of black nodes.

These color constraints are the core of the Red-Black Tree's design. The prohibition of consecutive red nodes and the uniform black-height work together to ensure that the longest path from the root to a leaf is no more than twice as long as the shortest path. This is how the tree remains approximately balanced.

---

## How the Data Structure is Implemented

This implementation maintains the red-black properties through a combination of color flips and rotations after each insertion.

-   **Node Class**: The private `Node` class stores the `key`, `value`, `color` (as a boolean), the `size` of the subtree rooted at the node, and references to its `left` and `right` children.

-   **Insertion**: The `put` method performs a standard BST insertion and colors the new node `RED`. 

-   **Rebalancing**: After insertion, the `put` method recursively walks back up the tree. At each node, it applies a series of checks and corrective actions to fix any violations of the red-black properties:
    -   `rotateLeft()` and `rotateRight()`: These helper methods perform rotations to restructure the tree.
    -   `flipColors()`: This method changes the color of a node and its two children to restore balance.

The specific combination of these operations depends on the colors of the current node, its parent, and its uncle, ensuring that all invariants are restored.

---

## Complexity of operations

| Operation      | Average Case | Worst Case |
| -------------- | ------------ | ---------- |
| **Put (Insert)** | O(log n)     | O(log n)   |
| **Get (Search)** | O(log n)     | O(log n)   |
| **Remove**     | O(log n)     | O(log n)   |
| **Space**      | O(n)         | O(n)       |

*Deletion is not implemented in this specific class, but its complexity is O(log n) in a full implementation.*

---

## Known Applications

Red-Black Trees offer a good balance between strict balancing and the complexity of rebalancing operations, making them very popular in practice.

-   **Standard Library Implementations**: Used in the `TreeMap` and `TreeSet` classes in Java, and the `std::map` and `std::set` in C++.
-   **Schedulers**: In operating systems for managing CPU scheduling.
-   **Computational Geometry**: For various geometric data processing tasks.
-   **K-Means Clustering**: Can be used to efficiently find the nearest neighbor.

---

## Comparisons

| Feature        | Red-Black Tree                               | AVL Tree                                     |
| -------------- | -------------------------------------------- | -------------------------------------------- |
| **Balancing**  | Less strict, faster insertions/deletions.    | Stricter balance, faster lookups.            |
| **Rotations**  | Max 2 rotations per insertion.               | Can require more rotations.                  |
| **Use Case**   | Good for write-heavy applications.           | Good for read-heavy applications.            |

---

## API Documentation

### `public void put(Key key, Value val)`
Inserts a key-value pair into the tree. If the key already exists, its value is updated. The tree is rebalanced automatically after insertion.

### `public Value get(Key key)`
Retrieves the value associated with the given key.
-   **Returns**: The value, or `null` if the key is not found.

### `public boolean contains(Key key)`
Checks if the tree contains the specified key.

### `public int size()`
Returns the number of key-value pairs in the tree.

### `public boolean isEmpty()`
Returns `true` if the tree is empty.

### `public Node getRoot()`
Returns the root node of the tree.
