# Topological Sort (Recursive DFS)

## Introduction

Topological sorting is a linear ordering of the vertices of a Directed Acyclic Graph (DAG) such that for every directed edge from vertex `u` to vertex `v`, vertex `u` comes before vertex `v` in the ordering. It is a fundamental algorithm used in various applications where tasks or events have dependencies.

This algorithm is not applicable to undirected graphs or graphs containing cycles.

## History

The concept of topological sorting was first described in the early 1960s. One of the first algorithms was published by Arthur B. Kahn in 1962, which uses an approach based on in-degrees. The alternative approach, which is used in this implementation, is based on Depth-First Search and was first described by Robert Tarjan in 1976.

## Behaviour of the Algorithm

This implementation uses a recursive Depth-First Search (DFS) approach to perform the topological sort. The algorithm traverses the graph, and for each visited vertex, it recursively visits all its neighbors. After visiting all the neighbors of a vertex, the vertex is pushed onto a stack.

This process ensures that a vertex is only added to the stack after all its dependencies (descendants in the graph) have been processed and pushed first. The final topologically sorted path is the sequence of vertices popped from the stack.

This implementation also includes cycle detection. During the DFS traversal, it maintains a separate `recursionStack` to keep track of the vertices in the current traversal path. If it encounters a vertex that is already in the `recursionStack`, it means a back edge has been found, indicating a cycle in the graph.

## How the Algorithm is Implemented

- **Main Data Structures**: The implementation relies on three main data structures:
    - A `Deque` (used as a `Stack`) to store the topologically sorted vertices.
    - A `Set` (`visited`) to keep track of all visited vertices to avoid redundant processing.
    - A `Set` (`recursionStack`) to keep track of vertices currently in the recursion stack to detect cycles.

- **Core Logic**: The `sort()` method iterates through all vertices in the graph, calling a recursive helper function (`hasCycle`) for any unvisited vertex. This helper function performs the DFS traversal. If it finds a cycle, it immediately returns `true`. If the traversal of a vertex and all its descendants completes without finding a cycle, the vertex is pushed onto the result stack.

- **Cycle Detection**: If the `hasCycle` function encounters a neighbor that is already in the `recursionStack`, it confirms a cycle, and the `sort` method throws an `IllegalStateException`.

## Algorithm Complexity

*   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. This is the complexity of the underlying DFS traversal.
*   **Space Complexity**: `O(V)` in the worst case. This is the space used by the `visited` set, the `recursionStack`, and the result stack.

## Comparison

*   **DFS-based vs. Kahn's Algorithm**: Both algorithms have the same time complexity. The DFS-based approach is often more intuitive to implement recursively. Kahn's algorithm, which is iterative and uses a queue, can sometimes be more useful as it can detect all cycles and can produce multiple valid topological sorts if they exist. The DFS-based approach naturally produces one valid sort (the reverse post-order traversal).

## Known Applications

- **Dependency Resolution**: Used in build systems (like Maven or Gradle) and package managers (like npm or pip) to determine the order in which to build or install modules with dependencies.
- **Task Scheduling**: In project management, it can be used to schedule a sequence of jobs or tasks based on their dependencies.
- **Instruction Scheduling**: In compilers, it can be used to order the sequence of machine instructions.
- **Event Ordering**: In simulations, to determine the sequence of events.

## API Documentation

### `public List<Graph.Vertex<T>> sort()`

Performs a topological sort on the graph provided in the constructor.

- **Returns**: A `List<Graph.Vertex<T>>` containing the vertices in topologically sorted order.
- **Throws**: `IllegalStateException` if the graph contains a cycle, as a topological sort is not possible.
