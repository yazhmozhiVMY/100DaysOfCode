# LeetCode Problem: String to Integer (atoi) – Custom Python Implementation

## 🔗 Problem Link
[LeetCode #8 – String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)

---

## Problem Description

Implement the `myAtoi` function, which converts a string to a 32-bit signed integer.  
It should mimic the behavior of the C/C++ `atoi()` function.

### The function must:

1. Skip all leading whitespace.
2. Accept an optional '+' or '-' sign.
3. Read in the next characters until a non-digit is encountered.
4. Convert the digits to an integer.
5. Clamp the result within the 32-bit signed integer range:  
   `[-2³¹, 2³¹ - 1]` → `[-2147483648, 2147483647]`
6. Return 0 if no valid conversion can be performed.

---

## Time and space complexity

1. Time - O(length of the string)
2. Space - O(1)
