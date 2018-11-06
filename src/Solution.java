import com.leixiao.leetcode.structure.ListNode;

import java.util.*;

public class Solution {


    //29
    // 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    //
    //返回被除数 dividend 除以除数 divisor 得到的商。
    //
    //示例 1:
    //
    //输入: dividend = 10, divisor = 3
    //输出: 3
    //
    //示例 2:
    //
    //输入: dividend = 7, divisor = -3
    //输出: -2
    //
    //说明:
    //
    //被除数和除数均为 32 位有符号整数。
    //除数不为 0。
    //假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
    //本题中，如果除法结果溢出，则返回 231 − 1。

    //没懂
    public int divide(int dividend,int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long) dividend);
        long dvr = Math.abs((long) divisor);
        int res = 0;
        while (dvd >= dvr) {
            long temp = dvr, multiple = 1;
            while (dvd >= temp << 1) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return (dividend < 0) ^ (divisor < 0) ? -res : res;
    }




}
