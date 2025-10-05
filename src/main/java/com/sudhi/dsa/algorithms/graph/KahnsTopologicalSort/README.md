# Kahn's Algorithm for Topological Sort

Kahn's algorithm is another algorithm for topological sorting of a Directed Acyclic Graph (DAG). It works by finding vertices with no incoming edges and adding them to the sorted list. It then removes these vertices and their outgoing edges from the graph and repeats the process.

## Usage

To use Kahn's algorithm, you need a directed `Graph` object. The algorithm will return a list of vertices in topologically sorted order.

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
KahnsTopologicalSort<String> kahnsSort = new KahnsTopologicalSort<>(graph);
List<Graph.Vertex<String>> sortedList = kahnsSort.sort();

// Print the sorted list
System.out.println("Topologically sorted order (Kahn's algorithm):");
for (Graph.Vertex<String> vertex : sortedList) {
    System.out.print(vertex.getVal() + " ");
}
```

## Methods

### `sort()`

Performs a topological sort on the graph provided in the constructor using Kahn's algorithm.

-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the vertices in topologically sorted order. If the graph contains a cycle, the returned list will have fewer vertices than the graph.

## Cycle Detection

Unlike the DFS-based topological sort, this implementation of Kahn's algorithm does not explicitly throw an exception for cycles. Instead, if the graph has a cycle, the resulting list of sorted vertices will contain fewer vertices than the total number of vertices in the graph. You can check for cycles by comparing the size of the returned list with the number of vertices in the graph.
