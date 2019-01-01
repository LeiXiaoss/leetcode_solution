package com.leixiao.leetcode.medium._077;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    //
    //示例:
    //
    //输入: n = 4, k = 2
    //输出:
    //[
    //  [2,4],
    //  [3,4],
    //  [2,3],
    //  [1,2],
    //  [1,3],
    //  [1,4],
    //]

    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),n,k,0);
        return result;
    }

    private void backtrack(List result,List<Integer> temp,int n,int k,int start){
        if(start == k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=1;i<=n;i++){
            if (!temp.contains(i)){
                temp.add(i);
                backtrack(result,temp,i,k,start+1);
                temp.remove(temp.size()-1);
            }

        }
    }

    public List<List<Integer>> combine2(int n,int k){
        List<List<Integer>> result = new ArrayList<>();
        backtrack2(result,n,k,1,new ArrayList<>());
        return result;
    }

    private void backtrack2(List result,int n,int k,int index,List<Integer> temp){
        if(k==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=index;i<=n-k+1;i++){
            temp.add(i);
            backtrack2(result,n,k-1,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.combine(4,2);
        return;
    }
}
