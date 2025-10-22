package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.datastructures.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursiveDepthFirstSearch <T> {
    private final Graph<T> graph;
    public RecursiveDepthFirstSearch(Graph<T> graph) {
        this.graph = graph;
    }
    public List<Graph.Vertex<T>> dfs(Graph.Vertex<T> src) {
        List<Graph.Vertex<T>> result = new ArrayList<>();
        Set<Graph.Vertex<T>> visited = new HashSet<>();
        dfsHelper(src, visited, result);
        return result;
    }

    private void dfsHelper(Graph.Vertex<T> vertex, Set<Graph.Vertex<T>> visited,
                           List<Graph.Vertex<T>> result) {
        visited.add(vertex);
        result.add(vertex);
        for (var child: graph.getAdjacentVertices(vertex)) {
            if (!visited.contains(child)) {
                dfsHelper(child, visited, result);
            }
        }
    }
}
