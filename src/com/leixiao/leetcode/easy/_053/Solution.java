package com.leixiao.leetcode.easy._053;

public class Solution {
    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //示例:
    //
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    //进阶:
    //
    //如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

    //Kadane算法
    public int maxSubArray(int[] nums){
        int sum = nums[0],sumMax = sum;

        for (int i=0;i<nums.length;i++){
            if(sum<=0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            sumMax = Math.max(sum,sumMax);
        }

        return sumMax;
    }

    //动态规划
    public int maxSubArray1(int[] nums){
        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];

        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            //状态转移方程
            maxArray[i] = Math.max(maxArray[i-1]+nums[i],nums[i]);
            max = Math.max(maxArray[i],max);
        }

        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int max = solution.maxSubArray(new int[]{-2,-1,-3,-4,-1,-2,-1,-5,-4});
        System.out.println(max);

        int max2 = solution.maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(max2);
    }
}
