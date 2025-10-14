# Quick Sort

## History

Quick Sort was developed by British computer scientist Tony Hoare in 1959 while at Moscow State University. The algorithm was published in 1961.

## Algorithm Complexity

| Name | Best | Average | Worst |
|---|---|---|---|
| Time | O(n log(n)) | O(n log(n)) | O(n^2) |
| Space | O(log(n)) | O(log(n)) | O(n) |

## Comparison

| Algorithm | Time Complexity | Space Complexity |
|---|---|---|
| Quick Sort | O(n log(n)) | O(log(n)) |
| Merge Sort | O(n log(n)) | O(n) |
| Heap Sort | O(n log(n)) | O(1) |

## Known Applications

- Used in various programming languages for their built-in sorting functions.
- Used in situations where the average-case performance is more important than the worst-case performance.

## API Documentation

### `public T[] sort()`

Sorts the elements in the array.

- **Returns**: The sorted array.
