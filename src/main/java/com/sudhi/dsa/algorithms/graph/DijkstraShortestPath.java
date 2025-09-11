package main.java.com.sudhi.dsa.algorithms.graph;

import main.java.com.sudhi.dsa.datastructures.PriorityQueue;
import main.java.com.sudhi.dsa.datastructures.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class DijkstraShortestPath<T>   {
    private final Graph<T> graph;
    public DijkstraShortestPath(Graph<T> graph) {
        this.graph = graph;
    }
    public List<Graph.Vertex<T>> getShortestPath(Graph.Vertex<T> src, Graph.Vertex<T> dest) {
        List<Graph.Vertex<T>> result = new ArrayList<>();
        PriorityQueue<Graph.Edge<T>> pq = new PriorityQueue<Graph.Edge<T>>();
        for (Graph.Vertex<T> vertex: graph.getAdjacentVertices(src)) {
            var edge = graph.getEdge(src, vertex);
            pq.add(edge);
            while (!pq.isEmpty()) {

            }
        }
        return result;
    }
}
