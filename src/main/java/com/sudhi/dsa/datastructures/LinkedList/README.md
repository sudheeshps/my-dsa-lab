# Linked List Data Structure

## Introduction

A Linked List is a linear data structure where elements are not stored at contiguous memory locations. Instead, each element is a separate object, called a `Node`, that contains the data and a reference (or pointer) to the next node in the sequence. This structure allows for efficient insertions and deletions from any position in the list, as it only requires updating a few pointers.

---

## History

The concept of linked lists was developed in 1955-56 by **Allen Newell, Cliff Shaw, and Herbert A. Simon** at RAND Corporation as the primary data structure for their Information Processing Language (IPL). It was used to build more complex structures like lists, stacks, and queues for their early work in artificial intelligence.

---

## Properties

-   **Node**: The basic building block of a linked list. Each node contains two components:
    1.  **Data**: The actual value stored in the node.
    2.  **Next Pointer**: A reference to the next node in the list. The last node's `next` pointer is `null`, indicating the end of the list.
-   **Head**: A special pointer that always points to the first node in the linked list. If the `head` is `null`, the list is empty.
-   **Singly Linked**: This is a singly linked list, meaning that each node only has a pointer to the next node in the sequence. Traversal is only possible in the forward direction.

---

## How the Data Structure is Implemented

This implementation uses a private nested `Node<T>` class to represent the elements.

-   **Node Class**: The `Node` class holds the generic `data` and a `next` reference to the subsequent `Node`.
-   **Head and Size**: The `LinkedList` class maintains a `head` reference to the first node and an integer `size` to keep track of the number of elements.
-   **Operations**: 
    -   `add(T data)`: To add an element to the end, the list is traversed from the `head` until the last node is found, and the new node is attached there. This is an O(n) operation.
    -   `addFirst(T data)`: To add to the beginning, the new node's `next` pointer is set to the current `head`, and the `head` is updated to the new node. This is an O(1) operation.
    -   `get(int index)` and `remove(int index)`: These operations require traversing the list from the `head` up to the desired index, resulting in O(n) time complexity.

---

## Complexity of operations

| Operation         | Average Case | Worst Case |
| ----------------- | ------------ | ---------- |
| **Access (get)**  | O(n)         | O(n)       |
| **Search**        | O(n)         | O(n)       |
| **Insertion (add)** | O(n)         | O(n)       | 
| **Insertion (addFirst)** | O(1)         | O(1)       |
| **Deletion (remove)** | O(n)         | O(n)       |
| **Space**         | O(n)         | O(n)       |

*Note: Insertion and deletion are O(1) if performed at the head of the list.*

---

## Known Applications

Linked lists are useful in scenarios where the number of elements is unknown beforehand and frequent insertions/deletions are required.

-   **Implementing other Data Structures**: Used to implement Stacks, Queues, and the adjacency lists in Graphs.
-   **Dynamic Memory Allocation**: For managing free memory blocks in a system.
-   **Music Players**: To create playlists where songs can be easily added, removed, or reordered.
-   **Undo Functionality**: In applications like text editors, where each action can be stored as a node in a list.

---

## Comparisons

| Feature           | Linked List                               | Array                                     |
| ----------------- | ----------------------------------------- | ----------------------------------------- |
| **Memory**        | Stored non-contiguously.                  | Stored in contiguous memory blocks.       |
| **Access Time**   | O(n) - requires traversal.                | O(1) - direct access via index.           |
| **Insertion/Deletion** | O(1) at head, O(n) elsewhere.             | O(n) - requires shifting elements.        |
| **Size**          | Dynamic - can grow and shrink easily.     | Fixed - size is determined at creation.   |

---

## API Documentation

### `public void add(T data)`
Adds an element to the end of the list.

### `public void addFirst(T data)`
Adds an element to the beginning of the list.

### `public T get(int index)`
Retrieves the element at the specified index.
-   **Throws**: `IndexOutOfBoundsException` if the index is out of bounds.

### `public T remove(int index)`
Removes the element at the specified index and returns its data.
-   **Throws**: `IndexOutOfBoundsException` if the index is out of bounds.

### `public T removeFirst()`
Removes and returns the first element of the list.
-   **Throws**: `IndexOutOfBoundsException` if the list is empty.

### `public int size()`
Returns the number of elements in the list.
