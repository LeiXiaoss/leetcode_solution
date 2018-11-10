package com.leixiao.leetcode.medium._040;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的每个数字在每个组合中只能使用一次。
    //
    //说明：
    //
    //    所有数字（包括目标数）都是正整数。
    //    解集不能包含重复的组合。
    //
    //示例 1:
    //
    //输入: candidates = [10,1,2,7,6,1,5], target = 8,
    //所求解集为:
    //[
    //  [1, 7],
    //  [1, 2, 5],
    //  [2, 6],
    //  [1, 1, 6]
    //]
    //
    //示例 2:
    //
    //输入: candidates = [2,5,2,1,2], target = 5,
    //所求解集为:
    //[
    //  [1,2,2],
    //  [5]
    //]

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList<>(),candidates,target,0);

        return list;
    }

    private boolean backtrack(List<List<Integer>> list,
                              List<Integer> tempList,int[] candidates,int target,int start){
        if(target < 0){
            return false;
        } else if(target == 0){
            if(!list.contains(new ArrayList<>(tempList))){
                list.add(new ArrayList<>(tempList));
            }
            return false;
        }else {
            for (int i=start;i<candidates.length;i++){
                boolean flag;
                tempList.add(candidates[i]);
                flag = backtrack(list,tempList,candidates,target-candidates[i],i+1);
                tempList.remove(tempList.size()-1);
                if(!flag){
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(new int[]{10,1,2,7,6,1,5},8);

        for (List list : lists){
            System.out.println(list);
        }
    }
}
