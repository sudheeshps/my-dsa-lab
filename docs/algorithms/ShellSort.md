# Shell Sort Algorithm

## Introduction

Shell Sort is an in-place comparison sort that can be seen as a generalization of insertion sort. It improves upon insertion sort by allowing the exchange of items that are far apart. The idea is to arrange the list of elements in a specific order based on a chosen 'gap' or 'interval'. This process is repeated with decreasing gap sizes until the last gap size is 1, at which point it becomes a regular insertion sort, but on a nearly sorted array.

---

## History

Shell Sort was invented by **Donald Shell** in 1959. It was one of the first algorithms to break the `O(n^2)` barrier for sorting algorithms, making it a significant advancement at the time.

---

## Behaviour of Shell Sort

1.  **Choose Gaps**: Select a sequence of gap sizes (e.g., `n/2, n/4, ..., 1`). The choice of gap sequence significantly impacts performance.
2.  **H-Sorted Array**: For each gap `h` in the sequence, perform an `h`-sort. An `h`-sort is essentially an insertion sort on sub-arrays formed by elements `h` positions apart. For example, if `h=3`, it sorts `(array[0], array[3], array[6], ...)`, then `(array[1], array[4], array[7], ...)`, and so on.
3.  **Decrease Gap**: After an `h`-sort, decrease the gap size and repeat the process. The final pass always uses a gap of 1, which is a standard insertion sort. Because previous passes have already partially sorted the array, this final insertion sort is very efficient.

---

## Algorithm Complexity

-   **Time Complexity**: The time complexity of Shell Sort is highly dependent on the chosen gap sequence. It can range from `O(n log^2 n)` to `O(n^(4/3))` or `O(n^(3/2))` for various gap sequences. In the worst case, it can still be `O(n^2)` for some poor gap sequences. However, for practical purposes, it often performs much better than `O(n^2)` algorithms.
-   **Space Complexity**: `O(1)`, as it sorts the array in-place and only requires a small amount of extra space for temporary variables.

---

## Comparison

-   **Insertion Sort**: Shell Sort is a direct improvement over Insertion Sort. While Insertion Sort only compares adjacent elements, Shell Sort allows comparisons and swaps of elements far apart, reducing the number of shifts required for elements to reach their correct positions.

-   **Quick Sort / Merge Sort**: For very large datasets, `O(n log n)` algorithms like Quick Sort and Merge Sort are generally faster. However, Shell Sort can be competitive for moderately sized arrays and has the advantage of being in-place.

---

## How the Algorithm is Implemented

This implementation uses a common gap sequence (e.g., `n/2, n/4, ...`). It has an outer loop for the gap sizes and an inner loop that performs an insertion sort-like operation for each `h`-sorted sub-array.

---

## Known Applications

-   **Embedded Systems**: Where memory is limited, and `O(1)` space complexity is crucial.
-   **Small to Medium Datasets**: Can be efficient for arrays that are not extremely large.
-   **Educational Purposes**: Demonstrates an improvement over basic `O(n^2)` sorts.

---

## API Documentation

### `public static <T extends Comparable<T>> void sort(T[] array)`

Sorts the given `array` in ascending order using the Shell Sort algorithm.

-   **Parameters:**
    -   `array`: The array of comparable elements to be sorted.
