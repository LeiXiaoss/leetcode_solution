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
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head.next;
        int count = 2;
        while (cur.next != null){
            count++;
            cur = cur.next;
        }

        k = k % count;
        if(k==0) return head;

        cur.next = head;

        ListNode prev = head;
        for (int i=1;i<count-k;i++){
            prev = prev.next;
        }

        cur = prev.next;
        prev.next = null;
        return cur;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode node = solution.rotateRight(head,2);
        return;
    }
}
