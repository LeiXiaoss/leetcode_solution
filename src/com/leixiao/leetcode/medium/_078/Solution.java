package com.leixiao.leetcode.medium._078;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    //
    //说明：解集不能包含重复的子集。
    //
    //示例:
    //
    //输入: nums = [1,2,3]
    //输出:
    //[
    //  [3],
    //  [1],
    //  [2],
    //  [1,2,3],
    //  [1,3],
    //  [2,3],
    //  [1,2],
    //  []
    //]

    //回溯
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result,new ArrayList<>(),0);
        return result;
    }

    private void backtrack(int[] nums,List result,List<Integer> temp,int start){
        result.add(new ArrayList<>(temp));

        for (int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(nums,result,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }

    //位运算
    public List<List<Integer>> subsets1(int[] nums){
        return null;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.subsets1(new int[]{1,2,3});
        return;
    }
}
