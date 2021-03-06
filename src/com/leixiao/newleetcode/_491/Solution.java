package com.leixiao.newleetcode._491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        List<Integer> temp = new ArrayList<>();

        helper(nums, 0, resultSet, temp);

        return new ArrayList<>(resultSet);
    }

    private void helper(int[] nums, int index, Set<List<Integer>> resultSet, List<Integer> temp) {
        for (int i = index; i < nums.length; i++) {
            boolean flag = false;

            if (temp.size() > 0 && temp.get(temp.size() - 1) <= nums[i]) {
                flag = true;
                temp.add(nums[i]);
                if (temp.size() > 1) {
                    resultSet.add(new ArrayList<>(temp));
                }
            } else if (temp.size() == 0) {
                flag = true;
                temp.add(nums[i]);
            }

            helper(nums, i+1, resultSet, temp);

            if (flag) {
                temp.remove(temp.size()-1);
            }
        }
    }
}
