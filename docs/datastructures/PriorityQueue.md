# Priority Queue

## Introduction

A priority queue is an abstract data type similar to a regular queue or stack, but where each element has a "priority" associated with it. In a priority queue, an element with higher priority is served before an element with lower priority. If two elements have the same priority, they are served according to their order in the queue (e.g., FIFO).

---

## History

The concept of priority queues has been around since the early days of computing, often implemented using heaps. The formal study and optimization of priority queue implementations became crucial with the development of algorithms like Dijkstra's and Prim's, which heavily rely on efficient priority queue operations.

---

## Behaviour of a Priority Queue

-   **Prioritized Retrieval**: The element with the highest (or lowest, depending on implementation) priority is always the first to be removed.
-   **Insertion**: Elements can be inserted in any order.
-   **No Random Access**: Elements are not accessed by index or position, only by priority.

---

## Data Structure Operations

-   **`insert(element, priority)`**: `O(log n)` (using a binary heap) - Adds an element with its priority.
-   **`extractMax()` / `extractMin()`**: `O(log n)` (using a binary heap) - Removes and returns the element with the highest/lowest priority.
-   **`peekMax()` / `peekMin()`**: `O(1)` (using a binary heap) - Returns the element with the highest/lowest priority without removing it.

---

## Comparison

-   **vs. Queue**: A regular queue follows FIFO. A priority queue prioritizes elements.
-   **vs. Stack**: A stack follows LIFO. A priority queue prioritizes elements.
-   **Implementation**: Priority queues are most commonly implemented using a binary heap, which provides efficient `O(log n)` operations. They can also be implemented using unsorted arrays (`O(n)` for extraction), sorted arrays (`O(n)` for insertion), or balanced binary search trees (`O(log n)` for all operations).

---

## How the Data Structure is Implemented

This `PriorityQueue` implementation uses a **Min-Heap** (a type of binary heap) internally. A min-heap is a complete binary tree where the value of each node is less than or equal to the value of its children. This structure ensures that the element with the smallest priority (highest priority in a min-heap context) is always at the root, allowing `O(1)` peek operations and `O(log n)` insertion and extraction operations.

-   **`heapifyUp()` and `heapifyDown()`**: Private helper methods that maintain the heap property after insertion and extraction, respectively.
-   **`elements`**: An `ArrayList` is used to store the heap elements, leveraging array-based representation of a binary tree.

---

## Known Applications

-   **Scheduling**: Task scheduling in operating systems (e.g., process scheduling).
-   **Graph Algorithms**: Dijkstra's algorithm (shortest path), Prim's algorithm (MST).
-   **Event Simulation**: Managing events in a simulation based on their occurrence time.
-   **Data Compression**: Huffman coding uses priority queues.
-   **Artificial Intelligence**: Best-first search algorithms.

---

## API Documentation

### `public void insert(T element)`

Inserts an element into the priority queue.

-   **Parameters:**
    -   `element`: The element to be inserted.

### `public T extractMin()`

Removes and returns the element with the highest priority (minimum value).

-   **Returns:**
    -   The element with the highest priority.
-   **Throws:**
    -   `NoSuchElementException`: If the priority queue is empty.

### `public T peekMin()`

Returns the element with the highest priority (minimum value) without removing it.

-   **Returns:**
    -   The element with the highest priority.
-   **Throws:**
    -   `NoSuchElementException`: If the priority queue is empty.

### `public boolean isEmpty()`

Checks if the priority queue is empty.

-   **Returns:**
    -   `true` if the priority queue is empty, `false` otherwise.

### `public int size()`

Returns the number of elements in the priority queue.

-   **Returns:**
    -   The number of elements.
