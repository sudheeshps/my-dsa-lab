# Selection Sort Algorithm

## Introduction

Selection Sort is a simple, in-place comparison-based sorting algorithm. It works by repeatedly finding the minimum element (considering ascending order) from the unsorted part of the array and putting it at the beginning. The algorithm maintains two sub-arrays in a given array: the first sub-array is already sorted, and the second sub-array is the remaining unsorted part.

---

## History

Selection Sort is one of the most basic sorting algorithms, often used for educational purposes due to its straightforward logic. Its principles have been known for a long time.

---

## Behaviour of Selection Sort

1.  **Outer Loop**: Iterate from the first element (`i = 0`) up to the second-to-last element (`n-2`) of the array. This loop marks the boundary between the sorted and unsorted portions.
2.  **Find Minimum**: In each iteration of the outer loop, assume the current element `array[i]` is the minimum. Then, iterate through the unsorted portion of the array (from `i+1` to `n-1`) to find the actual minimum element.
3.  **Swap**: If a smaller element is found, update the index of the minimum. After the inner loop completes, swap the found minimum element with the element at `array[i]`.

After each pass, the smallest element from the unsorted part is placed into its correct position in the sorted part.

---

## Algorithm Complexity

-   **Time Complexity**: `O(n^2)` in all cases (best, average, and worst), where `n` is the number of elements. This is because it involves nested loops, each iterating up to `n` times, regardless of the initial order of elements.
-   **Space Complexity**: `O(1)`, as it sorts the array in-place and only requires a small amount of extra space for temporary variables during swaps.

---

## Comparison

-   **Bubble Sort / Insertion Sort**: Selection Sort has similar `O(n^2)` complexity to Bubble Sort and Insertion Sort. While it performs fewer swaps than Bubble Sort, it still performs `O(n^2)` comparisons, making it generally less efficient than Insertion Sort in practice for most inputs.

-   **Merge Sort / Quick Sort**: For larger datasets, more advanced algorithms like Merge Sort or Quick Sort (`O(n log n)`) are significantly more efficient.

---

## How the Algorithm is Implemented

This implementation uses two nested `for` loops. The outer loop iterates through the array, and the inner loop finds the minimum element in the remaining unsorted part. A `swap` helper method is used to exchange elements.

---

## Known Applications

-   **Educational Purposes**: Primarily used for teaching basic sorting concepts.
-   **Small Datasets**: Can be acceptable for very small arrays where simplicity is prioritized over efficiency.

---

## API Documentation

### `public static <T extends Comparable<T>> void sort(T[] array)`

Sorts the given `array` in ascending order using the Selection Sort algorithm.

-   **Parameters:**
    -   `array`: The array of comparable elements to be sorted.
