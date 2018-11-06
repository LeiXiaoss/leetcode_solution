package com.leixiao.leetcode.easy._014;

public class Solution {
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。
    //
    //示例 1:
    //
    //输入: ["flower","flow","flight"]
    //输出: "fl"
    //
    //示例 2:
    //
    //输入: ["dog","racecar","car"]
    //输出: ""
    //解释: 输入不存在公共前缀。
    //
    //说明:
    //
    //所有输入只包含小写字母 a-z 。

    //从第一个字符串开始，依次判断是否为前缀，不是的话，减一
    //流弊！！！
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String prefix = strs[1];

        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //从第一个字符开始，纵向遍历
    public String longestCommonPrefix1(String[] strs){
        if(strs.length == 0 || strs == null) return "";

        for (int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (int j=0;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    //分治法
    public String longestCommonPrefix2(String[] strs){
        if(strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs,0,strs.length-1);
    }

    public String longestCommonPrefix(String[] strs,int start,int end){
        if(start == end){
            return strs[start];
        }else {
            int middle = (end + start)/2;
            String leftStr = longestCommonPrefix(strs,start,middle);
            String rightStr = longestCommonPrefix(strs,middle+1,end);
            return common(leftStr,rightStr);
        }
    }

    public String common(String left,String right){
        int min = Math.min(left.length(),right.length());
        for (int i=0;i<min;i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return left.substring(0,min);
    }

    //使用二分法，查找最短字符串的每一个字符
    public String longestCommonPrefix3(String[] strs){
        if(strs == null || strs.length == 0) return  "";

        int min = Integer.MAX_VALUE;
        for (String str : strs){
            min = Math.min(min,str.length());
        }

        int start = 0;
        int end = min-1;
        while (start<=end){
            int middle = (start+end)/2;
            if (isCommonPrefix(strs,middle)){
                start = middle+1;
            }else {
                end = middle-1;
            }
        }
        return strs[0].substring(0,start);
    }

    public boolean isCommonPrefix(String[] strs,int len){
        String str = strs[0].substring(0,len);
        for (int i=1;i<strs.length;i++){
            if(!strs[i].startsWith(str)){
                return false;
            }
        }
        return true;
    }
}
