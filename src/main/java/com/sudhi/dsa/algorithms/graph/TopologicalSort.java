package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.datastructures.Graph;

import java.util.*;

public class TopologicalSort<T> {
    private final Graph<T> graph;

    public TopologicalSort(Graph<T> graph) {
        // Topological sort is only for directed graphs.
        if (!graph.isDirected()) {
            throw new IllegalArgumentException("Topological sort can only be performed on a directed graph.");
        }
        this.graph = graph;
    }

    /**
     * Performs a topological sort on the graph.
     * @return A list of vertices in topologically sorted order.
     * @throws IllegalStateException if the graph contains a cycle.
     */
    public List<Graph.Vertex<T>> sort() {
        // Use Deque as a Stack (LIFO). ArrayDeque is preferred over the legacy Stack class.
        Deque<Graph.Vertex<T>> stack = new ArrayDeque<>();
        Set<Graph.Vertex<T>> visited = new HashSet<>();
        Set<Graph.Vertex<T>> recursionStack = new HashSet<>(); // To detect cycles

        for (var vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                if (hasCycle(vertex, visited, recursionStack, stack)) {
                    // Cycle detected, topological sort is not possible.
                    throw new IllegalStateException("Cycle detected in the graph. Topological sort not possible.");
                }
            }
        }

        List<Graph.Vertex<T>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * A recursive utility function to perform DFS and detect cycles.
     * @return true if a cycle is detected, false otherwise.
     */
    private boolean hasCycle(Graph.Vertex<T> vertex, Set<Graph.Vertex<T>> visited,
                             Set<Graph.Vertex<T>> recursionStack, Deque<Graph.Vertex<T>> stack) {
        visited.add(vertex);
        recursionStack.add(vertex);

        for (var adjacentVertex : graph.getAdjacentVertices(vertex)) {
            if (!visited.contains(adjacentVertex)) {
                if (hasCycle(adjacentVertex, visited, recursionStack, stack)) {
                    return true; // Cycle found in a deeper call
                }
            } else if (recursionStack.contains(adjacentVertex)) {
                return true; // Cycle detected: adjacent vertex is in the current recursion path
            }
        }

        // Remove from recursion stack before returning
        recursionStack.remove(vertex);
        // Push to the result stack only after visiting all descendants
        stack.push(vertex);

        return false; // No cycle found from this vertex
    }
}