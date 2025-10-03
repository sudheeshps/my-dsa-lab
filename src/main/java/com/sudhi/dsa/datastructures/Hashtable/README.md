# Hashtable Data Structure

This is a generic Hashtable implementation that can store key-value pairs. It uses a list of lists to handle collisions (separate chaining).

## Usage

To use the `Hashtable` class, you first need to create an instance of it, specifying the initial capacity:

```java
Hashtable<String, Integer> myHashtable = new Hashtable<>(10);
```

## Method Descriptions

*   `put(K key, V value)`: Adds a key-value pair to the hashtable. If the key already exists, its value is updated. Throws an exception if the hashtable is at full capacity.

*   `get(K key)`: Retrieves the value associated with the given key. Returns `null` if the key is not found.

*   `remove(K key)`: Removes the key-value pair associated with the given key. Returns the removed value, or `null` if the key was not found.

*   `size()`: Returns the number of key-value pairs in the hashtable.

*   `isEmpty()`: Returns `true` if the hashtable is empty, `false` otherwise.

*   `getKeySet()`: Returns a `List` of all keys in the hashtable.

*   `getValues()`: Returns a `List` of all values in the hashtable.
