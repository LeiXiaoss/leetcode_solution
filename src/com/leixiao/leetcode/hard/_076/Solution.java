package com.leixiao.leetcode.hard._076;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
    //
    //示例：
    //
    //输入: S = "ADOBECODEBANC", T = "ABC"
    //输出: "BANC"
    //说明：
    //
    //如果 S 中不存这样的子串，则返回空字符串 ""。
    //如果 S 中存在这样的子串，我们保证它是唯一的答案。

    public String minWindow(String s,String t){
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        for(int j=0;j<t.length();j++){
            sMap.put(t.charAt(j),0);

            if (!tMap.containsKey(t.charAt(j))){
                tMap.put(t.charAt(j),1);
            }else {
                tMap.put(t.charAt(j),tMap.get(t.charAt(j))+1);
            }
        }

        int begin=0,count=0,minBegin=0,length=s.length()+1;
        for (int i=0;i<s.length();i++){
            if(!tMap.containsKey(s.charAt(i))){
                continue;
            }

            sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);

            if(sMap.get(s.charAt(i))<=tMap.get(s.charAt(i))){
                count++;
            }

            if(count == t.length()){
                for (int j=begin;j<=i;j++){
                    if(!tMap.containsKey(s.charAt(j)))
                        continue;
                    if(sMap.get(s.charAt(j))>tMap.get(s.charAt(j))){
                        sMap.put(s.charAt(j),sMap.get(s.charAt(j))-1);
                        continue;
                    }
                    sMap.put(s.charAt(j),sMap.get(s.charAt(j))-1);
                    count--;
                    begin=j+1;
                    if(length>i-j){
                        length=i-j;
                        minBegin=j;
                    }
                    break;
                }
            }
        }
        return length!=s.length()+1?s.substring(minBegin, minBegin+length+1):"";
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
    }
}
