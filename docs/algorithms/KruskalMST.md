# Kruskal's Minimum Spanning Tree (MST) Algorithm

## Introduction

Kruskal's algorithm is a greedy algorithm used to find a Minimum Spanning Tree (MST) for a connected, undirected graph. An MST is a subgraph that connects all the vertices together, without any cycles, and with the minimum possible total edge weight. Kruskal's algorithm is particularly intuitive as it builds the MST by adding edges one by one, always picking the cheapest available edge that does not form a cycle.

---

## History

Kruskal's algorithm was first published by **Joseph Kruskal** in 1956. It is one of the classic algorithms for finding MSTs, alongside Prim's algorithm.

---
## Behaviour of Kruskal's Algorithm

1.  **Sort Edges**: Sort all the edges of the graph in non-decreasing order of their weights.
2.  **Initialize MST**: Create an empty set for the MST and a Disjoint Set Union (DSU) data structure (also known as Union-Find) to keep track of connected components.
3.  **Iterate and Add Edges**: Iterate through the sorted edges:
    a.  For each edge `(u, v)` with weight `w`:
    b.  Check if `u` and `v` are already in the same connected component using the DSU's `find` operation.
    c.  If they are not in the same component, adding this edge will not form a cycle. So, add the edge to the MST set and unite the components of `u` and `v` using the DSU's `union` operation.
4.  **Termination**: Continue until `V-1` edges have been added to the MST (where `V` is the number of vertices) or all edges have been considered. If the graph is connected, an MST with `V-1` edges will be formed.

---

## Algorithm Complexity

-   **Time Complexity**: `O(E log E)` or `O(E log V)`. Sorting the edges takes `O(E log E)` time. The DSU operations (find and union) take nearly constant time on average (amortized `O(α(V))`, where `α` is the inverse Ackermann function, which is extremely slow-growing and practically constant). Since `E` can be at most `V^2`, `log E` is at most `2 log V`, so `O(E log E)` is equivalent to `O(E log V)`.
-   **Space Complexity**: `O(V + E)` to store the graph, the sorted list of edges, and the DSU data structure.

---

## Comparison

-   **Prim's Algorithm**: Both Prim's and Kruskal's find an MST. Prim's algorithm builds the MST by growing a single tree from a starting vertex, while Kruskal's builds a forest of trees that eventually merge into a single MST. Kruskal's is generally better for sparse graphs (fewer edges), while Prim's (especially with a Fibonacci heap) can be faster for dense graphs.

---

## How the Algorithm is Implemented

This implementation uses a `List` to store all edges, which are then sorted by weight. A `DisjointSetUnion` (DSU) data structure is used to efficiently check for cycles and merge connected components. The DSU operations (`find` and `union`) are crucial for the algorithm's efficiency.

---

## Known Applications

-   **Network Design**: Designing telecommunication or computer networks to minimize cable length or cost.
-   **Clustering**: Grouping data points in machine learning.
-   **Image Segmentation**: Connecting similar pixels to form regions.
-   **Circuit Design**: Minimizing the amount of wire needed to connect components.

---

## API Documentation

### `public static <T> List<Graph.Edge<T>> findMinimumSpanningTree(Graph<T> graph)`

Finds the Minimum Spanning Tree (MST) of the given `graph` using Kruskal's algorithm.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to find the MST. The graph must be connected and undirected.
-   **Returns:**
    -   A `List<Graph.Edge<T>>` representing the edges of the MST.
    -   Returns an empty list if the graph is not connected or has no edges.
