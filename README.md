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
| 🔢 [Array](./src/main/java/com/sudhi/dsa/datastructures/Array/README.md) | A basic fixed-size collection of elements. |
| 🌳 [AVLTree](./src/main/java/com/sudhi/dsa/datastructures/AVLTree/README.md) | A self-balancing binary search tree. |
| 🅱️ [BTree](./src/main/java/com/sudhi/dsa/datastructures/BTree/README.md) | A self-balancing tree optimized for databases and filesystems. |
| ↔️ [Deque](./src/main/java/com/sudhi/dsa/datastructures/Deque/README.md) | A double-ended queue. |
| 🔗 [DoublyLinkedList](./src/main/java/com/sudhi/dsa/datastructures/DoublyLinkedList/README.md) | A linked list where each node has pointers to the next and previous nodes. |
| 🕸️ [Graph](./src/main/java/com/sudhi/dsa/datastructures/Graph/README.md) | A collection of vertices and edges. |
| #️⃣ [Hashtable](./src/main/java/com/sudhi/dsa/datastructures/Hashtable/README.md) | A data structure that implements an associative array abstract data type. |
| ⛓️ [LinkedList](./src/main/java/com/sudhi/dsa/datastructures/LinkedList/README.md) | A linear collection of data elements whose order is not given by their physical placement in memory. |
| 🔝 [PriorityQueue](./src/main/java/com/sudhi/dsa/datastructures/PriorityQueue/README.md) | A type of queue in which each element has a "priority" associated with it. |
| ➡️ [Queue](./src/main/java/com/sudhi/dsa/datastructures/Queue/README.md) | A collection of entities that are maintained in a sequence and can be modified by the addition of entities at one end of the sequence and the removal of entities from the other end. |
| 🌳 [RedBlackTree](./src/main/java/com/sudhi/dsa/datastructures/RedBlackTree/README.md) | A self-balancing binary search tree. |
| 🛡️ [Set](./src/main/java/com/sudhi/dsa/datastructures/Set/README.md) | A collection of distinct elements. |
| 📚 [Stack](./src/main/java/com/sudhi/dsa/datastructures/Stack/README.md) | A collection of elements with two principal operations: push, which adds an element to the collection, and pop, which removes the most recently added element. |
| 🌲 [Tree](./src/main/java/com/sudhi/dsa/datastructures/Tree/README.md) | A hierarchical data structure. |
| 🔤 [Trie](./src/main/java/com/sudhi/dsa/datastructures/Trie/README.md) | A tree-like data structure that stores a dynamic set of strings. |
| 🔤 [Trie2](./src/main/java/com/sudhi/dsa/datastructures/Trie2/README.md) | An alternative implementation of a Trie. |

---

## ⚙️ Algorithms

Explore a variety of algorithms, complete with explanations and implementation details.

### Searching Algorithms

| Algorithm | Description |
| :--- | :--- |
| 🔍 [Linear Search](./src/main/java/com/sudhi/dsa/algorithms/searching/LinearSearch/README.md) | A simple search that sequentially checks each element of a list. |
| 🎯 [Iterative Binary Search](./src/main/java/com/sudhi/dsa/algorithms/searching/IterativeBinarySearch/README.md) | An efficient search algorithm that finds the position of a target value within a sorted array. |
| 🎯 [Recursive Binary Search](./src/main/java/com/sudhi/dsa/algorithms/searching/RecursiveBinarySearch/README.md) | A recursive implementation of the binary search algorithm. |

### Sorting Algorithms

| Algorithm | Description |
| :--- | :--- |
| 🧼 [Bubble Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/BubbleSort/README.md) | A simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. |
| 🔢 [Count Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/CountSort/README.md) | An integer sorting algorithm that operates by counting the number of objects that have each distinct key value. |
| 堆 [Heap Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/HeapSort/README.md) | A comparison-based sorting algorithm that uses a binary heap data structure. |
| 👉 [Insertion Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/InsertionSort/README.md) | A simple sorting algorithm that builds the final sorted array one item at a time. |
| 🔀 [Merge Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/MergeSort/README.md) | An efficient, comparison-based, divide-and-conquer sorting algorithm. |
| ⚡ [Quick Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/QuickSort/README.md) | An efficient, comparison-based, divide-and-conquer sorting algorithm. |
| ✅ [Selection Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/SelectionSort/README.md) | A simple sorting algorithm that divides the input list into two parts: a sorted sublist of items which is built up from left to right and a sublist of the remaining unsorted items. |
| 🐚 [Shell Sort](./src/main/java/com/sudhi/dsa/algorithms/sorting/ShellSort/README.md) | A generalization of insertion sort that allows the exchange of items that are far apart. |

### Graph Algorithms

| Algorithm | Description |
| :--- | :--- |
| ⭐ [A* Search](./src/main/java/com/sudhi/dsa/algorithms/graph/AStar/README.md) | A pathfinding algorithm known for its performance and accuracy. |
| 🔔 [Bellman-Ford](./src/main/java/com/sudhi/dsa/algorithms/graph/BellmanFord/README.md) | Finds the shortest paths from a single source vertex to all of the other vertices in a weighted digraph. |
| 🗺️ [Dijkstra's Shortest Path](./src/main/java/com/sudhi/dsa/algorithms/graph/DijkstraShortestPath/README.md) | An algorithm for finding the shortest paths between nodes in a graph. |
| 🌐 [Floyd-Warshall](./src/main/java/com/sudhi/dsa/algorithms/graph/FloydWarshall/README.md) | An algorithm for finding shortest paths in a weighted graph with positive or negative edge weights. |
| 🌐 [Iterative Breadth-First Search](./src/main/java/com/sudhi/dsa/algorithms/graph/IterativeBreadthFirstSearch/README.md) | A graph traversal algorithm that explores the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level. |
| 🚶 [Iterative Depth-First Search](./src/main/java/com/sudhi/dsa/algorithms/graph/IterativeDepthFirstSearch/README.md) | A graph traversal algorithm that explores as far as possible along each branch before backtracking. |
| 📜 [Kahn's Topological Sort](./src/main/java/com/sudhi/dsa/algorithms/graph/KahnsTopologicalSort/README.md) | A topological sort algorithm. |
| 🌳 [Kruskal's MST](./src/main/java/com/sudhi/dsa/algorithms/graph/KruskalMST/README.md) | A minimum spanning tree algorithm. |
| 🌲 [Prim's MST](./src/main/java/com/sudhi/dsa/algorithms/graph/PrimMST/README.md) | A minimum spanning tree algorithm. |
| 🚶 [Recursive Depth-First Search](./src/main/java/com/sudhi/dsa/algorithms/graph/RecursiveDepthFirstSearch/README.md) | A graph traversal algorithm that explores as far as possible along each branch before backtracking. |
| 📜 [Topological Sort](./src/main/java/com/sudhi/dsa/algorithms/graph/TopologicalSort/README.md) | A linear ordering of the vertices of a directed acyclic graph. |

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
