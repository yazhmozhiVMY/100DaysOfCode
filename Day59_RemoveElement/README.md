# RemoveEltArray

This Java program defines a class `RemoveEltArray` that removes all instances of a specific value from an integer array **in-place**, and returns the new length of the array.

## Overview

The `removeElement` method iterates through the array and keeps only the elements that are **not equal** to the given value `val`. These elements are compacted to the front of the array. The rest of the array after the returned length is left unchanged but is not part of the meaningful data.

## Algorithm

1. Initialize a pointer `k` to track the position of the next element that is **not equal** to `val`.
2. Loop through the array from index `0` to `n - 1`:
   - If `nums[i]` is not equal to `val`, assign it to `nums[k]` and increment `k`.
3. After the loop, `k` holds the number of elements that are **not equal** to `val`.
4. Return `k` as the new length of the modified array.

### Sample Input

```java
int[] arr = {2, 3, 3, 3, 4, 5, 5};
int newSize = r.removeElement(arr, 3);
```

### Output

```
2 4 5 5
```

> Note: Only the first `newSize` elements are valid. The rest may contain overwritten or irrelevant data.

## Time and Space Complexity

- **Time Complexity**: O(n), where n is the length of the array. Each element is checked once.
- **Space Complexity**: O(1), as all operations are done in-place with no extra memory.

## Code Structure

- `removeElement(int[] nums, int val)`: Removes all instances of `val` in-place and returns the length of the resulting array.
- `main(String[] args)`: Demonstrates the method using a sample array.

## How to Compile and Run

```bash
javac RemoveEltArray.java
java RemoveEltArray
```

## License

This code is provided for educational purposes.