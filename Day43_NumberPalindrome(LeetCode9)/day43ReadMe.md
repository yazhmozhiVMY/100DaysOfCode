# LeetCode #9: Palindrome Number (Java)

## Problem Link
[LeetCode – Palindrome Number](https://leetcode.com/problems/palindrome-number/)

---

##  Problem Statement

Determine whether an integer `x` is a **palindrome**.

An integer is a palindrome when it **reads the same forward and backward**.

## Constraints:
- Must return `false` for negative numbers (e.g., `-121`)
- Must return `false` for numbers ending in 0 (e.g., `10`), **except** for `0` itself

---

## Approach 1: Convert Integer to String

### Algorithm
1. Convert the integer to a string
2. Use two-pointer technique to compare characters from both ends


### Time Complexity: O(n)
Length of number n digits (due to string conversion and scanning)

### Space Complexity: O(n)
Uses a string representation of the number

---
## Approach 2: Reverse Integer and check

### Algorithm
1. Reverse the integer using / and %
2. Check if it is equal to the input
3. Return false for -ve integers and numbers ending with 0

### Time Complexity: O(log₁₀(n))
Only half the digits are processed

### Space Complexity: O(1)
Uses just a few integer variables — very efficient


## LeetCode Submission
![Screenshot 2025-07-07 at 12 38 21 PM](https://github.com/user-attachments/assets/dae54b71-7c31-4626-ad28-1e32f97a3ed3)
