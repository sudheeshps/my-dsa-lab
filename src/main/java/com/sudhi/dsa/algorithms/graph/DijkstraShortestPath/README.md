# Dijkstra's Shortest Path Algorithm

Dijkstra's algorithm is an algorithm for finding the shortest paths between nodes in a graph, which may represent, for example, road networks. It was conceived by computer scientist Edsger W. Dijkstra in 1956 and published three years later. The algorithm is for graphs with non-negative edge weights.

## Usage

To use Dijkstra's algorithm, you need a `Graph` object, a source vertex, and a destination vertex. The algorithm will return a list of vertices representing the shortest path.

```java
import main.java.com.sudhi.dsa.datastructures.Graph.Graph;

import java.util.List;

// Create a graph
Graph<String> graph = new Graph<>(true); // Directed graph

        // Create vertex objects
        Graph.Vertex<String> vertexA = new Graph.Vertex<>("A");
        Graph.Vertex<String> vertexB = new Graph.Vertex<>("B");
        Graph.Vertex<String> vertexC = new Graph.Vertex<>("C");
        Graph.Vertex<String> vertexD = new Graph.Vertex<>("D");

// Add vertices to the graph
graph.

        addVertex(vertexA);
graph.

        addVertex(vertexB);
graph.

        addVertex(vertexC);
graph.

        addVertex(vertexD);

// Add edges with weights
graph.

        addEdge(vertexA, vertexB, 1);
graph.

        addEdge(vertexA, vertexC, 4);
graph.

        addEdge(vertexB, vertexC, 2);
graph.

        addEdge(vertexB, vertexD, 5);
graph.

        addEdge(vertexC, vertexD, 1);

        // Find the shortest path
        DijkstraShortestPath<String> dijkstra = new DijkstraShortestPath<>(graph);
        List<Graph.Vertex<String>> path = dijkstra.getShortestPath(vertexA, vertexD);

// Print the path
if(!path.

        isEmpty()){
        System.out.

        println("Shortest path from A to D:");
    for(
        Graph.Vertex<String> vertex :path){
        System.out.

        print(vertex.getVal() +" ");
        }
        }else{
        System.out.

        println("No path found from A to D.");
}
```

## Methods

### `getShortestPath(Graph.Vertex<T> src, Graph.Vertex<T> dest)`

Finds the shortest path between a `src` and `dest` vertex in the graph using Dijkstra's algorithm.

-   **Parameters:**
    -   `src`: The starting vertex.
    -   `dest`: The destination vertex.
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` representing the shortest path from `src` to `dest`. If no path exists, it returns an empty list.
