# Kruskal's Algorithm for Minimum Spanning Tree (MST)

Kruskal's algorithm is a greedy algorithm that finds a minimum spanning tree (MST) for a weighted, undirected graph. It works by sorting all the edges in the graph by weight in ascending order and adding them to the MST as long as they don't form a cycle.

## Usage

To use Kruskal's algorithm, you need a `Graph` object. The algorithm will return a new `Graph` object representing the MST.

```java
import main.java.com.sudhi.dsa.datastructures.Graph.Graph;

// Create a graph
Graph<Integer> graph = new Graph<>(false); // Undirected graph

        // Create vertex objects
        Graph.Vertex<Integer> vertex1 = new Graph.Vertex<>(1);
        Graph.Vertex<Integer> vertex2 = new Graph.Vertex<>(2);
        Graph.Vertex<Integer> vertex3 = new Graph.Vertex<>(3);
        Graph.Vertex<Integer> vertex4 = new Graph.Vertex<>(4);

// Add vertices to the graph
graph.

        addVertex(vertex1);
graph.

        addVertex(vertex2);
graph.

        addVertex(vertex3);
graph.

        addVertex(vertex4);

// Add edges with weights
graph.

        addEdge(vertex1, vertex2, 10);
graph.

        addEdge(vertex1, vertex3, 6);
graph.

        addEdge(vertex1, vertex4, 5);
graph.

        addEdge(vertex2, vertex4, 15);
graph.

        addEdge(vertex3, vertex4, 4);

        // Find the MST
        KruskalMST<Integer> kruskal = new KruskalMST<>();
        Graph<Integer> mst = kruskal.findMST(graph);

// You can now work with the 'mst' graph object
```

## Methods

### `findMST(Graph<T> graph)`

Finds the Minimum Spanning Tree (MST) of a given `graph` using Kruskal's algorithm.

-   **Parameters:**
    -   `graph`: The graph for which to find the MST.
-   **Returns:**
    -   A new `Graph<T>` object representing the Minimum Spanning Tree.

## Disjoint Set Union (DSU)

This implementation of Kruskal's algorithm uses a Disjoint Set Union (DSU) data structure to efficiently detect cycles in the graph. The DSU is implemented as a private inner class.
