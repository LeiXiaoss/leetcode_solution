package com.leixiao.newleetcode._503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		int n = nums.length;

		Deque<Integer> stack = new LinkedList<>();
		Arrays.fill(result, -1);

		for (int i=0; i < n*2-1; i++) {
			while (!stack.isEmpty() && stack.peek() < nums[i%n]) {
				result[stack.pop()] = nums[i%n];
			}
			stack.push(i%n);
		}
		return result;
	}
}
