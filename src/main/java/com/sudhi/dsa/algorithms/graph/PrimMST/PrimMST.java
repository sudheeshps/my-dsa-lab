package com.sudhi.dsa.algorithms.graph.PrimMST;

import com.sudhi.dsa.datastructures.Graph.Graph;

import java.util.*;

public class PrimMST<T> {

    public Graph<T> findMST(Graph<T> graph) {
        if (graph == null || graph.getVertices().isEmpty()) {
            return new Graph<>(false);
        }

        Graph<T> mst = new Graph<>(false);
        Set<Graph.Vertex<T>> visited = new HashSet<>();

        for (Graph.Vertex<T> vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                PriorityQueue<Graph.Edge<T>> pq = new PriorityQueue<>(Comparator.comparingDouble(Graph.Edge::getWeight));
                visited.add(vertex);
                mst.addVertex(vertex);

                for (Graph.Edge<T> edge : graph.getEdges(vertex)) {
                    pq.add(edge);
                }

                while (!pq.isEmpty()) {
                    Graph.Edge<T> edge = pq.poll();
                    Graph.Vertex<T> destination = edge.getTo();

                    if (visited.contains(destination)) {
                        continue;
                    }

                    visited.add(destination);
                    mst.addVertex(destination);
                    mst.addEdge(edge.getFrom(), destination, edge.getWeight());

                    for (Graph.Edge<T> nextEdge : graph.getEdges(destination)) {
                        if (!visited.contains(nextEdge.getTo())) {
                            pq.add(nextEdge);
                        }
                    }
                }
            }
        }

        return mst;
    }
}
