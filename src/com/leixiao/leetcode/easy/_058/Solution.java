package com.leixiao.leetcode.easy._058;

public class Solution {
    //给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
    //
    //如果不存在最后一个单词，请返回 0 。
    //
    //说明：一个单词是指由字母组成，但不包含任何空格的字符串。
    //
    //示例:
    //
    //输入: "Hello World"
    //输出: 5

    public int lengthOfLastWord(String s){
        s = s.trim();

        int index = s.lastIndexOf(' ');

        if(index == 0) return 0;
        else {
            System.out.println(s.substring(index+1));
            return s.substring(index+1).length();
        }
    }

    public static void main(String[] args){
        String s = "Hello world";
        System.out.println(new Solution().lengthOfLastWord(s));
    }
}
