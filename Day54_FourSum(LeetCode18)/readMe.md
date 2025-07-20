
# FourSum - Day 17 of #100DaysOfLeetCode

This Java program implements a solution for the **Four Sum** problem from LeetCode. The goal is to find all unique quadruplets in an array that sum up to a given target.

---

##  Problem Description

Given an array `nums` of `n` integers and an integer `target`, return all unique quadruplets `[a, b, c, d]` such that:

```
a + b + c + d == target
```

###  Example

```java
Input: nums = [1, 0, -1, 0, -2, 2], target = 0  
Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
```

---

##  Features

- Efficient **O(n³)** time complexity with early pruning
- Handles duplicate elements correctly
- Prevents integer overflow using `long` for sum calculations
- Demonstrates use of sorting and two-pointer technique

---

##  Code Overview

```java
import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ip1 = {1, 0, -1, 0, -2, 2};
        int[] ip2 = {2, 2, 2, 2, 2};
        FourSum t = new FourSum();
        System.out.println("Input [1,0,-1,0,-2,2] and target 0 : " + t.fourSum(ip1, 0));
        System.out.println("Input [2,2,2,2,2] and target 8: " + t.fourSum(ip2, 8));
    }
}
```

---

##  Sample Output

```
Input [1,0,-1,0,-2,2] and target 0 : [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
Input [2,2,2,2,2] and target 8: [[2, 2, 2, 2]]
```

---

##  Time and Space Complexity

| Aspect       | Complexity            |
|--------------|------------------------|
| Time         | O(n³) with pruning     |
| Space        | O(1) (excluding result) |

---

##  Tags

`#100DaysOfLeetCode` `#Java` `#TwoPointers` `#FourSum` `#Sorting` `#Array`

---
