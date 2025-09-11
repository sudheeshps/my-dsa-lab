package main.java.com.sudhi.dsa.algorithms.graph;

import main.java.com.sudhi.dsa.datastructures.graph.Graph;

import java.util.*;

public class TopologicalSort <T> {
    private final Graph<T> graph;
    public TopologicalSort(Graph<T> graph) {
        this.graph = graph;
    }
    public List<Graph.Vertex<T>> sort() {
        Stack<Graph.Vertex<T>> stack = new Stack<>();
        Set<Graph.Vertex<T>> visited = new HashSet<>();
        for (var vertex:graph.getVertices()) {
            if (!visited.contains(vertex)) {
                sortUtil(vertex, stack, visited);
            }
        }
        List<Graph.Vertex<T>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void sortUtil(Graph.Vertex<T> vertex, Stack<Graph.Vertex<T>> stack,
                          Set<Graph.Vertex<T>> visited) {
        visited.add(vertex);
        for (var childVertex: graph.getAdjacentVertices(vertex)) {
            if (!visited.contains(childVertex)) {
                sortUtil(childVertex, stack, visited);
            }
        }
        stack.push(vertex);
    }
}
