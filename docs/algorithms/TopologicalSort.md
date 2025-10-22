# Topological Sort (DFS-based) Algorithm

## Introduction

Topological Sort is a linear ordering of vertices in a directed acyclic graph (DAG) such that for every directed edge `u -> v`, vertex `u` comes before vertex `v` in the ordering. This algorithm is based on Depth-First Search (DFS) and is one of the two primary methods for performing a topological sort (the other being Kahn's algorithm). Topological sorting is only possible for DAGs; if a graph contains a cycle, a topological sort cannot be performed.

---

## History

The concept of topological sorting has been around since the early days of graph theory and computer science. The DFS-based approach is a natural extension of the standard DFS traversal.

---

## Behaviour of DFS-based Topological Sort

1.  **Initialization**: Create an empty list to store the topological order and a set to keep track of visited nodes. Also, maintain a recursion stack set to detect cycles.
2.  **DFS Traversal**: For each unvisited vertex `u` in the graph, perform a DFS starting from `u`.
3.  **DFS Helper Function**: Inside the DFS function for a vertex `u`:
    a.  Mark `u` as visited and add it to the recursion stack.
    b.  For each neighbor `v` of `u`:
        i.  If `v` is in the recursion stack, a cycle is detected (return `false` or throw an exception).
        ii. If `v` is not visited, recursively call DFS on `v`.
    c.  Remove `u` from the recursion stack.
    d.  Add `u` to the front of the topological order list. (This is the key step: nodes are added to the list after all their descendants have been processed).

---

## Algorithm Complexity

-   **Time Complexity**: `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges. This is because the algorithm performs a DFS traversal, and each vertex and edge is visited a constant number of times.
-   **Space Complexity**: `O(V)` for the visited set, recursion stack, and the topological order list.

---

## Comparison

-   **Kahn's Algorithm**: Both DFS-based topological sort and Kahn's algorithm have the same time complexity. Kahn's algorithm is iterative and uses in-degrees, while the DFS-based approach is recursive and uses finish times. Both can detect cycles.

---

## How the Algorithm is Implemented

This implementation uses a `HashSet` to keep track of visited nodes and another `HashSet` (`recursionStack`) to detect cycles during the DFS traversal. A `LinkedList` is used to build the topological order, adding elements to the front as they are finished.

---

## Known Applications

-   **Task Scheduling**: Ordering tasks in a project where some tasks depend on others (e.g., build systems, course prerequisites).
-   **Dependency Resolution**: In software package management (e.g., `apt`, `npm`, `maven`), to determine the order in which packages should be installed.
-   **Spreadsheet Recalculation**: Determining the order in which cells need to be recalculated when their dependencies change.
-   **Data Serialization**: Ordering objects for serialization based on their dependencies.

---

## API Documentation

### `public static <T> List<Graph.Vertex<T>> topologicalSort(Graph<T> graph)`

Performs a topological sort on the given `graph` using a DFS-based approach.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform the topological sort. Must be a Directed Acyclic Graph (DAG).
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` representing the topological order of the vertices.
    -   Returns `null` if the graph contains a cycle.
