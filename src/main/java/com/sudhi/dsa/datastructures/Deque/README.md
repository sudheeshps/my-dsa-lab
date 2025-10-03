# Deque Data Structure

This is a generic Deque (double-ended queue) implementation that is built on top of a `DoublyLinkedList`. A deque is a collection of elements that supports insertion and removal of elements from both ends.

## Usage

To use the `Deque` class, you first need to create an instance of it:

```java
Deque<Integer> myDeque = new Deque<>();
```

## Method Descriptions

*   `addFirst(T data)`: Adds an element to the front of the deque.

*   `addLast(T data)`: Adds an element to the back of the deque.

*   `removeFirst()`: Removes and returns the element at the front of the deque. Returns `null` if the deque is empty.

*   `removeLast()`: Removes and returns the element at the back of the deque. Returns `null` if the deque is empty.

*   `peekFirst()`: Returns the element at the front of the deque without removing it. Returns `null` if the deque is empty.

*   `peekLast()`: Returns the element at the back of the deque without removing it. Returns `null` if the deque is empty.

*   `isEmpty()`: Returns `true` if the deque is empty, `false` otherwise.

*   `size()`: Returns the number of elements in the deque.
