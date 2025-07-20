
# Remove Nth Node From End of List - Day 18 of #100DaysOfLeetCode

This Java program solves the **Remove Nth Node From End of List** problem from LeetCode using the **two-pointer technique** (fast and slow pointers).

---

## Problem Description

Given the head of a linked list, remove the **n-th node from the end** of the list and return its head.

### Example

```
Input: head = [1, 2, 3, 4, 5], n = 2  
Output: [1, 2, 3, 5]
```

---

## Features

- Utilizes the **fast and slow pointer** strategy to find the n-th node from the end in one pass
- Handles edge cases, such as removing the first node
- Includes a test case with output

---

##  Code Overview

```java
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++)
            fast = fast.next;

        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = r.removeNthFromEnd(head, 2);

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
```

---

###  Sample Output

```
1 2 3 5
```

---

##  Time and Space Complexity

| Aspect       | Complexity  |
|--------------|-------------|
| Time         | O(n)        |
| Space        | O(1)        |

---

## ListNode Class (Assumed)

Make sure to include the `ListNode` class if not using LeetCode's environment:

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```

---


## Tags

`#100DaysOfLeetCode` `#Java` `#LinkedList` `#TwoPointers`

