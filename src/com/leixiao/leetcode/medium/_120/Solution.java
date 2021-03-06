package com.leixiao.leetcode.medium._120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null || triangle.isEmpty()) {
            return 0;
        }

        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int k = 0; k < triangle.size(); k++) {
            result = Math.min(dp[triangle.size()-1][k], result);
        }
        return result;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle==null || triangle.isEmpty()) {
            return 0;
        }

        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[j] = dp[j-1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int k = 0; k < triangle.size(); k++) {
            result = Math.min(result, dp[k]);
        }
        return result;
    }
}
