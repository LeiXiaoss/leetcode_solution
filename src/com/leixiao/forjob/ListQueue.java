package com.leixiao.forjob;

import com.leixiao.leetcode.structure.ListNode;

//链表实现队列
public class ListQueue{
    public ListNode first;
    public ListNode last;
    public int length;

    public ListQueue(ListNode node) {
        if(node == null) {
            throw new IllegalArgumentException("不能插入空节点");
        }

        length = 0;
        first = node;
        while (node != null) {
            last = node;
            node = node.next;
            length++;
        }
    }

    public void push(int value) {
        ListNode node = new ListNode(value);

        last.next = node;
        last = node;
        length++;
    }

    public int poll() {
        if (length == 0) {
            throw new IllegalArgumentException("队列为空");
        }

        int value = first.val;
        if(first == last) {
            first = last = null;
            length = 0;
        } else {
            first = first.next;
            length--;
        }
        return value;
    }

    public int pop() {
        if (length == 0) {
            throw new IllegalArgumentException("队列为空");
        }

        return first.val;
    }

}
