package com.leixiao.leetcode.easy._083;

import com.leixiao.leetcode.structure.ListNode;

public class Solution {
    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    //
    //示例 1:
    //
    //输入: 1->1->2
    //输出: 1->2
    //示例 2:
    //
    //输入: 1->1->2->3->3
    //输出: 1->2->3

    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;

        while (pre.next != null){
            ListNode cur = pre.next;
            if(pre.val == cur.val){
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
