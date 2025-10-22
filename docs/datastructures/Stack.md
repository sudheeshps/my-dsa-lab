# Stack

## Introduction

A stack is a linear data structure that follows the Last-In, First-Out (LIFO) principle. This means that the last element added to the stack will be the first one to be removed. Think of a stack like a pile of plates: you can only add a new plate to the top, and you can only remove the topmost plate.

---

## History

The concept of a stack has been around since the early days of computing. It was formally introduced as an abstract data type by **Alan J. Perlis** in 1960. Stacks are fundamental to how computer programs execute, particularly in managing function calls and local variables.

---

## Behaviour of a Stack

-   **LIFO Principle**: Elements are added and removed from only one end, called the "top" of the stack.
-   **Push**: Adding an element to the top of the stack.
-   **Pop**: Removing an element from the top of the stack.
-   **Peek**: Viewing the element at the top without removing it.

---

## Data Structure Operations

-   **`push(element)`**: `O(1)` (using an array or linked list) - Adds an element to the top.
-   **`pop()`**: `O(1)` (using an array or linked list) - Removes and returns the element from the top.
-   **`peek()`**: `O(1)` (using an array or linked list) - Returns the element at the top without removing it.

---

## Comparison

-   **vs. Queue**: A queue follows FIFO (First-In, First-Out). A stack follows LIFO.
-   **vs. Deque**: A deque (double-ended queue) allows additions and removals from both ends, offering more flexibility than a traditional stack.
-   **Implementation**: Stacks can be efficiently implemented using a dynamic array (like `ArrayList` in Java) or a linked list (where `push` adds to the head and `pop` removes from the head).

---

## How the Data Structure is Implemented

This `Stack` implementation uses a **singly linked list** internally. Each node in the list stores an element and has a pointer to the next node. The `Stack` class maintains a `top` pointer (which is the `head` of the linked list) and a `size` variable.

-   `top`: Points to the top of the stack (where elements are pushed and popped).

This linked list-based approach allows for `O(1)` time complexity for all core operations (`push`, `pop`, `peek`) by simply manipulating the `top` pointer.

---

## Known Applications

-   **Function Call Stack**: Managing function calls in programming languages.
-   **Undo/Redo Functionality**: In text editors or other applications.
-   **Expression Evaluation**: Converting infix to postfix expressions and evaluating them.
-   **Backtracking Algorithms**: Depth-First Search (DFS) uses a stack implicitly (recursion) or explicitly.
-   **Browser History**: Storing visited web pages for the "back" button.

---

## API Documentation

### `public void push(T element)`

Adds an element to the top of the stack.

-   **Parameters:**
    -   `element`: The element to be added.

### `public T pop()`

Removes and returns the element from the top of the stack.

-   **Returns:**
    -   The element removed from the top.
-   **Throws:**
    -   `NoSuchElementException`: If the stack is empty.

### `public T peek()`

Returns the element at the top of the stack without removing it.

-   **Returns:**
    -   The element at the top.
-   **Throws:**
    -   `NoSuchElementException`: If the stack is empty.

### `public boolean isEmpty()`

Checks if the stack is empty.

-   **Returns:**
    -   `true` if the stack is empty, `false` otherwise.

### `public int size()`

Returns the number of elements in the stack.

-   **Returns:**
    -   The number of elements.
