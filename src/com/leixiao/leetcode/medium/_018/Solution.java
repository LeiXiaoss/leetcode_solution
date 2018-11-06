package com.leixiao.leetcode.medium._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    //给定一个包含 n 个整数的数组 nums 和一个目标值 target，
    // 判断 nums 中是否存在四个元素 a，b，c 和 d ，
    // 使得 a + b + c + d 的值与 target 相等？
    // 找出所有满足条件且不重复的四元组。
    //
    //注意：
    //
    //答案中不可以包含重复的四元组。
    //
    //示例：
    //
    //给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
    //
    //满足要求的四元组集合为：
    //[
    //  [-1,  0, 0, 1],
    //  [-2, -1, 1, 2],
    //  [-2,  0, 0, 2]
    //]

    //在三数之和上改进
    public List<List<Integer>> fourSum(int[] nums, int target){
        if(nums.length<4) return Collections.emptyList();

        Arrays.sort(nums);
        int max = nums[nums.length-1];
        List<List<Integer>> sumList = new ArrayList<>();
        for (int i=0;i<nums.length-3;i++){

            if (nums[i]*4>target) break;
            if (nums[i]+3*max<target) continue;
            if (i!=0&&i<nums.length-3&&nums[i]==nums[i-1]) continue;

            for (int j=i+1;j<nums.length-2;j++){

                if (j!=i+1&&j<nums.length-2&&nums[j]==nums[j-1]) continue;
                if (nums[i]+nums[j]*3>target) break;
                if (nums[i]+nums[j]+max*2<target) continue;

                int start = j+1;
                int end = nums.length-1;
                while (start<end){
                    if(nums[i]+nums[j]+nums[start]+nums[end]==target){
                        List<Integer> numList = new ArrayList<>();
                        numList.add(nums[i]);
                        numList.add(nums[j]);
                        numList.add(nums[start]);
                        numList.add(nums[end]);
                        sumList.add(numList);
                        start++;
                        while (start<end&&nums[start]==nums[start-1]){
                            start++;
                        }
                        end--;
                        while (start<end&&nums[end]==nums[end+1]){
                            end--;
                        }
                    }else if(nums[i]+nums[j]+nums[start]+nums[end]<target){
                        start++;
                    }else {
                        end--;
                    }
                }
            }
        }
        return sumList;
    }
}
