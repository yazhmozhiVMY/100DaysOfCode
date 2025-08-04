import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Write a description of class InorrderTraversal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InorrderTraversal
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (true) {
            if (node != null){
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
    public static void main(String[] args) 
    {
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
