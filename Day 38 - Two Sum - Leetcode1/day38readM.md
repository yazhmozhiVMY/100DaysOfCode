# LeetCode Problem: Two Sum (Easy)

## 🔗 Problem Link
[LeetCode #1 - Two Sum] (https://leetcode.com/problems/two-sum/description/)

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the **indices** of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

### Example

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

---

##  Approach

To solve this in **O(n)** time instead of O(n²), we use a **hash map** (dictionary in Python) to store each number's index as we iterate. For each number `num`, we check if its complement (`target - num`) is already in the map:

- If yes → we've found the two numbers.
- If not → store the current number and its index in the map.

---

## Solution (Python)

```python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        numIndexDict={}
        for index,num in enumerate(nums):
            pair=target-num
            if pair in numIndexDict:
                return [numIndexDict[pair],index]
            numIndexDict[num]=index
        else:
            return []

---

## Time and spac
Time	O(n) — One pass through the list
Space	O(n) — For the hash map
