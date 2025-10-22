# Red-Black Tree

## Introduction

A Red-Black Tree is a self-balancing binary search tree. It is a complex but highly efficient data structure that guarantees `O(log n)` time complexity for search, insertion, and deletion operations, where `n` is the number of elements in the tree. It achieves this balance by enforcing a set of properties on the coloring of its nodes (red or black).

---

## History

Red-Black trees were invented by **Rudolf Bayer** in 1972, who called them "symmetric binary B-trees." The modern name and properties were formalized by **Leo J. Guibas** and **Robert Sedgewick** in 1978. They are widely used in practice, notably in the C++ Standard Template Library (STL) `std::map` and `std::set`, and in Java's `TreeMap` and `TreeSet`.

---

## Behaviour of a Red-Black Tree

Red-Black trees maintain balance by adhering to five specific properties:

1.  **Node Color**: Every node is either Red or Black.
2.  **Root Color**: The root is Black.
3.  **Red Node Children**: Every Red node must have two Black children (no two adjacent Red nodes).
4.  **Black Height**: Every path from a given node to any of its descendant `null` nodes (leaves) contains the same number of Black nodes.
5.  **Null Leaves**: All leaf nodes are Black (and contain no data).

When an insertion or deletion violates these properties, the tree performs a series of rotations and recoloring operations to restore balance. These operations are carefully designed to maintain the `O(log n)` height guarantee.

---

## Data Structure Operations

-   **Search**: `O(log n)` - Similar to a binary search tree, but guaranteed logarithmic due to balance.
-   **Insertion**: `O(log n)` - Involves searching for the insertion point, inserting the node (initially as Red), and then performing recoloring and rotations to restore properties.
-   **Deletion**: `O(log n)` - Involves searching for the node, deleting it, and then performing recoloring and rotations to restore properties.

---

## Comparison

-   **vs. Binary Search Tree (BST)**: Red-Black trees provide guaranteed `O(log n)` performance for all operations, whereas a regular BST can degrade to `O(n)` in the worst case.
-   **vs. AVL Tree**: Both are self-balancing BSTs with `O(log n)` performance. Red-Black trees are generally less strictly balanced than AVL trees, leading to fewer rotations on average, but AVL trees offer faster lookups due to their stricter balance.

---

## How the Data Structure is Implemented

A Red-Black tree implementation involves `Node` objects that store a value, references to left and right children, and a color (Red or Black). The implementation includes methods for:

-   `isRed(Node node)`: Checks the color of a node.
-   `rotateLeft(Node node)` and `rotateRight(Node node)`: Perform single rotations.
-   `flipColors(Node node)`: Changes the colors of a node and its children.
-   `insert(Node node, T value)` and `delete(Node node, T value)`: Recursive methods that handle insertion/deletion and trigger recoloring and rotations as needed to maintain Red-Black properties.

---

## Known Applications

-   **Associative Arrays**: Used in implementations of `map` and `set` in various standard libraries.
-   **Database Indexing**: For efficient storage and retrieval of data.
-   **Operating Systems**: Used in schedulers and file systems.
-   **Computational Geometry**: For storing and querying geometric data.

---

## API Documentation

### `public void insert(T value)`

Inserts a new value into the Red-Black tree.

-   **Parameters:**
    -   `value`: The value to be inserted.

### `public void delete(T value)`

Deletes a value from the Red-Black tree.

-   **Parameters:**
    -   `value`: The value to be deleted.

### `public boolean search(T value)`

Searches for a value in the Red-Black tree.

-   **Parameters:**
    -   `value`: The value to search for.
-   **Returns:**
    -   `true` if the value is found, `false` otherwise.

### `public int size()`

Returns the number of elements in the Red-Black tree.

-   **Returns:**
    -   The number of elements.
