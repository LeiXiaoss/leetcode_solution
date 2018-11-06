package com.leixiao.leetcode.easy._009;

public class Solution {
    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    //示例 1:
    //
    //输入: 121
    //输出: true
    //
    //示例 2:
    //
    //输入: -121
    //输出: false
    //解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    //
    //示例 3:
    //
    //输入: 10
    //输出: false
    //解释: 从右向左读, 为 01 。因此它不是一个回文数。
    //
    //进阶:
    //
    //你能不将整数转为字符串来解决这个问题吗？

    public boolean isPalindrome(int x) {
        if(x<0) return false;

        int temp1 = x,temp2 = x;
        int length = 0;
        while(temp1 != 0){
            temp1 = temp1/10;
            length++;
        }

        int[] xArr = new int[length];
        for (int i=0;i<length;i++){
            xArr[i] = temp2%10;
            temp2 = temp2/10;
        }

        int start = 0,end = length-1;
        while(start<=end){
            if (xArr[start] != xArr[end]){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
