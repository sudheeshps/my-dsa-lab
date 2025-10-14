# Priority Queue Data Structure

## Introduction

A Priority Queue is an abstract data type similar to a regular queue or stack, but where each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. If two elements have the same priority, they are served according to their order in the queue.

This implementation can function as either a min-priority queue (where the smallest element has the highest priority) or a max-priority queue, depending on the `Comparator` provided.

---

## History

The concept of a priority queue was first introduced in the context of the **heap** data structure, which was invented by **J. W. J. Williams** in 1964 as a way to make heapsort more efficient. The priority queue, as an abstract data type, became a fundamental component in many algorithms, particularly in graph theory and simulation.

---

## Properties

- **Ordering**: Elements are ordered based on their natural ordering or by a custom `Comparator` provided at construction time.
- **Efficiency**: The `add` and `poll` operations (inserting and removing the highest-priority element) are efficient, typically running in O(log n) time.
- **Highest-Priority Access**: The highest-priority element can be inspected at any time in O(1) time using the `peek` operation.

---

## How the Data Structure is Implemented

This Priority Queue is implemented using a **binary heap**, which is a complete binary tree that satisfies the heap property. The heap is stored in a dynamic array (`ArrayList`).

- **Heap Property**: For a min-heap, the value of each node is less than or equal to the value of its children. For a max-heap, it's the reverse.
- **`add(T elem)`**: The new element is added to the end of the `ArrayList`. To restore the heap property, the element "swims" up the tree (`swim` method) until it is in its correct position.
- **`poll()`**: The highest-priority element (at the root of the heap) is removed. The last element in the list is moved to the root. To restore the heap property, this element "sinks" down the tree (`sink` method) until it is in its correct position.
- **Constructors**: The class provides multiple constructors, including one that can heapify a collection of elements in O(n) time, which is more efficient than adding elements one by one.

---

## Complexity of operations

| Operation      | Average Case | Worst Case |
| -------------- | ------------ | ---------- |
| **Add (add)**  | O(log n)     | O(log n)   |
| **Poll (poll)**| O(log n)     | O(log n)   |
| **Peek (peek)**| O(1)         | O(1)       |
| **Remove**     | O(n)         | O(n)       |
| **Contains**   | O(n)         | O(n)       |
| **Space**      | O(n)         | O(n)       |

*The O(n) complexity for `remove` and `contains` is due to the need for a linear scan to find the element.*

---

## Known Applications

- **Pathfinding Algorithms**: Used in Dijkstra's and A* algorithms to keep track of the next most promising nodes to visit.
- **Event-Driven Simulation**: To manage events to be processed in chronological order.
- **Data Compression**: Used in Huffman coding to build the optimal prefix code tree.
- **Operating Systems**: For scheduling processes based on priority.

---

## Comparisons

| Data Structure  | Priority Queue (Heap)              | Balanced BST (e.g., AVL Tree)      |
| --------------- | ---------------------------------- | ---------------------------------- |
| **Purpose**     | Get the highest-priority item quickly. | Fast search, insertion, and deletion. |
| **Get Min/Max** | O(1)                               | O(log n)                           |
| **Search**      | O(n)                               | O(log n)                           |
| **Structure**   | Partially ordered (heap property). | Fully ordered.                     |

---

## API Documentation

### `public PriorityQueue()`
Constructs an empty min-priority queue.

### `public PriorityQueue(int sz, Comparator<T> comparator)`
Constructs a priority queue with a specified initial capacity and comparator.

### `public PriorityQueue(T[] elems, Comparator<T> comparator)`
Constructs a priority queue from an array of elements in O(n) time.

### `public PriorityQueue(Collection<T> elems, Comparator<T> comparator)`
Constructs a priority queue from a collection of elements in O(n) time.

### `public void add(T elem)`
Adds an element to the priority queue. Runs in O(log n) time.

### `public T poll()`
Removes and returns the element with the highest priority. Returns `null` if the queue is empty. Runs in O(log n) time.

### `public T peek()`
Returns the element with the highest priority without removing it. Returns `null` if the queue is empty. Runs in O(1) time.

### `public int size()`
Returns the number of elements in the queue.

### `public boolean isEmpty()`
Returns `true` if the queue contains no elements.

### `public boolean remove(T element)`
Removes a specific element from the queue. Runs in O(n) time due to the linear search required.

### `public void clear()`
Removes all elements from the priority queue.
