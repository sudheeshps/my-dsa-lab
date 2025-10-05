package com.sudhi.dsa.datastructures.BTree;

import java.util.ArrayList;
import java.util.List;

public class BTree<T extends Comparable<T>> {

    private BTreeNode root;
    private final int t; // Minimum degree

    public BTree(int t) {
        this.t = t;
        this.root = new BTreeNode(t, true);
    }

    public BTreeNode getRoot() {
        return root;
    }

    public void insert(T key) {
        BTreeNode r = root;
        if (r.n == 2 * t - 1) {
            BTreeNode s = new BTreeNode(t, false);
            s.C[0] = r;
            s.splitChild(0, r);
            int i = 0;
            if (((T)s.keys[0]).compareTo(key) < 0) {
                i++;
            }
            s.C[i].insertNonFull(key);
            root = s;
        } else {
            r.insertNonFull(key);
        }
    }

    public void traverse() {
        if (root != null) {
            root.traverse();
        }
    }

    public List<T> getTraversalAsList() {
        List<T> list = new ArrayList<>();
        if (root != null) {
            root.traverse(list);
        }
        return list;
    }

    public class BTreeNode {
        public Object[] keys;
        public int t;
        public BTreeNode[] C;
        public int n;
        public boolean leaf;

        BTreeNode(int t, boolean leaf) {
            this.t = t;
            this.leaf = leaf;
            this.keys = new Object[2 * t - 1];
            this.C = new BTree.BTreeNode[2 * t];
            this.n = 0;
        }

        void traverse() {
            int i;
            for (i = 0; i < this.n; i++) {
                if (!this.leaf) {
                    C[i].traverse();
                }
                System.out.print(" " + keys[i]);
            }

            if (!leaf) {
                C[i].traverse();
            }
        }
        
        void traverse(List<T> list) {
            int i = 0;
            for (i = 0; i < n; i++) {
                if (!leaf) {
                    C[i].traverse(list);
                }
                list.add((T)keys[i]);
            }
            if (!leaf) {
                C[i].traverse(list);
            }
        }

        void insertNonFull(T key) {
            int i = n - 1;
            if (leaf) {
                while (i >= 0 && ((T)keys[i]).compareTo(key) > 0) {
                    keys[i + 1] = keys[i];
                    i--;
                }
                keys[i + 1] = key;
                n = n + 1;
            } else {
                while (i >= 0 && ((T)keys[i]).compareTo(key) > 0) {
                    i--;
                }
                if (C[i + 1].n == 2 * t - 1) {
                    splitChild(i + 1, C[i + 1]);
                    if (((T)keys[i + 1]).compareTo(key) < 0) {
                        i++;
                    }
                }
                C[i + 1].insertNonFull(key);
            }
        }

        void splitChild(int i, BTreeNode y) {
            BTreeNode z = new BTreeNode(y.t, y.leaf);
            z.n = t - 1;
            for (int j = 0; j < t - 1; j++) {
                z.keys[j] = y.keys[j + t];
            }
            if (!y.leaf) {
                for (int j = 0; j < t; j++) {
                    z.C[j] = y.C[j + t];
                }
            }
            y.n = t - 1;
            for (int j = n; j >= i + 1; j--) {
                C[j + 1] = C[j];
            }
            C[i + 1] = z;
            for (int j = n - 1; j >= i; j--) {
                keys[j + 1] = keys[j];
            }
            keys[i] = y.keys[t - 1];
            n = n + 1;
        }
    }
}