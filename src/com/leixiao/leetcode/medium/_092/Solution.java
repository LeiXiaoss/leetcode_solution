package com.leixiao.leetcode.medium._092;

import com.leixiao.leetcode.structure.ListNode;

import java.util.List;

public class Solution {
    //反转从位置 m 到 n 的链表。请使用 一趟扫描 完成反转。
    //
    //说明:
    //1 ≤ m ≤ n ≤ 链表长度。
    //
    //示例:
    //
    //输入: 1->2->3->4->5->NULL, m = 2, n = 4
    //输出: 1->4->3->2->5->NULL

    public ListNode reverseBetween(ListNode head,int m,int n){
        if(m==n) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode mNode = dummy;
        ListNode first = dummy;

        int count = 0;
        ListNode before = dummy;
        while (pre!=null){
            if(count == m-1){
                first = pre;
            }else if(count == m){
                mNode = pre;
            }else if(count == n){
                first.next = pre;
                mNode.next = null;
            }else if(count == n+1){
                mNode.next = pre;
            }

            if(count >= m && count <= n) {
                ListNode cur = pre.next;
                pre.next = before;
                before = pre;
                pre = cur;
                count++;
                continue;
            }
            before = pre;
            count++;
            pre = pre.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode head = solution.reverseBetween(node5,1,1);
        return;
    }
}
