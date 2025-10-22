package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.datastructures.*;

import java.util.HashMap;
import java.util.Map;

public class BellmanFord<T> {

    public Map<Graph.Vertex<T>, Double> findShortestPaths(Graph<T> graph, Graph.Vertex<T> start) {
        Map<Graph.Vertex<T>, Double> distances = new HashMap<>();
        for (Graph.Vertex<T> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        for (int i = 0; i < graph.getVertices().size() - 1; i++) {
            for (Graph.Edge<T> edge : graph.getEdges()) {
                Graph.Vertex<T> from = edge.getFrom();
                Graph.Vertex<T> to = edge.getTo();
                double weight = edge.getWeight();
                if (distances.get(from) != Double.POSITIVE_INFINITY && distances.get(from) + weight < distances.get(to)) {
                    distances.put(to, distances.get(from) + weight);
                }
            }
        }

        for (Graph.Edge<T> edge : graph.getEdges()) {
            Graph.Vertex<T> from = edge.getFrom();
            Graph.Vertex<T> to = edge.getTo();
            double weight = edge.getWeight();
            if (distances.get(from) != Double.POSITIVE_INFINITY && distances.get(from) + weight < distances.get(to)) {
                throw new RuntimeException("Graph contains a negative weight cycle");
            }
        }

        return distances;
    }
}
