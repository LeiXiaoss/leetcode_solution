package com.leixiao.leetcode.medium._093;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
    //
    //示例:
    //
    //输入: "25525511135"
    //输出: ["255.255.11.135", "255.255.111.35"]

    //1. 4个字节
    //2. 每个字节0-255
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()<4||s.length()>12) return result;
        backtraack(result,s,"",0,0);
        return result;
    }

    public void backtraack(List<String> result,String s,String temp,int index,int start){
        if(index > 4) return;
        if(index == 4 && start == s.length()){
            result.add(temp);
            return;
        }

        for (int i=start+1;i<=s.length()&&i<=start+3;i++){
            if(s.charAt(start) == '0'){
                backtraack(result, s, temp+(index==3?"0":"0."), index+1, start+1);
                return;
            }

            String num = s.substring(start,i);
            if(Integer.parseInt(num)>255) return;
            backtraack(result,s,temp+num+(index==3?"":"."),index+1,i);
        }
    }


    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        List result = solution.restoreIpAddresses(s);
//        List result1 = solution.restoreIpAddresses1(s);
        return;
    }
}
