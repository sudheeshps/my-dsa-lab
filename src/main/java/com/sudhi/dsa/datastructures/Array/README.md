# Array Data Structure

## Introduction

An array is a fundamental data structure consisting of a collection of elements, each identified by at least one array index or key. An array is stored such that the position of each element can be computed from its index tuple by a mathematical formula. This project provides a generic dynamic array implementation that can hold elements of any type. The array automatically resizes itself by doubling its capacity when it runs out of space.

## History

The concept of arrays has been fundamental to computing since its earliest days, with array-like structures appearing in the first stored-program computers. The first high-level programming language to include support for multi-dimensional arrays was Fortran, developed in the 1950s by a team at IBM led by John Backus. The array's ability to store and access data efficiently made it a cornerstone of scientific and engineering computation.

## Properties

*   **Contiguous Memory**: Elements are stored in a single, unbroken block of memory. This allows for efficient cache utilization.
*   **Indexed Access**: Each element has a unique index, allowing for constant-time O(1) direct access.
*   **Homogeneous Elements**: In this implementation, all elements must be of the same type `T`.
*   **Dynamic Sizing**: This implementation is a dynamic array (similar to Java's `ArrayList`), which can grow as more elements are added.

## How the Data Structure is Implemented

This dynamic array is implemented using a standard Java array internally.

*   **Initialization**: An array is created with an initial `capacity`. A `size` field tracks the number of elements currently stored.
*   **Adding Elements**: When an element is added using the `add` method, the `size` is incremented. If the `size` equals the `capacity`, a private `resize` method is called.
*   **Resizing**: The `resize` method creates a new, larger array (double the previous capacity), copies all elements from the old array to the new one, and then replaces the old array with the new one.
*   **Generics**: The class uses Java generics (`<T>`) to be type-safe. Due to Java's type erasure, the class requires a `Class<T>` object in its constructor to create a new generic array instance at runtime using `java.lang.reflect.Array.newInstance()`.

## Complexity of operations

The performance characteristics of the dynamic array are as follows:

| Operation | Average Case | Worst Case |
| :-------- | :----------: | :--------: |
| **Access (get)** | O(1) | O(1) |
| **Search** | O(n) | O(n) |
| **Insertion (add)** | O(1) (Amortized) | O(n) |
| **Deletion (remove)** | O(n) | O(n) |

*   **Access**: Accessing an element by its index is always a constant time operation.
*   **Insertion**: Adding an element to the end is typically O(1). However, if the array is full, it needs to be resized, which is an O(n) operation. Over many insertions, this averages out to an amortized cost of O(1).
*   **Deletion**: Removing an element requires shifting all subsequent elements to the left, resulting in O(n) complexity.

## Known Applications

*   As the primary building block for other data structures like Stacks, Queues, and Hashtables.
*   Storing lists of data where fast random access by index is a primary requirement.
*   Used in various algorithms for sorting (e.g., QuickSort, MergeSort), searching, and matrix manipulation.
*   Implementing buffers in I/O operations.

## Comparisons

*   **Array vs. Linked List**:
    *   **Access**: Arrays provide O(1) access, while linked lists require O(n) traversal.
    *   **Insertion/Deletion**: Linked lists have O(1) insertion/deletion at the ends (and in the middle if the node is known), whereas arrays have O(n) insertion/deletion in the middle and amortized O(1) at the end.
    *   **Memory**: Arrays use less memory per element as they don't store pointers. Linked lists can grow more gracefully without the need for expensive resizing operations.

## API documentation

### `public Array(Class<T> clazz)`
Creates a new dynamic array with a default initial capacity of 10.

*   **Parameters**:
    *   `clazz`: The class object of the type `T`, required for creating a generic array at runtime.

### `public Array(Class<T> clazz, int capacity)`
Creates a new dynamic array with a specified initial capacity.

*   **Parameters**:
    *   `clazz`: The class object of the type `T`.
    *   `capacity`: The initial capacity of the array.

### `public void add(T item)`
Adds an element to the end of the array. If the array is full, it will be resized to double its current capacity.

*   **Parameters**:
    *   `item`: The element to be added.

### `public T get(int index)`
Retrieves the element at the specified index.

*   **Parameters**:
    *   `index`: The index of the element to retrieve.
*   **Returns**: The element at the specified index.
*   **Throws**: `IndexOutOfBoundsException` if the index is out of bounds.

### `public T remove(int index)`
Removes the element at the specified index and shifts all subsequent elements to the left.

*   **Parameters**:
    *   `index`: The index of the element to remove.
*   **Returns**: The removed element.
*   **Throws**: `IndexOutOfBoundsException` if the index is out of bounds.

### `public int size()`
Returns the number of elements currently in the array.

*   **Returns**: The number of elements in the array.