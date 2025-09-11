package test.java.com.sudhi.datastructures;

import main.java.com.sudhi.dsa.datastructures.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

public class GraphTests {
    @Test
    public void isDirectedTrueTest() {
        Graph<Integer> graph = new Graph<>(true);
        Assert.assertTrue(graph.isDirected());
    }
    @Test
    public void isDirectedFalseTest() {
        Graph<Integer> graph = new Graph<>(false);
        Assert.assertFalse(graph.isDirected());
    }
    @Test
    public void addEdgeUndirectedTest() {
        Graph<Integer> graph = new Graph<>(false);
        var v1 = new Graph.Vertex<>(1);
        var v2 = new Graph.Vertex<>(2);
        graph.addEdge(new Graph.Edge<>(v1, v2));
        Assert.assertTrue(graph.isConnected(v1, v2));
        Assert.assertTrue(graph.isConnected(v2, v1));
    }
    @Test
    public void addEdgeDirectedTest() {
        Graph<Integer> graph = new Graph<>(true);
        var v1 = new Graph.Vertex<Integer>(1);
        var v2 = new Graph.Vertex<Integer>(2);
        graph.addEdge(new Graph.Edge<>(v1, v2));
        Assert.assertTrue(graph.isConnected(v1, v2));
        Assert.assertFalse(graph.isConnected(v2, v1));
    }
}