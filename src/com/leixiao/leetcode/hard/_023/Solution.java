package com.leixiao.leetcode.hard._023;

import com.leixiao.leetcode.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
    //
    //示例:
    //
    //输入:
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //输出: 1->1->2->3->4->4->5->6

    //分治法
    public ListNode mergeKList(ListNode[] lists){
        if(lists.length == 0) return null;
        return divide(lists,0,lists.length-1);
    }

    public ListNode divide(ListNode[] lists,int left,int right){
        if(left>=right) return lists[left];

        int mid = (left+right) >> 1;

        ListNode l1 = divide(lists,left,mid);
        ListNode l2 = divide(lists,mid+1,right);

        return merge2List(l1,l2);
    }

    public ListNode merge2List(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode first = dummy;

        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                first.next = l1;
                l1 = l1.next;
            }else {
                first.next = l2;
                l2 = l2.next;
            }
            first = first.next;
        }

        //超时
//        while (l1!=null){
//            first.next = l1;
//        }
//        while (l2!=null){
//            first.next = l2;
//        }
        first.next = l1!=null?l1:l2;
        return dummy.next;
    }

    //使用优先队列的实现
    public ListNode mergeKList1(ListNode[] lists){
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val<o2.val) return -1;
                else if(o1.val==o2.val) return 0;
                else return 1;
            }
        });

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode first = dummy;

        for (ListNode head : lists){
            if(head!=null){
                queue.add(head);
            }
        }

        while (!queue.isEmpty()){
            first.next = queue.poll();
            first = first.next;
            if(first.next!=null){
                queue.add(first.next);
            }
        }
        return dummy.next;
    }
}
