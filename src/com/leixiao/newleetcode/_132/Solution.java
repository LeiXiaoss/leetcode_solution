package com.leixiao.newleetcode._132;

import java.util.Arrays;

public class Solution {
	public int minCut(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i=0; i <s.length();i++) {
			Arrays.fill(dp[i], true);
		}

		for (int i = s.length()-1; i >= 0; i--) {
			for (int j = i+1; j < s.length(); j++ ) {
				dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
			}
		}

		int[] result = new int[s.length()];
		Arrays.fill(result, Integer.MAX_VALUE);

		for (int i = 0 ; i < s.length() ; i++) {
			if (dp[0][i]) {
				result[i] = 0;
			} else {
				for (int j = 0 ; j < i ; j++) {
					if (dp[j+1][i]) {
						result[i] = Math.min(result[i], result[j]+1);
					}
				}
			}
		}
		return result[s.length()-1];
 	}
}
