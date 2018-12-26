package com.leixiao.leetcode.easy._066;

public class Solution {
    //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    //
    //最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
    //
    //你可以假设除了整数 0 之外，这个整数不会以零开头。
    //
    //示例 1:
    //
    //输入: [1,2,3]
    //输出: [1,2,4]
    //解释: 输入数组表示数字 123。
    //
    //示例 2:
    //
    //输入: [4,3,2,1]
    //输出: [4,3,2,2]
    //解释: 输入数组表示数字 4321。

    public int[] plusOne(int[] digits){
        boolean carry = true;

        for (int i=digits.length-1;i>=0;i--){
            if(carry == true){
                digits[i] = digits[i] + 1;
                if(digits[i] > 9){
                    digits[i] = 0;
                    carry = true;
                }else {
                    carry = false;
                }
            }else {
                continue;
            }
        }

        if(carry == true){
            int[] numPlueOne = new int[digits.length+1];
            for (int i=1;i<digits.length+1;i++){
                numPlueOne[i] = digits[i-1];
            }
            numPlueOne[0] = 1;
            return numPlueOne;
        }
        return digits;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] digits = new int[]{9};
        int[] one = solution.plusOne(digits);
        System.out.println(one);
    }
}
