# Merge Two Sorted Linked Lists (Iterative)

This solution demonstrates how to merge two sorted singly linked lists into one sorted list using an **iterative approach**. It mimics the merge step of the Merge Sort algorithm.

---

##  Files

- `Node.java`: Defines the `Node` class representing a node in a singly linked list.
- `Solution.java`: Contains the `sortedMerge` function that performs the merging logic and a `main` method to run an example.

---

##  Algorithm Explanation

### Problem

Given two sorted linked lists `head1` and `head2`, merge them into a single sorted linked list and return the head of the merged list.

### Approach

1. Create a **dummy node** to serve as the placeholder for the result list.
2. Use a **pointer (`curr`)** starting at the dummy node.
3. While both lists are not empty:
   - Compare the data of the current nodes of both lists.
   - Append the node with the smaller data to `curr.next`.
   - Move the pointer (`curr`) and the list pointer (`head1` or `head2`) forward.
4. Once one of the lists is fully traversed, append the remaining elements of the other list.
5. Return `dummy.next`, which points to the head of the merged list.

---

##  Time Complexity

- **O(n + m)** where `n` and `m` are the lengths of the two linked lists.
- Every node is visited exactly once.

##  Space Complexity

- **O(1)** auxiliary space.
- We do not use any extra data structures (no recursion or additional lists), only a few pointers.

---

##  Step-by-Step Example

Given:

```
List 1: 5 → 10 → 15 → 40 → 50 → 60
List 2: 2 → 3 → 20
```

**Merging Process:**

| Step | head1 | head2 | curr.next becomes | Result so far              |
|------|-------|-------|-------------------|----------------------------|
| 1    | 5     | 2     | 2                 | 2                          |
| 2    | 5     | 3     | 3                 | 2 → 3                      |
| 3    | 5     | 20    | 5                 | 2 → 3 → 5                  |
| 4    | 10    | 20    | 10                | 2 → 3 → 5 → 10             |
| 5    | 15    | 20    | 15                | 2 → 3 → 5 → 10 → 15        |
| 6    | 40    | 20    | 20                | 2 → 3 → 5 → 10 → 15 → 20   |
| 7    | 40    | null  | append rest       | 2 → 3 → 5 → 10 → 15 → 20 → 40 → 50 → 60 |

Final Output:
```
2 3 5 10 15 20 40 50 60
```

---

##  How to Run

1. Compile the Java files:
   ```bash
   javac Node.java Solution.java
   ```
2. Run the program:
   ```bash
   java Solution
   ```

---

## Function Signature

```java
public static Node sortedMerge(Node head1, Node head2)
```

---

##  Output Format

Printed directly to standard output. Each node value of the merged list is printed with space separation.

---
