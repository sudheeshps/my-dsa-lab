# Linear Search

## Introduction

Linear search, also known as sequential search, is the most basic search algorithm. It sequentially checks each element of a list until a match is found or the whole list has been searched.

## History

Linear search is the most intuitive way to find an item in a list and has been used since the earliest days of computing. It doesn't have a specific inventor or date of discovery as it represents a fundamental, trivial approach to searching.

## Algorithm Complexity

### Time Complexity

*   **Best Case:** `O(1)` - The element is found at the first position.
*   **Average Case:** `O(n)` - The element is found somewhere in the middle of the list.
*   **Worst Case:** `O(n)` - The element is at the last position or not in the list at all.

### Space Complexity

*   **`O(1)`** - The algorithm uses a constant amount of extra space.

## Comparison

*   **vs. Binary Search:** Linear search is much slower than binary search on sorted arrays. However, it has the significant advantage of not requiring the data to be sorted beforehand.
*   **vs. Hash Table Search:** Searching in a hash table has an average time complexity of `O(1)`, which is much faster than linear search. However, hash tables require extra space for the table itself and a good hash function.

## Known Applications

*   **Small or Unsorted Datasets:** It is simple to implement and efficient for small lists (e.g., under 100 elements).
*   **Checking for an item's existence:** When the list is unsorted and you only need to do a single search.
*   **Educational Purposes:** It is often the first searching algorithm taught due to its simplicity.

## API Documentation

### `public int search(T key)`

Performs a linear search on the array to find the specified key.

*   **Parameters**:
    *   `key`: The element to search for.
*   **Returns**:
    *   The index of the first occurrence of the `key` in the array.
    *   `-1` if the `key` is not found in the array.
