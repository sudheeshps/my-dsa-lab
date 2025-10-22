# Deque (Double-Ended Queue)

## Introduction

A Deque (pronounced "deck" and short for "Double-Ended Queue") is a linear data structure that allows elements to be added or removed from both ends. It can function as both a queue (FIFO - First-In, First-Out) and a stack (LIFO - Last-In, First-Out), providing more flexibility than either a traditional queue or stack.

---

## History

The concept of a double-ended queue is a natural extension of queues and stacks. While not attributed to a single inventor, it has been a part of computer science literature and implementations for many decades, often implemented using doubly linked lists or dynamic arrays.

---

## Behaviour of a Deque

-   **Add/Remove from Front**: Elements can be added to the front (head) or removed from the front of the deque.
-   **Add/Remove from Rear**: Elements can be added to the rear (tail) or removed from the rear of the deque.
-   **Flexible**: Can mimic the behavior of a stack (using `pushFront`/`popFront` or `pushRear`/`popRear`) or a queue (using `pushFront`/`popRear` or `pushRear`/`popFront`).

---

## Data Structure Operations

-   **`addFront(element)`**: `O(1)` - Adds an element to the front.
-   **`addRear(element)`**: `O(1)` - Adds an element to the rear.
-   **`removeFront()`**: `O(1)` - Removes and returns the element from the front.
-   **`removeRear()`**: `O(1)` - Removes and returns the element from the rear.
-   **`peekFront()`**: `O(1)` - Returns the element at the front without removing it.
-   **`peekRear()`**: `O(1)` - Returns the element at the rear without removing it.

---

## Comparison

-   **vs. Queue**: A queue only allows additions at one end and removals from the other. A deque offers more operations.
-   **vs. Stack**: A stack only allows additions and removals from one end. A deque offers more operations.
-   **Implementation**: Deques can be efficiently implemented using a doubly linked list or a dynamic array (circular array).

---

## How the Data Structure is Implemented

This `Deque` implementation uses a **doubly linked list** internally. Each node in the list stores an element and has pointers to both the next and previous nodes. This allows for `O(1)` time complexity for adding and removing elements from both ends by simply updating the `head` and `tail` pointers and the `next`/`prev` references of the adjacent nodes.

---

## Known Applications

-   **Work-stealing algorithms**: In parallel computing, where idle processors can "steal" tasks from the ends of other processors' deques.
-   **Implementing other data structures**: Can be used to implement queues, stacks, and even priority queues.
-   **Browser history**: Storing URLs for back/forward navigation.
-   **Undo/Redo functionality**: In text editors or other applications.
-   **Palindrome checker**: Easily check if a string is a palindrome by adding characters to the rear and removing from both ends.

---

## API Documentation

### `public void addFront(T element)`

Adds an element to the front of the deque.

-   **Parameters:**
    -   `element`: The element to be added.

### `public void addRear(T element)`

Adds an element to the rear of the deque.

-   **Parameters:**
    -   `element`: The element to be added.

### `public T removeFront()`

Removes and returns the element from the front of the deque.

-   **Returns:**
    -   The element removed from the front.
-   **Throws:**
    -   `NoSuchElementException`: If the deque is empty.

### `public T removeRear()`

Removes and returns the element from the rear of the deque.

-   **Returns:**
    -   The element removed from the rear.
-   **Throws:**
    -   `NoSuchElementException`: If the deque is empty.

### `public T peekFront()`

Returns the element at the front of the deque without removing it.

-   **Returns:**
    -   The element at the front.
-   **Throws:**
    -   `NoSuchElementException`: If the deque is empty.

### `public T peekRear()`

Returns the element at the rear of the deque without removing it.

-   **Returns:**
    -   The element at the rear.
-   **Throws:**
    -   `NoSuchElementException`: If the deque is empty.

### `public boolean isEmpty()`

Checks if the deque is empty.

-   **Returns:**
    -   `true` if the deque is empty, `false` otherwise.

### `public int size()`

Returns the number of elements in the deque.

-   **Returns:**
    -   The number of elements.
