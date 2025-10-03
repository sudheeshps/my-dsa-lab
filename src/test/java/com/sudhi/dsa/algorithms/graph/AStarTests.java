package test.java.com.sudhi.dsa.algorithms.graph;

import main.java.com.sudhi.dsa.algorithms.graph.AStar.AStar;
import main.java.com.sudhi.dsa.datastructures.Graph.Graph;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AStarTests {

    @Test
    void givenGraph_whenPathExists_thenFindPathReturnsCorrectPath() {
        Graph<Point> graph = new Graph<>(true);
        Graph.Vertex<Point> start = new Graph.Vertex<>(new Point(0, 0));
        Graph.Vertex<Point> middle = new Graph.Vertex<>(new Point(1, 1));
        Graph.Vertex<Point> end = new Graph.Vertex<>(new Point(2, 2));

        graph.addVertex(start);
        graph.addVertex(middle);
        graph.addVertex(end);

        graph.addEdge(start, middle, 1);
        graph.addEdge(middle, end, 1);

        List<Graph.Vertex<Point>> path = AStar.findPath(graph, start, end);

        assertNotNull(path);
        assertEquals(3, path.size());
        assertEquals(start, path.get(0));
        assertEquals(middle, path.get(1));
        assertEquals(end, path.get(2));
    }

    @Test
    void givenGraph_whenNoPathExists_thenFindPathReturnsNull() {
        Graph<Point> graph = new Graph<>(true);
        Graph.Vertex<Point> start = new Graph.Vertex<>(new Point(0, 0));
        Graph.Vertex<Point> end = new Graph.Vertex<>(new Point(2, 2));
        Graph.Vertex<Point> unconnected = new Graph.Vertex<>(new Point(3,3));


        graph.addVertex(start);
        graph.addVertex(end);
        graph.addVertex(unconnected);


        List<Graph.Vertex<Point>> path = AStar.findPath(graph, start, end);

        assertNull(path);
    }

    @Test
    void givenGraph_whenStartAndEndAreSame_thenPathIsJustStart() {
        Graph<Point> graph = new Graph<>(true);
        Graph.Vertex<Point> start = new Graph.Vertex<>(new Point(0, 0));

        graph.addVertex(start);

        List<Graph.Vertex<Point>> path = AStar.findPath(graph, start, start);

        assertNotNull(path);
        assertEquals(1, path.size());
        assertEquals(start, path.get(0));
    }

    @Test
    void givenGraph_whenPathIsMoreComplex_thenFindPathReturnsCorrectPath() {
        Graph<Point> graph = new Graph<>(true);
        Graph.Vertex<Point> v1 = new Graph.Vertex<>(new Point(0, 0));
        Graph.Vertex<Point> v2 = new Graph.Vertex<>(new Point(1, 0));
        Graph.Vertex<Point> v3 = new Graph.Vertex<>(new Point(0, 1));
        Graph.Vertex<Point> v4 = new Graph.Vertex<>(new Point(1, 1));
        Graph.Vertex<Point> v5 = new Graph.Vertex<>(new Point(2, 1));

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v1, v2, 1);
        graph.addEdge(v1, v3, 1);
        graph.addEdge(v2, v4, 1);
        graph.addEdge(v3, v4, 1);
        graph.addEdge(v4, v5, 1);

        List<Graph.Vertex<Point>> path = AStar.findPath(graph, v1, v5);

        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(v1, path.get(0));
        // The path could be v1 -> v2 -> v4 -> v5 or v1 -> v3 -> v4 -> v5
        // Both are valid, so we check for the common parts
        assertEquals(v4, path.get(2));
        assertEquals(v5, path.get(3));
    }
}
