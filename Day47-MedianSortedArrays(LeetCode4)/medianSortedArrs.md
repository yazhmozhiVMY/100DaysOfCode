
#  LeetCode #4: Median of Two Sorted Arrays

##  Problem Statement

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the **median** of the two sorted arrays.

The overall run time complexity should be **O(log(min(m,n)))**.

---

##  Examples

### Example 1:
```
Input: nums1 = [1, 3], nums2 = [2]
Output: 2.0
Explanation: merged array = [1, 2, 3] and median is 2.0
```

### Example 2:
```
Input: nums1 = [1, 2], nums2 = [3, 4]
Output: 2.5
Explanation: merged array = [1, 2, 3, 4], and median is (2 + 3) / 2 = 2.5
```

---

##  Implemented Approaches

### 1️⃣ Brute Force (Merge + Sort)

- Merge both arrays using `System.arraycopy`
- Sort the combined array
- Return median based on array length (even or odd)

**Time Complexity:** O((m+n) x log(m+n))  
**Space Complexity:** O(m+n)

---

### 2️⃣ Merge Process in MERGE SORT (Without Full Sorting)

- Simulate the merge step from Merge Sort without extra space.
- Traverse until the middle element(s) and find the median.

**Time Complexity:** O(m + n)  
**Space Complexity:** O(1)

**Algorithm Logic:**

- Use two pointers `i` and `j` to iterate through `nums1` and `nums2`.
- Maintain two variables `m1` and `m2` to track the last two values visited before reaching median index.

---

### 3️⃣ Binary Search Partition (Optimal)

- Apply binary search on the shorter array.
- Partition both arrays such that:
    - max(left partition) <= min(right partition)
- Use `Integer.MIN_VALUE` and `Integer.MAX_VALUE` to handle edge cases.

**Time Complexity:** O(log(min(m, n)))  
**Space Complexity:** O(1)

**Key Observations:**

- Median splits array into two halves:
    - If total elements are odd: return max(left side)
    - If even: return average of max(left) and min(right)
- Ensures no extra array creation

---

# Detailed Iterations for Binary Search Partition Method
**Problem:** Median of Two Sorted Arrays  
**Approach:** Binary Search on Smaller Array

We simulate the detailed steps for:
```
nums1 = [1, 5, 7]
nums2 = [2, 3, 4, 6]
```

---

## Combined Length = 7 (Odd)

We always apply binary search on the **smaller** array: `nums1`

### Variables:
- `n1 = 3`, `n2 = 4`
- `begin1 = 0`, `end1 = 3`

---

##  Iteration 1:

- `mid1 = (0 + 3) / 2 = 1`
- `mid2 = (3 + 4 + 1) / 2 - 1 = 3`

Partitions:
- `l1 = nums1[mid1 - 1] = nums1[0] = 1`
- `r1 = nums1[mid1] = nums1[1] = 5`
- `l2 = nums2[mid2 - 1] = nums2[2] = 4`
- `r2 = nums2[mid2] = nums2[3] = 6`

Check:  
- `l1 (1) <= r2 (6)` ✅  
- `l2 (4) <= r1 (5)` ✅  
→ Valid partition found

**Since total length is odd, median = max(l1, l2) = max(1, 4) = 4**

---

## ✅ Median Found: **4**

This example shows that a valid partition was found in the **first iteration** and no further searching was needed.

---

##  Recap:

- Binary search is applied only on the shorter array.
- Partition divides the combined arrays into two equal halves.
- Correct partition condition: `l1 <= r2 && l2 <= r1`
- Median is computed based on total parity (odd/even).

---

##  Efficiency:

- Runs in `O(log(min(m,n)))` time.
- Requires no additional space.
- Ideal for large sorted datasets.


##  Sample Code Outputs

Given:

```
arr1 = {10, 20, 30}
arr2 = {5, 15, 25, 35, 45}
```

- Brute Force: 22.5
- Merge Process: 22.5
- Binary Search: 22.5

```
arr3 = {1, 5, 7}
arr4 = {2, 3, 4, 6}
```

- Brute Force: 4.0
- Merge Process: 4.0
- Binary Search: 4.0

---

##  Conclusion

| Method              | Time Complexity   | Space Complexity | Best Use Case                     |
|---------------------|------------------|------------------|------------------------------------|
| Brute Force         | O((m+n) log(m+n))| O(m+n)           | Simple merge-based scenarios      |
| Merge Process       | O(m + n)         | O(1)             | Efficient in-place computation    |
| Binary Search       | O(log(min(m,n))) | O(1)             | Large datasets & optimal approach |

---
