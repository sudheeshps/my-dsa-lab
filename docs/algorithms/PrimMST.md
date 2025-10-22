# Prim's Minimum Spanning Tree (MST) Algorithm

## Introduction

Prim's algorithm is a greedy algorithm used to find a Minimum Spanning Tree (MST) for a connected, undirected graph. An MST is a subgraph that connects all the vertices together, without any cycles, and with the minimum possible total edge weight. Prim's algorithm builds the MST by starting from an arbitrary vertex and iteratively adding the cheapest edge that connects a vertex in the growing tree to a vertex outside the tree.

---

## History

Prim's algorithm was originally developed by **Vojtěch Jarník** in 1930. It was later rediscovered by **Robert C. Prim** in 1957 and independently by **Edsger W. Dijkstra** in 1959. It is one of the classic algorithms for finding MSTs, alongside Kruskal's algorithm.

---

## Behaviour of Prim's Algorithm

1.  **Initialization**: Start with an arbitrary vertex `s` and add it to the MST. Initialize a priority queue with all edges connected to `s`.
2.  **Grow MST**: While the MST does not include all vertices (or the priority queue is not empty):
    a.  Extract the edge `(u, v)` with the minimum weight from the priority queue, where `u` is in the MST and `v` is not.
    b.  If `v` is not yet in the MST, add `v` and the edge `(u, v)` to the MST.
    c.  For all edges connecting `v` to unvisited neighbors `x`, add these edges to the priority queue.

This process ensures that at each step, the algorithm adds the cheapest possible edge that expands the current MST without forming a cycle.

---

## Algorithm Complexity

-   **Time Complexity**: The time complexity of Prim's algorithm depends on the data structure used for the priority queue:
    -   With a **binary heap**: `O(E log V)`, where `V` is the number of vertices and `E` is the number of edges. This is generally efficient for sparse graphs.
    -   With a **Fibonacci heap**: `O(E + V log V)`. This is asymptotically faster for dense graphs but has higher constant factors, making binary heaps often preferred in practice.
-   **Space Complexity**: `O(V + E)` to store the graph, distances, and the priority queue.

---

## Comparison

-   **Kruskal's Algorithm**: Both Prim's and Kruskal's find an MST. Kruskal's algorithm builds the MST by adding edges one by one, always picking the cheapest available edge that does not form a cycle, using a Disjoint Set Union data structure. Prim's algorithm grows a single tree from a starting vertex. Prim's is generally better for dense graphs (more edges), while Kruskal's is often preferred for sparse graphs.

---

## How the Algorithm is Implemented

This implementation uses a `PriorityQueue` to efficiently retrieve the minimum-weight edge. It also uses `HashMap`s to store the minimum weight to connect a vertex to the MST (`minWeight`) and the edge that achieves this minimum weight (`parentEdge`). A `HashSet` keeps track of vertices already included in the MST.

---

## Known Applications

-   **Network Design**: Designing telecommunication or computer networks to minimize cable length or cost.
-   **Clustering**: Grouping data points in machine learning.
-   **Image Segmentation**: Connecting similar pixels to form regions.
-   **Circuit Design**: Minimizing the amount of wire needed to connect components.

---

## API Documentation

### `public static <T> List<Graph.Edge<T>> findMinimumSpanningTree(Graph<T> graph, Graph.Vertex<T> startVertex)`

Finds the Minimum Spanning Tree (MST) of the given `graph` using Prim's algorithm.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to find the MST. The graph must be connected and undirected.
    -   `startVertex`: The `Graph.Vertex<T>` from which to start building the MST.
-   **Returns:**
    -   A `List<Graph.Edge<T>>` representing the edges of the MST.
    -   Returns an empty list if the graph is not connected or has no edges.
