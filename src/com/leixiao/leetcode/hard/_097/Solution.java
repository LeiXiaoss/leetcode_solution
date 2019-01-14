package com.leixiao.leetcode.hard._097;

public class Solution {
    //给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
    //
    //示例 1:
    //
    //输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    //输出: true
    //示例 2:
    //
    //输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    //输出: false

    public boolean isInterleave(String s1, String s2, String s3){
        if(s1==null||s2==null||s3==null){
            return false;
        }

        if(s3.length() != s2.length()+s1.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;

        for (int i=1;i<=s1.length();i++){
            if(!dp[i-1][0]||s1.charAt(i-1)!=s3.charAt(i-1)){
                break;
            }
            dp[i][0] = true;
        }

        for (int j=1;j<=s2.length();j++){
            if(!dp[0][j-1]||s2.charAt(j-1)!=s3.charAt(j-1)){
                break;
            }
            dp[0][j] = true;
        }

        for (int i=1;i<=s1.length();i++){
            for (int j=1;j<=s2.length();j++){
                if(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }

                if(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    //递归
    public boolean isInterleave1(String s1,String s2,String s3){
        if(s1.length()+s2.length()!=s3.length()) return false;
        if(s3 == null || s3.length() ==0){
            return true;
        }

        char ch = s3.charAt(0);

        if(s1.length() > 0&& ch == s1.charAt(0)){
            if(isInterleave1(s1.substring(1),s2,s3.substring(1))){
                return true;
            }
        }

        if(s2.length() >0 && ch == s2.charAt(0)){
            if(isInterleave1(s1,s2.substring(1),s3.substring(1))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isInterleave1(
                "aabcc",
                "dbbca",
                "aadbbcbcac");

        return;
    }
}
