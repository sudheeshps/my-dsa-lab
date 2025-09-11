package main.java.com.sudhi.dsa.algorithms.graph;

import main.java.com.sudhi.dsa.datastructures.graph.Graph;

import java.util.*;

public class IterativeDepthFirstSearch<T> {
    private final Graph<T> graph;

    public IterativeDepthFirstSearch(Graph<T> graph) {
        this.graph = graph;
    }

    public List<Graph.Vertex<T>> dfs(Graph.Vertex<T> src) {
        List<Graph.Vertex<T>> result = new ArrayList<>();
        Set<Graph.Vertex<T>> visited = new HashSet<>();
        Stack<Graph.Vertex<T>> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            var vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                result.add(vertex);
            }
            for (var child : graph.getAdjacentVertices(vertex)) {
                if (!visited.contains(child)) {
                    stack.push(child);
                }
            }
        }
        return result;
    }
}
