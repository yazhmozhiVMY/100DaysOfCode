# Zigzag Conversion

This project implements the **Zigzag Conversion** problem, where a given string is rearranged into a zigzag pattern across a specified number of rows and then read line by line.

---

## Code

```java
class Solution 
{
    public String convert(String s, int numRows) 
    {
        if (numRows == 1 || s.length() <= numRows) {
            return s; // No zigzag needed
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction if we're at the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
```

---

## Algorithm

1. **Handle base case:**
   - If `numRows` is 1 or the string length is less than or equal to `numRows`, no conversion is needed, and the original string is returned.

2. **Initialize row containers:**
   - Create an array of `StringBuilder` objects for each row.

3. **Traverse the string:**
   - Append each character to the current row.
   - Switch direction (`goingDown`) when reaching the top or bottom row.
   - Move `currentRow` up or down depending on the direction.

4. **Combine rows:**
   - Join all `StringBuilder` rows into the final result string.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`  
  - Each character is visited once and appended to a row.
- **Space Complexity:** `O(n)`  
  - Additional space is used for `StringBuilder` rows to store intermediate characters.

---

## Step-by-Step Example

### Example 1:
**Input:**
```
s = "PAYPALISHIRING", numRows = 3
```

**Zigzag pattern:**
```
P   A   H   N
A P L S I I G
Y   I   R
```

**Output:**
```
"PAHNAPLSIIGYIR"
```

---

### Example 2:
**Input:**
```
s = "PAYPALISHIRING", numRows = 4
```

**Zigzag pattern:**
```
P     I    N
A   L S  I G
Y A   H R
P     I
```

**Output:**
```
"PINALSIGYAHRPI"
```

---

## Key Points
- Efficient solution with linear time complexity.
- Uses `StringBuilder` for efficient string concatenation.
- Handles edge cases where zigzag is not required.
