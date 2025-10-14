# Shell Sort

## History

Shell Sort was invented by Donald Shell in 1959. It is a generalization of insertion sort.

## Algorithm Complexity

| Name | Best | Average | Worst |
|---|---|---|---|
| Time | O(n log(n)) | O(n log(n)) | O(n^2) |
| Space | O(1) | O(1) | O(1) |

## Comparison

| Algorithm | Time Complexity | Space Complexity |
|---|---|---|
| Shell Sort | O(n log(n)) | O(1) |
| Insertion Sort | O(n^2) | O(1) |
| Merge Sort | O(n log(n)) | O(n) |

## Known Applications

- Used in situations where a simple algorithm is needed, but insertion sort is too slow.
- Used in the Linux kernel.

## API Documentation

### `public T[] sort()`

Sorts the elements in the array.

- **Returns**: The sorted array.
