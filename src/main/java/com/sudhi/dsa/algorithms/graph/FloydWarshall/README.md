# Floyd-Warshall Algorithm

## Introduction

The Floyd-Warshall algorithm is a powerful and elegant dynamic programming algorithm used for finding the shortest paths between **all pairs** of vertices in a weighted, directed graph. It is an All-Pairs Shortest Path (APSP) algorithm. Unlike single-source shortest path algorithms like Dijkstra's or Bellman-Ford, Floyd-Warshall calculates the shortest route from every node to every other node in a single execution. It can handle positive and negative edge weights, but it will not produce correct results for graphs containing negative weight cycles.

---

## History

The algorithm is named after **Robert Floyd** (1962), who published it in its currently recognized form. However, the algorithm is essentially the same as algorithms published by **Bernard Roy** in 1959 and also by **Stephen Warshall** in 1962 for finding the transitive closure of a graph. The modern formulation that finds shortest paths is most commonly attributed to Floyd.

---

## Behaviour of the Floyd-Warshall Algorithm

The algorithm is based on a simple and intuitive principle: for any pair of vertices `i` and `j`, the shortest path between them is either the direct edge `(i, j)` or a path that goes through some intermediate vertex `k`. 

Floyd-Warshall considers each vertex `k` in the graph and checks if the path from `i` to `j` can be shortened by going through `k`. It systematically tries every possible intermediate vertex for every possible pair of source and destination vertices.

It builds up the solution iteratively. After `k` iterations, the algorithm will have found the shortest path between all pairs of vertices `(i, j)` that only use intermediate vertices from the set `{1, 2, ..., k}`.

---

## Algorithm Complexity

-   **Time Complexity**: **O(V^3)**, where `V` is the number of vertices. This is due to the three nested loops that iterate through all possible intermediate vertices `k` for all possible pairs of source `i` and destination `j`.
-   **Space Complexity**: **O(V^2)** to store the distance matrix that holds the shortest path distances between all pairs of vertices.

---

## Comparison with Other Algorithms

-   **vs. Repeated Bellman-Ford**: To solve the all-pairs problem, one could run a single-source algorithm like Bellman-Ford `V` times (once from each vertex). This would result in a total time complexity of `V * O(V*E) = O(V^2 * E)`. On a dense graph where `E` is close to `V^2`, this is `O(V^4)`, making Floyd-Warshall's `O(V^3)` more efficient. On a sparse graph, repeated Bellman-Ford might be faster.
-   **vs. Repeated Dijkstra**: If the graph has no negative edges, running Dijkstra from every vertex would have a complexity of `V * O(E + V log V)`. This is generally better than Floyd-Warshall for sparse graphs.

---

## How the Algorithm is Implemented

This implementation uses a 2D array (`dist[][]`) to store the shortest path distances between vertices.

1.  **Initialization**:
    -   A `dist` matrix of size `V x V` (where `V` is the number of vertices) is created.
    -   The distance from a vertex to itself (`dist[i][i]`) is initialized to `0`.
    -   The distance for all direct edges in the graph is populated in the matrix. `dist[u][v] = weight(u, v)`.
    -   All other distances are initialized to `Double.POSITIVE_INFINITY`, representing that there is no known path.

2.  **Main Loop**: The core of the algorithm consists of three nested loops:
    -   The outer loop iterates through each vertex `k` from `0` to `V-1`, considering it as a potential intermediate vertex.
    -   The two inner loops iterate through all possible source vertices `i` and destination vertices `j`.
    -   Inside the loops, it performs the relaxation step: `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`. This checks if the path from `i` to `j` via `k` is shorter than the currently known path.

3.  **Result Mapping**: After the loops complete, the `dist` matrix contains the shortest path distances between all pairs of vertices. This matrix is then converted into a `Map<Graph.Vertex<T>, Map<Graph.Vertex<T>, Double>>` for a more user-friendly return type.

---

## Known Applications

The Floyd-Warshall algorithm is used in a variety of applications where all-pairs shortest paths are needed:

-   **Transitive Closure of a Graph**: To find if there is a path between any two vertices.
-   **Network Routing**: For pre-calculating all possible routes in a small to medium-sized network.
-   **Bioinformatics**: In analyzing pathways in protein-protein interaction networks.
-   **Game Theory**: For finding optimal strategies in certain types of games.
-   **Shortest path in a city**: Finding the shortest path between every two intersections in a city map.

---

## API Documentation

### `public Map<Graph.Vertex<T>, Map<Graph.Vertex<T>, Double>> findAllShortestPaths(Graph<T> graph)`

Finds the shortest paths between all pairs of vertices in a given `graph` using the Floyd-Warshall algorithm.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform the search.
-   **Returns:**
    -   A `Map<Graph.Vertex<T>, Map<Graph.Vertex<T>, Double>>`. The outer map's keys are the source vertices, and the inner map contains the destination vertices and their corresponding shortest path distances from the source.
    -   If a path does not exist between two vertices, the distance will be `Double.POSITIVE_INFINITY`.
