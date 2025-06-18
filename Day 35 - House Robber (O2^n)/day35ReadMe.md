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
