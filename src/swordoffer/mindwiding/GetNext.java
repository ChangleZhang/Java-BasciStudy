package swordoffer.mindwiding;

import swordoffer.base.TreeLinkNode;

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (null == pNode)
            return null;

        TreeLinkNode next = null;
        // if current have right, get leftest of right
        if (null != pNode.right) {
            TreeLinkNode pRight = pNode.right;
            while (null != pRight.left) {
                pRight = pRight.left;
            }
            next = pRight;
        } else if(pNode.next != null){
            // get the first father which is grandfather's left
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pFather = pNode.next;
            while (pFather!= null && pCurrent !=pFather.left) {
                pCurrent = pFather;
                pFather = pFather.next;
            }
            next = pFather;
        }
        return next;
    }
}
