# Doubly Linked List Data Structure

## Introduction

A doubly linked list is a linear data structure where each element is a separate object, called a node. Each node contains data and references (or links) to both the next and the previous node in the sequence. This bidirectional linking allows for traversal in both forward and backward directions, making it more flexible than a singly linked list.

## History

Linked lists as a concept have been around since the mid-1950s, with significant contributions from researchers at RAND Corporation for use in their information processing language. The doubly linked list is a natural evolution of the singly linked list, and its principles were also popularized by **Donald Knuth** in his book series, *The Art of Computer Programming*.

## Properties

*   **Bidirectional Traversal**: Can be traversed from head to tail, or from tail to head.
*   **Node Structure**: Each node contains a data element and two pointers: `next` and `prev`.
*   **Non-Contiguous Memory**: Unlike arrays, nodes can be stored anywhere in memory, which allows the list to grow dynamically without resizing.
*   **Head and Tail Pointers**: The list maintains direct references to the first (`head`) and last (`tail`) nodes for efficient O(1) additions and removals at both ends.

## How the Data Structure is Implemented

This doubly linked list is implemented with a generic `Node<T>` inner class.

*   **Node Class**: The `Node` class holds the `data` and the `prev` and `next` pointers to other nodes.
*   **Head and Tail**: The `DoublyLinkedList` class maintains `head` and `tail` pointers. `head` points to the first node, and `tail` points to the last.
*   **Adding Nodes**: When adding a node (e.g., `addLast`), the `next` pointer of the current `tail` is updated to the new node, and the `prev` pointer of the new node is set to the old `tail`. Finally, the `tail` pointer is updated to the new node.
*   **Removing Nodes**: When a node is removed, the `next` pointer of the previous node is linked to the `next` pointer of the subsequent node, and vice-versa for the `prev` pointers, effectively bypassing the removed node.

## Complexity of operations

The performance of a doubly linked list varies depending on the operation.

| Operation | Average Case | Worst Case |
| :-------- | :----------: | :--------: |
| **Access** | O(n) | O(n) |
| **Search** | O(n) | O(n) |
| **Insertion (at ends)** | O(1) | O(1) |
| **Insertion (in middle)** | O(n) | O(n) |
| **Deletion (at ends)** | O(1) | O(1) |
| **Deletion (in middle)** | O(n) | O(n) |

*   **Access/Search**: To find an element by index, one must traverse the list from the beginning, leading to linear time complexity.
*   **Insertion/Deletion**: Adding or removing from the ends is very efficient (O(1)) because of the `head` and `tail` pointers. If the operation is in the middle, it first requires finding the node (O(n)), but the actual pointer manipulation is O(1) once the node is located.

## Known Applications

*   **Implementing other Data Structures**: Used as the underlying structure for Deques, Stacks, and Queues.
*   **Navigation Systems**: Used for "previous" and "next" page navigation in web browsers or "previous" and "next" track in music playlists.
*   **Undo/Redo Functionality**: The ability to easily add and remove from either end makes it suitable for managing a history of actions.
*   **LRU (Least Recently Used) Caches**: A doubly linked list combined with a hash map can provide O(1) time complexity for adding, removing, and looking up items in a cache.

## Comparisons

*   **Doubly Linked List vs. Singly Linked List**:
    *   **Traversal**: Doubly linked lists can be traversed backward, while singly linked lists cannot.
    *   **Deletion**: Deleting a node in a doubly linked list is more efficient if you have a pointer to the node itself, as you can access the previous node in O(1) time. In a singly linked list, you would need to traverse from the head to find the previous node (O(n)).
    *   **Memory**: Doubly linked lists require extra memory for the `prev` pointer in each node.

*   **Doubly Linked List vs. Array**:
    *   **Insertion/Deletion**: Insertion and deletion are much faster in a doubly linked list than in an array, as no elements need to be shifted.
    *   **Access**: Arrays provide O(1) random access, while linked lists require O(n) traversal.
    *   **Memory**: Arrays have better cache locality and no memory overhead for pointers.

## API documentation

### `public DoublyLinkedList()`
Creates a new, empty Doubly Linked List.

### `public void add(T data)`
Adds an element to the end of the list. This is an alias for `addLast(data)`.

*   **Parameters**:
    *   `data`: The element to be added.

### `public void addFirst(T data)`
Adds an element to the beginning of the list.

*   **Parameters**:
    *   `data`: The element to be added.

### `public void addLast(T data)`
Adds an element to the end of the list.

*   **Parameters**:
    *   `data`: The element to be added.

### `public T get(int index)`
Retrieves the element at the specified index.

*   **Parameters**:
    *   `index`: The index of the element to retrieve.
*   **Returns**: The element at the specified index.
*   **Throws**: `IndexOutOfBoundsException` if the index is out of bounds.

### `public T remove(int index)`
Removes the element at the specified index.

*   **Parameters**:
    *   `index`: The index of the element to remove.
*   **Returns**: The data of the removed element.
*   **Throws**: `IndexOutOfBoundsException` if the index is out of bounds.

### `public T removeFirst()`
Removes and returns the first element of the list.

*   **Returns**: The data of the removed element.
*   **Throws**: `IndexOutOfBoundsException` if the list is empty.

### `public T removeLast()`
Removes and returns the last element of the list.

*   **Returns**: The data of the removed element.
*   **Throws**: `IndexOutOfBoundsException` if the list is empty.

### `public int size()`
Returns the number of elements in the list.

*   **Returns**: The number of elements in the list.