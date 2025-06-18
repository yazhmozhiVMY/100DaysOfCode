# Day 35
## Problem

House robber problem 
There are n houses built in a line, each of which contains some money in it. A robber wants to steal money from these houses, but he can’t steal from two adjacent houses. The task is to find the maximum amount of money which can be stolen.

---

## Recursive solution

Recurrence relation is mL(n) = max(a[n - 1] + mL(n - 2), mL(n - 1)), where mL(n) returns the maximum amount of money which can be stolen if n houses are left.

----

#### Time complexity 
O(2^n). Every house has 2 choices to pick and not pick.

#### Space complexity

O(n) Recursion stack space

---
![PXL_2](https://github.com/user-attachments/assets/f4eac9d6-7223-439b-a489-9ef4124767b6)

![PXL_20250618_051844836](https://github.com/user-attachments/assets/c84c66ac-599c-47fa-b878-0bd0305c2d2b)

