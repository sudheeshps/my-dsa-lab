# B-Tree Data Structure

This is a generic B-Tree implementation that can hold elements of any type that implements the `Comparable` interface. A B-Tree is a self-balancing tree data structure that maintains sorted data and allows searches, sequential access, insertions, and deletions in logarithmic time.

## Usage

To use the `BTree` class, you first need to create an instance of it, specifying the minimum degree `t`:

```java
BTree<Integer> myBTree = new BTree<>(3);
```

## Method Descriptions

*   `insert(T key)`: Inserts a new key into the B-Tree. If the root is full, the tree will be restructured to accommodate the new key.

*   `traverse()`: Traverses the B-Tree and prints the keys in sorted order to the console.

*   `getTraversalAsList()`: Traverses the B-Tree and returns a `List` containing the keys in sorted order.

*   `getRoot()`: Returns the root node of the B-Tree.
