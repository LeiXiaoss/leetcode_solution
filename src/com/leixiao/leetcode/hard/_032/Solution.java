package com.leixiao.leetcode.hard._032;

import java.util.Stack;

public class Solution {

    //    32
    //    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    //
    //    示例 1:
    //
    //    输入: "(()"
    //    输出: 2
    //    解释: 最长有效括号子串为 "()"
    //
    //    示例 2:
    //
    //    输入: ")()())"
    //    输出: 4
    //    解释: 最长有效括号子串为 "()()"

    //遍历两次，时间复杂度O(n)
    public int longestValidParentheses(String s){
        if(s.length() <= 1) return 0;

        Stack<Character> charStack = new Stack<>();
        int[] mark = new int[s.length()];

        char[] sChar = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if(sChar[i] == '('){
                charStack.push(sChar[i]);
                mark[i] = 0;
            }else {
                if(!charStack.isEmpty()&&charStack.pop()=='('){
                    mark[i] = 2;
                }else {
                    mark[i] = 0;
                }
            }
        }

        int countTwo = 0;
        int max = 0;
        int totalTwo = 0;
        int i = s.length()-1;
        while (i>=0){
            if(mark[i] == 0){
                countTwo--;
                if(countTwo<0||i==0){
                    countTwo = 0;
                    if(totalTwo > max){
                        max = totalTwo;
                    }
                    totalTwo = 0;
                }
                i--;
            }else {
                countTwo++;
                totalTwo++;
                i--;
            }
        }
        return max*2;
    }

    //遍历一次，用栈存储字符位置，时间复杂度O(n)
    public int longestValidParentheses(String s,int v1){
        if(s.length()<=1) return 0;

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int max = 0;
        int temp = 0;

        char[] sChar = new char[s.length()];
        sChar = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if(sChar[i] == ')'&&indexStack.peek()!=-1&&s.charAt(indexStack.peek())=='('){
                indexStack.pop();
                temp = i - indexStack.peek();
                if(temp>max){
                    max = temp;
                }
            }else {
                indexStack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args){
        int i = 9;
        System.out.println(new Solution().longestValidParentheses(")()())",i));

    }
}
