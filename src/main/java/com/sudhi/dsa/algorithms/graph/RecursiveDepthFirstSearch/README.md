# Recursive Depth-First Search (DFS)

## Introduction

Depth-First Search (DFS) is a fundamental graph traversal algorithm used to explore all the vertices of a graph. It starts at a selected root node and explores as far as possible along each branch before backtracking. The recursive implementation of DFS is the most common and intuitive version, as it leverages the program's call stack to manage the backtracking process.

## History

The concept of Depth-First Search was investigated in the 19th century by French mathematician Charles Pierre Trémaux as a strategy for solving mazes. The algorithm as we know it today was later formalized and analyzed in the context of computer science.

## Behaviour of the Algorithm

The algorithm behaves as follows:

1.  **Start at a vertex**: Pick a starting vertex and mark it as visited.
2.  **Explore a neighbor**: Move to an adjacent, unvisited vertex.
3.  **Recurse**: Repeat the process from this new vertex.
4.  **Backtrack**: Once all of a vertex's neighbors have been visited, the algorithm backtracks to the previous vertex (by returning from the recursive call) and continues exploring its unvisited neighbors.

This process continues until all vertices reachable from the starting vertex have been visited. If the graph has multiple disconnected components, the DFS must be started again from a vertex in an unvisited component.

## How the Algorithm is Implemented

This implementation uses the following components:

*   **`Graph<T>`**: The graph data structure on which the algorithm operates.
*   **`Set<T> visited`**: A `HashSet` is used to keep track of all the nodes that have already been visited. This is crucial to prevent the algorithm from getting stuck in an infinite loop if the graph contains cycles.
*   **`dfs(T startNode)`**: The public method that initializes the `visited` set and starts the traversal from a given `startNode`.
*   **`dfsRecursive(T currentNode)`**: A private helper method that performs the actual recursion. It marks the current node as visited and then iterates through its neighbors, making a recursive call for each unvisited neighbor.

## Algorithm Complexity

*   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. The algorithm must visit every vertex and check every edge once.
*   **Space Complexity**: `O(V)` in the worst case. This is the space used by the `visited` set and the recursion call stack. In the worst case (a long, chain-like graph), the recursion depth can be `V`.

## Comparison

*   **DFS vs. BFS**: DFS explores a path to its conclusion before backtracking, making it suitable for finding solutions deep in a search space (like solving a maze). Breadth-First Search (BFS) explores level by level, making it better for finding the shortest path in an unweighted graph. DFS is generally implemented with a stack (or recursion), while BFS is implemented with a queue.

## Known Applications

Depth-First Search is a building block for many other graph algorithms and has a wide range of applications, including:

*   **Finding Connected Components**: Identifying disjoint subgraphs.
*   **Cycle Detection**: Determining if a graph contains cycles.
*   **Topological Sorting**: Ordering the vertices of a Directed Acyclic Graph (DAG).
*   **Pathfinding**: Finding a path between two vertices.
*   **Solving Puzzles**: Such as navigating mazes.

## API Documentation

### `public List<T> dfs(T startNode)`

Performs a recursive Depth-First Search traversal on the graph starting from a specified node.

*   **Parameters**:
    *   `startNode`: The vertex from which to begin the search.
*   **Returns**:
    *   A `List<T>` containing the vertices in the order they were visited.
