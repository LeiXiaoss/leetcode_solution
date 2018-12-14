package com.leixiao.leetcode.hard._065;

public class Solution {
    //验证给定的字符串是否为数字。
    //
    //例如:
    //"0" => true
    //" 0.1 " => true
    //"abc" => false
    //"1 a" => false
    //"2e10" => true
    //
    //说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。

    public boolean isNumber(String s){
        s = s.trim();
        String[] splitArr = s.split("e");
        if (s.length() == 0 || s.charAt(0) == 'e'
                || s.charAt(s.length() - 1) == 'e' || splitArr.length > 2)
            return false;
        for (int k = 0; k < splitArr.length; k++) {
            String str = splitArr[k];
            boolean isDecimal = false;
            if (str.charAt(0) == '-' || str.charAt(0) == '+')
                str = str.substring(1);
            if (str.length() == 0)
                return false;
            for (int i = 0; i < str.length(); i++) {
                if ('0' <= str.charAt(i) && str.charAt(i) <= '9')
                    continue;
                else if (str.charAt(i) == '.' && !isDecimal) {
                    if (k == 0 && str.length() > 1)
                        isDecimal = true;
                    else
                        return false;
                } else
                    return false;
            }
        }
        return true;
    }
}
