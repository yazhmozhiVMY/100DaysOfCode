# Day 2 of 200 days of leet code
## Unique Binary Search Trees (LeetCode 96)

## Problem Statement
Given an integer `n`, return the number of structurally unique **Binary Search Trees (BSTs)** which have exactly `n` nodes of unique values from `1` to `n`.

<img width="694" height="636" alt="image" src="https://github.com/user-attachments/assets/1d94491b-b794-4fcb-b506-bacaf743649e" />

---

## Algorithm Explanation

The number of unique Binary Search Trees (BSTs) that can be formed with `n` nodes is given by the **nth Catalan number**.

### Catalan Number Formula:
```
C(n) = (1 / (n + 1)) * (2n choose n)
```
Where `(2n choose n)` is the binomial coefficient.

### Binomial Coefficient:
```
(2n choose n) = (2n)! / (n! * n!)
```

Instead of calculating factorials directly (which may cause overflow and inefficiency), we iteratively calculate the binomial coefficient using the multiplicative formula.

---

## Steps of the Algorithm

### Step 1: Calculate Binomial Coefficient
We compute `(2n choose n)` using an iterative loop to avoid overflow:
```
res = 1
for i = 0 to k-1:
    res = res * (n - i) / (i + 1)
```
Where `k = min(k, n-k)` to reduce the number of iterations.

### Step 2: Compute Catalan Number
After computing `(2n choose n)`, divide it by `(n + 1)`:
```
C(n) = (binomialCoeff(2n, n)) / (n + 1)
```

### Step 3: Return Result
The result is the number of unique BSTs.

---

## Example Walkthrough

### Example 1: n = 3
1. Compute `(2 * 3 choose 3)`:
   ```
   res = 1
   i = 0: res = 1 * (6 - 0) / 1 = 6
   i = 1: res = 6 * (6 - 1) / 2 = 15
   i = 2: res = 15 * (6 - 2) / 3 = 20
   ```
   So, binomialCoeff(6, 3) = **20**

2. Compute Catalan number:
   ```
   C(3) = 20 / (3 + 1) = 5
   ```
3. **Output:** `5`

There are 5 unique BSTs for n = 3.

---

### Example 2: n = 19
1. Compute `(2 * 19 choose 19)` (large intermediate steps, handled using `long`):
   Result: **35345263800**
2. Compute Catalan number:
   ```
   C(19) = 35345263800 / 20 = 1767263190
   ```
3. **Output:** `1767263190`

---

## Time and Space Complexity

### Time Complexity
- `binomialCoeff` runs in **O(n)** because it loops `k` times where `k ≤ n/2`.
- `numTrees` calls `binomialCoeff` once and performs an O(1) division.

✅ **Overall: O(n)**

### Space Complexity
- Only a few variables (`res`, `c`, and loop counters) are used.
- No additional data structures are created.

✅ **Overall: O(1)** (constant space)

---

## Java Implementation

```java
class Solution 
{
    public static long binomialCoeff(int n, int k) 
    {
        if (k > n - k) 
        {
            k = n - k;
        }
        long res = 1;        
        for (int i = 0; i < k; ++i) 
        {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public int numTrees(int n) 
    {
        long c = binomialCoeff(2 * n, n);
        return (int)(c / (n + 1));   
    }
}
```

---

## Key Points
- We used `long` to prevent overflow.
- Final result fits in an `int` because for `n ≤ 19`, the maximum result is `1767263190`, which is within `int` range.
- Optimized by reducing `k` in the binomial coefficient calculation.


<img width="680" height="433" alt="image" src="https://github.com/user-attachments/assets/09047341-d9cf-4c33-a99b-49ac14b1116e" />

## Key Points
- We used `long` to prevent overflow.
- Final result fits in an `int` because for `n ≤ 19`, the maximum result is `1767263190`, which is within `int` range.
- Optimized by reducing `k` in the binomial coefficient calculation.
