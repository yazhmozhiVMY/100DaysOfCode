
#  Container With Most Water - LeetCode Problem #11

## Problem Statement

Given `n` non-negative integers `height[0], height[1], ..., height[n - 1]`, where each represents a point at coordinate `(i, height[i])`. `n` vertical lines are drawn such that the two endpoints of the line `i` are at `(i, 0)` and `(i, height[i])`.

Find two lines, which together with the x-axis form a container, such that the container contains the most water.

Return the **maximum amount of water** a container can store.

---

## Example

```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The container formed between height[1] and height[8] contains the most water (min(8,7) * (8-1) = 49)
```

---

## Approaches Implemented

###  Method 1: Brute Force

#### Idea:
- Check all possible pairs of lines `(i, j)` where `i < j`.
- Calculate the volume using the formula `min(height[i], height[j]) * (j - i)`.
- Track and return the maximum volume found.



#### Time Complexity: `O(n^2)`  
#### Space Complexity: `O(1)`

####  Pros:
- Simple and intuitive
- Easy to implement

####  Cons:
- Very inefficient for large inputs

---

### Method 2: Two-Pointer Technique (Efficient)

#### Idea:
- Start with two pointers, one at the beginning (`left`) and one at the end (`right`).
- Calculate area between them.
- Move the pointer with the shorter line inward, since it’s the limiting factor.
- Keep track of the maximum volume.



####  Time Complexity: `O(n)`  
####  Space Complexity: `O(1)`

#### Pros:
- Very efficient
- Works well on large inputs
- Easy to understand once grasped

---

## Sample Inputs and Expected Outputs

| Input                                | Output |
|--------------------------------------|--------|
| `[1, 5, 4, 3]`                       | `6`    |
| `[3, 1, 2, 4, 5]`                    | `12`   |
| `[2, 1, 8, 6, 4, 6, 5, 5]`           | `25`   |

---

##  Summary

| Method         | Time Complexity  | Space Complexity | Suitable For        |
|----------------|------------------|------------------|---------------------|
| Brute Force    | O(n²)            | O(1)             | Small Inputs        |
| Two Pointer    | O(n)             | O(1)             | Best for Interviews |

---
