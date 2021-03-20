package com.leixiao.newleetcode._150;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> numStack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				numStack.push(numStack.pop()+ numStack.pop());
			} else if (tokens[i].equals("-")) {
				int second = numStack.pop();
				int first = numStack.pop();
				numStack.push(first - second);
			} else if (tokens[i].equals("/")) {
				int second = numStack.pop();
				int first = numStack.pop();
				numStack.push(first / second);
			} else if (tokens[i].equals("*")) {
				numStack.push(numStack.pop() * numStack.pop());
			} else {
				numStack.push(Integer.parseInt(tokens[i]));
			}
		}

		return numStack.pop();
	}
}
