package com.leixiao.leetcode.medium._061;

import com.leixiao.leetcode.structure.ListNode;

import java.util.List;

public class Solution {
    //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    //
    //示例 1:
    //
    //输入: 1->2->3->4->5->NULL, k = 2
    //输出: 4->5->1->2->3->NULL
    //解释:
    //向右旋转 1 步: 5->1->2->3->4->NULL
    //向右旋转 2 步: 4->5->1->2->3->NULL
    //示例 2:
    //
    //输入: 0->1->2->NULL, k = 4
    //输出: 2->0->1->NULL
    //解释:
    //向右旋转 1 步: 2->0->1->NULL
    //向右旋转 2 步: 1->2->0->NULL
    //向右旋转 3 步: 0->1->2->NULL
    //向右旋转 4 步: 2->0->1->NULL

    public ListNode rotateRight(ListNode head,int k){
        if (head == null || head.next == null) {
            return head;
        }

        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        cur.next = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < count - k; i++) {
            prev = prev.next;
        }
        cur = prev.next;
        prev.next = null;
        return cur;
    }
}
