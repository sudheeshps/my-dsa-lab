package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.algorithms.graph.PrimMST.*;
import com.sudhi.dsa.datastructures.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimMSTTests {

    @Test
    public void givenSimpleGraph_whenFindMST_thenCorrectMST() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v3, 2);
        graph.addEdge(v1, v3, 3);

        PrimMST<Integer> primsMST = new PrimMST<>();
        Graph<Integer> mst = primsMST.findMST(graph);

        assertEquals(3, mst.getVertices().size());
        assertEquals(4, mst.getEdges().size());
        double totalWeight = mst.getEdges().stream().mapToDouble(Graph.Edge::getWeight).sum();
        assertEquals(6.0, totalWeight);
    }

    @Test
    public void givenComplexGraph_whenFindMST_thenCorrectMST() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> v4 = new Graph.Vertex<>(4);
        Graph.Vertex<Integer> v5 = new Graph.Vertex<>(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addEdge(v1, v2, 2);
        graph.addEdge(v1, v3, 3);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v2, v4, 4);
        graph.addEdge(v3, v5, 5);
        graph.addEdge(v4, v5, 1);

        PrimMST<Integer> primsMST = new PrimMST<>();
        Graph<Integer> mst = primsMST.findMST(graph);

        assertEquals(5, mst.getVertices().size());
        assertEquals(8, mst.getEdges().size());
        double totalWeight = mst.getEdges().stream().mapToDouble(Graph.Edge::getWeight).sum();
        assertEquals(16.0, totalWeight);
    }

    @Test
    public void givenGraphWithCycle_whenFindMST_thenNoCycleInMST() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v3, 2);
        graph.addEdge(v3, v1, 3);

        PrimMST<Integer> primsMST = new PrimMST<>();
        Graph<Integer> mst = primsMST.findMST(graph);

        assertEquals(3, mst.getVertices().size());
        assertEquals(4, mst.getEdges().size());
        double totalWeight = mst.getEdges().stream().mapToDouble(Graph.Edge::getWeight).sum();
        assertEquals(6.0, totalWeight);
    }

    @Test
    public void givenDisconnectedGraph_whenFindMST_thenForest() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> v4 = new Graph.Vertex<>(4);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v3, v4, 1);

        PrimMST<Integer> primsMST = new PrimMST<>();
        Graph<Integer> mst = primsMST.findMST(graph);

        assertEquals(4, mst.getVertices().size());
        assertEquals(4, mst.getEdges().size());
        double totalWeight = mst.getEdges().stream().mapToDouble(Graph.Edge::getWeight).sum();
        assertEquals(4.0, totalWeight);
    }

    @Test
    public void givenEmptyGraph_whenFindMST_thenEmptyGraph() {
        Graph<Integer> graph = new Graph<>(false);
        PrimMST<Integer> primsMST = new PrimMST<>();
        Graph<Integer> mst = primsMST.findMST(graph);
        assertTrue(mst.getVertices().isEmpty());
        assertTrue(mst.getEdges().isEmpty());
    }

    @Test
    public void givenSingleVertexGraph_whenFindMST_thenSingleVertexGraph() {
        Graph<Integer> graph = new Graph<>(false);
        graph.addVertex(new Graph.Vertex<>(1));
        PrimMST<Integer> primsMST = new PrimMST<>();
        Graph<Integer> mst = primsMST.findMST(graph);
        assertEquals(1, mst.getVertices().size());
        assertTrue(mst.getEdges().isEmpty());
    }
}
