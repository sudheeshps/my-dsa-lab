# Queue Data Structure

This is a generic Queue implementation that is built on top of a `LinkedList`. A queue is a First-In, First-Out (FIFO) data structure where elements are added to the rear and removed from the front.

## Usage

To use the `Queue` class, you first need to create an instance of it:

```java
Queue<Integer> myQueue = new Queue<>();
```

## Method Descriptions

*   `enqueue(T data)`: Adds an element to the back of the queue.

*   `dequeue()`: Removes and returns the element at the front of the queue. Throws an `IndexOutOfBoundsException` if the queue is empty.

*   `peek()`: Returns the element at the front of the queue without removing it. Returns `null` if the queue is empty.

*   `isEmpty()`: Returns `true` if the queue is empty, `false` otherwise.

*   `size()`: Returns the number of elements in the queue.
