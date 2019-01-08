package com.leixiao.leetcode.medium._090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    //
    //说明：解集不能包含重复的子集。
    //
    //示例:
    //
    //输入: [1,2,2]
    //输出:
    //[
    //  [2],
    //  [1],
    //  [1,2,2],
    //  [2,2],
    //  [1,2],
    //  []
    //]

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(result,new ArrayList<>(),nums,0);
        return result;
    }

    public void backtrack(List result,List<Integer> temp,int[] nums,int index){
        if(!result.contains(temp)){
            result.add(new ArrayList<>(temp));
        }

        for (int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    // 剪枝
    public void backtrack1(List result,List<Integer> temp,int[] nums,int index){
        result.add(new ArrayList<>(temp));

        for (int i=index;i<nums.length;i++){
            //与之前的一个数相同时，跳过这个数
            if (i>index&&nums[i]==nums[i-1]) continue;

            temp.add(nums[i]);
            backtrack1(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsetsWithDup(new int[]{1,2,2});
        for (List list  : result) {
            System.out.println(list);
        }
    }
}
