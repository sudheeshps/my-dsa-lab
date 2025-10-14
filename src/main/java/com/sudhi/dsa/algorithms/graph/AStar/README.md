# A* Search Algorithm

## Introduction

The A* (pronounced "A-star") algorithm is a widely used and highly efficient pathfinding and graph traversal algorithm. It is known for its performance and accuracy in finding the shortest path between two points, or nodes. A* is an informed search algorithm, as it uses a heuristic function to guide its search towards the destination, making it generally more efficient than uninformed search algorithms like Dijkstra's or Breadth-First Search.

---

## History

The A* algorithm was developed as part of the Shakey the Robot project at the Stanford Research Institute (now SRI International). It was described in a 1968 paper by **Peter Hart, Nils Nilsson, and Bertram Raphael**. A* is an extension of Dijkstra's algorithm and gained popularity for its ability to incorporate a heuristic, which significantly improves performance for pathfinding problems.

---

## Behaviour of the A* Algorithm

The core of the A* algorithm lies in the formula it uses to evaluate the "cost" of the path through any given node:

**f(n) = g(n) + h(n)**

Where:

-   **n** is the next node on the path.
-   **g(n)** is the actual cost of the path from the start node to `n`.
-   **h(n)** is the **heuristic** estimated cost from `n` to the end node.

At each step, A* chooses to explore the node with the lowest `f(n)` value. The quality of the heuristic is crucial: an optimistic (admissible) heuristic that never overestimates the true cost will guarantee that A* finds the shortest possible path.

---

## Algorithm Complexity

-   **Time Complexity**: `O(E + V log V)` in the worst case with an admissible heuristic, where `V` is the number of vertices and `E` is the number of edges. The use of a priority queue is the dominant factor. In practice, the efficiency of A* is highly dependent on the quality of the heuristic. A better heuristic prunes more of the search space, leading to much faster performance.
-   **Space Complexity**: `O(V)` to store the nodes in the priority queue (open set), the set of visited nodes (closed set), and the maps used to track scores and path reconstruction.

---

## Comparison

-   **Dijkstra's Algorithm**: A* can be considered an extension of Dijkstra's. The key difference is that A* adds a heuristic (`h(n)`) to the cost function. If the heuristic is set to zero for all nodes (`h(n) = 0`), A* behaves identically to Dijkstra's. For single-pair shortest path problems, A* is typically much faster because the heuristic guides the search towards the goal, whereas Dijkstra's explores radially outwards.

-   **Breadth-First Search (BFS)**: BFS is an uninformed algorithm that is optimal for finding the shortest path on unweighted graphs (in terms of the number of edges). A* is an informed algorithm designed for weighted graphs and is generally far more efficient.

-   **Greedy Best-First Search**: This algorithm only considers the heuristic cost (`h(n)`) and ignores the actual cost of the path so far (`g(n)`). It is very fast but does not guarantee the shortest path and can be easily led into dead ends. A* provides a better balance by considering both the past cost and future estimated cost, ensuring it finds the optimal path.

---

## How the Algorithm is Implemented

This implementation of A* uses several key data structures to efficiently find the shortest path:

1.  **Open Set (Priority Queue)**: A `PriorityQueue` is used for the "open set," which stores the nodes that have been discovered but not yet fully evaluated. The priority queue ensures that the node with the lowest `fScore` is always processed next, which is the central principle of the A* algorithm.

2.  **Score Maps (HashMaps)**: Two `HashMap`s, `gScore` and `fScore`, are used to store the cost from the start node and the total estimated cost for each node, respectively. Using maps provides O(1) average time complexity for score lookups and updates.

3.  **Path Reconstruction Map**: A `cameFrom` `HashMap` is used to keep track of the path. For each node, it stores the preceding node on the cheapest path found so far. Once the destination is reached, this map is used by the `reconstructPath` helper method to trace the path back to the start.

4.  **Heuristic Function**: The `heuristic` function estimates the cost from a given node to the destination. This implementation includes a specific heuristic for when the graph nodes are `java.awt.Point` objects, calculating the direct Euclidean distance between them. For other data types, it uses a simple default heuristic.

---

## Known Applications

A* is one of the most popular pathfinding algorithms and is used in a wide variety of applications, including:

-   **Video Games**: For character navigation, finding the shortest path around obstacles.
-   **Robotics and Navigation**: In route planning for autonomous vehicles or robots.
-   **Network Routing**: To find the shortest path for data packets to travel through a network.
-   **Logistics and Operations Research**: For solving routing problems, such as finding the most efficient route for a delivery truck.

---

## API Documentation

### `public static <T> List<Graph.Vertex<T>> findPath(Graph<T> graph, Graph.Vertex<T> start, Graph.Vertex<T> end)`

Finds the shortest path between a `start` and `end` vertex in a `graph` using the A* algorithm.

-   **Parameters:**
    -   `graph`: The `Graph<T>` on which to perform the search. The graph should be weighted.
    -   `start`: The `Graph.Vertex<T>` representing the starting point for the path.
    -   `end`: The `Graph.Vertex<T>` representing the destination.
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the sequence of vertices in the shortest path from `start` to `end`.
    -   Returns `null` if no path is found between the start and end vertices.
