# Recursive Binary Search Algorithm

## Introduction

Binary search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one. This recursive version of binary search uses function calls to perform the search, often leading to more concise code.

---

## History

Binary search is a classic algorithm, with its origins dating back to the 1940s. It is a fundamental algorithm taught in introductory computer science courses due to its efficiency and elegance.

---

## Behaviour of Recursive Binary Search

1.  **Base Case**: If the `low` index exceeds the `high` index, the `target` is not in the current sub-array. Return -1.
2.  **Midpoint Calculation**: Calculate `mid` as the average of `low` and `high`.
3.  **Comparison**: Compare the element at `mid` with the `target`:
    a.  If `array[mid]` equals `target`, the item is found. Return `mid`.
    b.  If `array[mid]` is less than `target`, the `target` must be in the right half. Recursively call binary search on the sub-array from `mid + 1` to `high`.
    c.  If `array[mid]` is greater than `target`, the `target` must be in the left half. Recursively call binary search on the sub-array from `low` to `mid - 1`.

---

## Algorithm Complexity

-   **Time Complexity**: `O(log n)`, where `n` is the number of elements in the array. This is because the algorithm repeatedly halves the search space.
-   **Space Complexity**: `O(log n)` due to the recursion stack. In the worst case (e.g., searching in a very large array), the recursion depth can be `log n`.

---

## Comparison

-   **Linear Search**: Linear search has a time complexity of `O(n)`, making binary search significantly faster for large arrays. However, linear search does not require the array to be sorted.

-   **Iterative Binary Search**: Both iterative and recursive binary search have the same time complexity. The iterative version has `O(1)` space complexity, while the recursive version has `O(log n)` due to the recursion stack. For very large arrays, the iterative version might be preferred to avoid stack overflow issues.

---

## How the Algorithm is Implemented

This recursive implementation uses a helper method that takes `low` and `high` indices as parameters to define the current search range. The base case handles when the element is not found, and recursive calls narrow down the search space.

---

## Known Applications

-   **Searching in Databases**: Efficiently locating records in sorted data.
-   **Dictionary Lookups**: Finding words in a sorted dictionary.
-   **Debugging**: In a sorted list of events, finding a specific event.
-   **Game Development**: Quickly finding elements in sorted lists (e.g., collision detection).

---

## API Documentation

### `public static <T extends Comparable<T>> int search(T[] array, T target)`

Performs a recursive binary search on a sorted `array` to find the `target` element.

-   **Parameters:**
    -   `array`: The sorted array to search within.
    -   `target`: The element to search for.
-   **Returns:**
    -   The index of the `target` element if found.
    -   Returns -1 if the `target` element is not found.
