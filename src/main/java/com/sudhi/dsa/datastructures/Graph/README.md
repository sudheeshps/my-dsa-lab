# Graph Data Structure

This is a generic graph implementation that can represent both directed and undirected graphs. It uses an adjacency list to store the graph's structure. The graph can hold vertices of any type, and edges can have weights.

## Usage

To use the `Graph` class, you first need to create an instance of it, specifying whether the graph is directed or not:

```java
// For a directed graph
Graph<Integer> directedGraph = new Graph<>(true);

// For an undirected graph
Graph<String> undirectedGraph = new Graph<>(false);
```

Vertices are represented by the `Graph.Vertex` class, and edges by the `Graph.Edge` class. You need to create `Vertex` objects before adding them to the graph:

```java
Graph.Vertex<Integer> v1 = new Graph.Vertex<>(1);
Graph.Vertex<Integer> v2 = new Graph.Vertex<>(2);

directedGraph.addVertex(v1);
directedGraph.addVertex(v2);
directedGraph.addEdge(v1, v2, 10); // Add a weighted edge from v1 to v2
```

## Method Descriptions

*   `addVertex(Vertex<T> vertex)`: Adds a vertex to the graph.

*   `addEdge(Vertex<T> from, Vertex<T> to, int weight)`: Adds an edge between two vertices with a specified weight. If the graph is undirected, a corresponding edge in the opposite direction is also added.

*   `addEdge(Vertex<T> from, Vertex<T> to)`: Adds an edge with a default weight of 1.

*   `getVertices()`: Returns a set of all vertices in the graph.

*   `getEdges(Vertex<T> vertex)`: Returns a list of all edges originating from the given vertex.

*   `getEdges()`: Returns a collection of all edges in the graph.

*   `getAdjacentVertices(Vertex<T> vertex)`: Returns a list of all vertices adjacent to the given vertex.

*   `isConnected(Vertex<T> from, Vertex<T> to)`: Returns `true` if there is a direct edge from the `from` vertex to the `to` vertex, `false` otherwise.

*   `isDirected()`: Returns `true` if the graph is directed, `false` otherwise.
