package com.leixiao.leetcode.medium._109;

import com.leixiao.leetcode.structure.ListNode;
import com.leixiao.leetcode.structure.TreeNode;

public class Solution {
    //给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
    //
    //本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    //
    //示例:
    //
    //给定的有序链表： [-10, -3, 0, 5, 9],
    //
    //一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
    //
    //      0
    //     / \
    //   -3   9
    //   /   /
    // -10  5

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }

        TreeNode root = addChild(head,0,length-1);
        return root;
    }

    private TreeNode addChild(ListNode head, int left, int right) {
        if(left > right) return null;

        if(left == right) {
            return new TreeNode(head.val);
        }

        int middle = (left+right)/2;
        int count = left;
        ListNode temp = head;
        while (count != middle && temp != null){
            count++;
            temp = temp.next;
        }
        TreeNode root = new TreeNode(temp.val);

        root.left = addChild(head,left,middle-1);
        root.right = addChild(temp.next,middle+1,right);

        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBST(head);
        return;
    }


}
