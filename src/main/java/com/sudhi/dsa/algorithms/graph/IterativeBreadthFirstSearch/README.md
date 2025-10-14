# Iterative Breadth-First Search (BFS)

## Introduction

Breadth-First Search (BFS) is a fundamental algorithm for traversing or searching graph and tree data structures. The algorithm starts at a given source node and explores all of its neighbors at the present depth before moving on to the nodes at the next depth level. This level-by-level traversal makes BFS an excellent algorithm for finding the shortest path in an unweighted graph.

This implementation performs BFS **iteratively**, using a queue to manage the traversal, which is the standard and most common way to implement BFS.

## History

BFS was invented in the late 1950s by E. F. Moore, who used it to find the shortest path out of a maze. It was later independently discovered and popularized by C. Y. Lee in the context of routing wires on circuit boards in 1961. Due to its nature, it is a foundational algorithm in graph theory.

## Behaviour of the Algorithm

-   **Traversal Order**: BFS explores the graph in a level-by-level fashion, visiting all nodes at a given depth before proceeding to the next level.
-   **Shortest Path**: For an unweighted graph, BFS is guaranteed to find the shortest path (in terms of the number of edges) between the starting node and any other reachable node.
-   **Completeness**: If the graph is finite, BFS is guaranteed to find a goal node if one exists.
-   **Data Structure**: The core of an iterative BFS is the **Queue** data structure, which operates on a First-In, First-Out (FIFO) basis. This ensures that nodes are visited in the order they are discovered.

## How the Algorithm is Implemented

This implementation uses a `Queue` to keep track of the nodes to visit and a `Set` to keep track of the nodes that have already been visited to avoid cycles and redundant processing.

1.  **Initialization**:
    -   A `Queue` (implemented as a `LinkedList`) is created to store the vertices to be visited.
    -   A `Set` (`HashSet`) is used to keep track of `visited` vertices.
    -   The `source` vertex is added to both the queue and the visited set.
    -   A `List` is initialized to store the traversal result.

2.  **Main Loop**: The algorithm runs as long as the `queue` is not empty.
    -   It dequeues a `vertex` from the front of the queue and adds it to the `result` list.
    -   It then retrieves all the `neighbor` vertices of the current `vertex`.
    -   For each `neighbor`, it checks if it has been visited. If not, the neighbor is added to the `visited` set and enqueued for future processing.

3.  **Termination**: Once the queue is empty, it means all reachable nodes have been visited, and the algorithm returns the `result` list containing the vertices in BFS order.

## Algorithm Complexity

*   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. The algorithm must visit every vertex and check every edge once.
*   **Space Complexity**: `O(V)` in the worst case. This is the space used by the `visited` set and the `Queue`. In the worst case (a star graph), the queue can hold up to `V-1` vertices.

## Comparison

*   **BFS vs. DFS**: BFS explores level by level, making it ideal for finding the shortest path in an unweighted graph. Depth-First Search (DFS) explores a path to its conclusion before backtracking, making it more suitable for problems where a solution is expected to be deep in the search space (like solving a maze). BFS is generally implemented with a queue, while DFS is implemented with a stack (or recursion).

## Known Applications

BFS is a versatile algorithm used in many areas of computer science:

-   **Shortest Path in Unweighted Graphs**: Finding the minimum number of steps or edges between two nodes.
-   **Web Crawlers**: To discover all the pages on a website by starting from a homepage and following links.
-   **Social Networks**: Finding all friends at a certain degree of connection (e.g., friends of friends).
-   **Network Broadcasting**: To send a message to all nodes in a network in the shortest amount of time.
-   **Garbage Collection**: Cheney's algorithm uses BFS to find all reachable objects during garbage collection.

## API Documentation

### `public List<Graph.Vertex<T>> bfs(Graph.Vertex<T> source)`

Performs an iterative Breadth-First Search (BFS) on the graph, starting from a given `source` vertex.

-   **Parameters:**
    -   `source`: The `Graph.Vertex<T>` from which the traversal begins.
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the vertices in the order they were visited during the BFS traversal.
