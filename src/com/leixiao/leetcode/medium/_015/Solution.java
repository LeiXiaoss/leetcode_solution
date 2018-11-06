package com.leixiao.leetcode.medium._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    // 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    //
    //满足要求的三元组集合为：
    //[
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    //]

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> sumList = new ArrayList<>();

        if(nums == null || nums.length == 0) return sumList;

        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;

            while (start<end){
                if(nums[i]+nums[start]+nums[end]==0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    sumList.add(temp);
                    start++;
                    end--;
                    while (start<end&&nums[start] == nums[start-1]){
                        start++;
                    }
                    while (start<end&&nums[end] == nums[end+1]){
                        end--;
                    }
                }else if(nums[i]+nums[start]+nums[end]<0){
                    start++;
                }else {
                    end--;
                }
            }
        }
        return sumList;
    }
}
