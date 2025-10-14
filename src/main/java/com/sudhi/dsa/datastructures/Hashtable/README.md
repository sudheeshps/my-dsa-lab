# Hashtable Data Structure

## Introduction

A Hashtable is a data structure that stores key-value pairs. It uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found. Hashtables are widely used because they provide constant time complexity on average for insertion, deletion, and retrieval operations, making them one of the most efficient data structures for lookups.

---

## History

The concept of hashing with chaining was first introduced by **Hans Peter Luhn** at IBM in 1953. His internal memorandum used the term "hashing" and laid the groundwork for what would become one of the most fundamental data structures in computer science. The idea was independently discovered and refined by others in the following years.

---

## Properties

-   **Key-Value Pairs**: Data is stored in pairs, where a unique `key` is used to access its corresponding `value`.
-   **Hash Function**: The core of a hashtable is its hash function. This function takes a key as input and computes an integer hash code, which is then mapped to an index in the underlying array.
-   **Collision Resolution**: Since different keys can potentially hash to the same index (a "collision"), a strategy must be in place to handle this. This implementation uses **Separate Chaining**.
-   **Load Factor**: This is a measure of how full the hashtable is allowed to get before its capacity is automatically increased. It is calculated as `(number of items) / (size of array)`.

---

## How the Data Structure is Implemented

This implementation is a classic example of a hashtable that uses separate chaining and dynamic resizing.

1.  **Internal `Entry` Class**: A private `Entry<K, V>` class is used to store the key-value pairs. Each `Entry` also contains a `next` reference, allowing it to act as a node in a linked list.

2.  **Array of Buckets**: The main data store is an array of `Entry` objects, referred to as `table`. Each index in this array represents a "bucket."

3.  **Separate Chaining**: When a new key-value pair is added, its key is hashed to determine the bucket index. If the bucket is empty, the new `Entry` is placed there. If the bucket is already occupied (a collision), the new `Entry` is added to the beginning of a linked list at that bucket. The `get` and `remove` operations traverse this short linked list to find the correct key.

4.  **Dynamic Resizing**: The hashtable starts with a default capacity. When the number of entries exceeds the `loadFactor * capacity` (the `threshold`), a `resize` operation is triggered. This creates a new, larger array (typically double the size) and rehashes all existing entries into the new array. This ensures that the linked lists remain short and the O(1) average time complexity is maintained.

---

## Complexity of operations

| Operation | Average Case | Worst Case (with collisions) |
| --------- | ------------ | ---------------------------- |
| **Put**   | O(1)         | O(n)                         |
| **Get**   | O(1)         | O(n)                         |
| **Remove**| O(1)         | O(n)                         |
| **Space** | O(n)         | O(n)                         |

*The worst-case scenario occurs when all keys hash to the same bucket, effectively turning the hashtable into a linked list.*

---

## Known Applications

Hashtables are ubiquitous in software development:

-   **Database Indexing**: To quickly locate records.
-   **Caching**: To store recently accessed data for fast retrieval.
-   **Symbol Tables**: In compilers and interpreters to store information about variables and functions.
-   **Implementing other Data Structures**: Used as the foundation for `HashMap`, `HashSet`, and `Dictionary` objects in many programming languages.
-   **Associative Arrays**: Any time you need to map a unique key to a value.

---

## Comparisons

| Data Structure | Hashtable (Separate Chaining) | Balanced Binary Search Tree (e.g., AVL, Red-Black) |
| -------------- | ----------------------------- | -------------------------------------------------- |
| **Complexity** | Average: O(1), Worst: O(n)    | O(log n) for all operations                        |
| **Ordering**   | Unordered                     | Keys are always kept in sorted order.              |
| **Use Case**   | Best for fast, unordered lookups. | Best when ordered data or range queries are needed.|

---

## API Documentation

### `public V put(K key, V value)`
Associates the specified `value` with the specified `key` in this hashtable. If the key already exists, the old value is replaced.
-   **Returns:** The previous value associated with the key, or `null` if there was no mapping for the key.

### `public V get(K key)`
Returns the value to which the specified key is mapped.
-   **Returns:** The value associated with the key, or `null` if the key is not found.

### `public V remove(K key)`
Removes the mapping for the specified key from this hashtable if it is present.
-   **Returns:** The value that was associated with the key, or `null` if the key was not found.

### `public int size()`
Returns the number of key-value mappings in this hashtable.

### `public boolean isEmpty()`
Returns `true` if this hashtable contains no key-value mappings.

### `public List<K> getKeySet()`
Returns a `List` of all keys in the hashtable.

### `public List<V> getValues()`
Returns a `List` of all values in the hashtable.
