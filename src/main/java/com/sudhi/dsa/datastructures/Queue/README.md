# Queue Data Structure

## Introduction

A Queue is a linear data structure that follows the **First-In, First-Out (FIFO)** principle. This means that the first element added to the queue will be the first one to be removed. It is analogous to a real-world queue, such as a line of customers waiting for service, where the person who arrives first is served first.

---

## History

The concept of queues as a data structure has been used since the early days of computer science, often in the context of operating systems and simulations. The term and its principles were formalized in computer science literature by the mid-20th century, alongside other fundamental structures like stacks and lists.

---

## Properties

-   **FIFO Principle**: The core property of a queue. The order of elements is preserved.
-   **Front (or Head)**: The end of the queue where elements are removed. 
-   **Rear (or Tail)**: The end of the queue where new elements are added.
-   **Enqueue**: The operation of adding an element to the rear of the queue.
-   **Dequeue**: The operation of removing an element from the front of the queue.

---

## How the Data Structure is Implemented

This `Queue` implementation is an example of a **composition-based** data structure. It does not implement the queue logic from scratch; instead, it is built **on top of the existing `LinkedList` class**.

-   **Underlying Container**: A private `LinkedList<T>` instance is used as the internal data store.
-   **Method Delegation**: The public methods of the `Queue` class delegate their work to the methods of the internal `LinkedList`:
    -   `enqueue(T data)` calls `list.add(data)`, adding the element to the end of the list (the rear of the queue).
    -   `dequeue()` calls `list.removeFirst()`, removing the element from the beginning of the list (the front of the queue).
    -   `peek()` calls `list.get(0)` to view the front element without removing it.

This approach is efficient and promotes code reuse, as the complex pointer management is already handled by the `LinkedList` class.

---

## Complexity of operations

Since this queue is implemented with a linked list where `add` is O(n) and `removeFirst` is O(1), the complexities are as follows:

| Operation      | Average Case | Worst Case |
| -------------- | ------------ | ---------- |
| **Enqueue (add)** | O(n)         | O(n)       |
| **Dequeue (removeFirst)** | O(1)         | O(1)       |
| **Peek**       | O(1)         | O(1)       |
| **Space**      | O(n)         | O(n)       |

*Note: The O(n) enqueue time is a result of the underlying `LinkedList.add()` needing to traverse to the end. A more optimized queue would use a doubly linked list or a linked list with a tail pointer to achieve O(1) enqueue time.*

---

## Known Applications

Queues are used in many algorithms and systems where order must be preserved:

-   **Task Scheduling**: In operating systems for managing processes waiting for the CPU.
-   **Buffering**: To handle data streams between processes, such as in I/O operations or network packet queuing.
-   **Breadth-First Search (BFS)**: The BFS algorithm for traversing a graph uses a queue to keep track of the nodes to visit.
-   **Print Spooling**: Managing print jobs in the order they were received.

---

## Comparisons

| Data Structure | Queue (FIFO)                               | Stack (LIFO)                               |
| -------------- | ------------------------------------------ | ------------------------------------------ |
| **Principle**  | First-In, First-Out.                       | Last-In, First-Out.                        |
| **Analogy**    | A line of people at a checkout counter.    | A stack of plates.                         |
| **Operations** | `enqueue` (add to rear), `dequeue` (remove from front). | `push` (add to top), `pop` (remove from top). |

---

## API Documentation

### `public void enqueue(T data)`
Adds an element to the rear of the queue.

### `public T dequeue()`
Removes and returns the element at the front of the queue.
-   **Throws**: `IndexOutOfBoundsException` if the queue is empty.

### `public T peek()`
Returns the element at the front of the queue without removing it.
-   **Returns**: The element at the front, or `null` if the queue is empty.

### `public boolean isEmpty()`
Returns `true` if the queue is empty.

### `public int size()`
Returns the number of elements in the queue.
