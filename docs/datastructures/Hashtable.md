# Hashtable

## Introduction

A hashtable (also known as a hash map) is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hashtable uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found. This allows for very efficient average-case performance for insertions, deletions, and lookups.

---

## History

The concept of hashing and hashtables emerged in the 1950s. **Hans Peter Luhn** of IBM is credited with the idea of hashing for data storage and retrieval in 1953. Since then, various collision resolution techniques and hash functions have been developed to optimize hashtable performance.

---

## Behaviour of a Hashtable

-   **Hash Function**: A function that converts a key into an integer index within the array of buckets. A good hash function distributes keys uniformly across the buckets.
-   **Collision Resolution**: When two different keys hash to the same index, a collision occurs. Common strategies to handle collisions include:
    -   **Separate Chaining**: Each bucket is a linked list (or another data structure) that stores all elements that hash to that index.
    -   **Open Addressing**: If a bucket is occupied, the algorithm probes for another open bucket (e.g., linear probing, quadratic probing, double hashing).
-   **Load Factor**: The ratio of the number of elements to the number of buckets. When the load factor exceeds a certain threshold, the hashtable is typically resized (rehashed) to maintain performance.

---

## Data Structure Operations

-   **Insertion**: `O(1)` on average, `O(n)` in worst case (due to collisions or resizing).
-   **Deletion**: `O(1)` on average, `O(n)` in worst case.
-   **Search**: `O(1)` on average, `O(n)` in worst case.

---

## Comparison

-   **vs. Balanced Binary Search Tree (e.g., AVL, Red-Black Tree)**: Hashtables offer `O(1)` average-case performance, which is faster than `O(log n)` for balanced BSTs. However, BSTs provide ordered data and guaranteed `O(log n)` worst-case performance, whereas hashtables can degrade to `O(n)` in the worst case.
-   **vs. Direct Address Table**: Direct address tables offer `O(1)` for all operations but require keys to be small integers and a large amount of memory if the key range is large.

---

## How the Data Structure is Implemented

This `Hashtable` implementation uses **separate chaining** to handle collisions. Internally, it uses an array of `LinkedList` objects (or `ArrayList` of `LinkedList` for dynamic resizing). Each `LinkedList` stores `Entry` objects, where an `Entry` contains a `key` and a `value`.

-   **`hash(K key)`**: A private method that computes the hash code for a given key and maps it to an index within the bucket array.
-   **`resize()`**: A private method that doubles the capacity of the hashtable and rehashes all existing entries when the load factor exceeds a threshold.

---

## Known Applications

-   **Symbol Tables**: In compilers and interpreters to store information about identifiers.
-   **Database Indexing**: For fast lookup of records.
-   **Caches**: For storing frequently accessed data.
-   **Associative Arrays**: In many programming languages (e.g., Python dictionaries, JavaScript objects).
-   **Set Implementations**: To store unique elements.

---

## API Documentation

### `public void put(K key, V value)`

Inserts a key-value pair into the hashtable. If the key already exists, its value is updated.

-   **Parameters:**
    -   `key`: The key to be inserted.
    -   `value`: The value associated with the key.

### `public V get(K key)`

Retrieves the value associated with the specified key.

-   **Parameters:**
    -   `key`: The key whose associated value is to be returned.
-   **Returns:**
    -   The value associated with the key, or `null` if the key is not found.

### `public V remove(K key)`

Removes the key-value pair associated with the specified key.

-   **Parameters:**
    -   `key`: The key to be removed.
-   **Returns:**
    -   The value previously associated with the key, or `null` if the key was not found.

### `public boolean containsKey(K key)`

Checks if the hashtable contains the specified key.

-   **Parameters:**
    -   `key`: The key to check for.
-   **Returns:**
    -   `true` if the key exists, `false` otherwise.

### `public int size()`

Returns the number of key-value pairs in the hashtable.

-   **Returns:**
    -   The number of entries.

### `public boolean isEmpty()`

Checks if the hashtable is empty.

-   **Returns:**
    -   `true` if the hashtable is empty, `false` otherwise.
