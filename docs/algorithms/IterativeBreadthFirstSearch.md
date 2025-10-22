# Iterative Breadth-First Search (BFS)

## Introduction

Breadth-First Search (BFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key') and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level. This iterative version of BFS uses a queue to manage the order of nodes to visit.

---

## History

BFS was invented by **Konrad Zuse** in 1945, but it was not published until 1972. It is a fundamental algorithm in graph theory and is widely used in various applications.

---

## Behaviour of Iterative BFS

1.  **Initialization**: Start with a source node `s`. Create a queue and add `s` to it. Mark `s` as visited.
2.  **Exploration**: While the queue is not empty:
    a.  Dequeue a node `u`.
    b.  Process `u` (e.g., print it, check if it's the target).
    c.  Enqueue all unvisited neighbors of `u` and mark them as visited.

This process ensures that all nodes at a given depth are visited before moving to the next depth level, guaranteeing the shortest path in terms of the number of edges for unweighted graphs.

---

## Algorithm Complexity

-   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. Each vertex and each edge is processed at most once.
-   **Space Complexity**: `O(V)` in the worst case, to store the queue and the visited set. In a dense graph, the queue can hold all vertices.

---

## Comparison

-   **Depth-First Search (DFS)**: BFS explores level by level, while DFS explores as far as possible along each branch before backtracking. BFS is guaranteed to find the shortest path in unweighted graphs, whereas DFS is not. BFS uses a queue, DFS uses a stack (or recursion).

-   **Dijkstra's Algorithm**: Dijkstra's algorithm finds the shortest path in weighted graphs with non-negative edge weights. BFS is a special case of Dijkstra's where all edge weights are 1.

---

## How the Algorithm is Implemented

This iterative implementation of BFS uses a `Queue` (specifically, a `LinkedList` acting as a queue) to manage the nodes to be visited. A `HashSet` is used to keep track of visited nodes to prevent cycles and redundant processing.

---

## Known Applications

-   **Shortest Path in Unweighted Graphs**: Finding the shortest path in terms of the number of edges.
-   **Web Crawlers**: Used to traverse links on the web.
-   **Social Networking**: Finding the shortest connection between two people (e.g., "degrees of separation").
-   **Garbage Collection**: In some garbage collection algorithms, to mark all reachable objects.
-   **Network Broadcasting**: Finding all nodes reachable from a source in a network.

---

## API Documentation

### `public static <T> void bfs(Graph<T> graph, Graph.Vertex<T> startVertex)`

Performs an iterative Breadth-First Search (BFS) on the given `graph` starting from `startVertex`.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform BFS.
    -   `startVertex`: The `Graph.Vertex<T>` from which to start the BFS traversal.
