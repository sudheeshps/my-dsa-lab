# Singly Linked List

## Introduction

A singly linked list is a linear data structure where each element (called a node) is a separate object. Each node contains two parts: the data and a reference (or pointer) to the next node in the sequence. The list maintains a reference to its first node, called the `head`. The last node in the list points to `null`, indicating the end of the list.

---

## History

Linked lists were invented by **Allen Newell**, **Cliff Shaw**, and **Herbert Simon** in 1955 at RAND Corporation. They were developed for their Information Processing Language (IPL) and were one of the first dynamic data structures, allowing for flexible memory management.

---

## Behaviour of a Singly Linked List

-   **Dynamic Size**: Can grow or shrink in size during execution.
-   **Non-contiguous Memory**: Elements are not stored in adjacent memory locations, but are linked together by pointers.
-   **Sequential Access**: To access an element, you must start from the head and traverse the list sequentially.
-   **Nodes**: Each node stores data and a reference to the next node.

---

## Data Structure Operations

-   **Insertion (at beginning)**: `O(1)` - By updating the head pointer.
-   **Insertion (at end)**: `O(n)` - Requires traversing to the last node, then `O(1)` for insertion. (Can be `O(1)` if a `tail` pointer is maintained).
-   **Insertion (at a given position)**: `O(n)` - Requires traversing to the position, then `O(1)` for insertion.
-   **Deletion (at beginning)**: `O(1)` - By updating the head pointer.
-   **Deletion (at end)**: `O(n)` - Requires traversing to the second-to-last node to update its `next` pointer. (Can be `O(1)` if a `tail` pointer is maintained and the previous node is known).
-   **Deletion (at a given position)**: `O(n)` - Requires traversing to the position and keeping track of the previous node, then `O(1)` for deletion.
-   **Search**: `O(n)` - Requires traversing the list.

---

## Comparison

-   **vs. Array**: Linked lists offer `O(1)` insertion/deletion at the beginning (and end if `tail` is maintained) but `O(n)` random access. Arrays offer `O(1)` random access but `O(n)` insertion/deletion in the middle.
-   **vs. Doubly Linked List**: Singly linked lists use less memory per node (one pointer vs. two). Doubly linked lists allow bidirectional traversal and `O(1)` deletion (if the node is known) but at the cost of more memory.

---

## How the Data Structure is Implemented

This `LinkedList` implementation uses a nested `Node` class to represent each element in the list. Each `Node` contains a `data` field and a `next` `Node` reference. The `LinkedList` class maintains a `head` pointer and a `size` variable.

Methods like `addFirst`, `addLast`, `removeFirst`, `removeLast` directly manipulate these pointers. Operations like `addAt`, `removeAt`, and `search` involve traversing the list from the `head`.

---

## Known Applications

-   **Implementing other data structures**: Stacks, queues, hash tables (for separate chaining).
-   **Dynamic memory allocation**: Managing free blocks of memory.
-   **Image viewers**: For navigating through images (next/previous).
-   **Polynomial representation**: Each node can represent a term in a polynomial.

---

## API Documentation

### `public void addFirst(T data)`

Adds an element to the beginning of the list.

-   **Parameters:**
    -   `data`: The data to be added.

### `public void addLast(T data)`

Adds an element to the end of the list.

-   **Parameters:**
    -   `data`: The data to be added.

### `public void addAt(T data, int index)`

Adds an element at the specified index.

-   **Parameters:**
    -   `data`: The data to be added.
    -   `index`: The index at which to add the element.
-   **Throws:**
    -   `IndexOutOfBoundsException`: If the index is out of bounds.

### `public T removeFirst()`

Removes and returns the element from the beginning of the list.

-   **Returns:**
    -   The element removed from the beginning.
-   **Throws:**
    -   `NoSuchElementException`: If the list is empty.

### `public T removeLast()`

Removes and returns the element from the end of the list.

-   **Returns:**
    -   The element removed from the end.
-   **Throws:**
    -   `NoSuchElementException`: If the list is empty.

### `public T removeAt(int index)`

Removes and returns the element at the specified index.

-   **Parameters:**
    -   `index`: The index of the element to remove.
-   **Returns:**
    -   The element removed from the specified index.
-   **Throws:**
    -   `IndexOutOfBoundsException`: If the index is out of bounds.

### `public T get(int index)`

Returns the element at the specified index.

-   **Parameters:**
    -   `index`: The index of the element to retrieve.
-   **Returns:**
    -   The element at the specified index.
-   **Throws:**
    -   `IndexOutOfBoundsException`: If the index is out of bounds.

### `public int search(T data)`

Searches for the first occurrence of the specified data in the list.

-   **Parameters:**
    -   `data`: The data to search for.
-   **Returns:**
    -   The index of the first occurrence of the data, or -1 if not found.

### `public boolean isEmpty()`

Checks if the list is empty.

-   **Returns:**
    -   `true` if the list is empty, `false` otherwise.

### `public int size()`

Returns the number of elements in the list.

-   **Returns:**
    -   The number of elements.
