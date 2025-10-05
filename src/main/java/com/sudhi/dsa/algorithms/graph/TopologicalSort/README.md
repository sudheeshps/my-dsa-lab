# Topological Sort

Topological sorting for a Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge from vertex `u` to vertex `v`, vertex `u` comes before vertex `v` in the ordering. Topological sorting is not possible if the graph has a cycle.

## Usage

To use the Topological Sort algorithm, you need a directed `Graph` object. The algorithm will return a list of vertices in topologically sorted order.

```java
import com.sudhi.dsa.datastructures.Graph.Graph;
import java.util.List;

// Create a directed graph
Graph<String> graph = new Graph<>(true);

// Create vertex objects
Graph.Vertex<String> vertexA = new Graph.Vertex<>("A");
Graph.Vertex<String> vertexB = new Graph.Vertex<>("B");
Graph.Vertex<String> vertexC = new Graph.Vertex<>("C");
Graph.Vertex<String> vertexD = new Graph.Vertex<>("D");
Graph.Vertex<String> vertexE = new Graph.Vertex<>("E");

// Add vertices to the graph
graph.addVertex(vertexA);
graph.addVertex(vertexB);
graph.addVertex(vertexC);
graph.addVertex(vertexD);
graph.addVertex(vertexE);

// Add edges
graph.addEdge(vertexA, vertexB, 1);
graph.addEdge(vertexA, vertexC, 1);
graph.addEdge(vertexB, vertexD, 1);
graph.addEdge(vertexC, vertexD, 1);
graph.addEdge(vertexD, vertexE, 1);

// Perform topological sort
TopologicalSort<String> topologicalSort = new TopologicalSort<>(graph);
try {
    List<Graph.Vertex<String>> sortedList = topologicalSort.sort();
    System.out.println("Topologically sorted order:");
    for (Graph.Vertex<String> vertex : sortedList) {
        System.out.print(vertex.getVal() + " ");
    }
} catch (IllegalStateException e) {
    System.out.println(e.getMessage());
}
```

## Methods

### `sort()`

Performs a topological sort on the graph provided in the constructor.

-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the vertices in topologically sorted order.
-   **Throws:**
    -   `IllegalStateException`: If the graph contains a cycle.

## Cycle Detection

This implementation of Topological Sort includes cycle detection. If a cycle is detected in the graph, an `IllegalStateException` is thrown, as a topological sort is not possible for a graph with cycles.
