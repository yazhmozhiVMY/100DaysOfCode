# strStr (Implement Substring Search)

This project implements the **`strStr`** function, which finds the first occurrence of a substring (`needle`) in a string (`haystack`).  
If the substring is not found, it returns `-1`. If the `needle` is empty, it returns `0`.

---

## Code

```java
class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        // If needle is empty, the index to return is 0 (as per the problem statement).
        if (needle.isEmpty()) {
            return 0;
        }

        // Get the lengths of haystack and needle.
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Initialize pointers for haystack and needle.
        int haystackPointer = 0;
        int needlePointer = 0;

        // Iterate through the haystack.
        while (haystackPointer < haystackLength) {
            // Check if the current characters in the haystack and needle are the same.
            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                // Special case: if needle length is 1 and characters match, we found the needle.
                if (needleLength == 1) {
                    return haystackPointer;
                }
                // Move both pointers forward.
                haystackPointer++;
                needlePointer++;
            } else {
                // Current characters do not match. Reset haystackPointer back by the amount
                // needlePointer had advanced, then move forward by one to search from next position.
                haystackPointer -= needlePointer - 1;
                // Reset needlePointer back to the start of the needle.
                needlePointer = 0;
            }

            // Check if the needle has been found within the haystack.
            if (needlePointer == needleLength) {
                // The start of the substring in haystack that matches the needle
                // is at the difference between current haystackPointer and the length of the needle.
                return haystackPointer - needlePointer;
            }
        }
      
        // Needle was not found in the haystack. Return -1 as specified in the problem statement.
        return -1;
    }
}

Reference: Algo monster
```

---

## Algorithm

1. **Check if `needle` is empty**
   - If yes, return `0`.

2. **Initialize pointers**
   - `haystackPointer` starts at 0.
   - `needlePointer` starts at 0.

3. **Traverse the `haystack`**
   - If characters match, increment both pointers.
   - If mismatch:
     - Reset `haystackPointer` to `haystackPointer - needlePointer + 1`.
     - Reset `needlePointer` to `0`.

4. **Check for full match**
   - If `needlePointer == needleLength`, return the starting index.

5. **Return `-1`**
   - If no match is found.

---

## Time and Space Complexity

- **Time Complexity:** `O((n - m) * m)` in the worst case, where:
  - `n` = length of `haystack`
  - `m` = length of `needle`
- **Space Complexity:** `O(1)` since no extra space is used.

---

## Step-by-Step Example

### Example 1: `haystack = "hello"`, `needle = "ll"`
- haystackPointer = 0, needlePointer = 0 → mismatch
- haystackPointer = 1, needlePointer = 0 → mismatch
- haystackPointer = 2, needlePointer = 0 → match `'l'`
- haystackPointer = 3, needlePointer = 1 → match `'l'`
- Full match → return `2`

Result: **2**

---

### Example 2: `haystack = "aaaaa"`, `needle = "bba"`
- haystackPointer moves through all positions but no match found.

Result: **-1**

---

### Example 3: `haystack = "abc"`, `needle = ""`
- Needle is empty → return **0**.

---

## Key Points
- Simple substring search implementation.
- Does not use built-in substring search.
- Works in `O((n - m) * m)` worst-case time.
- Returns `-1` if not found or `0` if needle is empty.

<img width="819" height="615" alt="image" src="https://github.com/user-attachments/assets/41efd4c1-0fe4-4b0a-b4d0-bdd88f9fa4ca" />

