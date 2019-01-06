package com.leixiao.leetcode.medium._086;

import com.leixiao.leetcode.structure.ListNode;

public class Solution {
    //给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
    //
    //你应当保留两个分区中每个节点的初始相对位置。
    //
    //示例:
    //
    //输入: head = 1->4->3->2->5->2, x = 3
    //输出: 1->2->2->4->3->5

    public ListNode partition(ListNode head, int x) {
        if(head == null ) return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;

        ListNode cur = dummy;
        while (cur.next != null){
            cur = cur.next;
            if(cur.val >= x){
                break;
            }
            pre = pre.next;
        }
        //如果cur是最后一个元素，直接返回
        //pre是cur之前一个节点
        if(cur.next == null) return head;

        while (cur.next != null){

            if(cur.next.val<x){
                ListNode temp = cur.next;

                if(cur.next.next != null){
                    cur.next = cur.next.next;
                }else {
                    cur.next = null;
                }

                temp.next = pre.next;
                pre.next = temp;

                pre = pre.next;
            }else {
                continue;
            }
        }
        return dummy.next;
    }
}
