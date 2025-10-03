# Stack Data Structure

This is a generic Stack implementation that is built on top of the custom `Array` class. A stack is a Last-In, First-Out (LIFO) data structure where elements are added and removed from the top.

## Usage

To use the `Stack` class, you first need to create an instance of it, specifying the type of elements it will hold:

```java
Stack<Integer> myStack = new Stack<>(Integer.class);
```

You can also specify an initial capacity:

```java
Stack<String> myStack = new Stack<>(String.class, 20);
```

## Method Descriptions

*   `push(T item)`: Adds an element to the top of the stack.

*   `pop()`: Removes and returns the element at the top of the stack. Throws an `IndexOutOfBoundsException` if the stack is empty.

*   `peek()`: Returns the element at the top of the stack without removing it. Throws an `IndexOutOfBoundsException` if the stack is empty.

*   `isEmpty()`: Returns `true` if the stack is empty, `false` otherwise.

*   `size()`: Returns the number of elements in the stack.
