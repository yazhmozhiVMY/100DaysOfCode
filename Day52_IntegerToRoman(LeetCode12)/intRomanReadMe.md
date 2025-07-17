
# Integer to Roman - LeetCode Problem
**Day 15 of 100 Days of LeetCode Challenge**  
**Date:** July 17, 2025  
**Version:** 1.0  

## Problem Statement
Convert an integer to a Roman numeral. The given integer is guaranteed to be within the range **1 to 3999**.

### Roman Numerals Reference
Roman numerals are represented by combinations of the following symbols:

| Symbol | Value |
|--------|-------|
| I      | 1     |
| IV     | 4     |
| V      | 5     |
| IX     | 9     |
| X      | 10    |
| XL     | 40    |
| L      | 50    |
| XC     | 90    |
| C      | 100   |
| CD     | 400   |
| D      | 500   |
| CM     | 900   |
| M      | 1000  |

## Approach

### Method: Greedy Matching

We use a **greedy algorithm** where we iterate through the symbols from highest to lowest value and subtract as many as possible from the input number while appending the corresponding symbol to the result string.

### Algorithm Steps:
1. Define two arrays:
   - `values[]` containing the Roman numeral values in descending order.
   - `str_romans[]` containing the corresponding Roman numerals.
2. Initialize a `StringBuilder` to build the result.
3. For each value in the `values[]` array:
   - While the input number `num` is greater than or equal to the current value:
     - Append the corresponding Roman numeral to the result.
     - Subtract the value from `num`.
4. Return the result as a string.

### Code:
```java
public String intToRoman(int num) {
    String str_romans[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 13; ++i) {
        while (num - values[i] >= 0) {
            result.append(str_romans[i]);
            num -= values[i];
        }
    }
    return result.toString();
}
```

### Sample Outputs:

| Input | Output |
|-------|--------|
| 1994  | MCMXCIV |
| 58    | LVIII   |
| 3749  | MMMDCCXLIX |
| 9     | IX      |
| 700   | DCC     |

## Time and Space Complexity

- **Time Complexity:** O(1)  
  - Because the maximum number of iterations is fixed (limited by 3999), and the Roman numeral list is of constant size.

- **Space Complexity:** O(1)  
  - Only a fixed number of variables and a `StringBuilder` is used.

##  Conclusion
This greedy approach efficiently converts any number in the valid range to its Roman numeral representation without requiring recursion or complex logic. It's fast, concise, and easy to understand.

---
##  Reference
https://medium.com/@sheefanaaz6417/12-integer-to-roman-leetcode-step-by-step-approach-7b8998ced754
---
Happy Coding
