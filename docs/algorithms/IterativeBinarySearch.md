# Iterative Binary Search Algorithm

## Introduction

Binary search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one. This iterative version of binary search uses a loop to perform the search, avoiding recursion.

---

## History

Binary search is a classic algorithm, with its origins dating back to the 1940s. It is a fundamental algorithm taught in introductory computer science courses due to its efficiency and elegance.

---

## Behaviour of Iterative Binary Search

1.  **Initialization**: Set `low` to the first index and `high` to the last index of the sorted array.
2.  **Loop**: While `low` is less than or equal to `high`:
    a.  Calculate `mid` as the average of `low` and `high`.
    b.  Compare the element at `mid` with the `target`:
        i.  If `array[mid]` equals `target`, the item is found. Return `mid`.
        ii. If `array[mid]` is less than `target`, the `target` must be in the right half. Set `low = mid + 1`.
        iii. If `array[mid]` is greater than `target`, the `target` must be in the left half. Set `high = mid - 1`.
3.  **Not Found**: If the loop finishes, the `target` was not found in the array. Return -1.

---

## Algorithm Complexity

-   **Time Complexity**: `O(log n)`, where `n` is the number of elements in the array. This is because the algorithm repeatedly halves the search space.
-   **Space Complexity**: `O(1)`, as it only uses a few variables for `low`, `high`, and `mid`.

---

## Comparison

-   **Linear Search**: Linear search has a time complexity of `O(n)`, making binary search significantly faster for large arrays. However, linear search does not require the array to be sorted.

-   **Recursive Binary Search**: Both iterative and recursive binary search have the same time and space complexity (ignoring the recursion stack overhead). The iterative version avoids potential stack overflow issues for very large arrays.

---

## How the Algorithm is Implemented

This iterative implementation uses a `while` loop to repeatedly narrow down the search range. It calculates the `mid` index and adjusts the `low` or `high` pointers based on the comparison with the target element.

---

## Known Applications

-   **Searching in Databases**: Efficiently locating records in sorted data.
-   **Dictionary Lookups**: Finding words in a sorted dictionary.
-   **Debugging**: In a sorted list of events, finding a specific event.
-   **Game Development**: Quickly finding elements in sorted lists (e.g., collision detection).

---

## API Documentation

### `public static <T extends Comparable<T>> int search(T[] array, T target)`

Performs an iterative binary search on a sorted `array` to find the `target` element.

-   **Parameters:**
    -   `array`: The sorted array to search within.
    -   `target`: The element to search for.
-   **Returns:**
    -   The index of the `target` element if found.
    -   Returns -1 if the `target` element is not found.
