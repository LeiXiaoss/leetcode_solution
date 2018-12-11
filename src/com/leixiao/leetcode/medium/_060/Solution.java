package com.leixiao.leetcode.medium._060;

import java.util.*;

public class Solution {
    //给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
    //
    //按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
    //
    //    "123"
    //    "132"
    //    "213"
    //    "231"
    //    "312"
    //    "321"
    //
    //给定 n 和 k，返回第 k 个排列。
    //
    //说明：
    //
    //    给定 n 的范围是 [1, 9]。
    //    给定 k 的范围是 [1,n!]。
    //
    //示例 1:
    //
    //输入: n = 3, k = 3
    //输出: "213"
    //
    //示例 2:
    //
    //输入: n = 4, k = 9
    //输出: "2314"

    // 会超时
    public String getPermutation(int n,int k){
        int[] array = new int[n];
        for (int i=0;i<n;i++){
            array[i] = i+1;
        }

        List<String> lists = new ArrayList<>();
        backtrack(lists,"",array,0);

        Collections.sort(lists, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });

        return lists.get(k-1);
    }

    private void backtrack(List lists,String str,int[] array,int start){
        if(start == array.length){
            lists.add(str);
            return;
        }

        for (int i=0;i<array.length;i++){
            if(str.indexOf(String.valueOf(array[i]))==-1){
                str = str+array[i];
                backtrack(lists,str,array,start+1);
                str = str.substring(0,str.length()-1);
            }
        }
    }

    public String getPermutation1(int n,int k){
        if(n==1) return "1";
        int num = 1;
        for (int i=1;i<n;i++){
            num = i*num;
        }
        int first = k/num;
        int index = k%num;

        if(index == 0){
            index = num-1;
        }else {
            first++;
            index--;
        }
        int[] array = new int[n];
        for (int i=0;i<n;i++){
            array[i] = i+1;
        }

        List<String> lists = new ArrayList<>();
        backtrack(lists,String.valueOf(first),array,1);

        Collections.sort(lists, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });

        return lists.get(index);
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        String k = solution.getPermutation1(1,1);
        System.out.println(k);
    }
}
