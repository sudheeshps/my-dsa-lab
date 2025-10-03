# Doubly Linked List Data Structure

This is a generic doubly linked list implementation. A doubly linked list is a linear data structure where each element is a separate object, called a node, that contains data and references to both the next and the previous node in the sequence.

## Usage

To use the `DoublyLinkedList` class, you first need to create an instance of it:

```java
DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
```

## Method Descriptions

*   `add(T data)`: Adds an element to the end of the list.

*   `addFirst(T data)`: Adds an element to the beginning of the list.

*   `addLast(T data)`: Adds an element to the end of the list.

*   `get(int index)`: Retrieves the element at the specified index. Throws an `IndexOutOfBoundsException` if the index is out of bounds.

*   `remove(int index)`: Removes the element at the specified index and returns its data. Throws an `IndexOutOfBoundsException` if the index is out of bounds.

*   `removeFirst()`: Removes and returns the first element of the list. Throws an `IndexOutOfBoundsException` if the list is empty.

*   `removeLast()`: Removes and returns the last element of the list. Throws an `IndexOutOfBoundsException` if the list is empty.

*   `size()`: Returns the number of elements in the list.
