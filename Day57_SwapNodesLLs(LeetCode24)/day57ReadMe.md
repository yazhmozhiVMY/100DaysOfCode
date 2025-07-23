# SwapPairsLL

This Java program defines a class `SwapPairsLL` that performs pairwise swapping of nodes in a singly linked list.

## Overview

The `swapPairs` method swaps every two adjacent nodes in a linked list and returns the modified list. It uses a dummy node to simplify edge cases involving the head node. A helper method `printList` is included to display the list, and the `main` method demonstrates functionality with an example list.

## Code Structure

- `swapPairs(ListNode head)`: Swaps every two adjacent nodes of the input linked list.
- `printList(ListNode head)`: Prints the values of the linked list.
- `main(String[] args)`: Builds a sample linked list, calls `swapPairs`, and prints the result.

### Sample Input

```
1 -> 2 -> 3 -> 4 -> 5 -> 6
```

### Expected Output

```
2 1 4 3 6 5
```

## ListNode Class

To make this code functional, include a basic definition of `ListNode` like so:

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

## How to Compile and Run

```bash
javac SwapPairsLL.java
java SwapPairsLL
```

Ensure the `ListNode` class is either included in the same file or accessible in the same package.
