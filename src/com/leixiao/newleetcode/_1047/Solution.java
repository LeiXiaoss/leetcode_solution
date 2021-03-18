package com.leixiao.newleetcode._1047;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public String removeDuplicates(String s) {
		Deque<Character> stack = new LinkedList<>();

		for (int i=0; i<s.length() ; i++) {
			if (!stack.isEmpty() && s.charAt(i) == stack.peek() ) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}
}
