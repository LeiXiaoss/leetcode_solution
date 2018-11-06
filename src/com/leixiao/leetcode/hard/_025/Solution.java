package com.leixiao.leetcode.hard._025;

import com.leixiao.leetcode.structure.ListNode;

public class Solution {
    //给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
    //
    //k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
    //
    //示例 :
    //
    //给定这个链表：1->2->3->4->5
    //
    //当 k = 2 时，应当返回: 2->1->4->3->5
    //
    //当 k = 3 时，应当返回: 3->2->1->4->5
    //
    //说明 :
    //
    //    你的算法只能使用常数的额外空间。
    //    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    //好难。。。
    //链表
    public ListNode reverseKGroup(ListNode head, int k){
        if(head ==  null || k == 1) return head;
        ListNode node = new ListNode(0);
        ListNode pre = node;
        node.next = head;
        for (int i=1;head!=null;i++){
            if(i%k == 0){
                pre = reverse(pre,head.next);
                head = pre.next;
            }else {
                head = head.next;
            }
        }
        return node.next;
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        ListNode head = pre.next;
        ListNode move = head.next;
        while (move!=next){
            head.next = move.next;
            move.next = pre.next;
            pre.next = move;
            move = head.next;
        }
        return head;
    }
}
