package com.leixiao.leetcode.hard._010;

public class Solution {
    //给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
    //
    //'.' 匹配任意单个字符。
    //'*' 匹配零个或多个前面的元素。
    //
    //匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
    //
    //说明:
    //
    //    s 可能为空，且只包含从 a-z 的小写字母。
    //    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
    //
    //示例 1:
    //
    //输入:
    //s = "aa"
    //p = "a"
    //输出: false
    //解释: "a" 无法匹配 "aa" 整个字符串。
    //
    //示例 2:
    //
    //输入:
    //s = "aa"
    //p = "a*"
    //输出: true
    //解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
    //
    //示例 3:
    //
    //输入:
    //s = "ab"
    //p = ".*"
    //输出: true
    //解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
    //
    //示例 4:
    //
    //输入:
    //s = "aab"
    //p = "c*a*b"
    //输出: true
    //解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
    //
    //示例 5:
    //
    //输入:
    //s = "mississippi"
    //p = "mis*is*p*."
    //输出: false

    //1/递归条件匹配表
    //2/合并条件
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.isEmpty() || (p.charAt(0) != s.charAt(0) &&
                    p.charAt(0) != '.')){
                return false;
            }else {
                return isMatch(s.substring(1),p.substring(1));
            }
        }

        while (!s.isEmpty() && (p.charAt(0) == s.charAt(0)||
                p.charAt(0) == '.')){
            if(isMatch(s,p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }

        return isMatch(s,p.substring(2));
    }

    //还有dp解法
    public boolean isMatch1(String s,String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;

        char[] sChar = s.toCharArray(),pChar = p.toCharArray();

        for (int j=2;j<=p.length();j++){
            if(pChar[j-1] == '*'&&dp[0][j-2]){
                dp[0][j] = true;
            }
        }

        for (int i=0;i<s.length();i++){
            for (int j=0;j<p.length();j++){
                if(pChar[j] == '*'){
                    dp[i+1][j+1] = dp[i+1][j-1]||(sChar[i]==pChar[j-1]||pChar[j-1]=='.')&&dp[i][j+1];
                }else {
                    dp[i+1][j+1] = dp[i][j] && (sChar[i]==pChar[j]||pChar[j]=='.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isMatch1("",".*"));
    }
}
