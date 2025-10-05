package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.AVLTree.AVLTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTests {

    private AVLTree<Integer> avlTree;

    @BeforeEach
    public void setUp() {
        avlTree = new AVLTree<>();
    }

    @Test
    public void givenEmptyTree_whenNewNodeIsInserted_thenTreeIsNotEmpty() {
        avlTree.insert(10);
        assertNotNull(avlTree.getRoot());
    }

    @Test
    public void givenEmptyTree_whenNewNodeIsInserted_thenRootHasCorrectKey() {
        avlTree.insert(10);
        assertEquals(10, avlTree.getRoot().key);
    }

    @Test
    public void givenTree_whenLeftRotationIsPerformed_thenTreeIsBalanced() {
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        assertEquals(20, avlTree.getRoot().key);
        assertEquals(10, avlTree.getRoot().left.key);
        assertEquals(30, avlTree.getRoot().right.key);
    }

    @Test
    public void givenTree_whenRightRotationIsPerformed_thenTreeIsBalanced() {
        avlTree.insert(30);
        avlTree.insert(20);
        avlTree.insert(10);
        assertEquals(20, avlTree.getRoot().key);
        assertEquals(10, avlTree.getRoot().left.key);
        assertEquals(30, avlTree.getRoot().right.key);
    }

    @Test
    public void givenTree_whenLeftRightRotationIsPerformed_thenTreeIsBalanced() {
        avlTree.insert(30);
        avlTree.insert(10);
        avlTree.insert(20);
        assertEquals(20, avlTree.getRoot().key);
        assertEquals(10, avlTree.getRoot().left.key);
        assertEquals(30, avlTree.getRoot().right.key);
    }

    @Test
    public void givenTree_whenRightLeftRotationIsPerformed_thenTreeIsBalanced() {
        avlTree.insert(10);
        avlTree.insert(30);
        avlTree.insert(20);
        assertEquals(20, avlTree.getRoot().key);
        assertEquals(10, avlTree.getRoot().left.key);
        assertEquals(30, avlTree.getRoot().right.key);
    }

    @Test
    public void givenTree_whenMultipleElementsAreInserted_thenBalanceIsMaintained() {
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        assertEquals(30, avlTree.getRoot().key);
        assertEquals(20, avlTree.getRoot().left.key);
        assertEquals(40, avlTree.getRoot().right.key);
        assertEquals(10, avlTree.getRoot().left.left.key);
        assertEquals(25, avlTree.getRoot().left.right.key);
        assertEquals(50, avlTree.getRoot().right.right.key);
    }

    @Test
    public void givenTree_whenDuplicateElementIsInserted_thenTreeRemainsUnchanged() {
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(10);

        assertEquals(10, avlTree.getRoot().key);
        assertEquals(20, avlTree.getRoot().right.key);
        assertNull(avlTree.getRoot().left);
    }

    @Test
    public void givenTree_whenBalanceFactorIsCalculated_thenItIsCorrect() {
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);

        assertEquals(0, avlTree.getBalance(avlTree.getRoot()));
        assertEquals(0, avlTree.getBalance(avlTree.getRoot().left));
        assertEquals(0, avlTree.getBalance(avlTree.getRoot().right));
    }
}
