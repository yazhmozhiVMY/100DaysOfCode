I lost my streak. So, this is gonna be 200 days of leetcode. Starting my streak again. 
Day 1 - 4th August
# Day 1 of 100days of leetCode
# Inorder Traversal of a Binary Tree (Iterative)

## Overview
This project implements an **iterative inorder traversal** of a binary tree in Java using a stack.  
Inorder traversal visits nodes in the following order:
1. **Left subtree**
2. **Root**
3. **Right subtree**

This avoids recursion by explicitly using a `Stack<TreeNode>`.

---

## Algorithm

1. Initialize an empty list `result` to store the traversal output.
2. Initialize an empty stack `stack`.
3. Set `node` to the root of the tree.
4. While `true`:
    - If `node` is not null:
        - Push `node` onto the stack.
        - Move to the left child (`node = node.left`).
    - Else if the stack is empty:
        - Break the loop (all nodes have been visited).
    - Else:
        - Pop a node from the stack.
        - Add the node's value to `result`.
        - Move to the right child (`node = node.right`).
5. Return the `result` list.

---

## Code

```java
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class InorrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
                continue;
            }
            if (stack.size() == 0) {
                break;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    public static void main(String[] args) {
        InorrderTraversal traversal = new InorrderTraversal();

        // Example 1: Tree [1, null, 2, 3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println("Inorder traversal of tree 1: " + traversal.inorderTraversal(root1));

        // Example 2: Tree [4, 2, 5, 1, 3]
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        System.out.println("Inorder traversal of tree 2: " + traversal.inorderTraversal(root2));
    }
}
```

---

## Example 1: Tree [1, null, 2, 3]

```
    1
           2
     /
    3
```

### Iterations:
- Start: node = 1, stack = [], result = []
- Push 1 → stack = [1], node = null (left is null)
- Pop 1 → result = [1], node = 2
- Push 2 → stack = [2], node = 3
- Push 3 → stack = [2, 3], node = null
- Pop 3 → result = [1, 3], node = null
- Pop 2 → result = [1, 3, 2], node = null
- Stack empty → end.

Output: **[1, 3, 2]**

---

## Example 2: Tree [4, 2, 5, 1, 3]

```
        4
       /       2   5
     /     1   3
```

### Iterations:
- Start: node = 4, stack = [], result = []
- Push 4 → stack = [4], node = 2
- Push 2 → stack = [4, 2], node = 1
- Push 1 → stack = [4, 2, 1], node = null
- Pop 1 → result = [1], node = null
- Pop 2 → result = [1, 2], node = 3
- Push 3 → stack = [4, 3], node = null
- Pop 3 → result = [1, 2, 3], node = null
- Pop 4 → result = [1, 2, 3, 4], node = 5
- Push 5 → stack = [5], node = null
- Pop 5 → result = [1, 2, 3, 4, 5], node = null
- Stack empty → end.

Output: **[1, 2, 3, 4, 5]**

---

## Time Complexity
- **O(n)** where `n` is the number of nodes in the tree.
  - Each node is pushed and popped from the stack exactly once.

## Space Complexity
- **O(n)** in the worst case (unbalanced tree) for the stack.
- **O(h)** where `h` is the height of the tree for a balanced tree.

---
