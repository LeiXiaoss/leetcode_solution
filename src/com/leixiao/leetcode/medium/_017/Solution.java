package com.leixiao.leetcode.medium._017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //2:abc,3:def,4:ghi,5:jkl,6:mno,7:pqrs,8:tuv,9:wxyz
    //
    //示例:
    //
    //输入："23"
    //输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    //回溯法
    public List<String> letterCombinations(String digits) {
        List<String> strList = new ArrayList<>();

        if(digits == null || digits.length() == 0) return strList;

        String[] map  = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        letterCombinationsCore(strList,digits,map,"");
        return strList;
    }

    public void letterCombinationsCore(List<String> list,String digits,String[] map,String ans){
        if(digits.length() == ans.length()){
            list.add(ans);
            return;
        }

        for (char ch : map[digits.charAt(ans.length())-'2'].toCharArray()){
            letterCombinationsCore(list,digits,map,ans+ch);
        }
    }

    //根据队列不断拼接结果
    public List<String> letterCombinations1(String digits){
        List<String> strList = new LinkedList<String>();
        if(digits.isEmpty()) return Collections.emptyList();

        String[] map  = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] charArray = digits.toCharArray();
        strList.add("");

        for (int i=0;i<charArray.length;i++){
            char ch = charArray[i];
            while (((LinkedList<String>) strList).getFirst().length()==i){
                String pop = ((LinkedList<String>) strList).removeFirst();
                for (char c : map[ch-'2'].toCharArray()){
                    strList.add(pop+c);
                }
            }
        }
        return strList;
    }
}
