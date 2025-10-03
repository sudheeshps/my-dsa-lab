# Bellman-Ford Algorithm

The Bellman-Ford algorithm is an algorithm that computes shortest paths from a single source vertex to all of the other vertices in a weighted digraph. It is slower than Dijkstra's algorithm, but more versatile, as it is capable of handling graphs in which some of the edge weights are negative numbers.

## Usage

To use the Bellman-Ford algorithm, you need a `Graph` object and a starting vertex. The algorithm will return a map of vertices to their shortest distance from the start vertex.

```java
import main.java.com.sudhi.dsa.datastructures.Graph.Graph;

import java.util.Map;

// Create a graph
Graph<String> graph = new Graph<>(true); // Directed graph

        // Create vertex objects
        Graph.Vertex<String> vertexA = new Graph.Vertex<>("A");
        Graph.Vertex<String> vertexB = new Graph.Vertex<>("B");
        Graph.Vertex<String> vertexC = new Graph.Vertex<>("C");
        Graph.Vertex<String> vertexD = new Graph.Vertex<>("D");

// Add vertices to the graph
graph.

        addVertex(vertexA);
graph.

        addVertex(vertexB);
graph.

        addVertex(vertexC);
graph.

        addVertex(vertexD);

// Add edges with weights
graph.

        addEdge(vertexA, vertexB, 1);
graph.

        addEdge(vertexA, vertexC, 4);
graph.

        addEdge(vertexB, vertexC, -2);
graph.

        addEdge(vertexB, vertexD, 5);
graph.

        addEdge(vertexC, vertexD, 3);

        // Find the shortest paths
        BellmanFord<String> bellmanFord = new BellmanFord<>();
        Map<Graph.Vertex<String>, Double> distances = bellmanFord.findShortestPaths(graph, vertexA);

// Print the distances
for(
        Map.Entry<Graph.Vertex<String>, Double> entry :distances.

        entrySet()){
        System.out.

        println("Distance from A to "+entry.getKey().

        getVal() +" is "+entry.

        getValue());
        }
```

## Methods

### `findShortestPaths(Graph<T> graph, Graph.Vertex<T> start)`

Finds the shortest paths from a `start` vertex to all other vertices in a `graph` using the Bellman-Ford algorithm.

-   **Parameters:**
    -   `graph`: The graph on which to perform the search.
    -   `start`: The starting vertex.
-   **Returns:**
    -   A `Map<Graph.Vertex<T>, Double>` where the keys are the vertices in the graph and the values are the shortest distances from the `start` vertex. If a vertex is unreachable, its distance will be `Double.POSITIVE_INFINITY`.

## Negative Weight Cycles

This implementation of the Bellman-Ford algorithm can detect negative weight cycles. If a negative weight cycle is found, the algorithm will throw a `RuntimeException`.
