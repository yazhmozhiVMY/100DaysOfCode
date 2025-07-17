
#  Balanced Parentheses Validator

This project provides a Java solution to the *Valid Parentheses* problem from LeetCode. It checks whether a given string containing only the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'` is **balanced**—i.e., each opening bracket has a corresponding closing bracket in the correct order.

---

##  Problem Statement

Given a string `s` containing just the characters `(`, `)`, `{`, `}`, `[` and `]`, determine if the input string is valid.

A string is considered valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every closing bracket has a corresponding open bracket of the same type.

---

## Method: `isValid_WithStack(String s)`

This method uses a **stack** to track the opening brackets. The logic ensures that every time a closing bracket is encountered, it matches the type of the most recent opening bracket.

###  Algorithm

1. Initialize an empty stack.
2. Traverse the string:
   - If the current character is `'('`, `'['`, or `'{'`, **push** it onto the stack.
   - If it is a closing bracket:
     - Check if the stack is not empty and if the **top of the stack** is the corresponding opening bracket.
     - If so, **pop** the stack.
     - Otherwise, return `false` (mismatch or premature closing).
3. After processing all characters:
   - If the stack is empty, return `true` (balanced).
   - Otherwise, return `false`.

---

### Examples

| Input      | Output | Explanation                                      |
|------------|--------|--------------------------------------------------|
| `"[(){}]"` | `true` | Properly nested brackets                         |
| `"[}"`     | `false`| Closing bracket `}` does not match opening `[`   |
| `"["`      | `false`| Missing closing bracket                          |
| `"[]}"`    | `false`| Extra closing bracket                            |

---

##  Code Snippet

```java
public boolean isValid_WithStack(String s) {
    Stack<Character> openParanthesesStack = new Stack<>();
    for (char currentChar : s.toCharArray()) {
        if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
            openParanthesesStack.push(currentChar);
        } else {
            if (!openParanthesesStack.isEmpty() &&
                ((currentChar == ')' && openParanthesesStack.peek() == '(') ||
                 (currentChar == ']' && openParanthesesStack.peek() == '[') ||
                 (currentChar == '}' && openParanthesesStack.peek() == '{'))) {
                openParanthesesStack.pop();
            } else {
                return false;
            }
        }
    }
    return openParanthesesStack.isEmpty();
}
```

---

##  Time & Space Complexity

| Metric            | Complexity           |
|-------------------|----------------------|
| **Time Complexity** | `O(n)` — one pass through the string |
| **Space Complexity**| `O(n)` — in the worst case, all characters are opening brackets stored in the stack |

---

##  Future Enhancements

- Add an implementation without a stack using integer counting (works only for simple parentheses).
- Handle input validation (non-bracket characters).
- Create a unit testing class for broader test coverage.

---

## 📅 Day 14 of #100DaysOfLeetCode

Implemented by **YazhVM** as part of the #100DaysOfLeetCode challenge.
