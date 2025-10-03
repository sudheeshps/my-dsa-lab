# A* Algorithm

The A* (A-star) algorithm is a popular and efficient pathfinding algorithm used to find the shortest path between two points, or nodes, in a graph. It is an extension of Dijkstra's algorithm and achieves better performance by using a heuristic to guide its search.

## Usage

To use the A* algorithm, you need a `Graph` object, a starting vertex, and an ending vertex. The algorithm will return a list of vertices representing the shortest path.

```java
import main.java.com.sudhi.dsa.datastructures.Graph.Graph;

import java.awt.Point;
import java.util.List;

// Create a graph of Point objects
Graph<Point> graph = new Graph<>(false); // Undirected graph

        // Create vertex objects
        Graph.Vertex<Point> startNode = new Graph.Vertex<>(new Point(0, 0));
        Graph.Vertex<Point> endNode = new Graph.Vertex<>(new Point(3, 3));
        Graph.Vertex<Point> node1 = new Graph.Vertex<>(new Point(1, 1));
        Graph.Vertex<Point> node2 = new Graph.Vertex<>(new Point(2, 2));

// Add vertices to the graph
graph.

        addVertex(startNode);
graph.

        addVertex(endNode);
graph.

        addVertex(node1);
graph.

        addVertex(node2);

// Add edges with weights
graph.

        addEdge(startNode, node1, 1.0);
graph.

        addEdge(node1, node2, 1.0);
graph.

        addEdge(node2, endNode, 1.0);

        // Find the shortest path
        List<Graph.Vertex<Point>> path = AStar.findPath(graph, startNode, endNode);

if(path !=null){
        System.out.

        println("Shortest path found:");
    for(
        Graph.Vertex<Point> vertex :path){
        System.out.

        println(vertex.getVal());
        }
        }else{
        System.out.

        println("No path found.");
}
```

## Methods

### `findPath(Graph<T> graph, Graph.Vertex<T> start, Graph.Vertex<T> end)`

Finds the shortest path between a `start` and `end` vertex in a `graph` using the A* algorithm.

-   **Parameters:**
    -   `graph`: The graph on which to perform the search.
    -   `start`: The starting vertex for the path.
    -   `end`: The destination vertex for the path.
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the sequence of vertices in the shortest path from `start` to `end`. If no path is found, it returns `null`.

### Heuristic

The A* algorithm uses a heuristic function to estimate the cost of the cheapest path from a given vertex to the destination. In this implementation, the heuristic uses the Euclidean distance if the vertices are `java.awt.Point` objects. Otherwise, it returns a default value.
