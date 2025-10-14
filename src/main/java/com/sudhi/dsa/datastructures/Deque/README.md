# Deque Data Structure

## Introduction

A Deque (pronounced "deck"), short for double-ended queue, is a linear data structure that allows for the insertion and removal of elements from both ends (front and back). It generalizes both stacks (LIFO) and queues (FIFO), as you can implement a stack by using only `addFirst` and `removeFirst`, and a queue by using `addLast` and `removeFirst`.

## History

The term "deque" was coined by computer scientist **Donald Knuth** in his influential book series, *The Art of Computer Programming*. The concept itself is a natural extension of the queue and stack data structures, providing more flexibility by allowing operations at both ends.

## Properties

*   **Double-Ended**: Elements can be added or removed from either the front or the back.
*   **Linear Structure**: Maintains a linear sequence of elements.
*   **Dynamic Size**: Can grow or shrink as needed.
*   **Versatile**: Can function as a stack or a queue.

## How the Data Structure is Implemented

This Deque is implemented as a wrapper around a `DoublyLinkedList`. This is a common and efficient way to build a deque.

*   **Composition**: The `Deque` class holds a private instance of `DoublyLinkedList`.
*   **Method Delegation**: Each method of the `Deque` class simply calls the corresponding method on the internal `DoublyLinkedList`. For example:
    *   `addFirst(data)` calls `list.addFirst(data)`.
    *   `removeLast()` calls `list.removeLast()`.
*   This approach avoids code duplication and leverages the O(1) performance of the doubly linked list for adding and removing at both ends.

## Complexity of operations

Because this Deque is implemented with a Doubly Linked List, it offers constant time performance for its primary operations.

| Operation | Average Case | Worst Case |
| :-------- | :----------: | :--------: |
| **Access (peek)** | O(1) | O(1) |
| **Search** | O(n) | O(n) |
| **Insertion (addFirst/addLast)** | O(1) | O(1) |
| **Deletion (removeFirst/removeLast)** | O(1) | O(1) |

## Known Applications

*   **Sliding Window Algorithms**: Deques are very efficient for tracking the maximum or minimum element in a sliding window of a fixed size across an array.
*   **Work Stealing Job Schedulers**: In parallel computing, some threads can "steal" work from the other end of another thread's deque, improving load balancing.
*   **Undo/Redo Functionality**: Can be used to implement undo/redo features in software, where actions are added to one end and undone from the same end.
*   **Palindrome Checking**: A string can be checked for being a palindrome by adding all characters to a deque and then simultaneously removing from both ends and comparing.

## Comparisons

*   **Deque vs. Array**: An array-based deque (like Java's `ArrayDeque`) is more memory-efficient due to avoiding node overhead, but adding an element to a full `ArrayDeque` can be an O(n) operation due to resizing. A linked-list-based deque has O(1) insertions but higher memory overhead.
*   **Deque vs. Queue/Stack**: A deque is a superset of both. It can do everything a queue and a stack can do.

## API documentation

### `public Deque()`
Creates a new, empty Deque.

### `public void addFirst(T data)`
Adds an element to the front of the deque.

*   **Parameters**:
    *   `data`: The element to be added.

### `public void addLast(T data)`
Adds an element to the back of the deque.

*   **Parameters**:
    *   `data`: The element to be added.

### `public T removeFirst()`
Removes and returns the element at the front of the deque.

*   **Returns**: The removed element, or `null` if the deque is empty.

### `public T removeLast()`
Removes and returns the element at the back of the deque.

*   **Returns**: The removed element, or `null` if the deque is empty.

### `public T peekFirst()`
Returns the element at the front of the deque without removing it.

*   **Returns**: The element at the front, or `null` if the deque is empty.

### `public T peekLast()`
Returns the element at the back of the deque without removing it.

*   **Returns**: The element at the back, or `null` if the deque is empty.

### `public boolean isEmpty()`
Returns `true` if the deque contains no elements.

*   **Returns**: `true` if the deque is empty, `false` otherwise.

### `public int size()`
Returns the number of elements in the deque.

*   **Returns**: The number of elements in the deque.