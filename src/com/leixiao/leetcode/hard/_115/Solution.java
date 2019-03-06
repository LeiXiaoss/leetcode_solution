package com.leixiao.leetcode.hard._115;

public class Solution {
    //给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
    //
    //一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
    //
    //示例 1:
    //
    //输入: S = "rabbbit", T = "rabbit"
    //输出: 3
    //解释:
    //
    //如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
    //(上箭头符号 ^ 表示选取的字母)
    //
    //rabbbit
    //^^^^ ^^
    //rabbbit
    //^^ ^^^^
    //rabbbit
    //^^^ ^^^
    //
    //示例 2:
    //
    //输入: S = "babgbag", T = "bag"
    //输出: 5
    //解释:
    //
    //如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
    //(上箭头符号 ^ 表示选取的字母)
    //
    //babgbag
    //^^ ^
    //babgbag
    //^^    ^
    //babgbag
    //^    ^^
    //babgbag
    //  ^  ^^
    //babgbag
    //    ^^^

    public int numDistinct(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return 0;

        int[][] dp = new int[t.length()][s.length()];

        dp[0][0] = s.charAt(0)==t.charAt(0)?1:0;

        for (int i=0;i<t.length();i++){
            for (int j=0;j<s.length();j++){

               if (i == 0 && j > 0){
                   dp[i][j] = s.charAt(j)==t.charAt(i)?dp[i][j-1]+1:dp[i][j-1];
               }

               if(i > j) dp[i][j] = 0;

               if(i>0&&i <= j){
                   dp[i][j] = dp[i][j-1];
                   if(s.charAt(j) == t.charAt(i)){
                       dp[i][j] += dp[i-1][j-1];
                   }
               }
            }
        }

        return dp[t.length()-1][s.length()-1];
    }

    public int numDistinct1(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];

        for (int j=0;j<s.length()+1;j++){
            dp[0][j] = 1;
        }

        for (int i=1;i<t.length()+1;i++){
            for (int j=1;j<s.length()+1;j++){
                dp[i][j] = dp[i][j-1];
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int result = solution.numDistinct("rabbbit","rabbit");
        System.out.println(result);

    }
}
