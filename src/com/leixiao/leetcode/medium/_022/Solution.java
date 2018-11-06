package com.leixiao.leetcode.medium._022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
    //
    //例如，给出 n = 3，生成结果为：
    //
    //[
    //  "((()))",
    //  "(()())",
    //  "(())()",
    //  "()(())",
    //  "()()()"
    //]

    //回溯法
    public List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        backTrack(ans,"",0,0,n);
        return ans;
    }

    public void backTrack(List<String> ans,String cur,int open,int close,int max){
        if(cur.length() == max*2){
            ans.add(cur);
            return;
        }

        if(open<max){
            backTrack(ans,cur+"(",open+1,close,max);
        }
        if(open>close){
            backTrack(ans,cur+")",open,close+1,max);
        }
    }
}
