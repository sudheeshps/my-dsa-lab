# Recursive Binary Search

## Introduction

Binary search is a highly efficient search algorithm that finds the position of a target value within a sorted array. It works by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, the search narrows to the lower half; otherwise, it narrows to the upper half. This process is repeated until the value is found or the interval is empty.

This implementation uses a recursive approach.

## History

The idea of binary search was first described by John Mauchly in 1946 during the Moore School Lectures. The first published implementation appeared in 1957. The algorithm has been a fundamental concept in computer science ever since.

## Algorithm Complexity

### Time Complexity

*   **Best Case:** `O(1)` - The element is found at the middle of the array on the first try.
*   **Average Case:** `O(log n)` - The search space is halved in each step.
*   **Worst Case:** `O(log n)` - The element is not in the array, or it is found at the last step.

### Space Complexity

*   **`O(log n)`** - The recursive version of binary search uses space on the call stack for each recursive call. In the worst case, the number of calls is proportional to `log n`.

## Comparison

*   **vs. Linear Search:** Binary search is significantly faster (`O(log n)` vs. `O(n)`) but requires the array to be sorted first.
*   **vs. Iterative Binary Search:** Both have the same time complexity. The recursive version can be more intuitive to write but carries the risk of a stack overflow error for very large arrays and has a higher space complexity due to the call stack.

## Known Applications

*   **Searching in large, sorted datasets:** This is the primary use case, such as looking up a word in a dictionary or a value in a database index.
*   **Finding the lower/upper bound:** Modifying the algorithm to find the first or last occurrence of an element.
*   **As a basis for more complex algorithms:** Used in algorithms for finding the square root of a number or solving certain optimization problems.

## API Documentation

### `public int search(T key)`

Performs a recursive binary search on the sorted array to find the specified key.

*   **Parameters**:
    *   `key`: The element to search for.
*   **Returns**:
    *   The index of the `key` in the array.
    *   `-1` if the `key` is not found in the array.
