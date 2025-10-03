# Red-Black Tree Data Structure

This is a generic Red-Black Tree implementation that can store key-value pairs. A red-black tree is a self-balancing Binary Search Tree (BST) where each node has an extra bit for storing color (red or black). By constraining the way nodes are colored on any path from the root to a leaf, red-black trees ensure that no such path is more than twice as long as any other, so that the tree remains approximately balanced.

## Usage

To use the `RedBlackTree` class, you first need to create an instance of it:

```java
RedBlackTree<String, Integer> myRBTree = new RedBlackTree<>();
```

You can then insert key-value pairs into the tree:

```java
myRBTree.put("apple", 1);
myRBTree.put("banana", 2);
myRBTree.put("cherry", 3);
```

The tree will automatically perform rotations and color flips to maintain its balance.

## Method Descriptions

*   `put(Key key, Value val)`: Inserts a key-value pair into the red-black tree. If the key already exists, its value is updated. The tree is rebalanced if necessary.

*   `get(Key key)`: Retrieves the value associated with the given key. Returns `null` if the key is not found.

*   `contains(Key key)`: Returns `true` if the tree contains the specified key, `false` otherwise.

*   `getRoot()`: Returns the root node of the red-black tree.

*   `size()`: Returns the number of key-value pairs in the tree.

*   `isEmpty()`: Returns `true` if the tree is empty, `false` otherwise.

### Node Class

The `RedBlackTree` class has a nested `Node` class that represents a node in the tree. Each node contains the key, value, color, size, and references to its left and right children.
