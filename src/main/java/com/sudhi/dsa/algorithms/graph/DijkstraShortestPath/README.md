# Dijkstra's Shortest Path Algorithm

## Introduction

Dijkstra's algorithm is a classic and highly efficient algorithm for finding the shortest paths between nodes in a weighted graph. It is a greedy algorithm that works by exploring the graph and always choosing the next closest vertex to visit. A key constraint of Dijkstra's is that it only works correctly on graphs with **non-negative edge weights**.

---

## History

The algorithm was conceived by Dutch computer scientist **Edsger W. Dijkstra** in 1956 and published in 1959. Dijkstra designed it in about 20 minutes as a demonstration of the capabilities of a new computer. He designed it without pen or paper and published it as a three-page article.

---

## Behaviour of Dijkstra's Algorithm

Dijkstra's algorithm works by maintaining a set of visited vertices and a set of tentative distances from the source to all other vertices. Its core properties are:

-   **Greedy Approach**: At each step, it greedily selects the unvisited vertex with the smallest known distance from the source.
-   **Path Relaxation**: It continuously "relaxes" the paths to vertices. If it finds a shorter path to a vertex `v` through a vertex `u`, it updates the distance to `v`.
-   **Guaranteed Optimality**: Because it only works with non-negative weights, once a vertex is marked as "visited," the path found to it is guaranteed to be the shortest one. This is because any other path would have to go through another unvisited vertex, which by definition has a longer path distance.

---

## Algorithm Complexity

-   **Time Complexity**: **O(E + V log V)** with a priority queue (as implemented here). `V` is the number of vertices and `E` is the number of edges. For each vertex, we perform an `extract-min` operation on the priority queue, and for each edge, we may perform a `decrease-key` operation.
-   **Space Complexity**: **O(V)** to store the distances, predecessors, and the priority queue.

---

## Comparison with Other Algorithms

-   **vs. Bellman-Ford**: Dijkstra's is faster but cannot handle negative edge weights. Bellman-Ford is slower (O(V*E)) but is more versatile as it can detect and handle negative weight cycles.
-   **vs. A* Search**: A* is an extension of Dijkstra's that uses a heuristic to guide its search, often making it faster in practice for finding a path to a single destination. However, A* does not necessarily find the shortest path to *all* nodes, whereas Dijkstra's does.
-   **vs. BFS**: Breadth-First Search (BFS) can be seen as a special case of Dijkstra's algorithm for unweighted graphs. On an unweighted graph, Dijkstra's behaves identically to BFS.

---

## How the Algorithm is Implemented

This implementation uses a `PriorityQueue` to efficiently find the unvisited vertex with the smallest distance at each step.

1.  **Initialization**: 
    -   A `distances` `HashMap` is used to store the shortest distance found so far from the source to every other vertex. All distances are initialized to `Integer.MAX_VALUE` except for the source, which is `0`.
    -   A `previous` `HashMap` is used to store the predecessor of each vertex in the shortest path, which is essential for reconstructing the path later.
    -   A `PriorityQueue` is used as the "open set" of vertices to visit. The queue is ordered by the tentative distances stored in the `distances` map, ensuring the closest vertex is always processed next.

2.  **Main Loop**: The algorithm runs as long as the priority queue is not empty. In each iteration:
    -   It extracts the vertex `current` with the smallest distance from the priority queue.
    -   If `current` is the destination, the shortest path has been found, and it is reconstructed using the `buildPath` helper method.
    -   For each `neighbor` of `current`, it performs the **relaxation** step: if the path to the neighbor through `current` is shorter than any previously known path, it updates the neighbor's distance and predecessor.

3.  **Path Reconstruction**: The `buildPath` helper method backtracks from the destination vertex using the `previous` map until it reaches the source, creating the final shortest path.

---

## Known Applications

Dijkstra's algorithm is fundamental in computer science and is used in many applications, including:

-   **Network Routing**: To find the shortest path for data packets in a network (e.g., in OSPF routing protocol).
-   **GPS and Mapping Services**: To find the shortest driving route between two locations.
-   **Social Networks**: To find the shortest path of connections between two people.
-   **Logistics and Flight Planning**: To find the cheapest or fastest route for travel.

---

## API Documentation

### `public List<Graph.Vertex<T>> getShortestPath(Graph.Vertex<T> src, Graph.Vertex<T> dest)`

Finds the shortest path between a `src` (source) and `dest` (destination) vertex in the graph using Dijkstra's algorithm.

-   **Parameters:**
    -   `src`: The `Graph.Vertex<T>` representing the starting point.
    -   `dest`: The `Graph.Vertex<T>` representing the destination.
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the sequence of vertices in the shortest path from `src` to `dest`.
    -   Returns an empty list (`Collections.emptyList()`) if no path exists.
