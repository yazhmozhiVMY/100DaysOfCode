
#  ThreeSumClosest
Day 16 of #100DaysOfLeetCode
This Java program provides an implementation of the **Three Sum Closest** problem using the **two-pointer** technique after sorting the input array. The goal is to find **three integers** in an array whose sum is **closest to a given target** value.

---

##  Problem Description

Given an integer array `nums` of length `n` and an integer `target`, find **three integers** in `nums` such that the **sum is closest** to `target`.

**You must return the sum of the three integers.**

###  Example

```
Input: nums = [-1, 2, 1, -4], target = 1  
Output: 2  
Explanation: The sum that is closest to 1 is 2 (-1 + 2 + 1).
```

---

##  Features

- Efficient **O(n²)** solution using two pointers
- Handles negative and positive values
- Returns the **closest possible sum**
- Includes a working `main()` method with test cases

---

##  How It Works

### 1. **Sorting the Array**
The array is sorted to enable the two-pointer technique:
```java
Arrays.sort(nums);
```

### 2. **Iterating Through Each Number**
For each `nums[i]`, a left and right pointer scan the rest of the array for the best sum:
```java
for (int i = 0; i < n - 2; i++) {
    int left = i + 1, right = n - 1;
    ...
}
```

### 3. **Updating Closest Difference**
We calculate the absolute difference between the current sum and the target, updating the result when a closer sum is found:
```java
int currentDiff = Math.abs(sum - target);
if (currentDiff < diff) {
    diff = currentDiff;
    result = sum;
}
```

### 4. **Moving Pointers**
Depending on whether the sum is greater than or less than the target:
- If `sum > target`, move the right pointer left
- If `sum < target`, move the left pointer right

### 5. **Early Return for Exact Match**
If `sum == target`, the closest match is found, and the function returns immediately.

---

##  Sample Output

```
Input [-1, 2, 1, -4] and target 1 : 2
Input [-1, 2, 2, 4] and target 4: 5
```

---

##  Code

```java
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(sum - target);
                if (currentDiff < diff) {
                    diff = currentDiff;
                    result = sum;
                }
                if (currentDiff == 0) return sum;
                else if (sum > target) right--;
                else left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ip1 = {-1, 2, 1, -4};
        int[] ip2 = {-1, 2, 2, 4};
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println("Input [-1,2,1,-4] and target 1 : " + t.threeSumClosest(ip1, 1));
        System.out.println("Input [-1, 2, 2, 4] and target 4: " + t.threeSumClosest(ip2, 4));
    }
}
```

---

##  Time and Space Complexity

| Aspect       | Complexity         |
|--------------|--------------------|
| Time         | O(n²)              |
| Space        | O(1) (in-place sort and constant extra space) |

---
