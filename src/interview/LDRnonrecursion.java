package interview;


import java.util.Stack;

public class LDRnonrecursion {
    public void LDR(leetcode.base.TreeNode root) {
        if (null == root)
            return;
        Stack<leetcode.base.TreeNode> stack = new Stack<>();
        while(root!= null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }
}
