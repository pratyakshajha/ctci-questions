# CTCI Practice Lab (Java/Gradle)

A structured approach to mastering algorithms and data structures using **Cracking the Coding Interview** (6th Ed) and LeetCode patterns.

## 🚀 Project Structure
- `src/main/java/`: Problem solutions categorized by data structure.
- `src/test/java/`: JUnit 5 test suites with edge-case coverage.
- `src/jmh/java/`: Microbenchmarks for comparing optimization strategies.

## 🧠 Pattern Mapping
| Pattern | Problems | Key Insights |
| :--- | :--- | :--- |
| **Backtracking** | [Word Search](src/main/java/recursion/WordSearch.java) | Use frequency pruning to avoid $3^L$ depth. |
| **Two Pointers** | [Is Palindrome](src/main/java/strings/Palindrome.java) | O(1) space by meeting in the middle. |
| **Bit Manipulation** | [Update Bit](src/main/java/bits/UpdateBit.java) | Masking with `~(1 << i)` is safer than XOR. |

## 📊 Performance Comparison
Example results from JMH benchmarks:
| Solution | Optimization | Mean Latency |
| :--- | :--- | :--- |
| Word Search | Standard DFS | 145.2 ms |
| Word Search | **Reverse Search** | **1.2 ms** |