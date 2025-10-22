# Iterative Depth-First Search (DFS)

## Introduction

Depth-First Search (DFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the root (or an arbitrary node) and explores as far as possible along each branch before backtracking. This iterative version of DFS uses a stack to manage the order of nodes to visit, avoiding recursion depth limits.

---

## History

DFS is a fundamental graph traversal algorithm, and its principles have been used in various forms since the early days of computer science. It is often contrasted with Breadth-First Search (BFS).

---

## Behaviour of Iterative DFS

1.  **Initialization**: Start with a source node `s`. Create a stack and add `s` to it. Create a set to keep track of visited nodes.
2.  **Exploration**: While the stack is not empty:
    a.  Pop a node `u` from the stack.
    b.  If `u` has not been visited:
        i.  Mark `u` as visited.
        ii. Process `u` (e.g., print it, check if it's the target).
        iii. Push all unvisited neighbors of `u` onto the stack. (The order of pushing neighbors can affect the traversal path, but not the correctness of visiting all reachable nodes).

This process ensures that the algorithm explores as deeply as possible along each path before returning to explore other branches.

---

## Algorithm Complexity

-   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. Each vertex and each edge is processed at most once.
-   **Space Complexity**: `O(V)` in the worst case, to store the stack and the visited set. In a skewed tree or a graph with long paths, the stack can hold all vertices.

---

## Comparison

-   **Breadth-First Search (BFS)**: DFS explores depth-wise, while BFS explores level by level. DFS uses a stack (or recursion), BFS uses a queue. DFS is not guaranteed to find the shortest path in unweighted graphs, while BFS is.

-   **Recursive DFS**: The iterative version avoids potential stack overflow issues that can occur with deep recursion in recursive DFS, especially for very large graphs.

---

## How the Algorithm is Implemented

This iterative implementation of DFS uses a `Stack` to manage the nodes to be visited. A `HashSet` is used to keep track of visited nodes to prevent cycles and redundant processing.

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

Performs an iterative Depth-First Search (DFS) on the given `graph` starting from `startVertex`.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform DFS.
    -   `startVertex`: The `Graph.Vertex<T>` from which to start the DFS traversal.
