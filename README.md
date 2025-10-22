# 🚀 MyDSALab: A Comprehensive Java Data Structures & Algorithms Library

Welcome to **MyDSALab**, your personal laboratory for exploring the fundamental building blocks of computer science! This project provides a rich collection of common data structures and algorithms, all implemented in Java. It's designed to be a learning resource, a reference, and a playground for experimentation.

---

## 💡 The Power of the Right Choice: A Real-World Example

Choosing the right data structure or algorithm can be the difference between an application that flies and one that crawls. The impact is not just theoretical—it's a real-world game-changer.

Imagine you're building a feature to find a specific user profile from a database of **1 million users**.

### Scenario A: The Naive Approach (Using an Unsorted Array)

If you store the user data in a simple unsorted array or list, finding a user requires a **linear search**. You'd have to check each user one by one until you find the one you're looking for.

-   **Best Case:** 1 comparison (the user is the first one).
-   **Worst Case:** 1,000,000 comparisons (the user is the last one, or not in the list at all).
-   **Average Case:** 500,000 comparisons.

This might be acceptable for a handful of users, but for a million, it's a recipe for a slow, frustrating user experience.

### Scenario B: The Smart Approach (Using a Hashtable)

Now, let's use a `Hashtable` (or a `HashMap` in Java). By using the user's unique ID as a key, we can compute a hash and get the user's data in what is effectively a single step.

-   **Best, Worst, and Average Case:** Approximately 1 operation (O(1)).

### The Verdict

| Approach | Time Complexity | Operations for 1 Million Users | Performance |
| :--- | :--- | :--- | :--- |
| Unsorted Array | O(n) | ~500,000 | 🐌 Slow |
| Hashtable | O(1) | ~1 | ⚡️ Blazingly Fast |

By choosing a `Hashtable`, you've made the operation **half a million times faster** on average. This is the power of computer science in action. This library is designed to give you the tools and the understanding to make these smart, impactful decisions in your own projects.

---

## 📚 Data Structures

Here you'll find the core data structures, each with its own detailed `README.md` explaining its implementation, usage, and performance characteristics.

| Data Structure | Description |
| :--- | :--- |
| 🔢 [Array](./docs/datastructures/Array.md) | A basic fixed-size collection of elements. |
| 🌳 [AVLTree](./docs/datastructures/AVLTree.md) | A self-balancing binary search tree. |
| 🅱️ [BTree](./docs/datastructures/BTree.md) | A self-balancing tree optimized for databases and filesystems. |
| ↔️ [Deque](./docs/datastructures/Deque.md) | A double-ended queue. |
| 🔗 [DoublyLinkedList](./docs/datastructures/DoublyLinkedList.md) | A linked list where each node has pointers to the next and previous nodes. |
| 🕸️ [Graph](./docs/datastructures/Graph.md) | A collection of vertices and edges. |
| #️⃣ [Hashtable](./docs/datastructures/Hashtable.md) | A data structure that implements an associative array abstract data type. |
| ⛓️ [LinkedList](./docs/datastructures/LinkedList.md) | A linear collection of data elements whose order is not given by their physical placement in memory. |
| 🔝 [PriorityQueue](./docs/datastructures/PriorityQueue.md) | A type of queue in which each element has a "priority" associated with it. |
| ➡️ [Queue](./docs/datastructures/Queue.md) | A collection of entities that are maintained in a sequence and can be modified by the addition of entities at one end of the sequence and the removal of entities from the other end. |
| 🌳 [RedBlackTree](./docs/datastructures/RedBlackTree.md) | A self-balancing binary search tree. |
| 🛡️ [Set](./docs/datastructures/Set.md) | A collection of distinct elements. |
| 📚 [Stack](./docs/datastructures/Stack.md) | A collection of elements with two principal operations: push, which adds an element to the collection, and pop, which removes the most recently added element. |
| 🌲 [Tree](./docs/datastructures/Tree.md) | A hierarchical data structure. |
| 🔤 [Trie](./docs/datastructures/Trie.md) | A tree-like data structure that stores a dynamic set of strings. |
| 🔤 [Trie2](./docs/datastructures/Trie2.md) | An alternative implementation of a Trie. |

---

