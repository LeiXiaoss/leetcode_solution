package com.leixiao.newleetcode._77;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> list = new ArrayList<>();
		Set<List<Integer>> res = new HashSet<>();

		helper(n, k, 1, list, res);

		return new ArrayList<>(res);
	}

	private void helper(int n, int k, int index, List<Integer> list, Set<List<Integer>> res) {
		for (int i = index; i <= n; i++) {
			boolean flag = false;
			if (list.size() >= 0 && list.size() < k) {
				list.add(i);
				flag = true;
				if (list.size() == k) {
					res.add(new ArrayList<>(list));
				}
			}

			helper(n, k, i+1, list, res);

			if (flag) {
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.combine(1, 1);
	}
}
