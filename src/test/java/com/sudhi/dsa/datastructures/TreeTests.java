package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeTests {

    private Tree<Integer> tree;
    private Tree.Node<Integer> root;
    private Tree.Node<Integer> child1;
    private Tree.Node<Integer> child2;

    @BeforeEach
    public void setUp() {
        tree = new Tree<>(1);
        root = tree.getRoot();
        child1 = root.addChild(2);
        child2 = root.addChild(3);
        child1.addChild(4);
        child1.addChild(5);
        child2.addChild(6);
    }

    @Test
    public void givenTree_whenGetRoot_thenCorrectRoot() {
        assertEquals(1, tree.getRoot().getData());
    }

    @Test
    public void givenNode_whenGetChildren_thenCorrectChildren() {
        assertEquals(2, root.getChildren().size());
        assertEquals(2, root.getChildren().get(0).getData());
        assertEquals(3, root.getChildren().get(1).getData());
    }

    @Test
    public void givenNode_whenGetParent_thenCorrectParent() {
        assertEquals(root, child1.getParent());
        assertEquals(root, child2.getParent());
    }

    @Test
    public void givenRootNode_whenGetParent_thenNull() {
        assertNull(root.getParent());
    }

    @Test
    public void givenNode_whenGetData_thenCorrectData() {
        assertEquals(1, root.getData());
        assertEquals(2, child1.getData());
        assertEquals(3, child2.getData());
    }

    @Test
    public void givenTree_whenGetHeight_thenCorrectHeight() {
        assertEquals(2, tree.height());
    }

    @Test
    public void givenTree_whenGetSize_thenCorrectSize() {
        assertEquals(6, tree.size());
    }

    @Test
    public void givenTree_whenIsEmpty_thenFalse() {
        assertFalse(tree.isEmpty());
    }

    @Test
    public void givenEmptyTree_whenGetHeight_thenCorrectHeight() {
        Tree<Integer> emptyTree = new Tree<>(null);
        assertEquals(-1, emptyTree.height());
    }

    @Test
    public void givenEmptyTree_whenGetSize_thenCorrectSize() {
        Tree<Integer> emptyTree = new Tree<>(null);
        assertEquals(0, emptyTree.size());
    }

    @Test
    public void givenEmptyTree_whenIsEmpty_thenTrue() {
        Tree<Integer> emptyTree = new Tree<>(null);
        assertTrue(emptyTree.isEmpty());
    }
}
