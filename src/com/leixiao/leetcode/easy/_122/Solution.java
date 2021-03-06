package com.leixiao.leetcode.easy._122;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        int i = 0;

        while (i < prices.length-1) {
            while (i < prices.length-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{6,1,3,2,4,7});
        return;
    }
}
