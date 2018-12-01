package com.leixiao.leetcode.medium._055;

import java.util.Map;

public class Solution {
    //给定一个非负整数数组，你最初位于数组的第一个位置。
    //
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //判断你是否能够到达最后一个位置。
    //
    //示例 1:
    //
    //输入: [2,3,1,1,4]
    //输出: true
    //解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
    //
    //示例 2:
    //
    //输入: [3,2,1,0,4]
    //输出: false
    //解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

    //贪心
    public boolean canJump(int[] nums){
        int reached = 0;

        int i=0;
        for (;i<nums.length&&reached>=i;i++){
            reached = Math.max(reached,i+nums[i]);
        }

        System.out.println(i);
        return i==nums.length;
    }

    //动态规划
    //dp[i]表示到达i这一点的最长跳跃距离
    public boolean canJump1(int[] nums){
        int[] dp = new int[nums.length];

        dp[0] = 0;
        for (int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i-1])-1;
            if(dp[i] < 0) return false;
        }

        return dp[nums.length-1]>=0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = new int[]{3,2,1,0,4};
        System.out.println(solution.canJump(arr));
        System.out.println(solution.canJump1(arr));
    }
}
