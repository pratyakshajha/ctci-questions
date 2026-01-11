# Cracking the Coding Interview - Java Solutions

A personal project for implementing and testing solutions to problems from **"Cracking the Coding Interview"** (6th Ed.) using Java and Gradle. This repository serves as a practice lab for mastering common data structures and algorithmic patterns.

## 🚀 Getting Started

### Prerequisites
- Java JDK (11 or higher)

### Running Tests
You can run all the unit tests from the command line using the Gradle wrapper. This will compile the code and execute the test suite.

 ```sh
 # On macOS/Linux
 ./gradlew test
 
 # On Windows
 .\gradlew.bat test
 ```

Test reports are automatically generated in `build/reports/tests/test/index.html`.

## Practice Mode (`template` Branch)
For a practicing, a `template` branch is available. This branch contains all the problem method
signatures but with their implementations removed. The complete JUnit test suite is included,
allowing you to write your own solutions and validate them immediately.

**How to Use:**
1.  Switch to the `template` branch:
2. Navigate to a problem file (e.g., src/main/java/linkedlists/LinkedListProblems.java).
3. Implement the empty methods.
4. Run the tests using ./gradlew test to check your work

## Implemented Solutions & Data Structures

### Core Data Structures
| Data Structure | File | Features |
 | :--- | :--- | :--- |
| Binary Tree Node | `src/main/java/binarytrees/Node.java` | Generic `Node<T>` class with a `toString()` override for pretty-printing the tree structure to the console. |
| Linked List Node | `src/main/java/linkedlists/Node.java` | Generic `Node<T>` class with a `printAsList()` static method for easy visualization. |

### Chapter 2: Linked Lists
*Solutions are in `src/main/java/linkedlists/LinkedListProblems.java`*

| Problem | Method | Key Concepts |
 | :--- | :--- | :--- |
| 2.1 Remove Dups | `removeDuplicates` | Hashing (`HashSet`) for O(N) time complexity. |
| 2.1 Remove Dups | `removeDuplicatesNoBuffer` | Two Pointers (runner technique) for O(1) space complexity. |
| 2.2 Return Kth to Last | `kthToLast` | Two Pointers with a fixed `k` distance. |
| 2.3 Delete Middle Node | `deleteMiddle` | Fast/Slow pointer to find the middle, then relink. |
| 2.6 Palindrome | `isPalindrome` | List reversal (reverse second half) and comparison. |
| 2.7 Intersection | `findIntersectingNode` | Aligning pointers by list length difference. |
| 2.8 Loop Detection | `detectLoop` | Floyd's Cycle-Finding Algorithm (Tortoise and Hare). |

### Chapter 4: Trees and Graphs
*Solutions are in `src/main/java/binarytrees` and `src/main/java/graphs`*

| Problem | Method | Key Concepts |
 | :--- | :--- | :--- |
| 4.1 Route Between Nodes | `routeBetweenNodes` | Graph Traversal (BFS/DFS) |
| 4.2 Minimal Tree | `(TBD)` | Recursive construction from sorted array |
| 4.3 List of Depths | `(TBD)` | Level-order traversal (BFS) |
| 4.4 Check Balanced | `(TBD)` | Recursive height checking |
| 4.5 Validate BST | `(TBD)` | In-order traversal or min/max range check |
| 4.6 Successor | `(TBD)` | In-order successor logic with parent pointers |
| 4.7 Build Order | `(TBD)` | Topological Sort |
| 4.8 First Common Ancestor | `firstCommonAncestor` | Recursive search from root |
| 4.9 BST Sequences | `(TBD)` | Weaving sub-problem solutions (Recursion) |
| 4.10 Check Subtree | `(TBD)` | Tree traversal and comparison |
| 4.12 Paths with Sum | `(TBD)` | Recursive traversal with path sum tracking |

### Chapter 5: Bit Manipulation
*Solutions are in `src/main/java/bitmanipulation/BitManipulationProblems.java`*

| Problem | Method | Key Concepts |
 | :--- | :--- | :--- |
| 5.1 Insertion | `updateBits` | Bit Masking to clear and set a range of bits. |
| 5.2 Binary to String | `printBinary` | Repeated multiplication by 2 to generate fractional bits. |
| 5.3 Flip Bit to Win | `flipBit` | Sliding window over bits, tracking current and previous sequences of 1s. |
