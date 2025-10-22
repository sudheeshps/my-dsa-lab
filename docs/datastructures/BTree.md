# B-Tree

## Introduction

A B-tree is a self-balancing tree data structure that maintains sorted data and allows searches, sequential access, insertions, and deletions in logarithmic time. It is a generalization of a binary search tree in that a node can have more than two children. Unlike self-balancing binary search trees (like AVL or Red-Black trees), B-trees are optimized for systems that read and write large blocks of data, such as disk storage. They are commonly used in databases and file systems.

---

## History

B-trees were invented by **Rudolf Bayer** and **Edward M. McCreight** at Boeing Scientific Research Labs in 1971. The original paper did not explain the meaning of "B" in B-tree, but it is widely believed to stand for "Boeing," "balanced," or "Bayer." They were designed to efficiently handle large amounts of data that could not fit into main memory.

---

## Behaviour of a B-Tree

-   **Multi-way Tree**: Each node can have a variable number of children within a pre-defined range. This range is determined by the `order` (or `minimum degree`) of the B-tree.
-   **Self-Balancing**: All leaf nodes are at the same depth, ensuring that search, insertion, and deletion operations always take logarithmic time. This is achieved through splitting and merging operations.
-   **Optimized for Disk I/O**: Nodes are typically sized to correspond to disk block sizes. This minimizes the number of disk accesses, which are much slower than memory accesses.
-   **Sorted Keys**: Keys within each node are stored in sorted order.

---

## Data Structure Operations

-   **Search**: `O(log n)` - The height of a B-tree is logarithmic, and each node traversal involves a linear scan of keys (or binary search if many keys per node), but the number of keys per node is bounded by the order.
-   **Insertion**: `O(log n)` - Involves searching for the insertion point, inserting the key, and potentially splitting nodes if they become full.
-   **Deletion**: `O(log n)` - Involves searching for the key, deleting it, and potentially merging or redistributing keys with sibling nodes if a node becomes underflowed.

---

## Comparison

-   **vs. Binary Search Tree (BST)**: B-trees are a generalization of BSTs. While BSTs are typically binary, B-trees can have many children per node. B-trees are designed for disk-based storage, while BSTs are generally for in-memory operations.
-   **vs. AVL/Red-Black Trees**: These are binary self-balancing trees optimized for in-memory performance. B-trees are multi-way trees optimized for minimizing disk I/O.

---

## How the Data Structure is Implemented

A B-tree implementation involves `Node` objects that contain an array of keys, an array of child pointers, and a boolean indicating if it's a leaf node. Key methods include:

-   `search(Node node, T key)`: Finds a key in the subtree rooted at `node`.
-   `insert(T key)`: Inserts a key, potentially splitting nodes from bottom-up.
-   `delete(T key)`: Deletes a key, potentially merging or redistributing keys.
-   `traverse()`: Performs an in-order traversal to print keys.

---

## Known Applications

-   **Database Indexing**: The most common application, as they efficiently store and retrieve data from disk.
-   **File Systems**: Used to organize files and directories (e.g., NTFS, HFS+).
-   **Large Data Storage**: Any system that needs to manage and access large amounts of data that cannot fit entirely in RAM.

---

## API Documentation

### `public void insert(T key)`

Inserts a new key into the B-tree.

-   **Parameters:**
    -   `key`: The key to be inserted.

### `public void delete(T key)`

Deletes a key from the B-tree.

-   **Parameters:**
    -   `key`: The key to be deleted.

### `public boolean search(T key)`

Searches for a key in the B-tree.

-   **Parameters:**
    -   `key`: The key to search for.
-   **Returns:**
    -   `true` if the key is found, `false` otherwise.

### `public void traverse()`

Performs an in-order traversal of the B-tree and prints its keys.
