package com.leixiao.leetcode.easy._121;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] dp = new int[prices.length];

        int result = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j]) {
                    dp[i] = Math.max(dp[i], prices[i]-prices[j]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
