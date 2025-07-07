# LeetCode #9: Palindrome Number (Java)

##  Problem Statement

Determine whether an integer `x` is a **palindrome** — that is, it reads the same backward as forward.

### Constraints:
- An integer is a palindrome when it reads the same backward as forward.
- Negative numbers are **not** palindromes.
- Any number ending in 0 is **not** a palindrome unless the number is 0 itself.

---

## Solutions Implemented

### Method 1: Full Integer Reversal

```java
public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int reverse = 0, temp = x;
    while (temp > 0) {
        reverse = reverse * 10 + temp % 10;
        temp /= 10;
    }
    return reverse == x;
}
```

####  Pros:
- Simple, intuitive logic
- Accepted in LeetCode

#### ⚠ Cons:
- Potential overflow if reversed integer exceeds `int` range

####  Time Complexity: O(log₁₀ n)  
####  Space Complexity: O(1)

####  LeetCode Stats:
- ⏱ Runtime: 5 ms (Beats 67.63%)
- 💾 Memory: 44.10 MB (Beats 48.42%)

![Submission_Method1](https://github.com/user-attachments/assets/19ee73a8-161e-4645-a358-6e0ccb243a2e)


---

###  Method 2: String Conversion (Not Accepted in LeetCode)

```java
public boolean isPalindromeASstring(int x) {
    if (x < 0) return false;
    String s = Integer.toString(x);
    for (int i = 0; i < s.length() / 2; i++) {
        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
    }
    return true;
}
```

#### Pros:
- Very easy to write and understand
- Leverages built-in string operations

####  Cons:
- Not memory-efficient
- **Not accepted** in LeetCode due to constraint of avoiding string conversion

#### Time Complexity: O(n)  
#### Space Complexity: O(n)

---

###  Method 3: Reverse Half of the Number (Best)

```java
public boolean isPalindrome_BEST(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    int reverse = 0;
    while (x > reverse) {
        reverse = reverse * 10 + x % 10;
        x /= 10;
    }
    return x == reverse || x == reverse / 10;
}
```

#### Pros:
- Avoids overflow
- Processes only half the digits
- Most efficient method


####  Time Complexity: O(log₁₀ n)  
####  Space Complexity: O(1)

####  LeetCode Stats:
- ⏱ Runtime: 5 ms (Beats 67.63%)
- 💾 Memory: 43.93 MB (Beats 76.33%)

![BestSubmission_Method 3](https://github.com/user-attachments/assets/10e8d3f7-0714-418d-9778-55e73018da9e)

---

## Sample Output (All Three Methods)

```java
Input: 121 → true
Input: -121 → false
Input: 1214 → false
```

---

## Conclusion

- **Best Choice:** Method 3 (half-reversal)  
- It's **safe from overflow**, memory-efficient, and fast

---

## Tags

`Palindrome` `Integer Manipulation` `Math` `Java` `LeetCode` `Optimization`
