# Kruskal's Algorithm for Minimum Spanning Tree (MST)

## Introduction

Kruskal's algorithm is a greedy algorithm that finds a Minimum Spanning Tree (MST) for a connected, weighted, and undirected graph. It finds a subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized.

---

## History

The algorithm was first published in 1956 by **Joseph Kruskal**. It was one of several early and influential greedy algorithms developed for graph problems.

---

## Behaviour of the Algorithm

The algorithm treats the graph as a forest and each vertex in it as an individual tree. It then sorts all the edges in non-decreasing order of their weights. It picks the smallest edge and checks if adding it to the spanning tree being formed will create a cycle. If no cycle is formed, the edge is included; otherwise, it is discarded.

This process is repeated until there are (V-1) edges in the spanning tree, where V is the number of vertices.

---

## Algorithm Complexity

-   **Time Complexity**: **O(E log E)** or **O(E log V)**. The dominant step is sorting the edges. The Union-Find operations have a nearly constant time complexity on average.
-   **Space Complexity**: **O(V + E)** to store the graph, the list of edges, and the Disjoint Set Union data structure.

---

## Comparison with Other Algorithms

-   **vs. Prim's Algorithm**: Both are greedy algorithms for finding MSTs. Kruskal's algorithm works by sorting edges and adding them as long as they don't form a cycle. Prim's algorithm grows a single tree from a starting vertex. Kruskal's is often faster for **sparse graphs** (where `E` is much smaller than `V^2`), while Prim's (with a Fibonacci heap) can be faster for **dense graphs**.

---

## How the Algorithm is Implemented

This implementation relies on a **Disjoint Set Union (DSU)** data structure, often called Union-Find, to efficiently detect cycles.

1.  All edges from the input graph are placed into a list and sorted by weight in ascending order.
2.  A `DisjointSet` helper class is used. Initially, each vertex is in its own set (`makeSet`).
3.  The algorithm iterates through the sorted edges. For each edge, it checks if the two vertices of the edge belong to the same set using the `find` operation.
4.  If they are in different sets, it means adding the edge will not form a cycle. The edge is added to the MST, and the two sets are merged using the `union` operation.
5.  If they are already in the same set, adding the edge would form a cycle, so it is ignored.

## Known Applications

- **Network Design**: Laying out electrical grids, computer networks, or pipelines to minimize total cable/pipe length.
- **Approximation Algorithms**: Used as a component in more complex algorithms, such as for the Traveling Salesman Problem.
- **Clustering**: Can be used in clustering algorithms to group similar data points.

## API Documentation

### `public Graph<T> findMST(Graph<T> graph)`

Finds the Minimum Spanning Tree (MST) of a given graph using Kruskal's algorithm.

- **Parameters**:
  - `graph`: The input `Graph<T>` for which to find the MST. It is assumed to be weighted and undirected.
- **Returns**:
  - A new `Graph<T>` object representing the Minimum Spanning Tree.
