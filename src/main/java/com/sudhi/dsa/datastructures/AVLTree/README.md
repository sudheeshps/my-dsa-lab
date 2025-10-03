# AVL Tree Data Structure

This is a generic AVL Tree implementation that can hold elements of any type that implements the `Comparable` interface. An AVL tree is a self-balancing Binary Search Tree (BST) where the difference between the heights of the left and right subtrees of any node is at most one.

## Usage

To use the `AVLTree` class, you first need to create an instance of it:

```java
AVLTree<Integer> myAVLTree = new AVLTree<>();
```

You can then insert elements into the tree:

```java
myAVLTree.insert(10);
myAVLTree.insert(20);
myAVLTree.insert(30);
```

The tree will automatically perform rotations to maintain its balance.

## Method Descriptions

*   `insert(T key)`: Inserts a new key into the AVL tree. After insertion, it checks the balance factor of the nodes and performs rotations if necessary to maintain the AVL property.

*   `getRoot()`: Returns the root node of the AVL tree.

*   `getBalance(Node N)`: Returns the balance factor of a given node (the difference in height between its left and right subtrees).

### Node Class

The `AVLTree` class has a nested `Node` class that represents a node in the tree. Each node contains the key, its height, and references to its left and right children.
