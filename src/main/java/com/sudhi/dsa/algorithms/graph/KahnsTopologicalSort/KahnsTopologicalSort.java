package main.java.com.sudhi.dsa.algorithms.graph.KahnsTopologicalSort;

import main.java.com.sudhi.dsa.datastructures.Graph.Graph;

import java.util.*;

public class KahnsTopologicalSort<T> {
    private final Graph<T> graph;
    private final Map<Graph.Vertex<T>, Integer> indegree;
    public KahnsTopologicalSort(Graph<T> graph) {
        this.graph = graph;
        this.indegree = new HashMap<>();
    }
    public List<Graph.Vertex<T>> sort() {
        for (var vertex: graph.getVertices()) {
            for (var neighbour: graph.getAdjacentVertices(vertex)) {
                indegree.put(neighbour, indegree.getOrDefault(neighbour, 0) + 1);
            }
            indegree.putIfAbsent(vertex, 0);
        }
        Queue<Graph.Vertex<T>> queue = new LinkedList<>();
        for (var vertex: indegree.keySet()) {
            if (indegree.get(vertex) == 0) {
                queue.add(vertex);
            }
        }
        List<Graph.Vertex<T>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            var vertex = queue.poll();
            result.add(vertex);
            for (var neighbour: graph.getAdjacentVertices(vertex)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }
}
