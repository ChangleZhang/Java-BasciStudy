package swordoffer.knowledge.migrate;

import swordoffer.base.TreeNode;

public class TreeDepth {
    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */

    public int TreeDepth_Solution(TreeNode root) {
        if (null == root)
            return 0;
        int leftDepth = TreeDepth_Solution(root.left);
        int rightDepth = TreeDepth_Solution(root.right);

        return leftDepth > rightDepth? leftDepth+1: rightDepth+1;
    }
}
