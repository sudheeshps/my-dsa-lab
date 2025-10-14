# Kahn's Algorithm for Topological Sort

## Introduction
Kahn's algorithm is a popular algorithm for performing a topological sort on a Directed Acyclic Graph (DAG). A topological sort is a linear ordering of vertices such that for every directed edge from vertex `u` to vertex `v`, `u` comes before `v` in the ordering. This algorithm is particularly useful in scheduling problems where tasks have dependencies.

---

## History

The algorithm was first described by **Arthur Kahn** in 1962. It provides a systematic way to create a topological ordering of a directed graph and is also capable of detecting cycles, making it a robust choice for dependency resolution.

---

## Behaviour of the Algorithm
The algorithm works by identifying vertices that have no incoming edges (an "in-degree" of zero) and adding them to a queue. It then processes these vertices one by one, adding them to the final sorted list. As each vertex is processed, it is conceptually "removed" from the graph, and the in-degree of all its neighboring vertices is decremented. If a neighbor's in-degree becomes zero, it is added to the queue. This process continues until the queue is empty.

If the final sorted list contains fewer vertices than the total number of vertices in the graph, it indicates that the graph contains at least one cycle.

---

## Algorithm Complexity

-   **Time Complexity**: **O(V + E)**, where `V` is the number of vertices and `E` is the number of edges. This is because the algorithm visits each vertex and each edge exactly once.
-   **Space Complexity**: **O(V)** to store the in-degrees of the vertices and the queue.

---

## Comparison with Other Algorithms

-   **vs. DFS-based Topological Sort**: The other common method for topological sorting is based on Depth-First Search (DFS). Both algorithms have the same time complexity. Kahn's algorithm processes nodes in a way that can be seen as a sequence of "ready" tasks, which can be useful in some scheduling applications. The DFS-based approach produces a valid topological sort by returning the reverse post-order traversal of the graph.

---

## How the Algorithm is Implemented
This implementation uses:
- A `Map<Vertex, Integer>` to store the in-degree of each vertex.
- A `Queue<Vertex>` to keep track of vertices with an in-degree of zero.

The `sort` method first calculates the in-degree of every vertex in the graph. It then initializes the queue with all vertices that have an in-degree of zero. The algorithm proceeds by dequeuing a vertex, adding it to the result list, and decrementing the in-degree of its neighbors. When a neighbor's in-degree becomes zero, it is enqueued.

## Known Applications
- **Task Scheduling**: Resolving dependencies in build systems (e.g., Makefiles), package managers, and task schedulers.
- **Course Prerequisites**: Determining the order in which to take university courses with prerequisites.
- **Data Serialization**: Ordering objects with dependencies for serialization.
- **Compiler Design**: Ordering the compilation of source code files.

## API Documentation

### `public List<Graph.Vertex<T>> sort()`
Performs a topological sort on the graph provided in the constructor using Kahn's algorithm.
- **Returns**:
  - A `List<Graph.Vertex<T>>` containing the vertices in topologically sorted order. If the graph contains a cycle, the returned list will have fewer vertices than the graph, allowing for implicit cycle detection by comparing list sizes.
