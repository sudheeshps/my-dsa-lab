# Set Data Structure

## Introduction

A Set is a data structure that stores a collection of unique elements. It does not allow duplicate values. The primary operations on a set are adding elements, removing elements, and checking for the presence of an element. The order of elements in a set is generally not guaranteed.

---

## History

The concept of a set is fundamental to mathematics and was formalized in the late 19th century by **Georg Cantor**. In computer science, sets were adopted early on as an abstract data type. Implementations are often based on hash tables (for hash sets) or balanced binary search trees (for tree sets).

---

## Properties

-   **Uniqueness**: A set cannot contain duplicate elements. All elements must be unique.
-   **Unordered (in this case)**: Because this set is implemented with a hashtable, the order of elements is not maintained.
-   **Membership Testing**: Sets provide a highly efficient way to check if an element is part of a collection.

---

## How the Data Structure is Implemented

This `Set` implementation is a classic example of using composition. It is built **on top of the existing `Hashtable` class**.

-   **Underlying Container**: A private `Hashtable<T, Object>` instance is used as the internal data store.
-   **Key-Only Storage**: The set stores its elements as the *keys* of the internal hashtable. The *value* associated with each key is a constant, dummy `Object`. This is a common and effective way to implement a set using a map.
-   **Method Delegation**: The public methods of the `Set` class delegate their work to the methods of the internal `Hashtable`:
    -   `add(T item)` calls `hashtable.put(item, DUMMY)`.
    -   `remove(T item)` calls `hashtable.remove(item)`.
    -   `contains(T item)` checks if `hashtable.get(item)` is not `null`.

---

## Complexity of operations

Since this set is implemented with a hashtable, its performance characteristics are directly inherited from the hashtable.

| Operation      | Average Case | Worst Case |
| -------------- | ------------ | ---------- |
| **Add**        | O(1)         | O(n)       |
| **Remove**     | O(1)         | O(n)       |
| **Contains**   | O(1)         | O(n)       |
| **Space**      | O(n)         | O(n)       |

*The worst-case scenario occurs when all elements hash to the same bucket in the underlying hashtable.*

---

## Known Applications

-   **Data Deduplication**: Removing duplicate entries from a list of items.
-   **Membership Testing**: Quickly checking if an item belongs to a group (e.g., checking if a user is a member of a group).
-   **Mathematical Operations**: Performing union, intersection, and difference operations on collections of data.
-   **Graph Algorithms**: Keeping track of visited nodes during a graph traversal.

---

## Comparisons

| Data Structure | Set (Hashtable-based)             | List (Array-based)                |
| -------------- | --------------------------------- | --------------------------------- |
| **Uniqueness** | Enforces unique elements.         | Allows duplicate elements.        |
| **Ordering**   | Unordered.                        | Ordered by index.                 |
| **Contains**   | O(1) on average.                  | O(n) - requires a linear scan.    |

---

## API Documentation

### `public Set(int capacity)`
Constructs a new set with a specified initial capacity for the underlying hashtable.

### `public void add(T item)`
Adds an element to the set. If the element already exists, the set remains unchanged.

### `public void remove(T item)`
Removes the specified element from the set if it is present.

### `public boolean contains(T item)`
Returns `true` if the set contains the specified element.

### `public boolean isEmpty()`
Returns `true` if the set contains no elements.

### `public int size()`
Returns the number of elements in the set.
