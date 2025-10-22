# Linear Search Algorithm

## Introduction

Linear search, also known as sequential search, is the simplest searching algorithm. It sequentially checks each element of the list until a match is found or the whole list has been searched. It is a straightforward and intuitive algorithm, but its efficiency decreases significantly with larger datasets.

---

## History

Linear search is one of the most basic algorithms in computer science, and its concept is as old as the idea of searching through a list of items. It doesn't have a specific inventor but is a fundamental technique.

---

## Behaviour of Linear Search

1.  **Start at the beginning**: Begin checking from the first element of the array.
2.  **Compare**: Compare the current element with the `target` element.
3.  **Match Found**: If the current element matches the `target`, return its index.
4.  **Continue or End**: If no match, move to the next element. If the end of the array is reached without finding a match, the `target` is not present in the array.

---

## Algorithm Complexity

-   **Time Complexity**: `O(n)`, where `n` is the number of elements in the array. In the worst case (target is the last element or not present), the algorithm has to check every element.
-   **Space Complexity**: `O(1)`, as it only uses a few variables for iteration and comparison.

---

## Comparison

-   **Binary Search**: For sorted arrays, binary search (`O(log n)`) is significantly faster than linear search. However, linear search does not require the array to be sorted, making it more versatile for unsorted data.

-   **Hash Table Lookups**: Hash table lookups can achieve `O(1)` average time complexity, but they require additional space for the hash table and a suitable hash function.

---

## How the Algorithm is Implemented

This implementation uses a simple `for` loop to iterate through the array from the first element to the last. Inside the loop, it compares each element with the `target` element.

---

## Known Applications

-   **Small Datasets**: When the number of elements is small, the overhead of more complex algorithms might outweigh the benefits.
-   **Unsorted Data**: When the data is not sorted and sorting it would be more expensive than a linear search.
-   **Sequential Access**: In scenarios where data is naturally accessed sequentially.

---

## API Documentation

### `public static <T> int search(T[] array, T target)`

Performs a linear search on an `array` to find the `target` element.

-   **Parameters:**
    -   `array`: The array to search within.
    -   `target`: The element to search for.
-   **Returns:**
    -   The index of the `target` element if found.
    -   Returns -1 if the `target` element is not found.
