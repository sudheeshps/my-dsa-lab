# Count Sort Algorithm

## Introduction

Counting Sort is a non-comparative sorting algorithm that works by counting the number of occurrences of each distinct element in the input array. It then uses these counts to determine the positions of each element in the sorted output array. Counting Sort is efficient for sorting data with a small range of non-negative integer keys.

---

## History

Counting Sort was introduced by **Harold H. Seward** in 1954. It is a foundational algorithm for understanding other non-comparative sorts like Radix Sort.

---

## Behaviour of Count Sort

1.  **Find Range**: Determine the maximum value (`max`) in the input array. This defines the range of keys.
2.  **Create Count Array**: Create a `count` array of size `max + 1`, initialized to zeros. This array will store the frequency of each element.
3.  **Populate Count Array**: Iterate through the input array and increment the count for each element in the `count` array.
4.  **Modify Count Array (Cumulative Sum)**: Iterate through the `count` array and update each element to store the cumulative sum of counts. This means `count[i]` will now store the number of elements less than or equal to `i`. This step helps in determining the correct position of each element in the output array.
5.  **Build Output Array**: Create an `output` array of the same size as the input array. Iterate through the input array from right to left:
    a.  Place the current element `array[j]` into `output[count[array[j]] - 1]`.
    b.  Decrement `count[array[j]]`.
6.  **Copy to Original**: Copy the elements from the `output` array back to the original input array.

---

## Algorithm Complexity

-   **Time Complexity**: `O(n + k)`, where `n` is the number of elements in the input array and `k` is the range of input values (i.e., `max - min + 1`). This is highly efficient when `k` is not significantly larger than `n`.
-   **Space Complexity**: `O(n + k)` to store the `count` array and the `output` array.

---

## Comparison

-   **Comparison-based Sorts (e.g., Quick Sort, Merge Sort)**: Counting Sort is faster than comparison-based sorts (`O(n log n)`) when `k` is small. However, it is not suitable for large `k` values or non-integer data.

-   **Radix Sort**: Counting Sort is often used as a subroutine in Radix Sort, which can sort integers with a larger range by applying Counting Sort digit by digit.

---

## How the Algorithm is Implemented

This implementation first finds the maximum element to determine the size of the `count` array. It then populates the `count` array with frequencies, converts it to cumulative frequencies, and finally uses these cumulative frequencies to place elements into a temporary `output` array, which is then copied back to the original array.

---

## Known Applications

-   **Sorting Integers with Small Range**: Efficiently sorting arrays of integers where the range of values is limited.
-   **Subroutine in Radix Sort**: Used as a stable sorting algorithm for each digit in Radix Sort.
-   **Data Processing**: When dealing with frequency counts of discrete data.

---

## API Documentation

### `public static void sort(int[] array)`

Sorts the given `array` of non-negative integers in ascending order using the Counting Sort algorithm.

-   **Parameters:**
    -   `array`: The array of non-negative integers to be sorted.
