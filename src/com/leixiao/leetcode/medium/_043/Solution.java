package com.leixiao.leetcode.medium._043;

public class Solution {
    //给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    //
    //示例 1:
    //
    //输入: num1 = "2", num2 = "3"
    //输出: "6"
    //
    //示例 2:
    //
    //输入: num1 = "123", num2 = "456"
    //输出: "56088"
    //
    //说明：
    //
    //    num1 和 num2 的长度小于110。
    //    num1 和 num2 只包含数字 0-9。
    //    num1 和 num2 均不以零开头，除非是数字 0 本身。
    //    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

    //用加法模拟乘法的过程
    public String multiply(String num1,String num2){
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] b = new int[num1.length()+num2.length()];

        for (int i=0;i<num1.length();i++){
            for (int j=0;j<num2.length();j++){
                b[i+j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }

        for (int i=0;i<num1.length()+num2.length();i++){
            if(b[i]>9){
                b[i+1] += b[i]/10;
                b[i] = b[i]%10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=b.length-1;i>=0;i--){
            sb.append(b[i]);
        }

        while (sb.charAt(0) == '0' && sb.length()>1) sb.deleteCharAt(0);

        return sb.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.multiply("2","3"));
    }
}
