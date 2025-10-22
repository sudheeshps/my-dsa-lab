package com.sudhi.dsa.algorithms.graph;

import com.sudhi.dsa.algorithms.graph.IterativeBreadthFirstSearch;
import com.sudhi.dsa.algorithms.graph.IterativeDepthFirstSearch;
import com.sudhi.dsa.algorithms.graph.KahnsTopologicalSort;
import com.sudhi.dsa.algorithms.graph.RecursiveDepthFirstSearch;
import com.sudhi.dsa.algorithms.graph.TopologicalSort;
import com.sudhi.dsa.datastructures.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphAlgorithmsTests {
    @Test
    public void givenGraph_whenTopologicalSort_thenCorrectOrder() {
//         A  B
//          \ /\
//           C  \
//        /      D
//        E     /
//        \    /
//         \  /
//           F
//           |
//           G
        var graph = new Graph<Character>(true);
        graph.addEdge(new Graph.Vertex<>('A'),
                new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('D'))
        .addEdge(new Graph.Vertex<>('C'),
                new Graph.Vertex<>('E'))
        .addEdge(new Graph.Vertex<>('E'),
                new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('D'),
                new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('F'),
                new Graph.Vertex<>('G'));
        var topologicalSort = new TopologicalSort<>(graph);
        var result = topologicalSort.sort();
        System.out.println(Arrays.toString(result.toArray()));
        List<Graph.Vertex<Character>> expected = new ArrayList<>();
        expected.add(new Graph.Vertex<>('B'));
        expected.add(new Graph.Vertex<>('D'));
        expected.add(new Graph.Vertex<>('A'));
        expected.add(new Graph.Vertex<>('C'));
        expected.add(new Graph.Vertex<>('E'));
        expected.add(new Graph.Vertex<>('F'));
        expected.add(new Graph.Vertex<>('G'));
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void givenGraph_whenKahnsTopologicalSort_thenCorrectOrder() {
//         A  B
//          \ /\
//           C  \
//        /      D
//        E     /
//        \    /
//         \  /
//           F
//           |
//           G
        var graph = new Graph<Character>(true);
        graph.addEdge(new Graph.Vertex<>('A'),
                        new Graph.Vertex<>('C'))
                .addEdge(new Graph.Vertex<>('B'),
                        new Graph.Vertex<>('C'))
                .addEdge(new Graph.Vertex<>('B'),
                        new Graph.Vertex<>('D'))
                .addEdge(new Graph.Vertex<>('C'),
                        new Graph.Vertex<>('E'))
                .addEdge(new Graph.Vertex<>('E'),
                        new Graph.Vertex<>('F'))
                .addEdge(new Graph.Vertex<>('D'),
                        new Graph.Vertex<>('F'))
                .addEdge(new Graph.Vertex<>('F'),
                        new Graph.Vertex<>('G'));
        var topologicalSort = new KahnsTopologicalSort<>(graph);
        var result = topologicalSort.sort();
        System.out.println(Arrays.toString(result.toArray()));
        List<Graph.Vertex<Character>> expected = new ArrayList<>();
        expected.add(new Graph.Vertex<>('A'));
        expected.add(new Graph.Vertex<>('B'));
        expected.add(new Graph.Vertex<>('C'));
        expected.add(new Graph.Vertex<>('D'));
        expected.add(new Graph.Vertex<>('E'));
        expected.add(new Graph.Vertex<>('F'));
        expected.add(new Graph.Vertex<>('G'));
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void givenGraph_whenBfs_thenCorrectOrder() {
//         A  B
//          \ /\
//           C  \
//        /      D
//        E     /
//        \    /
//         \  /
//           F
//           |
//           G
        var graph = new Graph<Character>(false);
        var src = new Graph.Vertex<>('A');
        graph.addEdge(src, new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('D'))
        .addEdge(new Graph.Vertex<>('C'),
                new Graph.Vertex<>('E'))
        .addEdge(new Graph.Vertex<>('E'),
                new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('D'),
                new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('F'),
                new Graph.Vertex<>('G'));
        System.out.println(graph);
        var breadthFirstSearch = new IterativeBreadthFirstSearch<>(graph);
        var result = breadthFirstSearch.bfs(src);
        System.out.println(Arrays.toString(result.toArray()));
        List<Graph.Vertex<Character>> expected = new ArrayList<>();
        expected.add(new Graph.Vertex<>('A'));
        expected.add(new Graph.Vertex<>('C'));
        expected.add(new Graph.Vertex<>('B'));
        expected.add(new Graph.Vertex<>('E'));
        expected.add(new Graph.Vertex<>('D'));
        expected.add(new Graph.Vertex<>('F'));
        expected.add(new Graph.Vertex<>('G'));
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void givenGraph_whenDfs_thenCorrectOrder() {
//         A  B
//          \ /\
//           C  \
//        /      D
//        E     /
//        \    /
//         \  /
//           F
//           |
//           G
        var graph = new Graph<Character>(false);
        var src = new Graph.Vertex<>('A');
        graph.addEdge(src, new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('D'))
        .addEdge(new Graph.Vertex<>('C'),
                 new Graph.Vertex<>('E'))
        .addEdge(new Graph.Vertex<>('E'),
                 new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('D'),
                 new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('F'),
                 new Graph.Vertex<>('G'));
        System.out.println(graph);
        var depthFirstSearch = new RecursiveDepthFirstSearch<>(graph);
        var result = depthFirstSearch.dfs(src);
        System.out.println(Arrays.toString(result.toArray()));
        List<Graph.Vertex<Character>> expected = new ArrayList<>();
        expected.add(new Graph.Vertex<>('A'));
        expected.add(new Graph.Vertex<>('C'));
        expected.add(new Graph.Vertex<>('B'));
        expected.add(new Graph.Vertex<>('D'));
        expected.add(new Graph.Vertex<>('F'));
        expected.add(new Graph.Vertex<>('E'));
        expected.add(new Graph.Vertex<>('G'));
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void givenGraph_whenIterativeDfs_thenCorrectOrder() {
//         A  B
//          \ /\
//           C  \
//        /      D
//        E     /
//        \    /
//         \  /
//           F
//           |
//           G
        var graph = new Graph<Character>(false);
        var src = new Graph.Vertex<>('A');
        graph.addEdge(src, new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('C'))
        .addEdge(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('D'))
        .addEdge(new Graph.Vertex<>('C'),
                 new Graph.Vertex<>('E'))
        .addEdge(new Graph.Vertex<>('E'),
                 new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('D'),
                 new Graph.Vertex<>('F'))
        .addEdge(new Graph.Vertex<>('F'),
                 new Graph.Vertex<>('G'));
        System.out.println(graph);
        var depthFirstSearch = new IterativeDepthFirstSearch<>(graph);
        var result = depthFirstSearch.dfs(src);
        System.out.println(Arrays.toString(result.toArray()));
        List<Graph.Vertex<Character>> expected = new ArrayList<>();
        expected.add(new Graph.Vertex<>('A'));
        expected.add(new Graph.Vertex<>('C'));
        expected.add(new Graph.Vertex<>('E'));
        expected.add(new Graph.Vertex<>('F'));
        expected.add(new Graph.Vertex<>('G'));
        expected.add(new Graph.Vertex<>('D'));
        expected.add(new Graph.Vertex<>('B'));
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }
}
