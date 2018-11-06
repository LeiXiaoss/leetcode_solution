package com.leixiao.leetcode.medium._016;

import java.util.Arrays;

public class Solution {
    //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
    // 找出 nums 中的三个整数，使得它们的和与 target 最接近。
    // 返回这三个数的和。假定每组输入只存在唯一答案。
    //
    //例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
    //
    //与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;

        Arrays.sort(nums);
        int bestSum = nums[0]+nums[1]+nums[2];

        for (int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while (start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(Math.abs(bestSum-target) > Math.abs(sum-target)){
                    bestSum = sum;
                }
                if(sum>target){
                    end--;
                }else if(sum<target){
                    start++;
                }else {
                    return target;
                }
            }
        }
        return bestSum;
    }
}
