# Priority Queue Data Structure

This is a generic priority queue implementation using a binary heap. It can be configured to be a min-priority queue or a max-priority queue by providing a custom comparator.

## Usage

To use the `PriorityQueue` class, you first need to create an instance of it. By default, it's a min-priority queue:

```java
PriorityQueue<Integer> minQueue = new PriorityQueue<>();
```

To create a max-priority queue, you can provide a custom comparator:

```java
PriorityQueue<Integer> maxQueue = new PriorityQueue<>(10, (a, b) -> b.compareTo(a));
```

## Method Descriptions

*   `add(T elem)`: Adds an element to the priority queue.

*   `poll()`: Removes and returns the element with the highest priority (the minimum element in a min-queue, or the maximum in a max-queue).

*   `peek()`: Returns the element with the highest priority without removing it.

*   `remove(T element)`: Removes a specific element from the priority queue.

*   `contains(T elem)`: Returns `true` if the priority queue contains the specified element, `false` otherwise.

*   `isEmpty()`: Returns `true` if the priority queue is empty, `false` otherwise.

*   `size()`: Returns the number of elements in the priority queue.

*   `clear()`: Removes all elements from the priority queue.
