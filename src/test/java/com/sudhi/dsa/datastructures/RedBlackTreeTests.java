package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.RedBlackTree.RedBlackTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedBlackTreeTests {

    private RedBlackTree<Integer, String> tree;

    @BeforeEach
    public void setUp() {
        tree = new RedBlackTree<>();
    }

    @Test
    public void givenEmptyTree_whenNewTreeIsCreated_thenRootIsNull() {
        assertNull(tree.getRoot());
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    public void givenTree_whenSingleElementIsInserted_thenRootIsBlackAndHasCorrectValue() {
        tree.put(10, "Value1");
        RedBlackTree<Integer, String>.Node root = tree.getRoot();
        assertNotNull(root);
        assertEquals(10, root.key);
        assertEquals("Value1", root.val);
        assertFalse(root.color);
        assertEquals(1, tree.size());
    }

    @Test
    public void givenTree_whenMultipleElementsAreInserted_thenTreePropertiesAreMaintained() {
        tree.put(10, "Value1");
        tree.put(20, "Value2");
        tree.put(5, "Value3");

        RedBlackTree<Integer, String>.Node root = tree.getRoot();
        assertEquals(10, root.key);
        assertFalse(root.color);

        assertEquals(5, root.left.key);
        assertFalse(root.left.color);

        assertEquals(20, root.right.key);
        assertFalse(root.right.color);

        assertEquals(3, tree.size());
    }

    @Test
    public void givenTree_whenElementsAreInsertedInAscendingOrder_thenTreeIsBalanced() {
        for (int i = 1; i <= 7; i++) {
            tree.put(i, "Value" + i);
        }

        RedBlackTree<Integer, String>.Node root = tree.getRoot();
        assertEquals(4, root.key);
        assertFalse(root.color);

        // Further structural and color assertions can be added here
        assertEquals(7, tree.size());
        assertTrue(isBalanced(root));
    }

    @Test
    public void givenTree_whenElementsAreInsertedInDescendingOrder_thenTreeIsBalanced() {
        for (int i = 7; i >= 1; i--) {
            tree.put(i, "Value" + i);
        }

        RedBlackTree<Integer, String>.Node root = tree.getRoot();
        assertEquals(4, root.key);
        assertFalse(root.color);

        // Further structural and color assertions can be added here
        assertEquals(7, tree.size());
        assertTrue(isBalanced(root));
    }

    @Test
    public void givenTree_whenDuplicateElementIsInserted_thenValueIsUpdatedAndSizeIsUnchanged() {
        tree.put(10, "Value1");
        tree.put(10, "Value2");

        assertEquals(1, tree.size());
        assertEquals("Value2", tree.get(10));
    }

    private boolean isBalanced(RedBlackTree<Integer, String>.Node node) {
        if (node == null) {
            return true;
        }
        int blackHeight = -1;
        return isBalanced(node, blackHeight) != -1;
    }

    private int isBalanced(RedBlackTree<Integer, String>.Node node, int blackHeight) {
        if (node == null) {
            return blackHeight + 1;
        }
        int leftHeight = isBalanced(node.left, blackHeight);
        int rightHeight = isBalanced(node.right, blackHeight);
        if (leftHeight == -1 || rightHeight == -1 || leftHeight != rightHeight) {
            return -1;
        }
        if (!node.color) { // is black
            return leftHeight + 1;
        }
        return leftHeight;
    }
}
