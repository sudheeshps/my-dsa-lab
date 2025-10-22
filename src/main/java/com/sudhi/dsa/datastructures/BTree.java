package com.sudhi.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;

public class BTree<T extends Comparable<T>> {
    private BTreeNode<T> root;
    private int t; // Minimum degree (defines the range of children for a node)

    public BTree(int t) {
        this.t = t;
        this.root = new BTreeNode<>(t, true);
    }

    public void insert(T key) {
        BTreeNode<T> r = root;
        if (r.n == 2 * t - 1) { // Root is full
            BTreeNode<T> s = new BTreeNode<>(t, false);
            s.children[0] = r;
            s.splitChild(0, r, t);
            int i = 0;
            if (s.keys[0].compareTo(key) < 0) {
                i++;
            }
            s.children[i].insertNonFull(key, t);
            root = s;
        } else {
            r.insertNonFull(key, t);
        }
    }

    public void traverse() {
        if (root != null) {
            root.traverse();
        }
        System.out.println();
    }

    public List<T> getTraversalAsList() {
        List<T> result = new ArrayList<>();
        if (root != null) {
            root.getTraversalAsList(result);
        }
        return result;
    }

    public BTreeNode<T> getRoot() {
        return root;
    }

    // BTreeNode inner class
    public static class BTreeNode<T extends Comparable<T>> {
        int n; // Current number of keys
        T[] keys; // An array of keys
        BTreeNode<T>[] children; // An array of child pointers
        boolean leaf; // Is true when node is leaf. Otherwise false

        @SuppressWarnings("unchecked")
        public BTreeNode(int t, boolean leaf) {
            this.leaf = leaf;
            this.keys = (T[]) new Comparable[2 * t - 1];
            this.children = new BTreeNode[2 * t];
            this.n = 0;
        }

        public void traverse() {
            int i;
            for (i = 0; i < n; i++) {
                if (!leaf) {
                    children[i].traverse();
                }
                System.out.print(" " + keys[i]);
            }

            if (!leaf) {
                children[i].traverse();
            }
        }

        public void getTraversalAsList(List<T> result) {
            int i;
            for (i = 0; i < n; i++) {
                if (!leaf) {
                    children[i].getTraversalAsList(result);
                }
                result.add(keys[i]);
            }

            if (!leaf) {
                children[i].getTraversalAsList(result);
            }
        }

        public BTreeNode<T> search(T key) {
            int i = 0;
            while (i < n && key.compareTo(keys[i]) > 0) {
                i++;
            }

            if (i < n && key.compareTo(keys[i]) == 0) {
                return this;
            }

            if (leaf) {
                return null;
            }

            return children[i].search(key);
        }

        private void insertNonFull(T key, int t) {
            int i = n - 1;

            if (leaf) {
                while (i >= 0 && keys[i].compareTo(key) > 0) {
                    keys[i + 1] = keys[i];
                    i--;
                }
                keys[i + 1] = key;
                n++;
            } else {
                while (i >= 0 && keys[i].compareTo(key) > 0) {
                    i--;
                }
                i++;
                if (children[i].n == 2 * t - 1) {
                    splitChild(i, children[i], t);
                    if (keys[i].compareTo(key) < 0) {
                        i++;
                    }
                }
                children[i].insertNonFull(key, t);
            }
        }

        private void splitChild(int i, BTreeNode<T> y, int t) {
            BTreeNode<T> z = new BTreeNode<>(t, y.leaf);
            z.n = t - 1;

            for (int j = 0; j < t - 1; j++) {
                z.keys[j] = y.keys[j + t];
            }

            if (!y.leaf) {
                for (int j = 0; j < t; j++) {
                    z.children[j] = y.children[j + t];
                }
            }

            y.n = t - 1;

            for (int j = n; j >= i + 1; j--) {
                children[j + 1] = children[j];
            }
            children[i + 1] = z;

            for (int j = n - 1; j >= i; j--) {
                keys[j + 1] = keys[j];
            }
            keys[i] = y.keys[t - 1];
            n++;
        }
    }
}
