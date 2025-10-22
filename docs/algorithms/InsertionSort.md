# Insertion Sort Algorithm

## Introduction

Insertion Sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as Quick Sort, Heap Sort, or Merge Sort. However, it has several advantages: it is simple to implement, efficient for small data sets, and more efficient than other `O(n^2)` algorithms like Bubble Sort or Selection Sort in practice.

---

## History

Insertion Sort is a very intuitive sorting method, similar to how one might sort a hand of playing cards. Its principles have been known and used for a long time in various forms.

---

## Behaviour of Insertion Sort

1.  **Start from Second Element**: The first element is considered sorted. Start iterating from the second element (`i = 1`) up to the last element of the array.
2.  **Pick Key**: For each element `array[i]`, consider it as the `key` to be inserted into the already sorted portion of the array (`array[0...i-1]`).
3.  **Shift Elements**: Compare `key` with elements in the sorted portion, moving from right to left (`j = i-1` down to `0`). If an element `array[j]` is greater than `key`, shift it one position to the right (`array[j+1] = array[j]`).
4.  **Insert Key**: Continue shifting until an element smaller than or equal to `key` is found, or the beginning of the array is reached. Insert `key` into the correct position (`array[j+1] = key`).

---

## Algorithm Complexity

-   **Time Complexity**: `O(n^2)` in the worst and average cases, where `n` is the number of elements. This occurs when the array is sorted in reverse order. In the best case (array is already sorted), it is `O(n)` because only `n` comparisons are needed.
-   **Space Complexity**: `O(1)`, as it sorts the array in-place and only requires a small amount of extra space for temporary variables.

---

## Comparison

-   **Bubble Sort / Selection Sort**: Insertion Sort generally outperforms Bubble Sort and Selection Sort for most inputs due to fewer comparisons and swaps on average, especially for partially sorted arrays.

-   **Merge Sort / Quick Sort**: For larger datasets, `O(n log n)` algorithms like Merge Sort and Quick Sort are significantly more efficient.

---

## How the Algorithm is Implemented

This implementation uses a nested loop structure. The outer loop iterates through the unsorted part of the array, picking one element at a time. The inner loop shifts elements in the sorted part to make space for the picked element.

---

## Known Applications

-   **Small Datasets**: Efficient for sorting small arrays.
-   **Nearly Sorted Data**: Performs very well when the input array is already mostly sorted.
-   **Online Algorithms**: Can sort a list as it receives new elements.
-   **Hybrid Sorting Algorithms**: Used as a subroutine in more complex algorithms (e.g., Timsort, Introsort) for sorting small partitions.

---

## API Documentation

### `public static <T extends Comparable<T>> void sort(T[] array)`

Sorts the given `array` in ascending order using the Insertion Sort algorithm.

-   **Parameters:**
    -   `array`: The array of comparable elements to be sorted.
