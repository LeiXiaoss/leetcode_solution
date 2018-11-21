package com.leixiao.leetcode.hard._045;

import com.sun.javafx.image.IntPixelGetter;

public class Solution {
    //给定一个非负整数数组，你最初位于数组的第一个位置。
    //
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    //
    //示例:
    //
    //输入: [2,3,1,1,4]
    //输出: 2
    //解释: 跳到最后一个位置的最小跳跃数是 2。
    //     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    //说明:
    //
    //假设你总是可以到达数组的最后一个位置。

    //动态规划
    //超时
    public int jump(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 0;

        int distance = nums.length-1;
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;

        for (int i=nums.length-2;i>=0;i--){
            if(nums[i] >= distance-i){
                dp[i] = 1;
            }else {
                dp[i] = findMin(nums,i,dp)+1;
            }
        }
        return dp[0];
    }

    private int findMin(int[] nums,int i,int[] dp){
        int min = Integer.MAX_VALUE-1;
        for (int j=i+1;j<=nums[i]+i;j++){
            min = Math.min(min,dp[j]);
        }
        return min;
    }

    //只能用贪心的解法
    public int jump1(int[] nums){
        int times=0;
        int reached=0;
        int max=0;
        for (int i=0;i<nums.length;i++){
            if(reached<i){
                times++;
                reached = max;
             }
             max = Math.max(max,i+nums[i]);
        }
        return times;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.jump1(new int[]{2,3,0,1,4}));
    }
}
