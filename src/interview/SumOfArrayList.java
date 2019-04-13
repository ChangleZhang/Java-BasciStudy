package interview;

import leetcode.leetcodeaa.base.ListNode;

public class SumOfArrayList {
    public static void main(String[] args) {
        SumOfArrayList sum = new SumOfArrayList();
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode root2 = new ListNode(8);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        root2.next = node4;
        node4.next = node5;
        node5.next = null;

        sum.printList(root);
        sum.printList(root2);
        ListNode add1 = sum.sumOfArrayList(root2, root);
        sum.printList(add1);
    }

    private ListNode sumOfArrayList(ListNode root1, ListNode root2) {
        ListNode rNode1 = reverseList(root1);
        ListNode rNode2 = reverseList(root2);
        ListNode resNode = sumList(rNode1, rNode2);
        return reverseList(resNode);
    }

    private ListNode reverseList(ListNode root) {
        if (null == root) {
            return null;
        }
        ListNode preNode;
        ListNode curNode;
        ListNode nextNode;
        preNode = root;
        curNode = root.next;
        preNode.next = null;
        while(null != curNode) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    private ListNode sumList(ListNode root1, ListNode root2) {
        int add = 0;
        ListNode res = new ListNode(0);
        ListNode out = res;
        while(root1 != null && root2 != null) {
            ListNode nextNode = new ListNode(0);
            nextNode.val = (root1.val + root2.val + add) % 10;
            add = (root1.val + root2.val) / 10;
            root1 = root1.next;
            root2 = root2.next;
            res.next = nextNode;
            res = nextNode;
        }
        while(root1 != null){
            ListNode nextNode = new ListNode(0);
            nextNode.val = root1.val + add;
            add = 0;
            root1 = root1.next;
            res.next = nextNode;
            res = nextNode;
        }
        while(root2 != null){
            ListNode nextNode = new ListNode(0);
            nextNode.val = root2.val + add;
            add = 0;
            root2 = root2.next;
            res.next = nextNode;
            res = nextNode;
        }
        return out.next;
    }

    private void printList(ListNode root) {
        while (null != root) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        System.out.println();
    }
}
