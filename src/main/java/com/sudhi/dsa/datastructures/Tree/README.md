# Tree Data Structure

This is a generic Tree implementation that can hold elements of any type. A tree is a hierarchical data structure that consists of nodes connected by edges.

## Usage

To use the `Tree` class, you first need to create an instance of it, specifying the data for the root node:

```java
Tree<Integer> myTree = new Tree<>(1);
```

You can then add children to the root or any other node:

```java
Tree.Node<Integer> root = myTree.getRoot();
Tree.Node<Integer> child1 = root.addChild(2);
Tree.Node<Integer> child2 = root.addChild(3);
child1.addChild(4);
```

## Method Descriptions

*   `getRoot()`: Returns the root node of the tree.

*   `preOrderTraversal()`: Performs a pre-order traversal of the tree and returns a `List` of the node data.

*   `postOrderTraversal()`: Performs a post-order traversal of the tree and returns a `List` of the node data.

*   `inOrderTraversal()`: Performs an in-order traversal of the tree and returns a `List` of the node data. This implementation assumes a binary tree and only considers the first two children of each node.

*   `height()`: Returns the height of the tree.

*   `size()`: Returns the number of nodes in the tree.

*   `isEmpty()`: Returns `true` if the tree is empty, `false` otherwise.

### Node Class

The `Tree` class has a nested `Node` class that represents a node in the tree.

*   `getData()`: Returns the data stored in the node.

*   `getParent()`: Returns the parent of the node.

*   `getChildren()`: Returns a `List` of the node's children.

*   `addChild(T data)`: Adds a new child to the node with the given data and returns the new child node.
