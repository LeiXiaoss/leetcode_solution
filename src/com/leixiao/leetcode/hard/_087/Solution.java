package com.leixiao.leetcode.hard._087;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
    //
    //下图是字符串 s1 = "great" 的一种可能的表示形式。
    //
    //    great
    //   /    \
    //  gr    eat
    // / \    /  \
    //g   r  e   at
    //           / \
    //          a   t
    //在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
    //
    //例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
    //
    //    rgeat
    //   /    \
    //  rg    eat
    // / \    /  \
    //r   g  e   at
    //           / \
    //          a   t
    //我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
    //
    //同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
    //
    //    rgtae
    //   /    \
    //  rg    tae
    // / \    /  \
    //r   g  ta  e
    //       / \
    //      t   a
    //我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
    //
    //给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
    //
    //示例 1:
    //
    //输入: s1 = "great", s2 = "rgeat"
    //输出: true
    //示例 2:
    //
    //输入: s1 = "abcde", s2 = "caebd"
    //输出: false

    public boolean isScramble(String s1, String s2) {
        if(!isVaild(s1,s2)){
            return false;
        }

        int length = s1.length();
        if(length == 1) return s1.equals(s2);

        for (int i=0;i<length;i++){
            if((isScramble(s1.substring(0,i),s2.substring(0,i))
                    &&isScramble(s1.substring(i),s2.substring(i)))){
                return true;
            }
            if((isScramble(s1.substring(0,i),s2.substring(length-i))
                    &&isScramble(s1.substring(i),s2.substring(0,length-i)))){
                return true;
            }
        }
        return false;
    }

    private boolean isVaild(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;

        int[] s1Char = new int[128];
        int[] s2Char = new int[128];

        for (int i=0;i<s1.length();i++){
            s1Char[s1.charAt(i)]++;
            s2Char[s2.charAt(i)]++;
        }
        for (int i=0;i<128;i++){
            if(s1Char[i] != s2Char[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isScramble("great","rgeat"));

    }
}
