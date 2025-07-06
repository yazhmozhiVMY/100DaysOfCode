# LeetCode #3: Longest Substring Without Repeating Characters (Java)

## Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

###  Constraints:
- `0 <= s.length <= 5 * 10⁴`
- `s` consists of English letters, digits, symbols, and spaces. (ASCII) 

---

## Approaches Implemented

This solution file implements **two methods** to solve the problem using the **sliding window** technique.

---

## Method 1: HashSet Sliding Window

###  Algorithm:

1. Use two pointers `left` and `right` to define the sliding window.
2. Use a `HashSet` to track characters inside the window.
3. Expand the window by moving `right`, and shrink from `left` if a duplicate is found.
4. Update the maximum window length when no duplicates exist.

### Time Complexity:
- **O(n)** – each character is added and removed at most once.

### Space Complexity:
- **O(k)** – where `k` is the size of the character set.
  - Supports full Unicode (depends on input)

###  Performance:
- **Runtime:** 7 ms → Beats **35.41%**
- **Memory:** 44.94 MB → Beats **32.20%**

## Screenshot:

![SolutionStats](https://github.com/user-attachments/assets/ff8f1f34-c018-4d79-bb3b-cd93f0d32523)


---

## Method 2: Optimized Sliding Window using `int[128]`

**This is the best performing method.**

### Algorithm:

1. Create an `int[] visited = new int[128]` for ASCII characters.
2. Use `visited[c]` to store the last seen index of each character.
3. If a character is repeated and its last index is **after or equal to** the current start `st`, move `st` to `visited[c] + 1`.
4. Update max length at each step.

###  Limitation:
- **Supports only ASCII characters (0–127)**

###  Time Complexity:
- **O(n)** – single pass through the string

### Space Complexity:
- **O(1)** – fixed array of size 128

### 🧪 Performance:
- **Runtime:** 2 ms → Beats **98.62%**
- **Memory:** 43.53 MB → Beats **92.06%**

📸 Screenshot:

![Screenshot 2025-07-06 at 4 35 12 PM](https://github.com/user-attachments/assets/f9712c95-57d2-4ccc-af7b-4112b00d3393)


---

## Visual Trace

Here’s a hand-drawn trace for string: `abcbadbd`

- `visited[]` tracks the last index of each character
- `st` points to the start of the valid substring (current window)
- `maxLen` updates when a new longer unique substring is found

Visual:

![PXL_20250706_154016168 MP~2](https://github.com/user-attachments/assets/4ef7856c-44f9-48e2-b131-d0b4331377a8)


---

##  Files Included

- `Solution.java` → Contains both methods in a single Java class
- lengthOfLongestSubstring(String s) - method 1 using HashSet
- lengthOfLongestSubstring_best(String s) - method 2 using int[128]
---

##  Output Example

Input: `"abcabcbb"`  
Output: `3`  
Explanation: Longest substring without repeating characters is `"abc"`

Input: `"abcbadbd"`  
Output: `4`  
Explanation: Longest substring without repeating characters is `"cbad"`
