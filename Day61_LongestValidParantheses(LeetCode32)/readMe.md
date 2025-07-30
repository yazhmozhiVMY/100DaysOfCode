# Longest Valid Parentheses

This project implements a function to find the **length of the longest valid parentheses substring** in a given string.  
The solution uses a **two-pass scanning algorithm (left-to-right and right-to-left)** for an **O(n)** time complexity and **O(1)** space complexity.

---

## Code

```java
class Solution 
{
    public int longestValidParentheses(String s)  
    {
        int maxLen = 0;
        
        // Left to Right Traversal
        int open = 0, close = 0;
        for (char ch : s.toCharArray()) 
        {
            if (ch == '(') 
            {
                open++;
            } 
            else if (ch == ')') 
            {
                close++;
            }

            if (open == close) 
            {
                maxLen = Math.max(maxLen, 2 * close);
            } 
            else if (close > open) 
            {
                open = close = 0;
            }
        }

        // Right to Left Traversal
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }
}
```

---

## Algorithm

1. **Initialize counters**  
   - `open` and `close` for counting '(' and ')'.
   - `maxLen` for tracking the longest valid substring.

2. **Left-to-Right Scan**
   - Traverse the string.
   - Increment `open` for '(' and `close` for ')'.
   - If `open == close`, update `maxLen`.
   - If `close > open`, reset both counters (invalid substring).

3. **Right-to-Left Scan**
   - Reset counters and traverse from the end of the string.
   - Increment `open` for '(' and `close` for ')'.
   - If `open == close`, update `maxLen`.
   - If `open > close`, reset both counters (invalid substring).

4. **Return `maxLen`**
   - This is the length of the longest valid parentheses substring.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`  
  Two linear scans through the string.
- **Space Complexity:** `O(1)`  
  Only a few counters are used.

---

## Step-by-Step Example

### Example 1: `s = "(()"`
- Left-to-Right:
  - '(' → open = 1, close = 0
  - '(' → open = 2, close = 0
  - ')' → open = 2, close = 1 → maxLen = 0
- Right-to-Left:
  - ')' → close = 1, open = 0
  - '(' → close = 1, open = 1 → maxLen = 2
  - '(' → close = 1, open = 2 → reset (open > close)

Result: **2**

---

### Example 2: `s = ")()())"`
- Left-to-Right:
  - ')' → close > open → reset
  - '(' → open = 1
  - ')' → open = 1, close = 1 → maxLen = 2
  - '(' → open = 2
  - ')' → open = 2, close = 2 → maxLen = 4
  - ')' → close > open → reset
- Right-to-Left:
  - ')' → close = 1
  - ')' → close = 2
  - '(' → close = 2, open = 1
  - '(' → close = 2, open = 2 → maxLen = 4

Result: **4**

---

### Example 3: `s = "()(())"`
- Left-to-Right:
  - '(' → open = 1
  - ')' → open = 1, close = 1 → maxLen = 2
  - '(' → open = 2
  - '(' → open = 3
  - ')' → open = 3, close = 1
  - ')' → open = 3, close = 2 → maxLen = 6
- Right-to-Left:
  - Scan confirms no longer valid sequence.

Result: **6**

---

## Key Points
- Efficient two-pass algorithm.
- Handles unmatched parentheses.
- `O(n)` time complexity and `O(1)` space complexity.
- Correct for all edge cases.
