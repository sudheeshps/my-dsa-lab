package main.java.com.sudhi.dsa.datastructures.graph;

import java.util.*;


public class Graph<T> {

    public static class Vertex<T> {
        T val;
        public Vertex(T val) {
            this.val = val;
        }
        public String toString() {
            return String.valueOf(val);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Vertex<T> that = (Vertex<T>) o;
            return that.val.equals(val);
        }

        @Override
        public int hashCode() {
            return val.hashCode();
        }
    }
    public static class Edge<T> implements Comparable<Edge<T>> {
        private final Vertex<T> from;
        private final Vertex<T> to;
        private final int weight;
        private boolean isDirected;
        public Edge(Vertex<T> from, Vertex<T> to) {
            this.from = from;
            this.to = to;
            this.weight = -1;
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
            return this.getWeight() - o.getWeight();
        }
    }
    private boolean isDirected = false;
    private final List<Edge<T>> edges = new ArrayList<>();
    private final Map<Vertex<T>, List<Vertex<T>>> vertices = new HashMap<>();
    public Graph(boolean isDirected) {
       this.isDirected = isDirected;
    }
    public boolean isDirected() {
        return this.isDirected;
    }
    public Graph<T> addEdge(Edge<T> edge) {
        edges.add(edge);
        vertices.computeIfAbsent(edge.getFrom(), l -> new ArrayList<>()).add(edge.getTo());
        vertices.putIfAbsent(edge.getTo(), new ArrayList<>());
        if (!isDirected) {
            vertices.computeIfAbsent(edge.getTo(), l -> new ArrayList<>()).add(edge.getFrom());
        }
        return this;
    }
    public List<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        return vertices.getOrDefault(vertex, new ArrayList<>());
    }
    public Set<Vertex<T>> getVertices() {
        return vertices.keySet();
    }
    public Edge<T> getEdge(Vertex<T> src, Vertex<T> dest) {
        for (Edge<T> edge: edges) {
            if (edge.getTo().equals(src) && edge.getTo().equals(dest)) {
                return edge;
            }
        }
        return null;
    }
    public boolean isConnected(Vertex<T> v1,  Vertex<T> v2) {
        boolean isConnected = false;
        if (vertices.containsKey(v1)) {
            isConnected = vertices.get(v1).contains(v2);
        }
        if (!isDirected) {
            if (vertices.containsKey(v2)) {
                isConnected = vertices.get(v2).contains(v1);
            }
        }
        return isConnected;
    }
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (var edge: edges) {
            StringBuilder sb = new StringBuilder();
            sb.append(edge.getFrom().toString()).append("->");
            for (var adj: getAdjacentVertices(edge.getFrom())) {
                sb.append(adj).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            ret.append(sb);
            ret.append('\n');
        }
        return ret.toString();
    }
}