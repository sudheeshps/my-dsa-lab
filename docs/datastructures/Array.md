# Array

## Introduction

An array is a fundamental data structure that stores a fixed-size sequential collection of elements of the same type. Elements are stored in contiguous memory locations, allowing for efficient random access (accessing any element directly by its index).

---

## History

The concept of arrays is as old as computing itself, being one of the earliest and most basic ways to organize data in memory. Early programming languages like Fortran (1957) and ALGOL (1958) had built-in support for arrays.

---

## Behaviour of an Array

-   **Fixed Size**: Once an array is created, its size cannot be changed. If more or fewer elements are needed, a new array must be created.
-   **Homogeneous Elements**: All elements in an array must be of the same data type.
-   **Contiguous Memory**: Elements are stored in adjacent memory locations, which is key to its performance characteristics.
-   **Zero-based Indexing**: Elements are typically accessed using an integer index, starting from 0 for the first element.

---

## Data Structure Operations

-   **Access (by index)**: `O(1)` - Direct access to any element using its index.
-   **Search (unsorted)**: `O(n)` - Linear scan through all elements.
-   **Search (sorted)**: `O(log n)` - Binary search can be used.
-   **Insertion/Deletion (at end)**: `O(1)` - If no shifting is required.
-   **Insertion/Deletion (at beginning/middle)**: `O(n)` - Requires shifting subsequent elements.

---

## Comparison

-   **vs. Linked List**: Arrays offer `O(1)` random access but `O(n)` insertion/deletion in the middle. Linked lists offer `O(1)` insertion/deletion (if the position is known) but `O(n)` random access.
-   **vs. Dynamic Array (ArrayList)**: Dynamic arrays provide a resizable array functionality by creating a new, larger array and copying elements when capacity is exceeded. This adds overhead compared to fixed-size arrays.

---

## How the Data Structure is Implemented

In Java, arrays are objects. When an array is declared, memory is allocated for a contiguous block of elements of the specified type. The `Array` class in this project provides utility methods for common array operations, such as searching, inserting, deleting, and resizing.

---

## Known Applications

-   **Storing collections of data**: The most basic use case.
-   **Implementing other data structures**: Stacks, queues, hash tables, and heaps can be implemented using arrays.
-   **Lookup tables**: For fast retrieval of values based on an index.
-   **Image processing**: Representing pixel data.

---

## API Documentation

### `public static <T> int search(T[] array, T target)`

Performs a linear search on the given `array` to find the `target` element.

-   **Parameters:**
    -   `array`: The array to search within.
    -   `target`: The element to search for.
-   **Returns:**
    -   The index of the `target` element if found.
    -   Returns -1 if the `target` element is not found.

### `public static <T> T[] insert(T[] array, T element, int index)`

Inserts an `element` into the `array` at the specified `index`.

-   **Parameters:**
    -   `array`: The original array.
    -   `element`: The element to insert.
    -   `index`: The index at which to insert the element.
-   **Returns:**
    -   A new array with the element inserted.
-   **Throws:**
    -   `IndexOutOfBoundsException`: If the `index` is out of bounds.

### `public static <T> T[] delete(T[] array, int index)`

Deletes an element from the `array` at the specified `index`.

-   **Parameters:**
    -   `array`: The original array.
    -   `index`: The index of the element to delete.
-   **Returns:**
    -   A new array with the element deleted.
-   **Throws:**
    -   `IndexOutOfBoundsException`: If the `index` is out of bounds.

### `public static <T> T[] resize(T[] array, int newCapacity)`

Resizes the `array` to a `newCapacity`.

-   **Parameters:**
    -   `array`: The original array.
    -   `newCapacity`: The new capacity for the array.
-   **Returns:**
    -   A new array with the specified `newCapacity`, containing elements copied from the original array.
-   **Throws:**
    -   `IllegalArgumentException`: If `newCapacity` is negative.
