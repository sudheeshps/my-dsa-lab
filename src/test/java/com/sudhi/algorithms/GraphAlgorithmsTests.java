package test.java.com.sudhi.algorithms;

import main.java.com.sudhi.dsa.algorithms.graph.*;
import main.java.com.sudhi.dsa.datastructures.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphAlgorithmsTests {
    @Test
    public void topologicalSortTest() {
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
        graph.addEdge(new Graph.Edge<>(new Graph.Vertex<>('A'),
                new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('D')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('C'),
                new Graph.Vertex<>('E')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('E'),
                new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('D'),
                new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('F'),
                new Graph.Vertex<>('G')));
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
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void kahnsTopologicalSortTest() {
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
        graph.addEdge(new Graph.Edge<>(new Graph.Vertex<>('A'),
                        new Graph.Vertex<>('C')))
                .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                        new Graph.Vertex<>('C')))
                .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                        new Graph.Vertex<>('D')))
                .addEdge(new Graph.Edge<>(new Graph.Vertex<>('C'),
                        new Graph.Vertex<>('E')))
                .addEdge(new Graph.Edge<>(new Graph.Vertex<>('E'),
                        new Graph.Vertex<>('F')))
                .addEdge(new Graph.Edge<>(new Graph.Vertex<>('D'),
                        new Graph.Vertex<>('F')))
                .addEdge(new Graph.Edge<>(new Graph.Vertex<>('F'),
                        new Graph.Vertex<>('G')));
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
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void bfsTest() {
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
        graph.addEdge(new Graph.Edge<>(src, new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                new Graph.Vertex<>('D')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('C'),
                new Graph.Vertex<>('E')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('E'),
                new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('D'),
                new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('F'),
                new Graph.Vertex<>('G')));
        System.out.println(graph.toString());
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
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void dfsTest() {
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
        graph.addEdge(new Graph.Edge<>(src, new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('D')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('C'),
                 new Graph.Vertex<>('E')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('E'),
                 new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('D'),
                 new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('F'),
                 new Graph.Vertex<>('G')));
        System.out.println(graph.toString());
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
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }
    @Test
    public void iterativeDfsTest() {
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
        graph.addEdge(new Graph.Edge<>(src, new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('C')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('B'),
                 new Graph.Vertex<>('D')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('C'),
                 new Graph.Vertex<>('E')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('E'),
                 new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('D'),
                 new Graph.Vertex<>('F')))
        .addEdge(new Graph.Edge<>(new Graph.Vertex<>('F'),
                 new Graph.Vertex<>('G')));
        System.out.println(graph.toString());
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
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }
}
