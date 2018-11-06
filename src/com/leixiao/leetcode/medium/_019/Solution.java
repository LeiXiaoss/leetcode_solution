package com.leixiao.leetcode.medium._019;

import com.leixiao.leetcode.structure.ListNode;

public class Solution {
    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    //
    //示例：
    //
    //给定一个链表: 1->2->3->4->5, 和 n = 2.
    //
    //当删除了倒数第二个节点后，链表变为 1->2->3->5.
    //
    //说明：
    //
    //给定的 n 保证是有效的。
    //
    //进阶：
    //
    //你能尝试使用一趟扫描实现吗？

    public ListNode removeNthFromEnd(ListNode head, int n){
        int length = 0;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            length++;
        }

        int nthFromFirst = length - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        temp = dummy;

        while (nthFromFirst > 0){
            nthFromFirst--;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i=0;i<n;i++){
            first = first.next;
        }

        while (first.next!=null){
            second = second.next;
            first = first.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
