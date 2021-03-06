package com.leixiao.newleetcode._557;

public class Solution {
    public String reverseWords(String s) {
        String[] wordsArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordsArray.length; i++) {
            StringBuilder temp = new StringBuilder(wordsArray[i]);
            if (i == 0) {
                sb.append(temp.reverse());
            } else {
                sb.append(" ");
                sb.append(temp.reverse());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
