package com.sudhi.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        if (rootData == null) {
            root = null;
        } else {
            root = new Node<>(rootData);
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.data);
        for (Node<T> child : node.children) {
            preOrder(child, result);
        }
    }

    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        for (Node<T> child : node.children) {
            postOrder(child, result);
        }
        result.add(node.data);
    }

    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    // This is a simplified in-order for a generic tree, typically in-order is for binary trees.
    // For a generic tree, it usually means visiting the first child, then the node, then remaining children.
    private void inOrder(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }

        if (!node.children.isEmpty()) {
            inOrder(node.children.get(0), result);
        }

        result.add(node.data);

        for (int i = 1; i < node.children.size(); i++) {
            inOrder(node.children.get(i), result);
        }
    }

    public int height() {
        if (isEmpty()) return -1;
        return calculateHeight(root);
    }

    private int calculateHeight(Node<T> node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }

        int maxHeight = -1;
        for (Node<T> child : node.children) {
            maxHeight = Math.max(maxHeight, calculateHeight(child));
        }
        return 1 + maxHeight;
    }

    public int size() {
        if (isEmpty()) return 0;
        return calculateSize(root);
    }

    private int calculateSize(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int count = 1;
        for (Node<T> child : node.children) {
            count += calculateSize(child);
        }
        return count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<T> findNode(T data) {
        return findNode(root, data);
    }

    private Node<T> findNode(Node<T> current, T data) {
        if (current == null) {
            return null;
        }
        if (current.data.equals(data)) {
            return current;
        }
        for (Node<T> child : current.children) {
            Node<T> found = findNode(child, data);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public static class Node<T> {
        T data;
        Node<T> parent;
        List<Node<T>> children;

        public Node(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public T getData() {
            return data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public Node<T> addChild(T childData) {
            Node<T> child = new Node<>(childData);
            child.parent = this;
            this.children.add(child);
            return child;
        }

        public void removeChild(T childData) {
            children.removeIf(child -> child.data.equals(childData));
        }

        public Node<T> findChild(T childData) {
            for (Node<T> child : children) {
                if (child.data.equals(childData)) {
                    return child;
                }
            }
            return null;
        }
    }
}