# Selection Sort

## History

The origin of Selection Sort is not attributed to a single person, but it is a simple, intuitive sorting algorithm that has been known for a long time.

## Algorithm Complexity

| Name | Best | Average | Worst |
|---|---|---|---|
| Time | O(n^2) | O(n^2) | O(n^2) |
| Space | O(1) | O(1) | O(1) |

## Comparison

| Algorithm | Time Complexity | Space Complexity |
|---|---|---|
| Selection Sort | O(n^2) | O(1) |
| Insertion Sort | O(n^2) | O(1) |
| Bubble Sort | O(n^2) | O(1) |

## Known Applications

- Useful when memory write operations are costly, as it makes at most n swaps.
- Used for small lists.

## API Documentation

### `public T[] sort()`

Sorts the elements in the array.

- **Returns**: The sorted array.
