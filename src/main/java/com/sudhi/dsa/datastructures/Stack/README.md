# Stack Data Structure

## Introduction

A Stack is a linear data structure that follows the **Last-In, First-Out (LIFO)** principle. This means that the last element added to the stack will be the first one to be removed. It is analogous to a stack of plates; you add a new plate to the top and you also remove a plate from the top.

---

## History

The concept of a stack was first proposed in 1946 by **Alan Turing** as a means of calling and returning from subroutines. The term "stack" was coined by **Klaus Samelson and Friedrich L. Bauer** in 1955. It has been a fundamental concept in computer architecture and programming language design ever since.

---

## Properties

-   **LIFO Principle**: The core property of a stack. The last element added is the first to be removed.
-   **Top**: The end of the stack where elements are added and removed. 
-   **Push**: The operation of adding an element to the top of the stack.
-   **Pop**: The operation of removing an element from the top of the stack.

---

## How the Data Structure is Implemented

This `Stack` implementation is built **on top of the custom `Array` class**.

-   **Underlying Container**: A private `Array<T>` instance is used as the internal data store.
-   **Method Delegation**: The public methods of the `Stack` class delegate their work to the methods of the internal `Array`:
    -   `push(T item)` calls `array.add(item)`, adding the element to the end of the dynamic array, which represents the top of the stack.
    -   `pop()` calls `array.remove(array.size() - 1)`, removing the last element from the array.
    -   `peek()` calls `array.get(array.size() - 1)` to view the top element without removing it.

This approach is simple and efficient, as the `Array` class already handles dynamic resizing.

---

## Complexity of operations

Since this stack is implemented with a dynamic array, the complexities are as follows:

| Operation | Average Case | Worst Case (due to resize) |
| --------- | ------------ | -------------------------- |
| **Push**  | O(1)         | O(n)                       |
| **Pop**   | O(1)         | O(1)                       |
| **Peek**  | O(1)         | O(1)                       |
| **Space** | O(n)         | O(n)                       |

*The worst-case for `push` occurs when the underlying array needs to be resized.*

---

## Known Applications

Stacks are fundamental in computer science and are used in many algorithms and systems:

-   **Function Call Management**: The "call stack" in programming languages manages active function calls.
-   **Expression Evaluation**: For converting infix expressions to postfix or prefix and then evaluating them.
-   **Undo/Redo Functionality**: In applications like text editors to keep track of previous states.
-   **Backtracking Algorithms**: To keep track of the path taken in algorithms like Depth-First Search (DFS) or solving mazes.

---

## Comparisons

| Data Structure | Stack (LIFO)                               | Queue (FIFO)                               |
| -------------- | ------------------------------------------ | ------------------------------------------ |
| **Principle**  | Last-In, First-Out.                        | First-In, First-Out.                       |
| **Analogy**    | A stack of plates.                         | A line of people at a checkout counter.    |
| **Operations** | `push` (add to top), `pop` (remove from top). | `enqueue` (add to rear), `dequeue` (remove from front). |

---

## API Documentation

### `public Stack(Class<T> clazz)`
Constructs a new stack with a default initial capacity.

### `public Stack(Class<T> clazz, int capacity)`
Constructs a new stack with the specified initial capacity.

### `public void push(T item)`
Adds an element to the top of the stack.

### `public T pop()`
Removes and returns the element at the top of the stack.
-   **Throws**: `IndexOutOfBoundsException` if the stack is empty.

### `public T peek()`
Returns the element at the top of the stack without removing it.
-   **Throws**: `IndexOutOfBoundsException` if the stack is empty.

### `public boolean isEmpty()`
Returns `true` if the stack is empty.

### `public int size()`
Returns the number of elements in the stack.
