# Integer Division using Bit Manipulation

This project implements a function to divide two integers **without using multiplication, division, or modulo operators**.  
The solution uses **bit manipulation** for efficient computation.

## Code

```java
class Solution {
    public int divide(int dividend, int divisor) 
    {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int quotient = 0;

        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                a -= b << i;
                quotient |= (1 << i);
            }
        }

        return ((dividend < 0) ^ (divisor < 0)) ? -quotient : quotient;
    }
}
```

---

## Algorithm

1. **Handle overflow case**  
   If `dividend == Integer.MIN_VALUE` and `divisor == -1`, return `Integer.MAX_VALUE` to avoid overflow.

2. **Convert to long and absolute values**  
   Use `long` to avoid overflow during absolute value conversion.

3. **Initialize quotient**  
   Start with `quotient = 0`.

4. **Iterate from bit 31 down to 0**  
   - For each bit position `i`, check if `(a >> i) >= b`.
   - If true:
     - Subtract `(b << i)` from `a`.
     - Set the `i-th` bit of `quotient` using `quotient |= (1 << i)`.

5. **Determine the sign of the result**  
   - If the dividend and divisor have different signs, return `-quotient`.
   - Otherwise, return `quotient`.

---

## Time and Space Complexity

- **Time Complexity:** `O(32)` → We loop over 32 bits.
- **Space Complexity:** `O(1)` → Only a few variables are used.

---

## Step-by-Step Example

### Example 1: divide(10, 3)
- `a = 10`, `b = 3`
- Start from `i = 31` down to `0`
    - At `i = 1`: `(10 >> 1) >= 3` → true  
      `a = 10 - (3 << 1) = 10 - 6 = 4`  
      `quotient = 0 | (1 << 1) = 2`
    - At `i = 0`: `(4 >> 0) >= 3` → true  
      `a = 4 - (3 << 0) = 4 - 3 = 1`  
      `quotient = 2 | (1 << 0) = 3`

Result: `3`

---

### Example 2: divide(43, 5)
- `a = 43`, `b = 5`
- At `i = 3`: `(43 >> 3) >= 5` → true  
  `a = 43 - (5 << 3) = 43 - 40 = 3`  
  `quotient = 0 | (1 << 3) = 8`
- All remaining bits fail because `a < b`.

Result: `8`

---

### Example 3: divide(-15, 4)
- `a = 15`, `b = 4`
- At `i = 1`: `(15 >> 1) >= 4` → true  
  `a = 15 - (4 << 1) = 15 - 8 = 7`  
  `quotient = 0 | (1 << 1) = 2`
- At `i = 0`: `(7 >> 0) >= 4` → true  
  `a = 7 - (4 << 0) = 7 - 4 = 3`  
  `quotient = 2 | (1 << 0) = 3`
- Apply sign → `-3`.

Result: `-3`

---

## Key Points
- No multiplication, division, or modulo operators used.
- Handles overflow.
- Uses bit manipulation for efficiency.
- Time complexity is constant (`O(32)`), independent of input size.

