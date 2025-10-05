package com.sudhi.dsa.datastructures;

import com.sudhi.dsa.datastructures.Graph.Graph;
import org.junit.Assert;
import org.junit.Test;

public class GraphTests {
    @Test
    public void givenGraph_whenIsDirected_thenReturnsTrue() {
        Graph<Integer> graph = new Graph<>(true);
        Assert.assertTrue(graph.isDirected());
    }
    @Test
    public void givenGraph_whenIsDirected_thenReturnsFalse() {
        Graph<Integer> graph = new Graph<>(false);
        Assert.assertFalse(graph.isDirected());
    }
    @Test
    public void givenUndirectedGraph_whenAddEdge_thenBothVerticesConnected() {
        Graph<Integer> graph = new Graph<>(false);
        var v1 = new Graph.Vertex<>(1);
        var v2 = new Graph.Vertex<>(2);
        graph.addEdge(new Graph.Edge<>(v1, v2));
        Assert.assertTrue(graph.isConnected(v1, v2));
        Assert.assertTrue(graph.isConnected(v2, v1));
    }
    @Test
    public void givenDirectedGraph_whenAddEdge_thenOnlySourceToDestinationConnected() {
        Graph<Integer> graph = new Graph<>(true);
        var v1 = new Graph.Vertex<>(1);
        var v2 = new Graph.Vertex<>(2);
        graph.addEdge(new Graph.Edge<>(v1, v2));
        Assert.assertTrue(graph.isConnected(v1, v2));
        Assert.assertFalse(graph.isConnected(v2, v1));
    }
}