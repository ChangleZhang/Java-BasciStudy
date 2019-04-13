package swordoffer.time.space.balance;

import leetcode.leetcodeaa.base.ListNode;

public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (null == pHead1 || null == pHead2)
            return null;

        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        ListNode pLong;
        ListNode pShort;
        int gap;
        if (len1 > len2) {
            pLong = pHead1;
            pShort = pHead2;
            gap = len1 - len2;
        } else {
            pLong = pHead2;
            pShort = pHead1;
            gap = len2 - len1;
        }
        for (int i=0; i<gap; i++) {
            pLong = pLong.next;
        }
        while (pLong != null && pShort != null) {
            if (pLong.val == pShort.val)
                return pLong;
            pLong = pLong.next;
            pShort = pShort.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int len = 1;
        while (head.next != null) {
            len ++;
            head = head.next;
        }
        return len;
    }
}
