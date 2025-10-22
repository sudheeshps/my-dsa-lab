# Kahn's Topological Sort Algorithm

## Introduction

Kahn's algorithm, also known as the "in-degree algorithm," is a method for performing a topological sort of a directed acyclic graph (DAG). A topological sort is a linear ordering of its vertices such that for every directed edge `u -> v`, vertex `u` comes before vertex `v` in the ordering. Topological sorting is only possible for DAGs; if a graph contains a cycle, a topological sort cannot be performed.

---

## History

Kahn's algorithm was first published by **Arthur B. Kahn** in 1962. It is one of the two main algorithms for topological sorting, the other being based on Depth-First Search (DFS).

---

## Behaviour of Kahn's Topological Sort Algorithm

1.  **Compute In-degrees**: For every vertex in the graph, calculate its "in-degree," which is the number of incoming edges.
2.  **Initialize Queue**: Add all vertices with an in-degree of 0 to a queue. These are the starting points of the topological sort.
3.  **Process Vertices**: While the queue is not empty:
    a.  Dequeue a vertex `u` and add it to the topological order list.
    b.  For each neighbor `v` of `u`:
        i.  Decrement the in-degree of `v`.
        ii. If the in-degree of `v` becomes 0, enqueue `v`.
4.  **Cycle Detection**: After the queue is empty, if the number of vertices in the topological order list is less than the total number of vertices in the graph, it indicates that the graph contains at least one cycle, and thus a topological sort is not possible.

---

## Algorithm Complexity

-   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. This is because each vertex and each edge is processed a constant number of times (calculating in-degrees, adding to queue, processing neighbors).
-   **Space Complexity**: `O(V + E)` to store the graph, in-degrees, and the queue.

---

## Comparison

-   **DFS-based Topological Sort**: Both Kahn's algorithm and DFS-based topological sort have the same time complexity. The DFS-based approach typically involves performing a DFS and adding vertices to the topological order in decreasing order of their finish times. Kahn's algorithm is often preferred for its iterative nature and ease of understanding, especially for cycle detection.

---

## How the Algorithm is Implemented

This implementation uses a `HashMap` to store the in-degree of each vertex and a `Queue` (specifically, a `LinkedList` acting as a queue) to manage vertices with an in-degree of 0. It iterates through the graph to compute initial in-degrees and then processes vertices from the queue, updating in-degrees of neighbors.

---

## Known Applications

-   **Task Scheduling**: Ordering tasks in a project where some tasks depend on others (e.g., build systems, course prerequisites).
-   **Dependency Resolution**: In software package management (e.g., `apt`, `npm`, `maven`), to determine the order in which packages should be installed.
-   **Spreadsheet Recalculation**: Determining the order in which cells need to be recalculated when their dependencies change.
-   **Data Serialization**: Ordering objects for serialization based on their dependencies.

---

## API Documentation

### `public static <T> List<Graph.Vertex<T>> topologicalSort(Graph<T> graph)`

Performs a topological sort on the given `graph` using Kahn's algorithm.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform the topological sort. Must be a Directed Acyclic Graph (DAG).
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` representing the topological order of the vertices.
    -   Returns `null` if the graph contains a cycle.
