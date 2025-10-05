# Floyd-Warshall Algorithm

The Floyd-Warshall algorithm is an algorithm for finding the shortest paths in a weighted graph with for all pairs of vertices. It can handle both positive and negative edge weights, but it does not handle negative-weight cycles.

## Usage

To use the Floyd-Warshall algorithm, you need a `Graph` object. The algorithm will return a map of maps containing the shortest distances between all pairs of vertices.

```java
import com.sudhi.dsa.datastructures.Graph.Graph;
import java.util.Map;

// Create a graph
Graph<String> graph = new Graph<>(true); // Directed graph

// Create vertex objects
Graph.Vertex<String> vertexA = new Graph.Vertex<>("A");
Graph.Vertex<String> vertexB = new Graph.Vertex<>("B");
Graph.Vertex<String> vertexC = new Graph.Vertex<>("C");
Graph.Vertex<String> vertexD = new Graph.Vertex<>("D");

// Add vertices to the graph
graph.addVertex(vertexA);
graph.addVertex(vertexB);
graph.addVertex(vertexC);
graph.addVertex(vertexD);

// Add edges with weights
graph.addEdge(vertexA, vertexC, -2);
graph.addEdge(vertexB, vertexA, 4);
graph.addEdge(vertexB, vertexC, 3);
graph.addEdge(vertexC, vertexD, 2);
graph.addEdge(vertexD, vertexB, -1);

// Find all shortest paths
FloydWarshall<String> floydWarshall = new FloydWarshall<>();
Map<Graph.Vertex<String>, Map<Graph.Vertex<String>, Double>> shortestPaths = floydWarshall.findAllShortestPaths(graph);

// Print the shortest paths
for (Graph.Vertex<String> from : shortestPaths.keySet()) {
    for (Graph.Vertex<String> to : shortestPaths.get(from).keySet()) {
        System.out.println("Shortest path from " + from.getVal() + " to " + to.getVal() + " is " + shortestPaths.get(from).get(to));
    }
}
```

## Methods

### `findAllShortestPaths(Graph<T> graph)`

Finds the shortest paths between all pairs of vertices in a `graph` using the Floyd-Warshall algorithm.

-   **Parameters:**
    -   `graph`: The graph on which to perform the search.
-   **Returns:**
    -   A `Map<Graph.Vertex<T>, Map<Graph.Vertex<T>, Double>>` where the outer map's keys are the source vertices, and the inner map's keys are the destination vertices, with the values being the shortest distances. If a path does not exist, the distance will be `Double.POSITIVE_INFINITY`.
