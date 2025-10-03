# Recursive Depth-First Search (DFS)

Depth-First Search (DFS) is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking. This implementation uses a recursive approach.

## Usage

To use the recursive DFS algorithm, you need a `Graph` object and a starting vertex. The algorithm will return a list of vertices in the order they were visited.

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

// Add edges
graph.

        addEdge(vertexA, vertexB, 1);
graph.

        addEdge(vertexA, vertexC, 1);
graph.

        addEdge(vertexB, vertexD, 1);

        // Perform recursive DFS
        RecursiveDepthFirstSearch<String> dfs = new RecursiveDepthFirstSearch<>(graph);
        List<Graph.Vertex<String>> traversal = dfs.dfs(vertexA);

// Print the traversal
System.out.

        println("Recursive DFS traversal:");
for(
        Graph.Vertex<String> vertex :traversal){
        System.out.

        print(vertex.getVal() +" ");
        }
```

## Methods

### `dfs(Graph.Vertex<T> src)`

Performs a recursive Depth-First Search (DFS) on the graph starting from a given source vertex.

-   **Parameters:**
    -   `src`: The starting vertex for the traversal.
-   **Returns:**
    -   A `List<Graph.Vertex<T>>` containing the vertices in the order they were visited during the DFS traversal.
