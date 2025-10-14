# Graph Data Structure

## Introduction

A graph is a non-linear data structure consisting of a set of vertices (or nodes) and a set of edges that connect these vertices. Graphs are used to model relationships between objects and are one of the most versatile and widely used data structures in computer science. This implementation can represent both **directed** (where edges have a direction) and **undirected** (where edges are bidirectional) graphs.

---

## History

The study of graphs, known as graph theory, is traced back to **Leonhard Euler** in 1736, who solved the famous "Seven Bridges of Königsberg" problem. This is considered one of the first problems in graph theory and laid the foundation for the entire field. The formalization of graph theory as a distinct area of mathematics came much later.

---

## Properties

A graph is defined by several key properties:

-   **Vertices (V)**: These are the fundamental units of the graph. They represent the objects or points of interest.
-   **Edges (E)**: These are the connections between vertices. An edge connects two vertices, indicating a relationship between them.
-   **Weight**: Edges can have a weight, which is a numerical value representing the cost, distance, or intensity of the connection.
-   **Directionality**: A graph can be directed, meaning edges have a specific direction (e.g., a one-way street), or undirected, where edges are bidirectional.

---

## How the Data Structure is Implemented

This graph is implemented using an **adjacency list**.

-   **Core Structure**: The primary data structure is a `Map<Vertex<T>, List<Edge<T>>>`. The keys of the map are the vertices in the graph. The value associated with each vertex is a `List` of all the edges that originate from that vertex.
-   **Vertex and Edge Classes**: The implementation includes nested `Vertex<T>` and `Edge<T>` classes to represent the nodes and their connections. The `Edge` class stores the `from` and `to` vertices, as well as the `weight` of the connection.
-   **Directionality**: A boolean flag, `isDirected`, is set in the constructor. When an edge is added, this flag determines whether a corresponding reverse edge should also be added to the adjacency list.

This approach is memory-efficient for sparse graphs (graphs with relatively few edges) and provides fast access to the neighbors of any given vertex.

---

## Complexity of operations

The time complexity of graph operations depends on the number of vertices (V) and edges (E).

| Operation                 | Average Case                               | Worst Case                                 |
| ------------------------- | ------------------------------------------ | ------------------------------------------ |
| **Add Vertex**            | O(1)                                       | O(1)                                       |
| **Add Edge**              | O(1)                                       | O(1)                                       |
| **Remove Vertex**         | O(V + E)                                   | O(V + E)                                   |
| **Remove Edge**           | O(E)                                       | O(E)                                       |
| **Query (is connected?)** | O(degree(V))                               | O(V)                                       |
| **Space**                 | O(V + E)                                   | O(V + E)                                   |

---

## Known Applications

Graphs are used to model a vast array of real-world problems:

-   **Social Networks**: Representing users as vertices and friendships or connections as edges.
-   **Mapping and Navigation**: Modeling locations as vertices and roads or routes as edges to find shortest paths.
-   **The World Wide Web**: Representing web pages as vertices and hyperlinks as edges.
-   **Computer Networks**: Modeling devices as vertices and network connections as edges.
-   **Recommendation Engines**: Modeling items and users to suggest related content.

---

## Comparisons

| Data Structure    | Graph                                      | Tree                                         |
| ----------------- | ------------------------------------------ | -------------------------------------------- |
| **Structure**     | Can have cycles, can be disconnected.      | Acyclic, must be connected, has a root.      |
| **Connections**   | No restrictions on connections between nodes. | Each node has one parent (except the root).  |
| **Use Case**      | Modeling complex networks and relationships. | Representing hierarchical data.              |

---

## API documentation

### `public Graph(boolean isDirected)`
Constructs a new graph.
-   **Parameters:**
    -   `isDirected`: `true` to create a directed graph, `false` for an undirected graph.

### `public void addVertex(Vertex<T> vertex)`
Adds a vertex to the graph.

### `public Graph<T> addEdge(Vertex<T> from, Vertex<T> to, int weight)`
Adds a weighted edge between two vertices. If the graph is undirected, a reverse edge is also added.

### `public Set<Vertex<T>> getVertices()`
Returns a set of all vertices in the graph.

### `public List<Edge<T>> getEdges(Vertex<T> vertex)`
Returns a list of all edges originating from the given vertex.

### `public Collection<Edge<T>> getEdges()`
Returns a collection of all edges in the entire graph.

### `public List<Vertex<T>> getAdjacentVertices(Vertex<T> vertex)`
Returns a list of all vertices directly connected to the given vertex.

### `public boolean isConnected(Vertex<T> from, Vertex<T> to)`
Checks if a direct edge exists from one vertex to another.
