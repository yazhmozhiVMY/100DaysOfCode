# LeetCode Problem: Reverse Integer (Easy)

## 🔗 Problem Link
[LeetCode #7 - Reverse Integer](https://leetcode.com/problems/reverse-integer/)

---

## 🧠 Problem Statement

Given a signed 32-bit integer `x`, return its digits reversed.  
If reversing `x` causes the value to go outside the 32-bit signed integer range  
`[-2³¹, 2³¹ - 1]`, return `0`.

---

### 📥 Example Inputs & Outputs

| Input   | Output |
|---------|--------|
| `123`   | `321`  |
| `-123`  | `-321` |
| `120`   | `21`   |
| `0`     | `0`    |
| `1534236469` | `0` (overflow) |

---

## Approach

1. Extract digits one by one using modulo and integer division.
2. Build the reversed number as `rev = rev * 10 + digit`.
3. Before adding a digit, **check for 32-bit overflow**:
   - If `rev > MAX // 10` OR
   - `rev == MAX // 10` AND `digit > 7` → Overflow!
4. Return 0 on overflow, else return `sign * rev`.

## Overflow check
1. MAX = 2,147,483,647
2. MIN = -2,147,483,648

1️⃣ rev > INT_MAX // 10
We're about to do: rev = rev * 10 + remainder

1. Before we do that, we check if multiplying rev by 10 will already cross the limit.
2. MAX // 10 = 214748364 — If rev is greater than this, then:
rev * 10 = >= 2147483640 → Already too big!
Even without + remainder, it will overflow.

2️⃣ rev == INT_MAX // 10 and remainder > 7

1. If rev == 214748364, then we're on the edge.
2. The final digit of INT_MAX is 7, so:

If remainder > 7, then rev * 10 + remainder > 2147483647 → overflow
If remainder ≤ 7, it’s still safe.

---

## Time and space complexity

|   Time         | Space  |
|----------------|--------|
| `O(log10 x)`   | `O(1)` |

O(log₁₀(x)) — O(number of digits)
