# LeetCode #13: Roman to Integer (Java)

##  Problem Statement

Given a Roman numeral, convert it to an integer.

### Roman Symbols:
| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

### Special Rules:
- `IV = 4`, `IX = 9`
- `XL = 40`, `XC = 90`
- `CD = 400`, `CM = 900`

---

## Solutions Implemented

### 🔹 Method 1: Without Hashing (Character Switch)
A helper function `roman(char c)` returns the value for each Roman character.  
This solution compares current and next characters, subtracting when a smaller numeral precedes a larger one.

```java
public static int roman(char c)
    {
        if(c=='I') return 1;
        if(c=='V') return 5;
        if(c=='X') return 10;
        if(c=='L') return 50;
        if(c=='C') return 100;
        if(c=='D') return 500;
        if(c=='M') return 1000;
        return -1;
    }
public int romanToInt_noHashing(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
        int first = roman(s.charAt(i));
        if (i + 1 < s.length()) {
            int second = roman(s.charAt(i + 1));
            if (first < second) {
                result += (second - first);
                i++;
            } else {
                result += first;
            }
        } else {
            result += first;
        }
    }
    return result;
}
```

#### Pros:
- Very fast (no HashMap lookup)
- Space-efficient

#### Cons:
- Manual handling of each Roman numeral
- Slightly less readable

####  Time: O(n) |  Space: O(1)

LeetCode Stats (Method 1):
- Runtime: **2 ms** (Beats 100.00%)
- Memory: **45.22 MB** (Beats 10.73%)


![Method1](https://github.com/user-attachments/assets/791b2474-ff9e-47d0-88ff-98894b2d528f)


---

### 🔹 Method 2: With Hashing (HashMap)

This version uses a HashMap for readability and flexibility.

```java
public int romanToInt_Hashing(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1); map.put('V', 5); map.put('X', 10);
    map.put('L', 50); map.put('C', 100);
    map.put('D', 500); map.put('M', 1000);

    int result = 0;
    for (int i = 0; i < s.length(); i++) {
        if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
            result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
            i++;
        } else {
            result += map.get(s.charAt(i));
        }
    }
    return result;
}
```

#### Pros:
- Readable and clean
- Easy to modify/extend

#### Cons:
- Slightly slower due to HashMap access

####  Time: O(n) | Space: O(1)

📸 LeetCode Stats (Method 2):
- Runtime: **5 ms** (Beats 53.36%)
- Memory: **44.60 MB** (Beats 92.15%)


![Method2_Hashing](https://github.com/user-attachments/assets/d52e8368-e83e-48c6-9566-c0f514fa2ca5)


---

##  Sample Output

```
LVIII = 58
IX = 9
XC = 90
```

---

##  Conclusion

-  Best Runtime: Method 1 (No Hashing)
-  Most Readable: Method 2 (With HashMap)

Use Method 1 in interviews if you're optimizing for performance.  
Use Method 2 for maintainability and clarity.

---

##  Tags

`Roman Numerals` `Greedy` `HashMap` `String Parsing` `LeetCode` `Java`

