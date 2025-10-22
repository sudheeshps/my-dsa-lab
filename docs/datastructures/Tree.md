# Tree (Binary Search Tree)

## Introduction

A tree is a non-linear data structure that simulates a hierarchical tree structure, with a root value and subtrees of children with a parent node, represented as a set of linked nodes. A Binary Search Tree (BST) is a special type of binary tree where for each node, all elements in its left subtree are less than the node's value, and all elements in its right subtree are greater than the node's value. This property allows for efficient searching, insertion, and deletion of elements.

---

## History

The concept of trees in computer science dates back to the early days of computing. Binary search trees were formally introduced by **P.F. Windley** in 1960 and further developed by **T.N. Hibbard** in 1962. They quickly became a fundamental data structure due to their efficiency in maintaining sorted data.

---

## Behaviour of a Binary Search Tree

-   **Hierarchical Structure**: Data is organized in a parent-child relationship.
-   **Binary Property**: Each node has at most two children (left and right).
-   **Search Tree Property**: For any node `N`:
    -   All values in the left subtree of `N` are less than the value of `N`.
    -   All values in the right subtree of `N` are greater than the value of `N`.
-   **No Duplicates**: Typically, BSTs do not allow duplicate values.

---

## Data Structure Operations

-   **Search**: `O(log n)` on average, `O(n)` in worst case (for skewed trees).
-   **Insertion**: `O(log n)` on average, `O(n)` in worst case.
-   **Deletion**: `O(log n)` on average, `O(n)` in worst case.
-   **Traversal (In-order, Pre-order, Post-order)**: `O(n)` - Visits all nodes.

---

## Comparison

-   **vs. Array/Linked List**: BSTs offer better average-case performance for search, insertion, and deletion than unsorted arrays/linked lists. For sorted arrays, search is `O(log n)`, but insertion/deletion is `O(n)`.
-   **vs. Balanced BSTs (AVL, Red-Black Tree)**: Regular BSTs can become unbalanced, leading to `O(n)` worst-case performance. Balanced BSTs guarantee `O(log n)` performance for all operations by performing rotations to maintain balance.

---

## How the Data Structure is Implemented

This `Tree` implementation represents a Binary Search Tree. It uses a nested `Node` class, where each `Node` contains a `value` and references to its `left` and `right` children. The `Tree` class maintains a `root` pointer.

-   **`insert(Node current, T value)`**: A recursive method to find the correct position and insert a new node.
-   **`delete(Node current, T value)`**: A recursive method to find and delete a node, handling various cases (no children, one child, two children).
-   **`search(Node current, T value)`**: A recursive method to find a value in the tree.
-   **`inorderTraversal(Node node)`**: A recursive method for in-order traversal (visits nodes in sorted order).

---

## Known Applications

-   **Database Indexing**: For fast data retrieval.
-   **Symbol Tables**: In compilers and interpreters.
-   **Implementing other data structures**: Sets and maps.
-   **Sorting**: In-order traversal of a BST produces sorted output.

---

## API Documentation

### `public void insert(T value)`

Inserts a new value into the binary search tree.

-   **Parameters:**
    -   `value`: The value to be inserted.

### `public void delete(T value)`

Deletes a value from the binary search tree.

-   **Parameters:**
    -   `value`: The value to be deleted.

### `public boolean search(T value)`

Searches for a value in the binary search tree.

-   **Parameters:**
    -   `value`: The value to search for.
-   **Returns:**
    -   `true` if the value is found, `false` otherwise.

### `public void inorderTraversal()`

Performs an in-order traversal of the tree and prints its elements.

### `public int size()`

Returns the number of elements in the tree.

-   **Returns:**
    -   The number of elements.
