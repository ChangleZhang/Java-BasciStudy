package leetcode;

import leetcode.base.ListNode;
import leetcode.base.TreeNode;

public class leetcode109 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        TreeNode t = sortedListToBST(l1);
        printTree(t);
    }

    private static void printTree(TreeNode t){
        System.out.println(t.val);
        if(t.left != null){
            printTree(t.left);
        }else {
            System.out.println("null");
        }
        if(t.right != null){
            printTree(t.right);
        }else{
            System.out.println("null");
        }
    }

    private static ListNode node;
    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while (runner != null) {
            runner = runner.next;
            size++;
        }

        return inorderHelper(0, size - 1);
    }

    private static TreeNode inorderHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }
}