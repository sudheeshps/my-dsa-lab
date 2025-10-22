# Heap Sort Algorithm

## Introduction

Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. It is an in-place algorithm, meaning it sorts the array within the original memory space. Heap Sort is known for its `O(n log n)` time complexity, making it efficient for large datasets, and its guarantee of this performance in the worst case, unlike Quick Sort.

---

## History

Heap Sort was invented by **J. W. J. Williams** in 1964, who also introduced the heap data structure. It was further refined by **Robert W. Floyd** in the same year, who published an improved version that could sort an array in-place.

---

## Behaviour of Heap Sort

Heap Sort can be divided into two main phases:

1.  **Heapify (Build Max-Heap)**: Convert the input array into a max-heap. A max-heap is a complete binary tree where the value of each node is greater than or equal to the value of its children. This is typically done by starting from the last non-leaf node and calling a `heapify` (or `sift-down`) procedure on each node up to the root.
2.  **Sort (Extract Elements)**: Repeatedly extract the maximum element from the heap and place it at the end of the sorted portion of the array.
    a.  Swap the root (largest element) with the last element of the heap.
    b.  Reduce the size of the heap by one.
    c.  Heapify the new root to restore the max-heap property.
    d.  Repeat until the heap size is 1.

---

## Algorithm Complexity

-   **Time Complexity**: `O(n log n)` in all cases (best, average, and worst), where `n` is the number of elements. Building the heap takes `O(n)` time, and extracting `n` elements takes `O(n log n)` time (each extraction involves a `log n` heapify operation).
-   **Space Complexity**: `O(1)` for an in-place implementation, as it only requires a small amount of extra space for temporary variables during swaps.

---

## Comparison

-   **Quick Sort**: Both Heap Sort and Quick Sort have `O(n log n)` average time complexity. Quick Sort is generally faster in practice due to better cache performance and smaller constant factors, but its worst-case time complexity is `O(n^2)`. Heap Sort guarantees `O(n log n)` in the worst case.

-   **Merge Sort**: Merge Sort also has `O(n log n)` time complexity in all cases but requires `O(n)` auxiliary space, making Heap Sort more space-efficient for in-place sorting.

-   **Selection Sort**: Heap Sort can be seen as an optimized version of Selection Sort. Selection Sort repeatedly finds the maximum element and puts it at the end, taking `O(n^2)` time. Heap Sort uses a heap to find the maximum element more efficiently.

---

## How the Algorithm is Implemented

This implementation includes a `heapify` helper method that maintains the max-heap property. The `sort` method first builds a max-heap from the input array and then repeatedly extracts the maximum element and places it in its sorted position.

---

## Known Applications

-   **Priority Queues**: The heap data structure itself is fundamental to priority queues, which are used in various algorithms (e.g., Dijkstra's algorithm).
-   **Embedded Systems**: Where memory is limited, and `O(1)` space complexity is crucial.
-   **Operating Systems**: For scheduling tasks based on priority.

---

## API Documentation

### `public static <T extends Comparable<T>> void sort(T[] array)`

Sorts the given `array` in ascending order using the Heap Sort algorithm.

-   **Parameters:**
    -   `array`: The array of comparable elements to be sorted.
