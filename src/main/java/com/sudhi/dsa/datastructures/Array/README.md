# Array Data Structure

This is a generic dynamic array implementation that can hold elements of any type that implements the `Comparable` interface. The array automatically resizes itself when it reaches its capacity.

## Usage

To use the `Array` class, you first need to create an instance of it, specifying the type of elements it will hold:

```java
Array<Integer> myArray = new Array<>(Integer.class);
```

You can also specify an initial capacity:

```java
Array<String> myArray = new Array<>(String.class, 20);
```

## Method Descriptions

*   `add(T item)`: Adds an element to the end of the array. If the array is full, it will be resized to double its current capacity.

*   `get(int index)`: Retrieves the element at the specified index. Throws an `IndexOutOfBoundsException` if the index is out of bounds.

*   `remove(int index)`: Removes the element at the specified index and shifts all subsequent elements to the left. Returns the removed element. Throws an `IndexOutOfBoundsException` if the index is out of bounds.

*   `size()`: Returns the number of elements currently in the array.
