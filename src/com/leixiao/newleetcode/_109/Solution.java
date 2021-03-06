package com.leixiao.newleetcode._109;

import com.leixiao.newleetcode.utils.ListNode;
import com.leixiao.newleetcode.utils.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        TreeNode root = addChild(head, 0, length-1);
        return root;
    }

    private TreeNode addChild(ListNode head, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(head.val);
        }

        int middle = (left + right) / 2;
        int count = left;
        ListNode temp = head;
        while (count != middle && temp != null) {
            count++;
            temp = temp.next;
        }
        TreeNode root = new TreeNode(temp.val);

        root.left = addChild(head, left, middle-1);
        root.right = addChild(temp.next, middle+1, right);

        return root;
    }
}
