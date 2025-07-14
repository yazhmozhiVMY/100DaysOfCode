# Letter Combinations of a Phone Number

This project contains two methods to solve the classic **"Letter Combinations of a Phone Number"** problem, inspired by the mappings of digits to letters on a telephone keypad.

## Problem Statement

Given a string containing digits from 2 to 9 inclusive, return all possible letter combinations that the number could represent. Return the answer in **any order**.

### Example
```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

---

## Method 1: BFS (Queue-based Iterative Approach)

### Algorithm

1. Initialize a queue and push an empty string into it.
2. Iterate while the queue is not empty:
   - Pop the front element.
   - If its length matches the input, add it to output.
   - Otherwise, append possible letters for the next digit.
3. Return the output list.

### Code Logic
```java
// Inside letterCombinations()
while(!que.isEmpty()) {
    String prefix = que.poll();
    if(prefix.length() == digits.length()) {
        output.add(prefix);
    } else {
        int number = digits.charAt(prefix.length()) - '0';
        for(char c: keyChars[number].toCharArray()) {
            que.add(prefix + c);
        }
    }
}
```

### Time and Space Complexity

- **Time:** O(3^N × 4^M) where N is the number of digits that map to 3 letters and M to 4 letters.
- **Space:** O(3^N × 4^M) for the output list and queue.

### Visual for Digits = "235"

Please refer to the diagram below for a detailed BFS execution:

![method_BFS](https://github.com/user-attachments/assets/9a51c58f-8b46-44dc-9c62-3588cd0e55fd)

---

## Method 2: DFS (Backtracking with Recursion)

### Algorithm

1. Define a recursive method `backtrack(index, path)`:
   - If index == digits.length, add path to output.
   - Otherwise, loop through each letter corresponding to current digit.
   - Recurse with the new character appended and backtrack.
2. Call this recursive method starting from index 0.

### Code Logic
```java
// Inside backtrack()
String letters = keyChars[digits.charAt(index) - '0'];
for (char c : letters.toCharArray()) {
    path.append(c);
    backtrack(digits, index + 1, path, output);
    path.deleteCharAt(path.length() - 1); // backtrack
}
```

### Time and Space Complexity

- **Time:** O(3^N × 4^M)
- **Space:** O(N) for recursion depth + O(3^N × 4^M) output

### Visual for Digits = "23"

Please refer to the diagram below for a detailed DFS execution:

![method_DFS](https://github.com/user-attachments/assets/318f983a-3d4a-4e72-b4e4-057c9e482b3a)


---

## Comparison

| Feature          | BFS                     | DFS (Backtracking)           |
|------------------|--------------------------|-------------------------------|
| Approach         | Iterative                | Recursive                     |
| Intermediate DS  | Queue                    | Call Stack                    |
| Output Order     | Level-wise               | Depth-wise                    |
| Ease of Debug    | Moderate                 | Easier with visual tree       |

---

## Test Cases
```
Input: "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Input: "235"
Output: 27 combinations

Input: ""
Output: []
```

---

## How to Run

- Compile the Java file: `javac PhoneNumberCombos.java`
- Run the program: `java PhoneNumberCombos`
