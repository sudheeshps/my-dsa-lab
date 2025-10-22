# Bubble Sort Algorithm

## Introduction

Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. The algorithm gets its name from the way smaller or larger elements "bubble" to their correct positions.

---

## History

Bubble Sort is one of the oldest and simplest sorting algorithms. While not efficient for large datasets, it is often used as a teaching tool to introduce the concept of sorting algorithms due to its straightforward logic.

---

## Behaviour of Bubble Sort

1.  **Outer Loop**: Iterate from the first element to the second-to-last element (`n-1` passes).
2.  **Inner Loop**: For each pass, iterate from the first element to the `(n-i-1)`-th element (where `i` is the current pass number).
3.  **Comparison and Swap**: Compare the current element with the next element.
    a.  If the current element is greater than the next element, swap them.
4.  **Optimization**: An optimization can be added: if no swaps occur during a pass, the array is sorted, and the algorithm can terminate early.

After each pass, the largest unsorted element "bubbles up" to its correct position at the end of the unsorted portion of the array.

---

## Algorithm Complexity

-   **Time Complexity**: `O(n^2)` in the worst and average cases, where `n` is the number of elements. This is because it involves nested loops, each iterating up to `n` times. In the best case (array is already sorted with the optimization), it is `O(n)`.
-   **Space Complexity**: `O(1)`, as it only requires a small amount of extra space for temporary variables during swaps.

---

## Comparison

-   **Insertion Sort / Selection Sort**: Bubble Sort has similar `O(n^2)` complexity to Insertion Sort and Selection Sort. However, it generally performs worse than these two in practice due to more swaps.

-   **Merge Sort / Quick Sort**: For larger datasets, more advanced algorithms like Merge Sort or Quick Sort (`O(n log n)`) are significantly more efficient.

---

## How the Algorithm is Implemented

This implementation uses two nested `for` loops. The outer loop controls the number of passes, and the inner loop performs comparisons and swaps of adjacent elements. A boolean flag (`swapped`) is used for the optimization to detect if the array becomes sorted early.

---

## Known Applications

-   **Educational Purposes**: Primarily used for teaching basic sorting concepts.
-   **Small Datasets**: Can be acceptable for very small arrays where simplicity is prioritized over efficiency.

---

## API Documentation

### `public static <T extends Comparable<T>> void sort(T[] array)`

Sorts the given `array` in ascending order using the Bubble Sort algorithm.

-   **Parameters:**
    -   `array`: The array of comparable elements to be sorted.
