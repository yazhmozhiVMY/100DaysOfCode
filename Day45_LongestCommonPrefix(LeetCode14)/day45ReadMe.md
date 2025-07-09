
# Longest Common Prefix - LeetCode Problem #14

##  Problem Statement
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

---

## Method 1: Sorting + Compare First and Last

###  Algorithm:
1. Sort the array of strings lexicographically.
2. Compare only the first and last strings.
3. Count matching characters from the start.
4. Return the common prefix substring.



###  Time Complexity:
- **O(n log n + m)**, where `n` is the number of strings and `m` is the length of the shortest string.

###  Space Complexity:
- **O(1)** extra space

###  Performance:
- Runtime: 1ms (Beats 63.59%)
- Memory: 42.11 MB (Beats 14.55%)

---

## Method 2: Vertical Scanning (Character by Character)

###  Algorithm:
1. Start from the first character of each string.
2. Compare that character across all strings.
3. If any mismatch is found, return the result till previous character.


###  Time Complexity:
- **O(S)**, where `S` is the sum of all characters in all strings.

###  Space Complexity:
- **O(1)**

###  Performance:
- Runtime: 1ms (Beats 63.59%)
- Memory: 41.91 MB (Beats 25.59%)

---

##  Summary

| Method                  | Time Complexity    | Space Complexity | Strength                     |
|-------------------------|--------------------|------------------|------------------------------|
| Sorting + First/Last    | O(n log n + m)     | O(1)             | Concise, easy to implement  |
| Vertical Scanning       | O(S)               | O(1)             | Optimal for all inputs       |



---

##  Screenshots from LeetCode Submissions
- Method 1:  
  ![Screenshot 2025-07-09 at 9 43 28 PM](https://github.com/user-attachments/assets/a1c5216a-c641-4032-b5ee-2c82867caa3b)


- Method 2:  
 ![Screenshot 2025-07-09 at 9 56 52 PM](https://github.com/user-attachments/assets/a486b0d1-553d-4ac5-9122-739af66d6a3b)

