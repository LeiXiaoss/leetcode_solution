package com.leixiao.leetcode.medium._046;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给定一个没有重复数字的序列，返回其所有可能的全排列。
    //
    //示例:
    //
    //输入: [1,2,3]
    //输出:
    //[
    //  [1,2,3],
    //  [1,3,2],
    //  [2,1,3],
    //  [2,3,1],
    //  [3,1,2],
    //  [3,2,1]
    //]

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists,new ArrayList<>(),nums,0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists,List<Integer> tempList,int[] nums,int start){
        if(start == nums.length) {
            lists.add(new ArrayList<>(tempList));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if(!tempList.contains(nums[i])){
                tempList.add(nums[i]);
                backtrack(lists,tempList,nums,start+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
}
