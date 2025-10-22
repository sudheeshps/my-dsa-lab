# AVL Tree

## Introduction

An AVL tree (Adelson-Velsky and Landis tree) is a self-balancing binary search tree. It is the first self-balancing binary search tree ever invented. In an AVL tree, the heights of the two child subtrees of any node differ by at most one. This property ensures that the tree remains balanced, preventing worst-case scenarios that can degrade the performance of a regular binary search tree to `O(n)`.

---

## History

The AVL tree was named after its inventors, **Georgy Adelson-Velsky** and **Evgenii Landis**, who published their paper "An algorithm for the organization of information" in 1962. It was a groundbreaking development in data structures, providing a guaranteed logarithmic time complexity for search, insertion, and deletion operations.

---

## Behaviour of an AVL Tree

-   **Self-Balancing**: After every insertion or deletion, the AVL tree checks its balance factor (height difference between left and right subtrees). If the balance factor becomes greater than 1 or less than -1, it performs rotations to restore the balance.
-   **Rotations**: There are four types of rotations: Left Rotation, Right Rotation, Left-Right Rotation, and Right-Left Rotation. These operations rearrange the nodes to maintain the AVL property while preserving the binary search tree property.
-   **Logarithmic Height**: The height of an AVL tree with `n` nodes is always `O(log n)`, which guarantees efficient operations.

---

## Data Structure Operations

-   **Search**: `O(log n)` - Similar to a binary search tree, but guaranteed logarithmic due to balance.
-   **Insertion**: `O(log n)` - Involves searching for the insertion point, inserting the node, and then potentially performing rotations to rebalance.
-   **Deletion**: `O(log n)` - Involves searching for the node, deleting it, and then potentially performing rotations to rebalance.

---

## Comparison

-   **vs. Binary Search Tree (BST)**: AVL trees provide guaranteed `O(log n)` performance for all operations, whereas a regular BST can degrade to `O(n)` in the worst case (e.g., when elements are inserted in sorted order).
-   **vs. Red-Black Tree**: Both are self-balancing BSTs with `O(log n)` performance. Red-Black trees are generally less strictly balanced than AVL trees, leading to fewer rotations on average, but AVL trees offer faster lookups due to their stricter balance.

---

## How the Data Structure is Implemented

An AVL tree is typically implemented with nodes that store a value, references to left and right children, and a height or balance factor. The implementation includes methods for:

-   `height(Node node)`: Calculates the height of a subtree.
-   `balanceFactor(Node node)`: Calculates the balance factor of a node.
-   `rotateLeft(Node node)` and `rotateRight(Node node)`: Perform single rotations.
-   `insert(Node node, T value)` and `delete(Node node, T value)`: Recursive methods that handle insertion/deletion and trigger rotations as needed.

---

## Known Applications

-   **Databases**: Used in database indexing for fast data retrieval.
-   **File Systems**: For organizing and searching files.
-   **Symbol Tables**: In compilers and interpreters to store information about identifiers.
-   **Any application requiring fast lookups, insertions, and deletions**: Where guaranteed performance is critical.

---

## API Documentation

### `public void insert(T value)`

Inserts a new value into the AVL tree.

-   **Parameters:**
    -   `value`: The value to be inserted.

### `public void delete(T value)`

Deletes a value from the AVL tree.

-   **Parameters:**
    -   `value`: The value to be deleted.

### `public boolean search(T value)`

Searches for a value in the AVL tree.

-   **Parameters:**
    -   `value`: The value to search for.
-   **Returns:**
    -   `true` if the value is found, `false` otherwise.

### `public int height()`

Returns the height of the AVL tree.

-   **Returns:**
    -   The height of the tree (number of edges on the longest path from the root to a leaf). Returns -1 for an empty tree.
