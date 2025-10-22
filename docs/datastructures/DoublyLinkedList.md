# Doubly Linked List

## Introduction

A doubly linked list is a linear data structure in which each node contains, in addition to the data, a pointer to the next node and a pointer to the previous node. This structure allows for traversal in both forward and backward directions, offering more flexibility than a singly linked list.

---

## History

Linked lists, in general, are one of the earliest and most fundamental data structures in computer science. The concept of a doubly linked list naturally evolved from the singly linked list to address the need for bidirectional traversal and more efficient deletion operations without needing a reference to the previous node.

---

## Behaviour of a Doubly Linked List

-   **Bidirectional Traversal**: Can be traversed from head to tail and from tail to head.
-   **Nodes**: Each node consists of three parts: data, a pointer to the next node, and a pointer to the previous node.
-   **Head and Tail Pointers**: Typically maintains pointers to both the first (head) and last (tail) nodes for `O(1)` access to both ends.

---

## Data Structure Operations

-   **Insertion (at beginning/end)**: `O(1)` - By updating head/tail pointers and adjacent node references.
-   **Insertion (at a given position)**: `O(n)` - Requires traversing to the position, then `O(1)` for insertion.
-   **Deletion (at beginning/end)**: `O(1)` - By updating head/tail pointers and adjacent node references.
-   **Deletion (at a given position)**: `O(n)` - Requires traversing to the position, then `O(1)` for deletion.
-   **Search**: `O(n)` - Requires traversing the list.

---

## Comparison

-   **vs. Singly Linked List**: Doubly linked lists offer `O(1)` deletion (if the node is known) and bidirectional traversal, which singly linked lists lack. However, they require more memory per node (for the extra pointer).
-   **vs. Array**: Linked lists (both singly and doubly) offer `O(1)` insertion/deletion at ends (or known positions) but `O(n)` random access. Arrays offer `O(1)` random access but `O(n)` insertion/deletion in the middle.

---

## How the Data Structure is Implemented

This `DoublyLinkedList` implementation uses a nested `Node` class to represent each element in the list. Each `Node` contains a `data` field and two `Node` references: `next` and `prev`. The `DoublyLinkedList` class maintains `head` and `tail` pointers, along with a `size` variable.

Methods like `addFirst`, `addLast`, `removeFirst`, `removeLast` directly manipulate these pointers to achieve `O(1)` complexity. Operations like `addAt`, `removeAt`, and `search` involve traversing the list.

---

## Known Applications

-   **Implementing other data structures**: Deques, LRU caches.
-   **Navigation systems**: For back and forth movement (e.g., browser history).
-   **Undo/Redo functionality**: In text editors or other applications.
-   **Music playlists**: Allowing users to go to the next or previous song.

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
