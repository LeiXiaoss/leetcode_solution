package com.leixiao.leetcode.easy._067;

import javax.xml.transform.SourceLocator;

public class Solution {
    //给定两个二进制字符串，返回他们的和（用二进制表示）。
    //
    //输入为非空字符串且只包含数字 1 和 0。
    //
    //示例 1:
    //
    //输入: a = "11", b = "1"
    //输出: "100"
    //示例 2:
    //
    //输入: a = "1010", b = "1011"
    //输出: "10101"

    public String addBinary(String a,String b){
        int maxLength = a.length()>=b.length()?a.length():b.length();
        if(a.length() != b.length()){
            while (a.length()!=maxLength){
                a = "0"+a;
            }
            while (b.length()!=maxLength){
                b = "0"+b;
            }
        }

        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        char[] addChar = new char[maxLength];
        boolean carry = false;

        for (int i=maxLength-1;i>=0;i--){
            if(carry == true){
                addChar[i] = aChar[i]==bChar[i]?'1':'0';
                carry = aChar[i]=='0'&&bChar[i]=='0'?false:true;
            }else {
                addChar[i] = aChar[i]==bChar[i]?'0':'1';
                carry = aChar[i]=='1'&&bChar[i]=='1'?true:false;
            }
        }

        if(carry == true){
            return 1+String.valueOf(addChar);
        }
        return String.valueOf(addChar);
    }

    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        Solution solution = new Solution();
        System.out.println(solution.addBinary(a,b));
    }
}
