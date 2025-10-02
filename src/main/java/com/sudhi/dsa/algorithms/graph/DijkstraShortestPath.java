package main.java.com.sudhi.dsa.algorithms.graph;

import main.java.com.sudhi.dsa.datastructures.Graph;

import java.util.*;

public class DijkstraShortestPath<T> {

    private final Graph<T> graph;

    public DijkstraShortestPath(Graph<T> graph) {
        this.graph = graph;
    }

    /**
     * Finds the shortest path between a source and destination vertex using Dijkstra's algorithm.
     *
     * @param src  The starting vertex.
     * @param dest The destination vertex.
     * @return A list of vertices representing the shortest path, or an empty list if no path exists.
     */
    public List<Graph.Vertex<T>> getShortestPath(Graph.Vertex<T> src, Graph.Vertex<T> dest) {
        // Map to store the shortest distance from the source to each vertex
        Map<Graph.Vertex<T>, Integer> distances = new HashMap<>();

        // Map to reconstruct the path. Stores the predecessor of each vertex.
        Map<Graph.Vertex<T>, Graph.Vertex<T>> previous = new HashMap<>();

        // Priority queue to select the vertex with the smallest distance to visit next.
        // It stores vertices, and the comparator uses the 'distances' map to determine priority.
        PriorityQueue<Graph.Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Initialize all distances to infinity and add to the maps
        for (Graph.Vertex<T> vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }

        // The distance from the source to itself is 0
        distances.put(src, 0);
        pq.add(src);

        while (!pq.isEmpty()) {
            // Get the vertex with the smallest distance
            Graph.Vertex<T> current = pq.poll();

            // If we've reached the destination, we can stop and build the path
            if (current.equals(dest)) {
                return buildPath(previous, dest);
            }

            // If the smallest distance is infinity, the remaining vertices are unreachable
            if (distances.get(current) == Integer.MAX_VALUE) {
                break;
            }

            // This is the "relaxation" step
            // For each outgoing edge from the current vertex...
            for (Graph.Edge<T> edge : graph.getEdges(current)) {
                Graph.Vertex<T> neighbor = edge.getTo();
                int newDist = distances.get(current) + edge.getWeight();

                // If we found a shorter path to the neighbor...
                if (newDist < distances.get(neighbor)) {
                    // ...update its distance and predecessor
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);

                    // Re-prioritize the neighbor in the queue with its new, shorter distance
                    // (remove and re-add to update priority)
                    pq.remove(neighbor);
                    pq.add(neighbor);
                }
            }
        }

        // If the loop finishes and we haven't reached the destination, no path exists
        return Collections.emptyList();
    }

    /**
     * Helper method to reconstruct the path from the 'previous' map.
     */
    private List<Graph.Vertex<T>> buildPath(Map<Graph.Vertex<T>, Graph.Vertex<T>> previous, Graph.Vertex<T> dest) {
        LinkedList<Graph.Vertex<T>> path = new LinkedList<>();
        Graph.Vertex<T> at = dest;

        // If 'at' is null or has no predecessor, it means it was unreachable
        if (previous.get(at) == null && !at.equals(dest)) { // Check if dest itself was the start
            return Collections.emptyList();
        }

        // Backtrack from destination to source
        while (at != null) {
            path.addFirst(at);
            at = previous.get(at);
        }

        // If the path starts with the source, it's a valid path
        if (path.getFirst().equals(dest)) { // A simple check to ensure we found a path
            return path;
        }

        return Collections.emptyList();
    }
}