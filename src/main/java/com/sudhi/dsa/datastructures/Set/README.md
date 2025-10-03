# Set Data Structure

This is a generic Set implementation that is built on top of a `Hashtable`. A set is a collection of unique elements.

## Usage

To use the `Set` class, you first need to create an instance of it, specifying the initial capacity:

```java
Set<Integer> mySet = new Set<>(10);
```

## Method Descriptions

*   `add(T item)`: Adds an element to the set. If the element already exists, it will not be added again.

*   `remove(T item)`: Removes an element from the set.

*   `contains(T item)`: Returns `true` if the set contains the specified element, `false` otherwise.

*   `isEmpty()`: Returns `true` if the set is empty, `false` otherwise.

*   `size()`: Returns the number of elements in the set.
