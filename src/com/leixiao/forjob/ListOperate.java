package com.leixiao.forjob;

import com.leixiao.leetcode.structure.ListNode;

public class ListOperate {
    //链表m到n反转
    public static ListNode revertList(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        int index = 0;

        ListNode first = dummy;
        ListNode mNode = dummy;
        ListNode before = dummy;

        while (current != null) {
            if (index == m-1) {
                first = current;
            } else if (index == m) {
                mNode = current;
            } else if (index == n) {
                first.next = current;
                mNode.next = null;
            } else if (index == n+1) {
                mNode.next = current;
            }

            if (index >= m && index <= n) {
                ListNode temp = current.next;
                current.next = before;
                before = current;
                current = temp;
                index++;
                continue;
            }

            before = current;
            index++;
            current = current.next;
        }
        return dummy.next;
    }

    //链表反转
    //遍历
    public static ListNode revertList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre  = current;
            current = temp;
        }

        return pre;
    }

    //递归
    public static ListNode revertList1(ListNode head) {
        ListNode current = head;
        ListNode pre = null;

        return exchangeNode(current, pre);

    }
    private static ListNode exchangeNode(ListNode current, ListNode pre) {
        if (current == null) return pre;

        ListNode temp = current.next;
        current.next = pre;
        pre = current;
        return exchangeNode(temp, pre);
    }


    //给定一个有序存在重复的值链表，使得每个元素只出现一次
    public static ListNode removeEqualNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            while (temp != null && temp.val == current.val) {
                temp = temp.next;
            }
            current.next = temp;
            current = temp;
        }
        return dummy.next;
    }

    //链表第k-1个节点
    public static ListNode getKNode(ListNode head, int k) {
        ListNode pre = null;
        ListNode current = head;
        int index = 0;


        while (index < k-1) {
            ListNode temp = current.next;
            pre = current;
            current = temp;
            index++;
        }
        return pre;
    }

    //单调不递减链表，删除掉重复值
    public static ListNode removeRepeatNode(ListNode head) {
        if (head == null) return head;

        ListNode pre = head;
        ListNode current = head.next;

        while (current != null) {
            if (pre.val == current.val) {
                current = current.next;
                continue;
            } else {
                pre.next = current;
                pre = current;
                current = current.next;
            }
        }
        return head;
    }



}
