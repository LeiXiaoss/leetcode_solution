package com.leixiao.newleetcode._227;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public int calculate(String s) {
		Deque<Integer> stack = new LinkedList<>();

		int num = 0;
		char preSign = '+';
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}

			if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1) {
				switch (preSign) {
					case '+':
						stack.push(num);
						break;
					case '-':
						stack.push(-num);
						break;
					case '/':
						stack.push(stack.pop() / num);
						break;
					default:
						stack.push(stack.pop() * num);
						break;
				}
				num = 0;
				preSign = s.charAt(i);
			}
		}

		int ans = 0;
		while (!stack.isEmpty()){
			ans += stack.pop();
		}
		return ans;
	}
}
