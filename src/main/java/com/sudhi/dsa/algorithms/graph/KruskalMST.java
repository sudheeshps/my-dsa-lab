package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.datastructures.Graph;

import java.util.*;

public class KruskalMST<T> {

    public Graph<T> findMST(Graph<T> graph) {
        Graph<T> mst = new Graph<>(false);
        List<Graph.Edge<T>> edges = new ArrayList<>(graph.getEdges());
        edges.sort(Comparator.comparingInt(Graph.Edge::getWeight));

        DisjointSet<Graph.Vertex<T>> disjointSet = new DisjointSet<>();
        for (Graph.Vertex<T> vertex : graph.getVertices()) {
            disjointSet.makeSet(vertex);
            mst.addVertex(vertex);
        }

        for (Graph.Edge<T> edge : edges) {
            Graph.Vertex<T> from = edge.getFrom();
            Graph.Vertex<T> to = edge.getTo();
            if (disjointSet.find(from) != disjointSet.find(to)) {
                mst.addEdge(from, to, edge.getWeight());
                disjointSet.union(from, to);
            }
        }

        return mst;
    }

    private static class DisjointSet<T> {
        private final Map<T, T> parent = new HashMap<>();

        public void makeSet(T item) {
            parent.put(item, item);
        }

        public T find(T item) {
            if (parent.get(item) == item) {
                return item;
            }
            return find(parent.get(item));
        }

        public void union(T item1, T item2) {
            T root1 = find(item1);
            T root2 = find(item2);
            parent.put(root1, root2);
        }
    }
}
