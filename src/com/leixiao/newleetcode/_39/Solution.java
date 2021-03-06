package com.leixiao.newleetcode._39;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		helper(res, list, target, 0, candidates);

		return new ArrayList<>(res);
	}

	private void helper(Set<List<Integer>> res, List<Integer> list, int target, int index, int[] candidates) {
		if (index == candidates.length) {
			return;
		}

		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		helper(res, list, target, index+1, candidates);

		if (target - candidates[index] >= 0) {
			list.add(candidates[index]);
			helper(res, list, target - candidates[index], index, candidates);
			list.remove(list.size() - 1);
		}
	}
}