## ⚙️ Algorithms

Explore a variety of algorithms, complete with explanations and implementation details.

### Searching Algorithms

| Algorithm | Description |
| :--- | :--- |
| 🔍 [Linear Search](./docs/algorithms/LinearSearch.md) | A simple search that sequentially checks each element of a list. |
| 🎯 [Iterative Binary Search](./docs/algorithms/IterativeBinarySearch.md) | An efficient search algorithm that finds the position of a target value within a sorted array. |
| 🎯 [Recursive Binary Search](./docs/algorithms/RecursiveBinarySearch.md) | A recursive implementation of the binary search algorithm. |

### Sorting Algorithms

| Algorithm | Description |
| :--- | :--- |
| 🧼 [Bubble Sort](./docs/algorithms/BubbleSort.md) | A simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. |
| 🔢 [Count Sort](./docs/algorithms/CountSort.md) | An integer sorting algorithm that operates by counting the number of objects that have each distinct key value. |
| 堆 [Heap Sort](./docs/algorithms/HeapSort.md) | A comparison-based sorting algorithm that uses a binary heap data structure. |
| 👉 [Insertion Sort](./docs/algorithms/InsertionSort.md) | A simple sorting algorithm that builds the final sorted array one item at a time. |
| 🔀 [Merge Sort](./docs/algorithms/MergeSort.md) | An efficient, comparison-based, divide-and-conquer sorting algorithm. |
| ⚡ [Quick Sort](./docs/algorithms/QuickSort.md) | An efficient, comparison-based, divide-and-conquer sorting algorithm. |
| ✅ [Selection Sort](./docs/algorithms/SelectionSort.md) | A simple sorting algorithm that divides the input list into two parts: a sorted sublist of items which is built up from left to right and a sublist of the remaining unsorted items. |
| 🐚 [Shell Sort](./docs/algorithms/ShellSort.md) | A generalization of insertion sort that allows the exchange of items that are far apart. |

### Graph Algorithms

| Algorithm | Description |
| :--- | :--- |
| ⭐ [A* Search](./docs/algorithms/AStar.md) | A pathfinding algorithm known for its performance and accuracy. |
| 🔔 [Bellman-Ford](./docs/algorithms/BellmanFord.md) | Finds the shortest paths from a single source vertex to all of the other vertices in a weighted digraph. |
| 🗺️ [Dijkstra's Shortest Path](./docs/algorithms/DijkstraShortestPath.md) | An algorithm for finding the shortest paths between nodes in a graph. |
| 🌐 [Floyd-Warshall](./docs/algorithms/FloydWarshall.md) | An algorithm for finding shortest paths in a weighted graph with positive or negative edge weights. |
| 🌐 [Iterative Breadth-First Search](./docs/algorithms/IterativeBreadthFirstSearch.md) | A graph traversal algorithm that explores the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level. |
| 🚶 [Iterative Depth-First Search](./docs/algorithms/IterativeDepthFirstSearch.md) | A graph traversal algorithm that explores as far as possible along each branch before backtracking. |
| 📜 [Kahn's Topological Sort](./docs/algorithms/KahnsTopologicalSort.md) | A topological sort algorithm. |
| 🌳 [Kruskal's MST](./docs/algorithms/KruskalMST.md) | A minimum spanning tree algorithm. |
| 🌲 [Prim's MST](./docs/algorithms/PrimMST.md) | A minimum spanning tree algorithm. |
| 🚶 [Recursive Depth-First Search](./docs/algorithms/RecursiveDepthFirstSearch.md) | A graph traversal algorithm that explores as far as possible along each branch before backtracking. |
| 📜 [Topological Sort](./docs/algorithms/TopologicalSort.md) | A linear ordering of the vertices of a directed acyclic graph. |

---

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

1.  **Clone the repo**
    ```sh
    git clone https://github.com/your_username/MyDSALab.git
    ```
2.  **Open the project** in your favorite Java IDE (like IntelliJ IDEA, Eclipse, or VS Code).
3.  **Explore the code!** Each data structure and algorithm is in its own file, with accompanying tests.

---

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

---

## 📄 License

Distributed under the MIT License. See [LICENSE](LICENSE) for more information.
