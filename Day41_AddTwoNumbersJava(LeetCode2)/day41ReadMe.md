# LeetCode #2 – Add Two Numbers (Java)

## Problem Link
[LeetCode – Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

---

## Problem Description

You are given two **non-empty linked lists** representing two non-negative integers.  
The digits are stored in **reverse order**, and each of their nodes contains a single digit.  
Add the two numbers and return the sum as a linked list in the same reversed format.

- The two numbers **do not contain any leading zero**, except the number 0 itself.

---

## Algorithm

1. **Initialize** a dummy head node and a pointer `result` for building the output list.
2. Use a variable `carry` to store the overflow from each addition step.
3. Traverse both lists (`l1` and `l2`) simultaneously:
   - Get the current digit from each list (default to 0 if one list is shorter).
   - Compute the sum of both digits and the carry.
   - Set `carry = sum / 10` and store `sum % 10` in a new node.
   - Move `l1`, `l2`, and `result` pointers forward.
4. After the loop, if a carry remains, create a new node for it.
5. Return the list starting at `dummyHead.next`.

---

## 🧪 Examples

### Example 1:

Input:
l1 = 2 -> 4 -> 3
l2 = 5 -> 6 -> 4

Explanation:
342 + 465 = 807

Output:
7 -> 0 -> 8

### Example 2:

Input:
l1 = 9 -> 9
l2 = 1

Output:
0 -> 0 -> 1 (because 99 + 1 = 100)

---

---

## 🧠 Time and Space Complexity

| Metric     | Value                     |
|------------|---------------------------|
| **Time**   | O(max(m, n))              |
| **Space**  | O(max(m, n))              |

- `m` and `n` are the lengths of the two input linked lists.
- Space is for the new result list, which can be at most one node longer than the longer input (in case of final carry).

---

![image](https://github.com/user-attachments/assets/0d7b178c-8fa7-4f35-adeb-9b06c5834bc6)

---

## Java Code (given)

### `ListNode.java`

```java
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
