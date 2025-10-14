# Iterative Binary Search

## Introduction

Binary search is a highly efficient search algorithm that finds the position of a target value within a sorted array. It works by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, the search narrows to the lower half; otherwise, it narrows to the upper half. This process is repeated until the value is found or the interval is empty.

This implementation uses an iterative approach with a `while` loop.

## History

The idea of binary search was first described by John Mauchly in 1946 during the Moore School Lectures. The first published implementation appeared in 1957. The algorithm has been a fundamental concept in computer science ever since.

## Algorithm Complexity

### Time Complexity

*   **Best Case:** `O(1)` - The element is found at the middle of the array on the first try.
*   **Average Case:** `O(log n)` - The search space is halved in each step.
*   **Worst Case:** `O(log n)` - The element is not in the array, or it is found at the last step.

### Space Complexity

*   **`O(1)`** - The iterative version of binary search uses a constant amount of extra space for variables (low, high, mid).

## Comparison

*   **vs. Linear Search:** Binary search is significantly faster (`O(log n)` vs. `O(n)`) but requires the array to be sorted first.
*   **vs. Recursive Binary Search:** Both have the same time complexity. The iterative version is generally preferred as it avoids the overhead of function calls and the risk of a stack overflow error for very large arrays.

## Known Applications

*   **Searching in large, sorted datasets:** This is the primary use case, such as looking up a word in a dictionary or a value in a database index.
*   **Finding the lower/upper bound:** Modifying the algorithm to find the first or last occurrence of an element.
*   **As a basis for more complex algorithms:** Used in algorithms for finding the square root of a number or solving certain optimization problems.

## API Documentation

### `public int search(T key)`

Performs an iterative binary search on the sorted array to find the specified key.

*   **Parameters**:
    *   `key`: The element to search for.
*   **Returns**:
    *   The index of the `key` in the array.
    *   `-1` if the `key` is not found in the array.
