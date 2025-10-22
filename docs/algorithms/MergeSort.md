# Merge Sort Algorithm

## Introduction

Merge Sort is an efficient, comparison-based, divide-and-conquer sorting algorithm. It works by dividing an unsorted list into `n` sublists, each containing one element (a list of one element is considered sorted). Then, it repeatedly merges sublists to produce new sorted sublists until there is only one sorted list remaining. Merge Sort is known for its stable performance and guaranteed `O(n log n)` time complexity.

---

## History

Merge Sort was invented by **John von Neumann** in 1945. It is one of the earliest and most influential sorting algorithms, laying the groundwork for many other divide-and-conquer algorithms.

---

## Behaviour of Merge Sort

Merge Sort consists of two main steps:

1.  **Divide**: Recursively divide the unsorted list into two sublists of about half the size until each sublist contains only one element.
2.  **Conquer (Merge)**: Repeatedly merge sublists to produce new sorted sublists. The merging process compares elements from the two sublists and places them into a new sorted list in the correct order. This continues until there is only one sorted list.

The key operation is the `merge` function, which takes two sorted sublists and combines them into a single sorted list.

---

## Algorithm Complexity

-   **Time Complexity**: `O(n log n)` in all cases (best, average, and worst), where `n` is the number of elements. The `log n` factor comes from the number of times the list is divided, and the `n` factor comes from the merging process, which takes linear time.
-   **Space Complexity**: `O(n)` because it requires an auxiliary array of size `n` for merging the sublists. While there are in-place merge sort variations, they are often more complex or have higher constant factors.

---

## Comparison

-   **Quick Sort**: Both Merge Sort and Quick Sort have `O(n log n)` average time complexity. Quick Sort is often faster in practice due to better cache performance and `O(log n)` space complexity (for recursive calls), but its worst-case is `O(n^2)`. Merge Sort guarantees `O(n log n)` in the worst case and is stable, but requires `O(n)` auxiliary space.

-   **Heap Sort**: Heap Sort also has `O(n log n)` time complexity in all cases and is an in-place algorithm (`O(1)` space). However, Merge Sort is a stable sorting algorithm, which Heap Sort is not.

---

## How the Algorithm is Implemented

This implementation uses a recursive `sort` method that divides the array into two halves. A `merge` helper method then combines these two sorted halves into a single sorted array. A temporary array is used during the merging process.

---

## Known Applications

-   **External Sorting**: When data to be sorted is too large to fit into memory.
-   **Linked Lists**: Merge Sort is particularly well-suited for sorting linked lists because it doesn't require random access to elements.
-   **Parallel Sorting**: Easily parallelizable due to its divide-and-conquer nature.
-   **Hybrid Sorting Algorithms**: Used as a component in algorithms like Timsort (used in Python and Java) and Introsort.

---

## API Documentation

### `public static <T extends Comparable<T>> void sort(T[] array)`

Sorts the given `array` in ascending order using the Merge Sort algorithm.

-   **Parameters:**
    -   `array`: The array of comparable elements to be sorted.
