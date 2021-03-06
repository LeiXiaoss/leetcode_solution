package com.leixiao.newleetcode._647;

public class Solution {
    int num;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i+1);
        }
        return num;
    }

    public void count(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            num++;
            left--;
            right++;
        }
    }

    public int countSubstrings1(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length() ; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j-i) >= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }


}
