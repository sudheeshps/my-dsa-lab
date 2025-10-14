# Prim's Algorithm for Minimum Spanning Tree (MST)

## Introduction

Prim's algorithm is a greedy algorithm that finds a minimum spanning tree (MST) for a weighted, undirected graph. An MST is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.

---

## History

The algorithm was originally developed in 1930 by Czech mathematician **Vojtěch Jarník**. It was later independently rediscovered and republished by computer scientist **Robert C. Prim** in 1957 and by **Edsger W. Dijkstra** in 1959. Therefore, it is also sometimes known as the Jarník-Prim algorithm or the DJP algorithm.

---

## Behaviour of the Algorithm

The algorithm works by building the MST from an arbitrary starting vertex. It greedily grows a single tree by adding the cheapest possible edge that connects a vertex in the growing tree to a vertex outside the tree.

The steps are as follows:
1. Initialize the MST with an arbitrary starting vertex.
2. Maintain a priority queue of all edges that connect vertices in the MST to vertices outside the MST.
3. At each step, extract the edge with the minimum weight from the priority queue.
4. If the vertex at the other end of the edge is not yet in the MST, add the edge and the vertex to the MST.
5. Repeat until all vertices are in the MST.

---

## Algorithm Complexity

-   **Time Complexity**: **O(E log V)** using a binary heap-based priority queue (as implemented here). With a more advanced Fibonacci heap, the complexity can be improved to **O(E + V log V)**.
-   **Space Complexity**: **O(V + E)** to store the graph, the priority queue, and the set of visited vertices.

---

## Comparison with Other Algorithms

-   **vs. Kruskal's Algorithm**: Both are greedy algorithms for finding MSTs. Prim's algorithm grows one tree from a start node. Kruskal's algorithm sorts all edges and adds the smallest ones that don't create a cycle. Prim's is generally faster for **dense graphs** (where `E` is close to `V^2`), while Kruskal's is often faster for **sparse graphs**.

---

## How the Algorithm is Implemented

This implementation uses a `PriorityQueue` to efficiently select the cheapest edge to add at each step.

- A `Set` is used to keep track of the vertices that have already been visited and included in the MST.
- The algorithm iterates through all vertices to handle disconnected graphs, finding an MST for each connected component.
- For each component, it starts with a vertex, adds all its outgoing edges to a `PriorityQueue`, and then enters a loop.
- In the loop, it polls the cheapest edge. If the destination vertex of that edge hasn't been visited, it's added to the MST, and all its outgoing edges are added to the priority queue.

## Known Applications

- **Network Design**: Designing least-cost networks, such as laying fiber optic cables, electrical wiring, or water pipes.
- **Approximation Algorithms**: Used as a subroutine in approximation algorithms for other problems, like the Traveling Salesman Problem.
- **Cluster Analysis**: Can be used to find clusters of points in a dataset.

## API Documentation

### `public Graph<T> findMST(Graph<T> graph)`

Finds the Minimum Spanning Tree (MST) of a given graph using Prim's algorithm.

- **Parameters**:
  - `graph`: The input `Graph<T>` for which to find the MST. It is assumed to be weighted and undirected.
- **Returns**:
  - A new `Graph<T>` object representing the Minimum Spanning Tree. If the input graph is null or empty, it returns a new empty graph.
