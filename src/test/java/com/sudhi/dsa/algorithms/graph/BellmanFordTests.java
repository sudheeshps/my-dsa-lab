package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.algorithms.graph.BellmanFord;
import com.sudhi.dsa.datastructures.Graph;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BellmanFordTests {

    @Test
    void givenSimpleGraph_whenFindShortestPaths_thenCorrectDistances() {
        Graph<Integer> graph = new Graph<>(true);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> v4 = new Graph.Vertex<>(4);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 1);
        graph.addEdge(v1, v3, 4);
        graph.addEdge(v2, v3, 2);
        graph.addEdge(v2, v4, 5);
        graph.addEdge(v3, v4, 1);

        BellmanFord<Integer> bellmanFord = new BellmanFord<>();
        Map<Graph.Vertex<Integer>, Double> distances = bellmanFord.findShortestPaths(graph, v1);

        assertEquals(0.0, distances.get(v1));
        assertEquals(1.0, distances.get(v2));
        assertEquals(3.0, distances.get(v3));
        assertEquals(4.0, distances.get(v4));
    }

    @Test
    void givenGraphWithNegativeWeights_whenFindShortestPaths_thenCorrectDistances() {
        Graph<Integer> graph = new Graph<>(true);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> v4 = new Graph.Vertex<>(4);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 1);
        graph.addEdge(v1, v3, 4);
        graph.addEdge(v2, v3, -2);
        graph.addEdge(v2, v4, 5);
        graph.addEdge(v3, v4, 1);

        BellmanFord<Integer> bellmanFord = new BellmanFord<>();
        Map<Graph.Vertex<Integer>, Double> distances = bellmanFord.findShortestPaths(graph, v1);

        assertEquals(0.0, distances.get(v1));
        assertEquals(1.0, distances.get(v2));
        assertEquals(-1.0, distances.get(v3));
        assertEquals(0.0, distances.get(v4));
    }

    @Test
    void givenGraphWithNegativeCycle_whenFindShortestPaths_thenThrowException() {
        Graph<Integer> graph = new Graph<>(true);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v3, 2);
        graph.addEdge(v3, v1, -4);

        BellmanFord<Integer> bellmanFord = new BellmanFord<>();
        assertThrows(RuntimeException.class, () -> bellmanFord.findShortestPaths(graph, v1));
    }

    @Test
    void givenDisconnectedGraph_whenFindShortestPaths_thenInfiniteDistances() {
        Graph<Integer> graph = new Graph<>(true);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v1, v2, 1);

        BellmanFord<Integer> bellmanFord = new BellmanFord<>();
        Map<Graph.Vertex<Integer>, Double> distances = bellmanFord.findShortestPaths(graph, v1);

        assertEquals(0.0, distances.get(v1));
        assertEquals(1.0, distances.get(v2));
        assertEquals(Double.POSITIVE_INFINITY, distances.get(v3));
    }

    @Test
    void givenSingleNodeGraph_whenFindShortestPaths_thenZeroDistance() {
        Graph<Integer> graph = new Graph<>(true);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);

        graph.addVertex(v1);

        BellmanFord<Integer> bellmanFord = new BellmanFord<>();
        Map<Graph.Vertex<Integer>, Double> distances = bellmanFord.findShortestPaths(graph, v1);

        assertEquals(0.0, distances.get(v1));
    }
}
