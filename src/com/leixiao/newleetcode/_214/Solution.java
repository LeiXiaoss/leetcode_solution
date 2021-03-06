package com.leixiao.newleetcode._214;

public class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        int flag = 0;

        for (int i = s.length(), j = 0; i > 0 && j < s.length(); i--, j++) {
            String temp = s.substring(0, i);
            int index = reverse.indexOf(temp,j);
            if (index!= -1 ) {
                flag = index;
                break;
            }
        }
        return reverse.substring(0, flag) + s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome("adcba"));
    }
}
