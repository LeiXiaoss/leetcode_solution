package com.leixiao.leetcode.easy._038;

public class Solution {
    //报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
    //
    //1.     1
    //2.     11
    //3.     21
    //4.     1211
    //5.     111221
    //
    //1 被读作  "one 1"  ("一个一") , 即 11。
    //11 被读作 "two 1s" ("两个一"）, 即 21。
    //21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
    //
    //给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
    //
    //注意：整数顺序将表示为一个字符串。
    //
    //
    //
    //示例 1:
    //
    //输入: 1
    //输出: "1"
    //
    //示例 2:
    //
    //输入: 4
    //输出: "1211"

    public String countAndSay(int n){
        if(n<1) return "";
        String res = "1";
        for (int i=1;i<n;i++){
            res = doCountAndSay(res);
        }
        return res;
    }

    private String doCountAndSay(String res) {
        int count = 0;
        char lastCh = res.charAt(0);
        StringBuffer sb = new StringBuffer();
        int len = res.length();
        for (int i=0;i<=len;i++){
            if(i<len&&lastCh == res.charAt(i)){
                count++;
            }else {
                sb.append(String.valueOf(count));
                sb.append(String.valueOf(lastCh));
                count = 1;
                if(i<len){
                    lastCh = res.charAt(i);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Solution().countAndSay(7));
        String a = "abcd";
        System.out.println(a.charAt(0));
        System.out.println(a.charAt(3));
    }
}
