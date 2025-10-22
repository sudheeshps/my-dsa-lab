# Recursive Depth-First Search (DFS)

## Introduction

Depth-First Search (DFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the root (or an arbitrary node) and explores as far as possible along each branch before backtracking. This recursive version of DFS is often more concise and easier to understand than its iterative counterpart, but it can be limited by recursion depth for very large graphs.

---

## History

DFS is a fundamental graph traversal algorithm, and its principles have been used in various forms since the early days of computer science. It is often contrasted with Breadth-First Search (BFS).

---

## Behaviour of Recursive DFS

1.  **Base Case**: If the current node has already been visited, return.
2.  **Visit Node**: Mark the current node as visited and process it (e.g., print it, check if it's the target).
3.  **Recurse on Neighbors**: For each unvisited neighbor of the current node, recursively call DFS on that neighbor.

This process naturally explores deeply into each branch before returning to explore other branches, due to the nature of recursion.

---

## Algorithm Complexity

-   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. Each vertex and each edge is processed at most once.
-   **Space Complexity**: `O(V)` in the worst case, due to the recursion stack. In a skewed tree or a graph with long paths, the recursion depth can be `V`.

---

## Comparison

-   **Breadth-First Search (BFS)**: DFS explores depth-wise, while BFS explores level by level. DFS uses recursion (or a stack), BFS uses a queue. DFS is not guaranteed to find the shortest path in unweighted graphs, while BFS is.

-   **Iterative DFS**: The iterative version avoids potential stack overflow issues that can occur with deep recursion in recursive DFS, especially for very large graphs.

---

## How the Algorithm is Implemented

This recursive implementation of DFS uses a `HashSet` to keep track of visited nodes to prevent cycles and redundant processing. The recursion itself handles the stack management.

---

## Known Applications

-   **Topological Sorting**: Ordering tasks or items that have dependencies.
-   **Cycle Detection**: Detecting cycles in a graph.
-   **Pathfinding**: Finding a path between two nodes (though not necessarily the shortest).
-   **Connected Components**: Finding all connected components in a graph.
-   **Solving Puzzles**: Such as mazes or logic puzzles.

---

## API Documentation

### `public static <T> void dfs(Graph<T> graph, Graph.Vertex<T> startVertex)`

Performs a recursive Depth-First Search (DFS) on the given `graph` starting from `startVertex`.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform DFS.
    -   `startVertex`: The `Graph.Vertex<T>` from which to start the DFS traversal.
