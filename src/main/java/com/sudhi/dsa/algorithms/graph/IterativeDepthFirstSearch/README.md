# Iterative Depth-First Search (DFS)

## Introduction

Depth-First Search (DFS) is a fundamental algorithm for traversing or searching tree or graph data structures. The algorithm starts at a selected root node and explores as far as possible along each branch before backtracking. This implementation uses an iterative approach, which manages the traversal explicitly with a stack, avoiding the potential for stack overflow errors that can occur with deep recursion in very large graphs.

## History

The concept of Depth-First Search was investigated in the 19th century by French mathematician Charles Pierre Trémaux as a strategy for solving mazes. The algorithm as we know it today was later formalized and analyzed in the context of computer science. The iterative version is a direct alternative to the recursive approach, designed to handle very deep graphs without exhausting the call stack.

## Behaviour of the Algorithm

The behaviour of an iterative DFS is characterized by its "deep" exploration strategy. It always expands the "deepest" node first.

1.  It begins at the starting vertex, pushes it onto a stack, and marks it as visited.
2.  It then enters a loop that continues as long as the stack is not empty.
3.  In each iteration, it pops a vertex from the stack.
4.  It then identifies all unvisited neighbors of that vertex and pushes them onto the stack.

This process continues until all reachable vertices have been visited. The use of a stack (a Last-In, First-Out structure) ensures that the algorithm always explores the most recently discovered path first, leading to its depth-first nature.

## How the Algorithm is Implemented

This implementation of iterative DFS relies on two primary data structures:

-   **Stack**: A `java.util.Stack` is used to keep track of the vertices to be visited. When a vertex is visited, its unvisited neighbors are pushed onto the stack.
-   **Set**: A `java.util.HashSet` is used to store the set of `visited` vertices. This provides O(1) average time complexity for checking if a vertex has already been visited, which is crucial for performance and to prevent the algorithm from getting stuck in cycles.

The `dfs` method orchestrates this process, initializing the data structures and running the main loop until the stack is empty, at which point the traversal is complete.

## Algorithm Complexity

*   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. The algorithm must visit every vertex and check every edge once.
*   **Space Complexity**: `O(V)` in the worst case. This is the space used by the `visited` set and the explicit `Stack`. In the worst case (a vertex connects to all other vertices), the stack can hold up to `V-1` vertices.

## Comparison

*   **Iterative vs. Recursive DFS**: The iterative approach provides the same traversal order and has the same time complexity as the recursive version. Its main advantage is that it is not limited by the depth of the system's call stack, making it safer for very deep or unbalanced graphs where recursion could lead to a `StackOverflowError`.
*   **DFS vs. BFS**: DFS explores a path to its conclusion before backtracking, making it suitable for finding solutions deep in a search space. Breadth-First Search (BFS) explores level by level, making it better for finding the shortest path in an unweighted graph. DFS is generally implemented with a stack, while BFS is implemented with a queue.

## Known Applications

DFS is a versatile algorithm used in many areas of computer science:

-   **Topological Sorting**: For ordering the vertices of a directed acyclic graph (DAG).
-   **Finding Connected Components**: To identify all vertices that are mutually reachable in a graph.
-   **Pathfinding**: To find a path between two vertices in a graph (though it doesn't guarantee the shortest path).
-   **Solving Puzzles**: Such as finding a path through a maze or solving puzzles like Sudoku.

## API Documentation

### `public List<Graph.Vertex<T>> dfs(Graph.Vertex<T> src)`

Performs an iterative Depth-First Search (DFS) on the graph starting from a given source vertex.

-   **Parameters:**
    -   `src`: The `Graph.Vertex<T>` representing the starting vertex for the traversal.
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the vertices in the order they were visited during the DFS traversal.
