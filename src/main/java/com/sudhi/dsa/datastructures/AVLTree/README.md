# AVL Tree Data Structure

## Introduction

An AVL Tree is a self-balancing Binary Search Tree (BST) where the heights of the two child subtrees of any node differ by at most one. This strict balancing property ensures that operations like search, insertion, and deletion have a guaranteed worst-case time complexity of O(log n), making them highly efficient for look-up intensive applications.

## History

The AVL tree was invented in 1962 by two Soviet inventors, **Georgy Adelson-Velsky** and **Evgenii Landis**, and is named after them using the acronym AVL. It was the first data structure to be invented that performed self-balancing, guaranteeing logarithmic time complexity for its major operations long before other structures like Red-Black Trees were discovered.

## Properties

*   **BST Property**: For any given node, all keys in the left subtree are less than the node's key, and all keys in the right subtree are greater.
*   **Balance Factor**: Every node maintains a "balance factor," which is `height(left subtree) - height(right subtree)`. In a valid AVL tree, every node must have a balance factor of -1, 0, or 1.
*   **Self-Balancing**: If an insertion or deletion causes any node to have a balance factor outside the valid range (e.g., -2 or 2), the tree performs "rotations" to restore the balance.

## How the Data Structure is Implemented

This AVL tree is implemented using a `Node` class, where each node contains the `key`, its `height`, and references to its `left` and `right` children.

*   **Insertion**: A new key is first inserted just like in a standard BST. After insertion, the algorithm traverses back up the tree from the insertion point to the root, updating the height of each ancestor node.
*   **Rebalancing**: During the traversal up the tree, it calculates the balance factor of each node. If a node is found to be unbalanced, the appropriate rotation (or combination of rotations) is performed to restore the AVL property. The four rotation cases are:
    1.  **Left-Left Case**: Fixed with a single `rightRotate`.
    2.  **Right-Right Case**: Fixed with a single `leftRotate`.
    3.  **Left-Right Case**: Fixed with a `leftRotate` on the left child, followed by a `rightRotate` on the current node.
    4.  **Right-Left Case**: Fixed with a `rightRotate` on the right child, followed by a `leftRotate` on the current node.

## Complexity of operations

The self-balancing nature of the AVL tree provides guaranteed logarithmic performance for its main operations.

| Operation | Average Case | Worst Case |
| :-------- | :----------: | :--------: |
| **Access/Search** | O(log n) | O(log n) |
| **Insertion** | O(log n) | O(log n) |
| **Deletion** | O(log n) | O(log n) |

## Known Applications

Due to their strict balance, AVL trees are used in applications where fast lookups are critical and insertions/deletions are less frequent compared to lookups.

*   **Database Indexing**: Used in database systems where fast retrieval of data is essential.
*   **In-memory Dictionaries or Sets**: When a sorted collection with guaranteed fast search is needed.
*   **Network Routing**: Can be used in routing tables where fast lookups of routes are required.

## Comparisons

*   **AVL Tree vs. Red-Black Tree**:
    *   **Balance**: AVL trees are more strictly balanced than Red-Black trees. This can lead to faster lookups in AVL trees.
    *   **Rotations**: AVL trees may require more rotations on insertion/deletion, making them slightly slower for write-heavy workloads. Red-Black trees require at most two rotations for insertion.
    *   **Memory**: Red-Black trees require one extra bit of storage per node (for the color), whereas AVL trees store an integer balance factor (height difference).

*   **AVL Tree vs. standard BST**:
    *   A standard BST can become unbalanced (effectively a linked list), leading to O(n) worst-case complexity for operations. AVL trees guarantee O(log n) complexity.

## API documentation

### `public void insert(T key)`
Inserts a new key into the AVL tree. If the key already exists, the tree is not modified. After insertion, the tree automatically performs rotations if necessary to maintain the AVL balance property.

*   **Parameters**:
    *   `key`: The `Comparable` element to be inserted.

### `public Node getRoot()`
Returns the root node of the AVL tree.

*   **Returns**: The `Node` object that is the current root of the tree, or `null` if the tree is empty.

### `public int getBalance(Node N)`
Returns the balance factor of a given node.

*   **Parameters**:
    *   `N`: The `Node` for which to calculate the balance factor.
*   **Returns**: An `int` representing the difference in height between the node's left and right subtrees.