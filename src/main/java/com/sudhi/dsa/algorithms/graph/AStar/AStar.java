package main.java.com.sudhi.dsa.algorithms.graph.AStar;

import main.java.com.sudhi.dsa.datastructures.Graph.Graph;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;

public class AStar {

    public static <T> List<Graph.Vertex<T>> findPath(Graph<T> graph, Graph.Vertex<T> start, Graph.Vertex<T> end) {
        Map<Graph.Vertex<T>, Double> gScore = new HashMap<>();
        gScore.put(start, 0.0);

        Map<Graph.Vertex<T>, Double> fScore = new HashMap<>();
        fScore.put(start, heuristic(start, end));

        PriorityQueue<Graph.Vertex<T>> openSet = new PriorityQueue<>((v1, v2) -> Double.compare(fScore.get(v1), fScore.get(v2)));
        openSet.add(start);

        Map<Graph.Vertex<T>, Graph.Vertex<T>> cameFrom = new HashMap<>();

        while (!openSet.isEmpty()) {
            Graph.Vertex<T> current = openSet.poll();

            if (current.equals(end)) {
                return reconstructPath(cameFrom, current);
            }

            for (Graph.Edge<T> edge : graph.getEdges(current)) {
                Graph.Vertex<T> neighbor = edge.getTo();
                double tentativeGScore = gScore.get(current) + edge.getWeight();

                if (tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, gScore.get(neighbor) + heuristic(neighbor, end));

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null; // No path found
    }

    private static <T> double heuristic(Graph.Vertex<T> a, Graph.Vertex<T> b) {
        if (a.getVal() instanceof Point && b.getVal() instanceof Point) {
            Point p1 = (Point) a.getVal();
            Point p2 = (Point) b.getVal();
            return p1.distance(p2);
        }
        // A default heuristic if the vertices are not Points.
        // This can be a simple non-zero value if any two nodes are connected, and 0 if they are the same.
        return a.equals(b) ? 0 : 1;
    }

    private static <T> List<Graph.Vertex<T>> reconstructPath(Map<Graph.Vertex<T>, Graph.Vertex<T>> cameFrom, Graph.Vertex<T> current) {
        List<Graph.Vertex<T>> totalPath = new ArrayList<>();
        totalPath.add(current);
        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            totalPath.add(current);
        }
        Collections.reverse(totalPath);
        return totalPath;
    }
}
