package com.sudhi.dsa.datastructures.Graph;

import java.util.*;
import java.util.Set;

public class Graph<T> {

    // --- Inner Classes: Vertex and Edge ---

    public static class Vertex<T> {
        private final T val;

        public Vertex(T val) {
            this.val = val;
        }

        public T getVal() {
            return val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return val.equals(vertex.val);
        }

        @Override
        public final int hashCode() {
            return val.hashCode();
        }
    }

    public static class Edge<T> implements Comparable<Edge<T>> {
        private final Vertex<T> from;
        private final Vertex<T> to;
        private final int weight;

        // A directed edge has a weight of 1 by default if not specified
        public Edge(Vertex<T> from, Vertex<T> to) {
            this(from, to, 1);
        }

        public Edge(Vertex<T> from, Vertex<T> to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Vertex<T> getFrom() { return from; }
        public Vertex<T> getTo() { return to; }
        public int getWeight() { return weight; }

        @Override
        public int compareTo(Edge<T> o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return from + " -> " + to + " (w:" + weight + ")";
        }
    }

    // --- Graph Implementation ---

    private final Map<Vertex<T>, List<Edge<T>>> adjacencyList = new HashMap<>();
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex The vertex to add.
     */
    public void addVertex(Vertex<T> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    /**
     * Adds a directed edge between two vertices.
     * If the vertices do not exist, they are added to the graph.
     */
    public Graph<T> addEdge(Vertex<T> from, Vertex<T> to, int weight) {
        // Ensure both vertices exist in the adjacency list
        this.addVertex(from);
        this.addVertex(to);

        // Add the forward edge
        adjacencyList.get(from).add(new Edge<>(from, to, weight));

        // If the graph is undirected, add the reverse edge
        if (!isDirected) {
            adjacencyList.get(to).add(new Edge<>(to, from, weight));
        }
        return this;
    }

    public Graph<T> addEdge(Vertex<T> from, Vertex<T> to) {
        return addEdge(from, to, 1);
    }

    public Graph<T> addEdge(Edge<T> edge) {
        return addEdge(edge.getFrom(), edge.getTo(), edge.getWeight());
    }

    /**
     * Returns a set of all vertices in the graph.
     * @return An unmodifiable set of vertices.
     */
    public Set<Vertex<T>> getVertices() {
        return Collections.unmodifiableSet(adjacencyList.keySet());
    }

    /**
     * Returns all edges originating from a given vertex.
     * @return An unmodifiable list of edges.
     */
    public List<Edge<T>> getEdges(Vertex<T> vertex) {
        return Collections.unmodifiableList(adjacencyList.getOrDefault(vertex, Collections.emptyList()));
    }

    /**
     * Returns all vertices adjacent to a given vertex.
     * @return A new list of adjacent vertices.
     */
    public List<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        List<Vertex<T>> adjacent = new ArrayList<>();
        for (Edge<T> edge : adjacencyList.getOrDefault(vertex, Collections.emptyList())) {
            adjacent.add(edge.getTo());
        }
        return adjacent;
    }

    public boolean isConnected(Vertex<T> from, Vertex<T> to) {
        List<Edge<T>> edges = adjacencyList.get(from);
        if (edges != null) {
            for (Edge<T> edge : edges) {
                if (edge.getTo().equals(to)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            sb.append(vertex).append(" -> ");
            List<Edge<T>> edges = adjacencyList.get(vertex);
            if (edges.isEmpty()) {
                sb.append("[]");
            } else {
                sb.append(Arrays.toString(edges.toArray()));
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public Collection<Edge<T>> getEdges() {
        List<Edge<T>> allEdges = new ArrayList<>();
        for (List<Edge<T>> edges : adjacencyList.values()) {
            allEdges.addAll(edges);
        }
        return Collections.unmodifiableList(allEdges);
    }
}