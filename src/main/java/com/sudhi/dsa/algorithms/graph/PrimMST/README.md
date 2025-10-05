# Prim's Algorithm for Minimum Spanning Tree (MST)

Prim's algorithm is a greedy algorithm that finds a minimum spanning tree (MST) for a weighted, undirected graph. It works by starting with an arbitrary vertex and growing the MST by adding the cheapest edge that connects a vertex in the MST to a vertex outside the MST.

## Usage

To use Prim's algorithm, you need a `Graph` object. The algorithm will return a new `Graph` object representing the MST.

```java
import com.sudhi.dsa.datastructures.Graph.Graph;

// Create a graph
Graph<Integer> graph = new Graph<>(false); // Undirected graph

// Create vertex objects
Graph.Vertex<Integer> vertex1 = new Graph.Vertex<>(1);
Graph.Vertex<Integer> vertex2 = new Graph.Vertex<>(2);
Graph.Vertex<Integer> vertex3 = new Graph.Vertex<>(3);
Graph.Vertex<Integer> vertex4 = new Graph.Vertex<>(4);

// Add vertices to the graph
graph.addVertex(vertex1);
graph.addVertex(vertex2);
graph.addVertex(vertex3);
graph.addVertex(vertex4);

// Add edges with weights
graph.addEdge(vertex1, vertex2, 10);
graph.addEdge(vertex1, vertex3, 6);
graph.addEdge(vertex1, vertex4, 5);
graph.addEdge(vertex2, vertex4, 15);
graph.addEdge(vertex3, vertex4, 4);

// Find the MST
PrimMST<Integer> prims = new PrimMST<>();
Graph<Integer> mst = prims.findMST(graph);

// You can now work with the 'mst' graph object
```

## Methods

### `findMST(Graph<T> graph)`

Finds the Minimum Spanning Tree (MST) of a given `graph` using Prim's algorithm.

-   **Parameters:**
    -   `graph`: The graph for which to find the MST.
-   **Returns:**
    -   A new `Graph<T>` object representing the Minimum Spanning Tree. If the input graph is `null` or empty, it returns an empty graph.

## Disconnected Graphs

This implementation of Prim's algorithm also handles disconnected graphs. In such cases, it will find a Minimum Spanning Forest, which is a collection of MSTs for each connected component of the graph.
