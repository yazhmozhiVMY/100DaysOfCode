# Merge k Sorted Linked Lists in Java

This repository contains two efficient solutions for the classic problem of merging **k sorted linked lists** into a single sorted list.

---

##  Problem Statement

> You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order. Merge all the linked-lists into one sorted linked-list and return it.

---

##  Approach 1: Using Min Heap (PriorityQueue)

###  Description

This approach uses a **min-heap** (Java `PriorityQueue`) to keep track of the smallest current node from each list. At each step, we pop the smallest node and append it to the merged list.

### 💡 Time Complexity
- `O(N log k)`, where `N` is the total number of nodes and `k` is the number of lists.

### 📦 Space Complexity
- `O(k)` for the priority queue.

###  Code

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            tail.next = top;
            tail = top;

            if (top.next != null) {
                pq.add(top.next);
            }
        }

        return dummy.next;
    }
}
```

---

##  Approach 2: Divide and Conquer

###  Description

This approach recursively merges the linked lists in pairs, similar to merge sort. This reduces the number of lists by half in each round, ultimately leading to a single merged list.

###  Time Complexity
- `O(N log k)`

###  Space Complexity
- `O(1)` extra (in-place merging)

###  Code

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
```

---

##  Comparison

| Approach           | Time Complexity | Space Complexity | Notes                                 |
|--------------------|------------------|-------------------|----------------------------------------|
| Min Heap (PQ)      | O(N log k)       | O(k)              | Slightly more overhead due to heap     |
| Divide & Conquer   | O(N log k)       | O(1) extra        | More memory efficient, clean recursion |

---

##  Note

Both approaches assume the `ListNode` class is defined as:

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```
