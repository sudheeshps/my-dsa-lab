package test.java.com.sudhi.dsa.algorithms.graph;

import main.java.com.sudhi.dsa.algorithms.graph.FloydWarshall.FloydWarshall;
import main.java.com.sudhi.dsa.datastructures.Graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydWarshallTests {

    @Test
    void givenSimpleGraph_whenFindAllShortestPaths_thenCorrectDistances() {
        Graph<Integer> graph = new Graph<>(true);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> v4 = new Graph.Vertex<>(4);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 5);
        graph.addEdge(v1, v4, 10);
        graph.addEdge(v2, v3, 3);
        graph.addEdge(v3, v4, 1);

        FloydWarshall<Integer> floydWarshall = new FloydWarshall<>();
        Map<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Double>> distances = floydWarshall.findAllShortestPaths(graph);

        assertEquals(0, distances.get(v1).get(v1));
        assertEquals(5, distances.get(v1).get(v2));
        assertEquals(8, distances.get(v1).get(v3));
        assertEquals(9, distances.get(v1).get(v4));

        assertEquals(Double.POSITIVE_INFINITY, distances.get(v2).get(v1));
        assertEquals(0, distances.get(v2).get(v2));
        assertEquals(3, distances.get(v2).get(v3));
        assertEquals(4, distances.get(v2).get(v4));

        assertEquals(Double.POSITIVE_INFINITY, distances.get(v3).get(v1));
        assertEquals(Double.POSITIVE_INFINITY, distances.get(v3).get(v2));
        assertEquals(0, distances.get(v3).get(v3));
        assertEquals(1, distances.get(v3).get(v4));

        assertEquals(Double.POSITIVE_INFINITY, distances.get(v4).get(v1));
        assertEquals(Double.POSITIVE_INFINITY, distances.get(v4).get(v2));
        assertEquals(Double.POSITIVE_INFINITY, distances.get(v4).get(v3));
        assertEquals(0, distances.get(v4).get(v4));
    }

    @Test
    void givenGraphWithNegativeWeights_whenFindAllShortestPaths_thenCorrectDistances() {
        Graph<Integer> graph = new Graph<>(true);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v1, v2, -1);
        graph.addEdge(v2, v3, -2);
        graph.addEdge(v3, v1, 4);

        FloydWarshall<Integer> floydWarshall = new FloydWarshall<>();
        Map<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Double>> distances = floydWarshall.findAllShortestPaths(graph);

        assertEquals(0, distances.get(v1).get(v1));
        assertEquals(-1, distances.get(v1).get(v2));
        assertEquals(-3, distances.get(v1).get(v3));
    }

    @Test
    void givenDisconnectedGraph_whenFindAllShortestPaths_thenInfinityDistances() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> v3 = new Graph.Vertex<>(3);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v1, v2, 1);

        FloydWarshall<Integer> floydWarshall = new FloydWarshall<>();
        Map<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Double>> distances = floydWarshall.findAllShortestPaths(graph);

        assertEquals(Double.POSITIVE_INFINITY, distances.get(v1).get(v3));
        assertEquals(Double.POSITIVE_INFINITY, distances.get(v2).get(v3));
    }

    @Test
    void givenSingleVertexGraph_whenFindAllShortestPaths_thenZeroDistance() {
        Graph<Integer> graph = new Graph<>(false);
        Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
        graph.addVertex(v1);

        FloydWarshall<Integer> floydWarshall = new FloydWarshall<>();
        Map<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Double>> distances = floydWarshall.findAllShortestPaths(graph);

        assertEquals(0, distances.get(v1).get(v1));
    }

    @Test
    void givenEmptyGraph_whenFindAllShortestPaths_thenEmptyMap() {
        Graph<Integer> graph = new Graph<>(false);
        FloydWarshall<Integer> floydWarshall = new FloydWarshall<>();
        Map<Graph.Vertex<Integer>, Map<Graph.Vertex<Integer>, Double>> distances = floydWarshall.findAllShortestPaths(graph);
        assertTrue(distances.isEmpty());
    }
}
