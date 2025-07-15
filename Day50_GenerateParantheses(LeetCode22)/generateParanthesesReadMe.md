#  Generate Valid Parentheses — Java Implementation

This project demonstrates how to generate all **valid combinations of parentheses** using a **recursive backtracking** approach in Java.

---

## File Overview

- **`GenerateParantheses.java`**: Contains the implementation for generating valid parentheses combinations and a `main` method to test with `n = 2` and `n = 3`.

---

##  Problem Statement

Given an integer `n`, generate all combinations of `n` pairs of well-formed parentheses.

---

## Algorithm Description

The solution uses **recursive backtracking** to explore all valid strings that can be formed using `n` opening and `n` closing parentheses.

### Function Signature

```java
void VP(int n, int numOpen, String current, ArrayList<String> output)
```

### Parameters

- `n`: The number of pairs of parentheses.
- `numOpen`: Number of opening parentheses used so far.
- `current`: The current string being built.
- `output`: A list that stores all valid sequences.

### Base Case

```java
if(current.length() == 2 * n)
```

Once the string has length `2 * n`, it's a valid sequence and is added to `output`.

### Recursive Steps

1. **Add `'('`** if `numOpen < n`
   ```java
   if(numOpen < n)
       VP(n, numOpen + 1, current + "(", output);
   ```

2. **Add `')'`** if the number of closing brackets used (`current.length() - numOpen`) is **less than** the number of opening brackets
   ```java
   if(current.length() - numOpen < numOpen)
       VP(n, numOpen, current + ")", output);
   ```

This ensures:
- Never more `)` than `(` at any point.
- Exactly `n` pairs in the final output.

---

##  Example Output

When `n = 2`:
```
["(())", "()()"]
```

When `n = 3`:
```
["((()))", "(()())", "(())()", "()(())", "()()()"]
```

---

##  Time Complexity

The number of valid sequences is the **Catalan number**:

\[
C_n = \frac{1}{n+1} \binom{2n}{n}
\]

Therefore:

- **Time complexity**: `O(4^n / sqrt(n))` (derived from Catalan number growth)
- **Each call generates one character**, leading to exponential recursion.

---

##  Space Complexity

- **O(n)** recursive stack depth (because each call builds one character).
- **O(C_n \* 2n)** output space, where `C_n` is the Catalan number (number of valid strings) and each string is of length `2n`.

---

##  How to Run

1. Compile:
   ```bash
   javac GenerateParantheses.java
   ```

2. Run:
   ```bash
   java GenerateParantheses
   ```

Expected Output:
```
2 parantheses [(()) , ()()]
3 parantheses [((())), (()()), (())(), ()(()), ()()()]
```

---

## ✅ Notes

- This approach **prunes** invalid branches early.
- Guarantees only **valid** strings are added to the result.

---


This Java implementation showcases a classic example of recursive backtracking with pruning for generating combinatorially valid sequences.

![PXL_20250715_203822864](https://github.com/user-attachments/assets/d7919032-7205-4ae9-a7a8-0c4449db5642)

<img width="809" height="477" alt="Screenshot 2025-07-15 at 9 39 16 PM" src="https://github.com/user-attachments/assets/06ff3070-3add-4647-ad2e-39c6b8fd3e05" />


