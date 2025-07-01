# 🏠 House Robber Problem – Day 37

## 📘 Problem Statement
Given an array of integers `nums`, where each element represents the amount of money in a house, determine the maximum amount of money you can rob **without robbing two adjacent houses**.

---

## 📊 Approaches Covered

### 1. Tabulation (Bottom-Up DP)
We use a DP array where each index `i` represents the maximum money that can be robbed from the first `i+1` houses.

**Transition Formula:**
```
dp[i] = max(nums[i] + dp[i-2], dp[i-1])
```

**Base Cases:**
```python
dp[0] = nums[0]
dp[1] = max(nums[0], nums[1])
```

**Example:**
```python
nums = [6, 7, 1, 3, 8]
dp = [0] * len(nums)
dp[0] = 6
dp[1] = 7

# Iterative update:
dp[2] = max(1 + 6, 7) = 7
dp[3] = max(3 + 7, 7) = 10
dp[4] = max(8 + 7, 10) = 15

# Result:
return dp[4] = 15
```

---

### 2. Space-Optimized Tabulation
Instead of maintaining an entire DP array, we only track the **last two relevant values**.

**State Variables:**
- `rob`: max money including current house
- `not_rob`: max money excluding current house

**Logic:**
```python
rob = not_rob + num
not_rob = max(prev_rob, not_rob)
```
![PXL_20250701_095707818](https://github.com/user-attachments/assets/818b82e7-9cec-4d8e-a773-6c8f04ae0fa8)

**Python Code:**
```python
def rob(nums):
    rob = 0
    not_rob = 0
    for num in nums:
        new_rob = not_rob + num
        not_rob = max(rob, not_rob)
        rob = new_rob
    return max(rob, not_rob)
```

**Example Execution (for `nums = [6, 7, 1, 3, 8]`):**

| Step | `num` | `rob` | `not_rob` | Explanation |
|------|-------|--------|-----------|-------------|
| 1    | 6     | 6      | 0         | rob = 6+0 |
| 2    | 7     | 7      | 6         | rob = 7+0, not_rob = max(6,0) |
| 3    | 1     | 7      | 7         | rob = 1+6, not_rob = max(7,6) |
| 4    | 3     | 10     | 7         | rob = 3+7, not_rob = max(7,7) |
| 5    | 8     | 15     | 10        | rob = 8+7, not_rob = max(10,7) |

**Final Output:** `max(rob, not_rob) = 15`

---

## 💡 Insight
By analyzing the recurrence in the DP array, we realize each state depends only on the previous two states. Thus, we can reduce the space complexity from **O(n)** to **O(1)** using two variables.

---

## 📌 Summary

| Approach            | Time Complexity | Space Complexity |
|---------------------|------------------|-------------------|
| Tabulation DP       | O(n)             | O(n)              |
| Space Optimized DP  | O(n)             | O(1)              |

