package com.leixiao.leetcode.medium._049;



import java.util.*;

public class Solution {
    //给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    //
    //示例:
    //
    //输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    //输出:
    //[
    //  ["ate","eat","tea"],
    //  ["nat","tan"],
    //  ["bat"]
    //]
    //说明：
    //
    //所有输入均为小写字母。
    //不考虑答案输出的顺序。

    //使用排序后的字符串作为哈希表的key
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0 || strs == null) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String keyStr = String.valueOf(ch);
            if(!map.containsKey(keyStr)) {
                map.put(keyStr,new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    //使用数组记录字符串中字符个数作为key
    public List<List<String>> groupAnagrams1(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] count = new int[26];
            for (char c : str.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++){
                sb.append(count[i]);
            }
            String key = String.valueOf(sb);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
