# Set

## Introduction

A Set is an abstract data type that stores a collection of unique elements. Unlike lists or arrays, the order of elements in a set is not guaranteed, and duplicate elements are not allowed. Sets are primarily used to test for membership, insert new elements, and delete existing elements efficiently.

---

## History

The mathematical concept of a set was introduced by **Georg Cantor** in the late 19th century. In computer science, sets are fundamental and have been implemented in various forms since the early days of programming, often using hash tables or balanced binary search trees for efficient operations.

---

## Behaviour of a Set

-   **Uniqueness**: Every element in a set must be unique. Attempting to add a duplicate element will have no effect.
-   **Unordered**: Elements in a set do not have a specific order or index.
-   **Membership Testing**: Efficiently checks if an element is present in the set.

---

## Data Structure Operations

-   **`add(element)`**: `O(1)` on average (using a hash table) or `O(log n)` (using a balanced BST) - Adds an element if it's not already present.
-   **`remove(element)`**: `O(1)` on average (using a hash table) or `O(log n)` (using a balanced BST) - Removes an element if it's present.
-   **`contains(element)`**: `O(1)` on average (using a hash table) or `O(log n)` (using a balanced BST) - Checks for the presence of an element.
-   **`size()`**: `O(1)` - Returns the number of elements.

---

## Comparison

-   **vs. List/Array**: Lists and arrays allow duplicate elements and maintain order/index. Sets enforce uniqueness and do not guarantee order.
-   **Implementation**: Sets are commonly implemented using hash tables (like `HashSet` in Java) for `O(1)` average-case performance, or balanced binary search trees (like `TreeSet` in Java) for `O(log n)` guaranteed performance and ordered iteration.

---

## How the Data Structure is Implemented

This `Set` implementation uses a **`HashMap`** internally to store its unique elements. The elements added to the set are stored as keys in the `HashMap`, and a dummy `Boolean` value (e.g., `true`) is stored as the value. This leverages the `HashMap`'s ability to store unique keys and provides `O(1)` average-case time complexity for `add`, `remove`, and `contains` operations.

---

## Known Applications

-   **Membership Testing**: Quickly checking if an item is part of a collection.
-   **Removing Duplicates**: Easily filtering out duplicate elements from a list or array.
-   **Mathematical Set Operations**: Performing union, intersection, difference, and subset checks.
-   **Frequency Counting**: Counting unique items.
-   **Graph Algorithms**: Keeping track of visited nodes.

---

## API Documentation

### `public void add(T element)`

Adds an element to the set if it is not already present.

-   **Parameters:**
    -   `element`: The element to be added.

### `public void remove(T element)`

Removes the specified element from the set if it is present.

-   **Parameters:**
    -   `element`: The element to be removed.

### `public boolean contains(T element)`

Checks if the set contains the specified element.

-   **Parameters:**
    -   `element`: The element to check for.
-   **Returns:**
    -   `true` if the element is found, `false` otherwise.

### `public int size()`

Returns the number of elements in the set.

-   **Returns:**
    -   The number of elements.

### `public boolean isEmpty()`

Checks if the set is empty.

-   **Returns:**
    -   `true` if the set is empty, `false` otherwise.
