package main.java.com.sudhi.dsa.algorithms.graph;

import main.java.com.sudhi.dsa.datastructures.Graph;

import java.util.*;

public class IterativeBreadthFirstSearch<T> {
    private final Graph<T> graph;
    public IterativeBreadthFirstSearch(Graph<T> graph) {
        this.graph = graph;
    }
    public List<Graph.Vertex<T>> bfs(Graph.Vertex<T> source) {
        List<Graph.Vertex<T>> result = new ArrayList<>();
        Queue<Graph.Vertex<T>> queue = new LinkedList<>();
        Set<Graph.Vertex<T>> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            var vertex = queue.poll();
            result.add(vertex);
            for (var neighbor: graph.getAdjacentVertices(vertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return result;
    }
}
