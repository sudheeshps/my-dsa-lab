# B-Tree Data Structure

## Introduction

A B-Tree is a self-balancing tree data structure that maintains sorted data and allows for efficient searches, sequential access, insertions, and deletions in logarithmic time. Unlike binary trees, B-Trees are not limited to two children per node; they are generalized search trees where each node can have many children. This high branching factor makes them well-suited for storage systems where reading a block of data is expensive (like hard drives or SSDs).

## History

The B-Tree was invented in 1971 by **Rudolf Bayer** and **Edward M. McCreight** while they were working at Boeing Research Labs. The exact meaning of "B" has never been officially specified, but suggestions include "Balanced," "Broad," "Bushy," or the names of the inventors, "Bayer" or "Boeing."

## Properties

A B-Tree is defined by a minimum degree, `t`. The properties of a B-Tree of degree `t` are as follows:

1.  Every node has at most `2t-1` keys.
2.  Every internal node (except the root) has at least `t-1` keys.
3.  The root has at least one key (unless the tree is empty).
4.  All leaves appear on the same level, ensuring the tree is always balanced.
5.  An internal node with `k` keys has `k+1` children.
6.  The keys within each node are kept in sorted order.

These properties ensure that the tree remains wide and shallow, keeping its height logarithmic with respect to the number of elements.

## How the Data Structure is Implemented

This B-Tree is implemented with a `BTreeNode` class.

*   **Nodes**: Each `BTreeNode` stores an array of keys, an array of child node references, the current number of keys `n`, and a boolean `leaf` flag.
*   **Insertion**: When a key is inserted, the algorithm finds the appropriate leaf node. If the leaf node is not full, the key is inserted directly in sorted order.
*   **Node Splitting**: If the leaf node is full (contains `2t-1` keys), it must be split. The median key is moved up to the parent node, and the remaining keys are split into two new nodes. This process may propagate up the tree, potentially splitting the root and increasing the tree's height by one.
*   **`insertNonFull`**: This is the main recursive helper method that inserts a key into a node that is guaranteed to be not full.
*   **`splitChild`**: This method is responsible for splitting a full child node of a given node.

## Complexity of operations

The performance of a B-Tree is characterized by its height, which is kept low by having a high branching factor.

| Operation | Average Case | Worst Case |
| :-------- | :----------: | :--------: |
| **Access/Search** | O(log n) | O(log n) |
| **Insertion** | O(log n) | O(log n) |
| **Deletion** | O(log n) | O(log n) |

## Known Applications

B-Trees are most commonly used in systems that need to read and write large blocks of data.

*   **Databases**: Almost all modern relational database systems (like PostgreSQL, Oracle, and SQL Server) use B-Trees or their variants (like B+ Trees) for indexing, as they allow for fast lookups of records.
*   **Filesystems**: Many filesystems, such as NTFS, HFS+, and ext4, use B-Trees to manage metadata, directories, and file extents.

## Comparisons

*   **B-Tree vs. AVL/Red-Black Tree**:
    *   **Branching Factor**: B-Trees have a much larger branching factor. Binary trees are essentially B-Trees of order 1 (t=2).
    *   **Use Case**: B-Trees are optimized for disk-based storage where I/O is slow, as their flat structure minimizes the number of disk reads. AVL and Red-Black trees are better for in-memory data structures where I/O is not a concern.
    *   **Node Size**: B-Tree nodes are designed to be large enough to fill a disk block or cache line.

## API documentation

### `public BTree(int t)`
Creates a new B-Tree with a specified minimum degree `t`.

*   **Parameters**:
    *   `t`: The minimum degree of the B-Tree. This determines the minimum (`t-1`) and maximum (`2t-1`) number of keys a node can hold.

### `public void insert(T key)`
Inserts a new key into the B-Tree. The tree structure is automatically adjusted to maintain the B-Tree properties, which may involve splitting nodes.

*   **Parameters**:
    *   `key`: The `Comparable` element to be inserted.

### `public void traverse()`
Performs an in-order traversal of the B-Tree and prints all the keys to the console.

### `public List<T> getTraversalAsList()`
Performs an in-order traversal of the B-Tree and returns a `List` containing all the keys in sorted order.

*   **Returns**: A `List<T>` of all keys in the tree.

### `public BTreeNode getRoot()`
Returns the root node of the B-Tree.

*   **Returns**: The `BTreeNode` object that is the current root of the tree.