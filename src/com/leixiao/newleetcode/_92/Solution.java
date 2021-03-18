package com.leixiao.newleetcode._92;

import com.leixiao.newleetcode.utils.ListNode;

public class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;

		ListNode pre = dummyNode;
		for (int i=0; i < left-1 ; i++) {
			pre = pre.next;
		}

		ListNode rightNode = dummyNode;
		for (int i=0; i < right-left+1; i++) {
			rightNode = rightNode.next;
		}

		ListNode leftNode = pre.next;
		ListNode current = rightNode.next;

		pre.next = null;
		rightNode.next = null;

		reverseLinkedList(leftNode);

		pre.next = rightNode;
		leftNode.next = current;
		return dummyNode.next;
	}

	public void reverseLinkedList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
	}

}
