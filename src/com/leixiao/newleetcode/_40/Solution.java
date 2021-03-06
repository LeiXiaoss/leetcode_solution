package com.leixiao.newleetcode._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		Arrays.sort(candidates);
		helper(res, list, 0, target, candidates);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list, int index, int target, int[] candidates) {
		if (target < 0) return;
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i] == candidates[i-1]) continue;
			list.add(candidates[i]);
			helper(res, list, i+1, target-candidates[i], candidates);
			list.remove(list.size()-1);
		}
	}
}
