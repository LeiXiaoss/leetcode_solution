package com.leixiao.leetcode.hard._030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
    //
    //注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
    //
    //示例 1:
    //
    //输入:
    //  s = "barfoothefoobarman",
    //  words = ["foo","bar"]
    //输出: [0,9]
    //解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
    //输出的顺序不重要, [9,0] 也是有效答案。
    //
    //示例 2:
    //
    //输入:
    //  s = "wordgoodstudentgoodword",
    //  words = ["word","student"]
    //输出: []

    //难
    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
        }

        int len = words[0].length();
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(map);
            int temp = i;
            int count = 0;
            String tempStr = s.substring(temp, temp + len);
            while (tempMap.containsKey(tempStr) && tempMap.get(tempStr) > 0) {
                tempMap.put(tempStr, tempMap.get(tempStr) - 1);
                temp = temp + len;
                count++;
                if (temp + len <= s.length()) {
                    tempStr = s.substring(temp, temp + len);
                } else {
                    break;
                }
            }
            if (count == words.length) {
                res.add(i);
            }
        }
        return res;
    }
}
