package com.leixiao.forjob;

public class FindLength {
    //最长连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1 ; i < nums.length ; i++ ) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }

        return max;
    }
}
