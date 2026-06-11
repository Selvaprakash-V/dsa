# Complexity Analysis

## What is Big O?
Big O notation describes the **worst-case** growth rate of an algorithm as input size `n` grows.

---

## Time Complexity Cheat Sheet

| Notation   | Name         | Example                        |
|------------|--------------|--------------------------------|
| O(1)       | Constant     | Array access, HashMap get/put  |
| O(log n)   | Logarithmic  | Binary Search                  |
| O(n)       | Linear       | Linear Search, single loop     |
| O(n log n) | Linearithmic | Merge Sort, Heap Sort          |
| O(n²)      | Quadratic    | Bubble Sort, nested loops      |
| O(2ⁿ)      | Exponential  | Recursion without memoization  |
| O(n!)      | Factorial    | Permutations                   |

---

## Space Complexity
- **O(1)** — no extra space (in-place)
- **O(n)** — extra array, recursion call stack
- **O(log n)** — recursive binary search call stack

---

## How to Analyze

1. Drop constants → O(2n) = O(n)
2. Drop lower-order terms → O(n² + n) = O(n²)
3. Different inputs = different variables → O(a + b), not O(2n)
4. Nested loops multiply → O(n) × O(n) = O(n²)

---

## Recurrence Relations (for Recursion)

| Pattern              | Complexity  |
|----------------------|-------------|
| T(n) = T(n-1) + O(1) | O(n)       |
| T(n) = T(n/2) + O(1) | O(log n)   |
| T(n) = 2T(n/2) + O(n)| O(n log n) |
| T(n) = T(n-1) + O(n) | O(n²)      |

---

## Tips
- Always ask: *how many times does this loop run?*
- Recursive functions → draw the recursion tree
- Java `HashMap` → O(1) avg, O(n) worst (hash collisions)
- Java `TreeMap` → O(log n) always (Red-Black Tree)