package com.leixiao.newleetcode._459;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String pattern = new String();

        for (int i = 0; i < s.length()/2; i++) {
            pattern += s.charAt(i);
            if (s.length() % pattern.length() == 0 && s.matches("(" + pattern + ")+")) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern1(String s) {
        return (s + s).substring(1,s.length()*2-1).indexOf(s) != -1;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(1,1));
    }
}
