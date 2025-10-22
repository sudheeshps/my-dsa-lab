# Graph

## Introduction

A graph is a non-linear data structure consisting of a finite set of vertices (or nodes) and a set of edges (or arcs) that connect pairs of vertices. Graphs are used to model many real-world systems, such as social networks, road networks, and computer networks.

---

## History

Graph theory originated with **Leonhard Euler** in 1736 when he solved the famous "Seven Bridges of Königsberg" problem. Since then, graph theory has evolved into a vast and important field within mathematics and computer science, with applications in nearly every scientific discipline.

---

## Behaviour of a Graph

-   **Vertices (Nodes)**: The fundamental entities in a graph.
-   **Edges (Arcs)**: Connections between vertices. Edges can be:
    -   **Directed**: (u, v) means an edge from u to v, but not necessarily from v to u.
    -   **Undirected**: (u, v) means an edge between u and v, implying a connection in both directions.
-   **Weighted**: Edges can have associated numerical values (weights or costs) representing distance, time, capacity, etc.
-   **Cycles**: A path that starts and ends at the same vertex.
-   **Connectivity**: A graph is connected if there is a path between every pair of vertices.

---

## Data Structure Operations

-   **Add Vertex**: `O(1)` (using adjacency list with hash map) or `O(V)` (using adjacency matrix).
-   **Add Edge**: `O(1)` (using adjacency list) or `O(1)` (using adjacency matrix).
-   **Remove Vertex**: `O(V + E)` (requires iterating through all edges connected to the vertex).
-   **Remove Edge**: `O(1)` (using adjacency matrix) or `O(degree(V))` (using adjacency list).
-   **Check Adjacency**: `O(1)` (using adjacency matrix) or `O(degree(V))` (using adjacency list).

---

## Comparison

-   **Adjacency Matrix**: Good for dense graphs (many edges), `O(1)` edge lookup, but `O(V^2)` space.
-   **Adjacency List**: Good for sparse graphs (few edges), `O(V + E)` space, `O(degree(V))` edge lookup.

---

## How the Data Structure is Implemented

This `Graph` implementation uses an **adjacency list** representation, where each vertex is mapped to a list of its adjacent vertices (and edge weights if applicable). Specifically, it uses a `HashMap<Vertex<T>, List<Edge<T>>>` to store the graph structure.

-   **`Vertex<T>`**: A nested class representing a node in the graph, storing its data and providing `equals` and `hashCode` methods for use in `HashMap`.
-   **`Edge<T>`**: A nested class representing a connection between two vertices, storing the `source`, `destination`, and `weight`.

Key methods include `addVertex`, `addEdge`, `removeVertex`, `removeEdge`, and `getNeighbors`.

---

## Known Applications

-   **Social Networks**: Representing users as vertices and friendships as edges.
-   **GPS and Mapping**: Representing locations as vertices and roads as edges.
-   **Computer Networks**: Representing devices as vertices and connections as edges.
-   **Dependency Graphs**: In project management or compilers.
-   **Airline Flight Connections**: Representing airports as vertices and flights as edges.

---

## API Documentation

### `public void addVertex(T data)`

Adds a new vertex with the given `data` to the graph.

-   **Parameters:**
    -   `data`: The data for the new vertex.

### `public void addEdge(T sourceData, T destinationData, double weight)`

Adds a directed edge from the `sourceData` vertex to the `destinationData` vertex with the specified `weight`.

-   **Parameters:**
    -   `sourceData`: The data of the source vertex.
    -   `destinationData`: The data of the destination vertex.
    -   `weight`: The weight of the edge.
-   **Throws:**
    -   `IllegalArgumentException`: If either source or destination vertex does not exist.

### `public void removeVertex(T data)`

Removes the vertex with the given `data` and all its incident edges from the graph.

-   **Parameters:**
    -   `data`: The data of the vertex to remove.

### `public void removeEdge(T sourceData, T destinationData)`
Removes the directed edge from `sourceData` to `destinationData`.

-   **Parameters:**
    -   `sourceData`: The data of the source vertex.
    -   `destinationData`: The data of the destination vertex.

### `public List<Vertex<T>> getNeighbors(T data)`

Returns a list of neighbors for the vertex with the given `data`.

-   **Parameters:**
    -   `data`: The data of the vertex.
-   **Returns:**
    -   A `List<Vertex<T>>` of neighboring vertices.
    -   Returns an empty list if the vertex does not exist or has no neighbors.

### `public boolean containsVertex(T data)`

Checks if a vertex with the given `data` exists in the graph.

-   **Parameters:**
    -   `data`: The data of the vertex to check.
-   **Returns:**
    -   `true` if the vertex exists, `false` otherwise.

### `public boolean containsEdge(T sourceData, T destinationData)`

Checks if a directed edge exists from `sourceData` to `destinationData`.

-   **Parameters:**
    -   `sourceData`: The data of the source vertex.
    -   `destinationData`: The data of the destination vertex.
-   **Returns:**
    -   `true` if the edge exists, `false` otherwise.

### `public int getVertexCount()`

Returns the total number of vertices in the graph.

-   **Returns:**
    -   The number of vertices.

### `public int getEdgeCount()`

Returns the total number of edges in the graph.

-   **Returns:**
    -   The number of edges.
