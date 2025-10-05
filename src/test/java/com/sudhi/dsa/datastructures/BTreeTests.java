package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.BTree.BTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BTreeTests {

    private BTree<Integer> bTree;

    @BeforeEach
    void setUp() {
        bTree = new BTree<>(3);
    }

    @Test
    void givenNewBTree_whenCreated_thenRootIsLeafAndHasNoKeys() {
        BTree<Integer>.BTreeNode root = bTree.getRoot();
        assertTrue(root.leaf);
        assertEquals(0, root.n);
    }

    @Test
    void givenBTree_whenSingleElementInserted_thenRootHasOneKey() {
        bTree.insert(10);
        BTree<Integer>.BTreeNode root = bTree.getRoot();
        assertEquals(1, root.n);
        assertEquals(10, root.keys[0]);
    }

    @Test
    void givenBTree_whenMultipleElementsInserted_thenTraversalIsCorrect() {
        List<Integer> elements = Arrays.asList(10, 20, 5, 15, 25, 30, 3, 8, 12, 18, 22, 28, 32, 35, 2, 1, 4, 6, 7, 9, 11, 13, 14, 16, 17, 19, 21, 23, 24, 26, 27, 29, 31, 33, 34);
        for (Integer element : elements) {
            bTree.insert(element);
        }

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35);
        assertEquals(expected, bTree.getTraversalAsList());
    }

    @Test
    void givenBTree_whenRootIsFullAndSplit_thenNewRootHasOneKeyAndTwoChildren() {
        // t = 3, so max keys = 5
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(30);
        bTree.insert(40);
        bTree.insert(50);
        bTree.insert(60); // This should cause a split

        BTree<Integer>.BTreeNode root = bTree.getRoot();
        assertEquals(1, root.n);
        assertEquals(30, root.keys[0]);
        assertFalse(root.leaf);
        assertNotNull(root.C[0]);
        assertNotNull(root.C[1]);

        BTree<Integer>.BTreeNode leftChild = root.C[0];
        assertEquals(2, leftChild.n);
        assertEquals(10, leftChild.keys[0]);
        assertEquals(20, leftChild.keys[1]);

        BTree<Integer>.BTreeNode rightChild = root.C[1];
        assertEquals(3, rightChild.n);
        assertEquals(40, rightChild.keys[0]);
        assertEquals(50, rightChild.keys[1]);
        assertEquals(60, rightChild.keys[2]);
    }
}
