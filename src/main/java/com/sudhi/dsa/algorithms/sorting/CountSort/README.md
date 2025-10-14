# Count Sort

## History

Count Sort was invented by Harold H. Seward in 1954. It is an integer sorting algorithm that operates by counting the number of objects that have each distinct key value.

## Algorithm Complexity

- **Time Complexity**: O(n + k) in the best, average, and worst cases, where n is the number of elements and k is the range of the input.
- **Space Complexity**: O(k)

## Comparison

Count Sort is a non-comparison-based sorting algorithm, which means it is not limited by the Ω(n log n) lower bound of comparison-based sorting algorithms. It is very fast for a specific range of inputs, but it is not a general-purpose sorting algorithm.

## Known Applications

Count Sort is used when the input is a collection of objects with a known range of key values. It is often used as a subroutine in other sorting algorithms, such as Radix Sort.

## API Documentation

### `public Integer[] sort()`

Sorts the array of integers in ascending order using the Count Sort algorithm.

- **Returns**: The sorted array of integers.
