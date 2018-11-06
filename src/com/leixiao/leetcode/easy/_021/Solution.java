package com.leixiao.leetcode.easy._021;

import com.leixiao.leetcode.structure.ListNode;

public class Solution {
    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //
    //示例：
    //
    //输入：1->2->4, 1->3->4
    //输出：1->1->2->3->4->4

    //链表
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode firstNode = dummy;

        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                firstNode.next = l1;
                l1 = l1.next;
            }else {
                firstNode.next = l2;
                l2 = l2.next;
            }
            firstNode = firstNode.next;
        }
        while (l1!=null){
            firstNode.next = l1;
            l1 = l1.next;
            firstNode = firstNode.next;
        }
        while (l2!=null){
            firstNode.next = l2;
            l2 = l2.next;
            firstNode = firstNode.next;
        }
        return dummy.next;
    }
}
