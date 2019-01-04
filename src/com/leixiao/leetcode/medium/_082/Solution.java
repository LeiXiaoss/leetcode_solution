package com.leixiao.leetcode.medium._082;

import com.leixiao.leetcode.structure.ListNode;

public class Solution {
    //给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
    //
    //示例 1:
    //
    //输入: 1->2->3->3->4->4->5
    //输出: 1->2->5
    //示例 2:
    //
    //输入: 1->1->1->2->3
    //输出: 2->3

    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode keep = dummy;

        OUT:
        while (true){
            if(pre.val == cur.val){
                while (pre.val == cur.val){
                    cur = cur.next;
                    if(cur == null){
                        keep.next = null;
                        break OUT;
                    }
                }
                pre = cur;
                cur = cur.next;
            }else {
                keep.next = pre;
                keep = pre;
                pre = cur;
                cur = cur.next;
            }

            if(cur == null){
                keep.next = pre;
                keep = pre;
                keep.next = null;
                break;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null){
            ListNode cur = pre.next;
            while(cur.next != null && cur.val == cur.next.val) cur = cur.next;
            if(pre.next != cur) pre.next = cur.next;
            else pre = pre.next;
        }
        return dummy.next;
    }
}
