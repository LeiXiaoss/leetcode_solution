package com.leixiao.leetcode.easy._028;

public class Solution {
    //实现 strStr() 函数。
    //
    //给定一个 haystack 字符串和一个 needle 字符串，
    // 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    //
    //示例 1:
    //
    //输入: haystack = "hello", needle = "ll"
    //输出: 2
    //
    //示例 2:
    //
    //输入: haystack = "aaaaa", needle = "bba"
    //输出: -1
    //
    //说明:
    //
    //当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    //
    //对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr()
    // 以及 Java的 indexOf() 定义相符。

    //两个指针分别指向两个字符串，逐个字符比较，如果出现不同的字符，要考虑字符回退的情况
    public int strStr(String haystack,String needle){
        if(needle==null||needle.length()==0) return 0;
        if(needle.length()>haystack.length()) return -1;

        int first=0,second=0;
        while (first<=haystack.length()-1&&second<=needle.length()-1){
            if(haystack.charAt(first) == needle.charAt(second)){
                first++;
                second++;
            }else {
                first = first-second+1;
                second = 0;
            }
        }
        if(second>=needle.length()){
            return first-second;
        }else {
            return -1;
        }
    }

    //从主串找子串的索引，将主串分割为子串长度相当的若干子串，再进行比较
    public int strStr1(String haystack,String needle){
        if(needle==null||needle.length()==0) return 0;
        if(needle.length()>haystack.length()) return -1;

        int length = needle.length();
        for (int i=0;i+length<=haystack.length();i++){
            if(haystack.substring(i,i+length).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
