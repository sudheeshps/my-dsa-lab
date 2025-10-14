# Bellman-Ford Algorithm

## Introduction

The Bellman-Ford algorithm is a fundamental algorithm used to find the shortest paths from a single source vertex to all other vertices in a weighted, directed graph. Unlike Dijkstra's algorithm, Bellman-Ford is more versatile as it can handle graphs that contain negative edge weights. This makes it suitable for a wider range of problems where costs can be negative (e.g., representing a gain instead of a cost).

---

## History

The algorithm is named after its two main inventors: **Richard Bellman** (who published it in 1958) and **Lester Ford Jr.** (who published it in 1956). Edward F. Moore also independently published the same algorithm in 1957, so it is sometimes referred to as the Bellman-Ford-Moore algorithm.

---

## Behaviour of the Bellman-Ford Algorithm

The algorithm is based on the principle of **relaxation**. It systematically decreases an estimated distance to a vertex until the true shortest path distance is found. The core idea is that if a path from the source to vertex `u` is known, and there is an edge from `u` to `v`, then a potential shorter path to `v` can be found by going through `u`.

Bellman-Ford repeats this relaxation process for every edge in the graph. It does this `V-1` times, where `V` is the number of vertices. After `i` iterations, the algorithm is guaranteed to have found the shortest path to any vertex that is reachable from the source in at most `i` edges.

One of the most critical features of Bellman-Ford is its ability to detect **negative weight cycles**. If, after `V-1` iterations, the algorithm can still find a shorter path for any vertex, it means the graph contains a negative weight cycle that is reachable from the source. Such a cycle would allow for infinitely short paths, so the algorithm reports this as an error.

---

## Algorithm Complexity

-   **Time Complexity**: **O(V * E)**, where `V` is the number of vertices and `E` is the number of edges. The algorithm iterates through all `E` edges `V-1` times.
-   **Space Complexity**: **O(V)** to store the distances from the source vertex to all other vertices.

---

## Comparison with Other Algorithms

-   **vs. Dijkstra's Algorithm**: Bellman-Ford is significantly slower than Dijkstra's (O(V*E) vs. O(E + V log V)). However, its key advantage is its ability to handle graphs with **negative edge weights**, which Dijkstra cannot. If the graph is guaranteed to have no negative edge weights, Dijkstra's is the superior choice.
-   **vs. Floyd-Warshall Algorithm**: Bellman-Ford is a single-source shortest path algorithm (finding paths from one start node), whereas Floyd-Warshall is an all-pairs shortest path algorithm (finding paths between all pairs of nodes). For the single-source problem, Bellman-Ford is more efficient than Floyd-Warshall's O(V^3).

---

## How the Algorithm is Implemented

This implementation follows the classic Bellman-Ford procedure:

1.  **Initialization**: A `distances` `HashMap` is created to store the shortest distance from the `start` vertex to every other vertex. All distances are initialized to `Double.POSITIVE_INFINITY`, except for the start vertex, which is set to `0`.

2.  **Iterative Relaxation**: The algorithm iterates `V-1` times (where `V` is the number of vertices). In each iteration, it loops through every edge in the graph. For each edge `(u, v)` with weight `w`, it checks if the path through `u` is shorter than the currently known path to `v`. If `distance(u) + w < distance(v)`, it updates `distance(v)`.

3.  **Negative Cycle Detection**: After the main loop completes, the algorithm performs one final iteration over all the edges. If any distance can still be improved, it means a negative weight cycle exists, and the algorithm throws a `RuntimeException` to indicate this.

---

## Known Applications

The Bellman-Ford algorithm is used in various applications, especially when negative weights are possible:

-   **Network Routing**: In distance-vector routing protocols (like RIP), it helps find the shortest paths for data packets. The negative weights can represent gains or preferences.
-   **Arbitrage Detection in Finance**: In currency exchange, it can be used to detect arbitrage opportunities, which can be modeled as negative weight cycles.
-   **Network Flow Analysis**: As a component in more complex algorithms for analyzing network flows.

---

## API Documentation

### `public Map<Graph.Vertex<T>, Double> findShortestPaths(Graph<T> graph, Graph.Vertex<T> start)`

Computes the shortest paths from a single `start` vertex to all other vertices in a weighted, directed `graph`.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform the search. It must be a directed graph.
    -   `start`: The `Graph.Vertex<T>` from which to calculate the shortest paths.
-   **Returns:**
    -   A `Map<Graph.Vertex<T>, Double>` where the keys are the vertices in the graph and the values are their shortest distances from the `start` vertex. If a vertex is unreachable, its distance will be `Double.POSITIVE_INFINITY`.
-   **Throws:**
    -   `RuntimeException`: If the graph contains a negative weight cycle that is reachable from the start vertex.
