package swordoffer.knowledge.migrate;

import swordoffer.base.TreeNode;

public class TreeDepth {

    public int TreeDepth_Solution(TreeNode root) {
        if (null == root)
            return 0;
        int leftDepth = TreeDepth_Solution(root.left);
        int rightDepth = TreeDepth_Solution(root.right);

        return leftDepth > rightDepth? leftDepth+1: rightDepth+1;
    }
}
