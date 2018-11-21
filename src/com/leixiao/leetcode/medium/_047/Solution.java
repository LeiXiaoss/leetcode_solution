package com.leixiao.leetcode.medium._047;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给定一个可包含重复数字的序列，返回所有不重复的全排列。
    //
    //示例:
    //
    //输入: [1,1,2]
    //输出:
    //[
    //  [1,1,2],
    //  [1,2,1],
    //  [2,1,1]
    //]

    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(lists,new ArrayList<>(),nums,0,visited);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists,List<Integer> tempList,
                           int[] nums,int start,boolean[] visited){
        if(start == nums.length) {
            if(lists.contains(tempList)){
                return;
            }else {
                lists.add(new ArrayList<>(tempList));
                return;
            }
        }

        for (int i=0;i<nums.length;i++){
            if(visited[i] == false) {
                tempList.add(nums[i]);
                visited[i] = true;
                backtrack(lists, tempList, nums, start + 1, visited);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1,1,2}));
    }
}
