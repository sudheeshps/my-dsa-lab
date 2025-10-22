package com.sudhi.dsa.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class PriorityQueue<T> {

    // The number of elements currently inside the heap
    private int heapSize = 0;

    

    // A dynamic list to track the elements inside the heap
    private List<T> heap = null;

    // A map to keep track of the possible indices a certain node value is at.
    // Key: element, Value: List of indices where element is found
    private java.util.Map<T, java.util.TreeSet<Integer>> map = new java.util.HashMap<>();

    // Comparator for heap elements
    private Comparator<T> comparator;

    // Constructs a PQ with an initial capacity
    public PriorityQueue(int sz) {
        this(sz, null);
    }

    public PriorityQueue(int sz, Comparator<T> comparator) {
        if (sz < 0) throw new IllegalArgumentException("Initial capacity cannot be negative");
        this.comparator = comparator;
        heap = new ArrayList<T>(sz);
    }

    // Constructs a PQ with default initial capacity
    public PriorityQueue() {
        this(10);
    }

    // Constructs a PQ with default initial capacity and a comparator
    public PriorityQueue(Comparator<T> comparator) {
        this(10, comparator);
    }

    // Constructs a PQ from an array of elements in O(n) time
    public PriorityQueue(T[] elems) {
        this(elems.length, null);
        for (T elem : elems) add(elem);
    }

    public PriorityQueue(T[] elems, Comparator<T> comparator) {
        this(elems.length, comparator);
        for (T elem : elems) add(elem);
    }

    // Constructs a PQ from a collection of elements in O(n) time
    public PriorityQueue(Collection<T> elems) {
        this(elems.size(), null);
        for (T elem : elems) add(elem);
    }

    public PriorityQueue(Collection<T> elems, Comparator<T> comparator) {
        this(elems.size(), comparator);
        for (T elem : elems) add(elem);
    }

    // Returns true if the priority queue is empty
    public boolean isEmpty() {
        return heapSize == 0;
    }

    // Clears everything inside the heap, O(n)
    public void clear() {
        for (int i = 0; i < heapSize; i++) {
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }

    // Return the size of the heap
    public int size() {
        return heapSize;
    }

    // Returns the value of the element with the lowest priority in this priority queue.
    // If the priority queue is empty null is returned.
    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    // Removes the root of the heap, O(log(n))
    public T poll() {
        if (isEmpty()) return null;
        return removeAt(0);
    }

    // Test if an element is in heap, O(1)
    public boolean contains(T element) {
        if (element == null) return false;
        return map.containsKey(element);
    }

    // Adds an element to the priority queue, the element must not be null, O(log(n))
    public void add(T element) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null");
        heap.add(element);
        mapAdd(element, heapSize);
        swim(heapSize);
        heapSize++;
    }

    // Tests if the value of node i <= node j
    // This method assumes that i & j are valid indices, O(1)
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) heap.get(i)).compareTo(heap.get(j)) <= 0;
        } else {
            return comparator.compare(heap.get(i), heap.get(j)) <= 0;
        }
    }

    // Perform bottom up node swim, O(log(n))
    private void swim(int k) {
        // Grab the index of the next parent node WRT to k
        int parent = (k - 1) / 2;

        // Keep swimming while we have not reached the root and while we're less than our parent.
        while (k > 0 && less(k, parent)) {
            // Exchange k with the parent
            swap(parent, k);
            k = parent;

            // Grab the index of the next parent node WRT to k
            parent = (k - 1) / 2;
        }
    }

    // Top down node sink, O(log(n))
    private void sink(int k) {
        while (true) {
            int left = 2 * k + 1; // Left node
            int right = 2 * k + 2; // Right node
            int smallest = left; // Assume left is the smallest node of the two children

            // Find which is smaller left or right
            // If right is smaller set smallest to be right
            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            // Stop if we're outside the bounds of the tree
            // or stop if we're not less than our smallest child
            if (left >= heapSize || less(k, smallest)) break;

            // Swap with the smallest child
            swap(smallest, k);
            k = smallest;
        }
    }

    // Swaps two nodes. Assumes i & j are valid, O(1)
    private void swap(int i, int j) {
        T elemI = heap.get(i);
        T elemJ = heap.get(j);

        heap.set(i, elemJ);
        heap.set(j, elemI);

        mapSwap(elemI, elemJ, i, j);
    }

    // Removes a particular element in the heap, O(log(n))
    public boolean remove(T element) {
        if (element == null) return false;

        // Find the index of the element in the map
        TreeSet<Integer> indices = map.get(element);
        if (indices == null) return false;

        int indexOfElement = indices.last(); // Get the last index (largest value)
        removeAt(indexOfElement);
        return true;
    }

    // Removes a node at a particular index, O(log(n))
    private T removeAt(int i) {
        if (i < 0 || i >= heapSize) throw new IndexOutOfBoundsException("Invalid index");

        heapSize--;
        T removedData = heap.get(i);
        swap(i, heapSize);

        // Obliterate the value
        heap.set(heapSize, null);
        mapRemove(removedData, heapSize);
        heap.remove(heapSize); // Physically remove the element

        // If the element removed was the last element we do not need to sink or swim it.
        // If however, the element removed was not the last element then we must reorganize the heap.
        if (i == heapSize) return removedData;

        T elem = heap.get(i);

        // Try sinking element
        sink(i);

        // If sinking did not work try swimming
        if (heap.get(i) != null && heap.get(i).equals(elem)) { // Added null check for elem
            swim(i);
        }
        return removedData;
    }

    // Add a node value and its index to the map
    private void mapAdd(T value, int index) {
        TreeSet<Integer> indices = map.get(value);
        if (indices == null) {
            indices = new TreeSet<>();
            map.put(value, indices);
        }
        indices.add(index);
    }

    // Removes the index at a given value, O(log(n)) for TreeSet
    private void mapRemove(T value, int index) {
        TreeSet<Integer> indices = map.get(value);
        indices.remove(index);
        if (indices.size() == 0) map.remove(value);
    }

    // Extract an index from a value, O(log(n)) for TreeSet
    private int mapGet(T value) {
        TreeSet<Integer> indices = map.get(value);
        if (indices == null) return -1;
        return indices.last();
    }

    // Swaps two element's indices in the map, O(log(n)) for TreeSet
    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {
        TreeSet<Integer> set1 = map.get(val1);
        TreeSet<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }
}
