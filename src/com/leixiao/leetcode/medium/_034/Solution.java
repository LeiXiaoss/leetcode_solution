package com.leixiao.leetcode.medium._034;

public class Solution {
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //
    //你的算法时间复杂度必须是 O(log n) 级别。
    //
    //如果数组中不存在目标值，返回 [-1, -1]。
    //
    //示例 1:
    //
    //输入: nums = [5,7,7,8,8,10], target = 8
    //输出: [3,4]
    //
    //示例 2:
    //
    //输入: nums = [5,7,7,8,8,10], target = 6
    //输出: [-1,-1]

    //找到target对应的下标之后，向前向后检索。需要优化
    public int[] searchRange(int[] nums,int target){
        if(nums == null || nums.length == 0) return new int[]{-1,-1};

        int left = 0,right = nums.length-1;
        int start = 0,end = nums.length;
        int middle=0;

        while (left<=right){
            middle = (left+right)/2;
            if(nums[middle] == target){
                start = middle;
                end = middle;
                break;
            }else if(nums[left] <= target && nums[middle] >= target){
                right = middle-1;
            }else {
                left = middle+1;
            }
        }
        if(nums[middle]!=target) return new int[]{-1,-1};

        while (nums[start] == target && start>0){
            start--;
        }
        while (nums[end] == target && end<nums.length-1){
            end++;
        }
        return new int[]{nums[start]==target?start:start+1,nums[end]==target?end:end-1};
    }

    //先找到target的第一个下标，然后向后检索
    public int[] searchRange(int[] nums,int target,int v1){
        if(nums.length == 0 || nums == null) return new int[]{-1,-1};

        int left=0,right=nums.length-1;
        while (left<right){
            int middle = (left+right)/2;
            if(nums[middle] >= target){
                right = middle;
            }else {
                left = middle+1;
            }
        }

        if(nums[left] != target) return new int[]{-1,-1};

        int i=left;
        for (;i<nums.length;i++){
            if(nums[i] != target){
                break;
            }
        }
        return new int[]{left,i-1};
    }
}
