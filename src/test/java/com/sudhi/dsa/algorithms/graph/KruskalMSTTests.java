package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.algorithms.graph.KruskalMST.KruskalMST;
import com.sudhi.dsa.datastructures.Graph.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KruskalMSTTests {

    @Test
    void givenSimpleGraph_whenFindMST_thenCorrectMST() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addEdge(v1, v2, 10);
        graph.addEdge(v2, v3, 20);
        graph.addEdge(v1, v3, 30);

        KruskalMST<Integer> kruskal = new KruskalMST<>();
        Graph<Integer> mst = kruskal.findMST(graph);

        assertEquals(3, mst.getVertices().size());
        assertEquals(4, mst.getEdges().size());
        assertEquals(60, mst.getEdges().stream().mapToInt(Graph.Edge::getWeight).sum());
    }

    @Test
    void givenComplexGraph_whenFindMST_thenCorrectMST() {
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
        graph.addEdge(v2, v4, 1);
        graph.addEdge(v3, v4, 2);
        graph.addEdge(v4, v5, 4);

        KruskalMST<Integer> kruskal = new KruskalMST<>();
        Graph<Integer> mst = kruskal.findMST(graph);

        assertEquals(5, mst.getVertices().size());
        assertEquals(8, mst.getEdges().size());
        assertEquals(16, mst.getEdges().stream().mapToInt(Graph.Edge::getWeight).sum());
    }

    @Test
    void givenGraphWithCycle_whenFindMST_thenCorrectMST() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addEdge(v1, v2, 10);
        graph.addEdge(v2, v3, 20);
        graph.addEdge(v3, v1, 5);

        KruskalMST<Integer> kruskal = new KruskalMST<>();
        Graph<Integer> mst = kruskal.findMST(graph);

        assertEquals(3, mst.getVertices().size());
        assertEquals(4, mst.getEdges().size());
        assertEquals(30, mst.getEdges().stream().mapToInt(Graph.Edge::getWeight).sum());
    }

    @Test
    void givenDisconnectedGraph_whenFindMST_thenCorrectMST() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> v4 = new Graph.Vertex<>(4);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2, 10);
        graph.addEdge(v3, v4, 20);

        KruskalMST<Integer> kruskal = new KruskalMST<>();
        Graph<Integer> mst = kruskal.findMST(graph);

        assertEquals(4, mst.getVertices().size());
        assertEquals(4, mst.getEdges().size());
        assertEquals(60, mst.getEdges().stream().mapToInt(Graph.Edge::getWeight).sum());
    }

    @Test
    void givenEmptyGraph_whenFindMST_thenEmptyMST() {
        Graph<Integer> graph = new Graph<>(false);
        KruskalMST<Integer> kruskal = new KruskalMST<>();
        Graph<Integer> mst = kruskal.findMST(graph);
        assertEquals(0, mst.getVertices().size());
        assertEquals(0, mst.getEdges().size());
    }

    @Test
    void givenSingleVertexGraph_whenFindMST_thenSingleVertexMST() {
        Graph<Integer> graph = new Graph<>(false);
        graph.addVertex(new Graph.Vertex<>(1));
        KruskalMST<Integer> kruskal = new KruskalMST<>();
        Graph<Integer> mst = kruskal.findMST(graph);
        assertEquals(1, mst.getVertices().size());
        assertEquals(0, mst.getEdges().size());
    }
}
