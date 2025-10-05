package com.sudhi.dsa.algorithms.graph.FloydWarshall;

import com.sudhi.dsa.datastructures.Graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FloydWarshall<T> {

    public Map<Graph.Vertex<T>, Map<Graph.Vertex<T>, Double>> findAllShortestPaths(Graph<T> graph) {
        List<Graph.Vertex<T>> vertices = new ArrayList<>(graph.getVertices());
        int numVertices = vertices.size();
        Map<Graph.Vertex<T>, Integer> vertexIndexMap = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            vertexIndexMap.put(vertices.get(i), i);
        }

        double[][] dist = new double[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        for (Graph.Edge<T> edge : graph.getEdges()) {
            Graph.Vertex<T> from = edge.getFrom();
            Graph.Vertex<T> to = edge.getTo();
            int u = vertexIndexMap.get(from);
            int v = vertexIndexMap.get(to);
            dist[u][v] = edge.getWeight();
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != Double.POSITIVE_INFINITY && dist[k][j] != Double.POSITIVE_INFINITY && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        Map<Graph.Vertex<T>, Map<Graph.Vertex<T>, Double>> shortestPaths = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            Graph.Vertex<T> fromVertex = vertices.get(i);
            shortestPaths.put(fromVertex, new HashMap<>());
            for (int j = 0; j < numVertices; j++) {
                Graph.Vertex<T> toVertex = vertices.get(j);
                shortestPaths.get(fromVertex).put(toVertex, dist[i][j]);
            }
        }

        return shortestPaths;
    }
}
