# MyDSALab: A journey into Data Structures and Algorithms

[![Java](https://img.shields.io/badge/Language-Java-blue.svg)](https://www.java.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A comprehensive, from-scratch implementation of common data structures and algorithms in Java. This project is designed as a learning tool and reference for students, self-learners, and developers looking to strengthen their foundational computer science knowledge.

## 🎯 What is this project?

This repository is a personal endeavor to build, test, and demonstrate various data structures and algorithms from the ground up. While most programming languages provide these tools out-of-the-box, understanding their inner workings is fundamental to writing efficient and scalable software.

### Key Features

*   **📝 From-Scratch Implementation**: Data structures are built without relying on Java's standard `java.util` collections library to expose their core logic.
*   **☕ Pure Java**: Using Java for its clarity and strong object-oriented principles, making the code easy to follow and understand.
*   **✅ Unit Tested**: Each implementation is accompanied by a suite of JUnit tests to verify its correctness and behavior.
*   **🎓 Educational Focus**: Serves as a practical guide for both beginners and advanced learners.

## 🤔 Why are Data Structures Important?

Choosing the right data structure is the key to designing efficient algorithms. The way data is organized directly impacts an algorithm's performance in terms of speed and memory usage.

> Algorithms are designed to solve a particular problem, and data structures are the ways to organize data so that the algorithm solves the problem in a memory-efficient and time-bound manner.

Let's consider a simple example.

**Problem**: Given a list of names, group them by their starting letter.

*   **A Naive Approach**: You could add all the names to a list and sort it. While names with the same starting letter are now grouped, you still need to iterate through the list again to find the start and end of each group (e.g., all names starting with 'A'). This involves multiple passes over the data.

*   **A Better Approach**: Use a `HashTable` (also known as a Dictionary or Map). You can iterate through the list of names just **once**. For each name, you use its starting letter as a `key` and add the name to a list of names stored as the `value`. This approach is far more efficient. For more complex problems, like finding all words in a dictionary that start with a given prefix (e.g., "algo"), an advanced data structure like a **Trie** offers superior performance over simple lists or hash tables. This project explores how to build and use these powerful tools.

## 📚 Data Structures Covered

### Commonly Used Data Structures
- [ ] Array
- [ ] Linked List
- [ ] Doubly Linked List
- [ ] Stack
- [ ] Queue
- [ ] Deque
- [ ] HashTable
- [ ] Set
- [ ] Tree

### Advanced Data Structures
- [ ] Graph
- [ ] Trie
- [ ] B-Tree
- [ ] AVL Tree
- [ ] Red-Black Tree

*(You can update the checkboxes `[ ]` to `[x]` as you complete each implementation.)*

## 🚀 Getting Started

You can clone and run this project locally to explore the implementations and run the tests.

### Prerequisites
*   Java JDK (Version 11 or higher recommended)
*   Git

### Installation & Setup
1.  **Clone the repository:**
    