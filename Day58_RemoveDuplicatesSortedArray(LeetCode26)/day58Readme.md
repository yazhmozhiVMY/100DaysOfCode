# RemoveDuplicates

This Java program defines a class `RemoveDuplicates` which removes duplicates from a **sorted** integer array in-place and returns the new length of the array containing only unique elements.

## Overview

The algorithm processes the array from left to right and uses a pointer `idx` to keep track of the position to insert the next unique element. Duplicate values are skipped, and only the first occurrence of each unique value is retained in the array.

## Algorithm

1. Handle edge case: if the array has length 0 or 1, return the length as is.
2. Initialize a pointer `idx` at position 1 (first index after the first element).
3. Iterate through the array starting from index 1.
4. If the current element `nums[i]` is not equal to the previous element `nums[i - 1]`, it is a unique value and gets stored at `nums[idx]`.
5. Increment `idx` for each unique element found.
6. Return `idx` as the new length of the array with unique values.

### Sample Input

```
int[] arr = {1, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5};
```

### Output

```
1 2 3 4 5
```

## Time and Space Complexity

- **Time Complexity**: O(n), where n is the length of the array. The array is traversed once.
- **Space Complexity**: O(1), as the operation is performed in-place with constant extra space.

## Code Structure

- `removeDuplicates(int[] nums)`: Removes duplicates in-place and returns the new length of the array.
- `main(String[] args)`: Demonstrates usage with an example input array.

## How to Compile and Run

```bash
javac RemoveDuplicates.java
java RemoveDuplicates
```

## Notes

- This function assumes the input array is **sorted**.
- The returned length indicates the number of unique elements from the beginning of the array.

