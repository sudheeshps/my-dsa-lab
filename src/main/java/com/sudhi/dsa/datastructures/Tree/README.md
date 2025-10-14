# Tree Data Structure

## Introduction

A Tree is a hierarchical data structure that consists of nodes connected by edges. Unlike linear data structures like arrays and linked lists, a tree is non-linear and is used to represent hierarchical relationships. Each tree has a root node, and every node (except the root) has one parent. A node can have zero or more children.

---

## History

The concept of a tree as a data structure grew out of the work on graph theory and was implicitly used in many early algorithms. The formal study of trees and their properties became a central part of computer science with the advent of searching and sorting algorithms in the 1950s and 1960s. **Donald Knuth** made significant contributions to the formalization and analysis of trees in his seminal work, "The Art of Computer Programming."

---

## Properties

-   **Root**: The topmost node in the tree.
-   **Parent**: A node that has one or more child nodes.
-   **Child**: A node that has a parent node.
-   **Leaf**: A node that has no children.
-   **Height**: The length of the longest path from the root to a leaf.
-   **Depth**: The length of the path from the root to a specific node.
-   **Acyclic**: A tree is a type of graph that contains no cycles.

---

## How the Data Structure is Implemented

This is a generic tree implementation where each node can have multiple children.

-   **Node Class**: A private nested `Node<T>` class is used. Each node contains:
    -   `data`: The value stored in the node.
    -   `parent`: A reference to the parent node.
    -   `children`: A `List<Node<T>>` to store references to all its child nodes.
-   **Tree Class**: The main `Tree` class holds a single reference to the `root` node.
-   **Operations**: Methods like `preOrderTraversal`, `postOrderTraversal`, `height`, and `size` are implemented recursively, starting from the root and visiting each node in the tree.

---

## Complexity of operations

For a tree with *n* nodes:

| Operation      | Average Case | Worst Case |
| -------------- | ------------ | ---------- |
| **Search**     | O(n)         | O(n)       |
| **Insertion**  | O(1) (if parent is known) | O(n) (if search is needed) |
| **Deletion**   | O(1) (if node is known) | O(n) (if search is needed) |
| **Traversal**  | O(n)         | O(n)       |
| **Space**      | O(n)         | O(n)       |

*Note: For a general tree, searching for a node requires visiting all nodes in the worst case. The complexity is much better (O(log n)) for balanced binary search trees.*

---

## Known Applications

-   **File Systems**: Representing the directory structure of a computer.
-   **DOM in HTML**: The Document Object Model is a tree representation of an HTML document.
-   **Artificial Intelligence**: Decision trees and game trees.
-   **Family Trees**: Representing genealogical relationships.
-   **Syntax Trees**: In compilers to represent the structure of a program.

---

## Comparisons

| Data Structure | Tree                                         | Graph                                      |
| -------------- | -------------------------------------------- | ------------------------------------------ |
| **Structure**  | Acyclic, must be connected, has a root.      | Can have cycles, can be disconnected.      |
| **Hierarchy**  | Strictly hierarchical (parent-child).        | No inherent hierarchy.                     |
| **Paths**      | Exactly one path between any two nodes.      | Can have multiple paths between nodes.     |

---

## API Documentation

### `public Tree(T rootData)`
Constructs a new tree with a root node containing the given data.

### `public Node<T> getRoot()`
Returns the root node of the tree.

### `public List<T> preOrderTraversal()`
Performs a pre-order traversal (Root, Left, Right) of the tree and returns a `List` of the node data.

### `public List<T> postOrderTraversal()`
Performs a post-order traversal (Left, Right, Root) of the tree and returns a `List` of the node data.

### `public List<T> inOrderTraversal()`
Performs an in-order traversal (Left, Root, Right) of the tree. *Note: This implementation assumes a binary tree and only considers the first two children of each node.*

### `public int height()`
Returns the height of the tree.

### `public int size()`
Returns the number of nodes in the tree.

### `public boolean isEmpty()`
Returns `true` if the tree is empty.

### Node Class API

-   `public T getData()`: Returns the data stored in the node.
-   `public Node<T> getParent()`: Returns the parent of the node.
-   `public List<Node<T>> getChildren()`: Returns a `List` of the node's children.
-   `public Node<T> addChild(T data)`: Adds a new child to the node with the given data and returns the new child node.
