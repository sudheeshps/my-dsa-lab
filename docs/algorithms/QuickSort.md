# Quick Sort Algorithm

## Introduction

Quick Sort is an efficient, comparison-based, divide-and-conquer sorting algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted. Quick Sort is known for its speed in practice, making it one of the most widely used sorting algorithms.

---

## History

Quick Sort was developed by **Tony Hoare** in 1959 and published in 1961. It is often considered one of the top 10 algorithms of the 20th century due to its practical efficiency.

---

## Behaviour of Quick Sort

Quick Sort follows a divide-and-conquer paradigm:

1.  **Pick a Pivot**: Choose an element from the array to be the pivot. The choice of pivot significantly affects performance.
2.  **Partition**: Rearrange the array such that all elements less than the pivot come before it, and all elements greater than the pivot come after it. Elements equal to the pivot can go on either side. After partitioning, the pivot is in its final sorted position.
3.  **Recurse**: Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.

The base case for the recursion is when a sub-array has zero or one element, as it is already sorted.

---

## Algorithm Complexity

-   **Time Complexity**: `O(n log n)` on average, where `n` is the number of elements. This is due to the balanced partitioning. In the worst case (e.g., already sorted array with a naive pivot choice), it can degrade to `O(n^2)`. Randomized Quick Sort avoids the worst-case behavior with high probability.
-   **Space Complexity**: `O(log n)` on average due to the recursion stack. In the worst case, it can be `O(n)`.

---

## Comparison

-   **Merge Sort**: Both Quick Sort and Merge Sort have `O(n log n)` average time complexity. Quick Sort is generally faster in practice due to better cache performance and `O(log n)` space complexity (for recursive calls), but its worst-case is `O(n^2)`. Merge Sort guarantees `O(n log n)` in the worst case and is stable, but requires `O(n)` auxiliary space.

-   **Heap Sort**: Heap Sort also has `O(n log n)` time complexity in all cases and is an in-place algorithm (`O(1)` space). However, Quick Sort is often faster in practice.

---

## How the Algorithm is Implemented

This implementation uses a recursive `sort` method that takes `low` and `high` indices to define the current sub-array. A `partition` helper method selects a pivot (e.g., the last element) and rearranges the elements around it. The `swap` helper method is used during partitioning.

---

## Known Applications

-   **General-Purpose Sorting**: Widely used in libraries and systems for its practical speed.
-   **Hybrid Sorting Algorithms**: Often combined with Insertion Sort for small sub-arrays (e.g., Introsort).
-   **Quicksort Variants**: Used in various forms, including 3-way Quick Sort for arrays with many duplicate elements.

---

## API Documentation

### `public static <T extends Comparable<T>> void sort(T[] array)`

Sorts the given `array` in ascending order using the Quick Sort algorithm.

-   **Parameters:**
    -   `array`: The array of comparable elements to be sorted.
