# Queue

## Introduction

A queue is a linear data structure that follows the First-In, First-Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed. Think of a queue like a line of people waiting for a service: the person who arrives first is served first.

---

## History

The concept of a queue is fundamental in computer science and mathematics, mirroring real-world queuing systems. It was formally introduced as an abstract data type in the early days of computing, with implementations often using arrays or linked lists.

---

## Behaviour of a Queue

-   **FIFO Principle**: Elements are added at one end (the "rear" or "tail") and removed from the other end (the "front" or "head").
-   **Enqueue**: Adding an element to the rear of the queue.
-   **Dequeue**: Removing an element from the front of the queue.
-   **Peek**: Viewing the element at the front without removing it.

---

## Data Structure Operations

-   **`enqueue(element)`**: `O(1)` (using a linked list or dynamic array) - Adds an element to the rear.
-   **`dequeue()`**: `O(1)` (using a linked list or dynamic array) - Removes and returns the element from the front.
-   **`peek()`**: `O(1)` (using a linked list or dynamic array) - Returns the element at the front without removing it.

---

## Comparison

-   **vs. Stack**: A stack follows LIFO (Last-In, First-Out). A queue follows FIFO.
-   **vs. Deque**: A deque (double-ended queue) allows additions and removals from both ends, offering more flexibility than a traditional queue.
-   **Implementation**: Queues can be efficiently implemented using a linked list (where `enqueue` adds to the tail and `dequeue` removes from the head) or a circular array.

---

## How the Data Structure is Implemented

This `Queue` implementation uses a **singly linked list** internally. Each node in the list stores an element and has a pointer to the next node. The `Queue` class maintains `head` and `tail` pointers, along with a `size` variable.

-   `head`: Points to the front of the queue (where elements are dequeued).
-   `tail`: Points to the rear of the queue (where elements are enqueued).

This linked list-based approach allows for `O(1)` time complexity for all core operations (`enqueue`, `dequeue`, `peek`) by simply manipulating the `head` and `tail` pointers.

---

## Known Applications

-   **Operating Systems**: CPU scheduling, disk scheduling, handling interrupts.
-   **Network Buffering**: Managing data packets in network routers.
-   **Breadth-First Search (BFS)**: A graph traversal algorithm.
-   **Spooling**: For printers or other shared resources.
-   **Simulation**: Modeling real-world queuing systems.

---

## API Documentation

### `public void enqueue(T element)`

Adds an element to the rear of the queue.

-   **Parameters:**
    -   `element`: The element to be added.

### `public T dequeue()`

Removes and returns the element from the front of the queue.

-   **Returns:**
    -   The element removed from the front.
-   **Throws:**
    -   `NoSuchElementException`: If the queue is empty.

### `public T peek()`

Returns the element at the front of the queue without removing it.

-   **Returns:**
    -   The element at the front.
-   **Throws:**
    -   `NoSuchElementException`: If the queue is empty.

### `public boolean isEmpty()`

Checks if the queue is empty.

-   **Returns:**
    -   `true` if the queue is empty, `false` otherwise.

### `public int size()`

Returns the number of elements in the queue.

-   **Returns:**
    -   The number of elements.
