package main.java.com.sudhi.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private Node<T> root;

    public Tree(T rootData) {
        if (rootData != null) {
            root = new Node<>();
            root.data = rootData;
        } else {
            root = null;
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    private void preOrderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            result.add(node.getData());
            for (Node<T> child : node.getChildren()) {
                preOrderTraversal(child, result);
            }
        }
    }

    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            for (Node<T> child : node.getChildren()) {
                postOrderTraversal(child, result);
            }
            result.add(node.getData());
        }
    }

    /**
     * In-order traversal is not uniquely defined for a general tree.
     * This implementation assumes a binary tree and only considers the first two children.
     */
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            List<Node<T>> children = node.getChildren();
            if (children.size() > 0) {
                inOrderTraversal(children.get(0), result);
            }
            result.add(node.getData());
            if (children.size() > 1) {
                inOrderTraversal(children.get(1), result);
            }
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        int maxHeight = -1;
        for (Node<T> child : node.getChildren()) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return maxHeight + 1;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int count = 1;
        for (Node<T> child : node.getChildren()) {
            count += size(child);
        }
        return count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children = new ArrayList<>();

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public Node<T> addChild(T data) {
            Node<T> child = new Node<>();
            child.setData(data);
            child.setParent(this);
            this.children.add(child);
            return child;
        }
    }
}
