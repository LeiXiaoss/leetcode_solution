package com.leixiao.leetcode.easy._035;

public class Solution {
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //你可以假设数组中无重复元素。
    //
    //示例 1:
    //
    //输入: [1,3,5,6], 5
    //输出: 2
    //
    //示例 2:
    //
    //输入: [1,3,5,6], 2
    //输出: 1
    //
    //示例 3:
    //
    //输入: [1,3,5,6], 7
    //输出: 4
    //
    //示例 4:
    //
    //输入: [1,3,5,6], 0
    //输出: 0

    //可以创建一个新数组，直接排序，输出target的下标，空间复杂度O(n)

    //二分法查找,存在这个元素的话，直接输出下标，否则最接近target的高位下标
    public int searchInsert(int[] nums,int target){
        if(nums == null || nums.length == 0) return 0;
        if(nums[nums.length-1] < target) return nums.length;

        int left = 0,right = nums.length-1;
        int middle;
        while (left < right){
            middle = (left+right)/2;
            if (nums[middle] == target){
                right = middle;
                break;
            }else if(nums[middle] > target){
                right = middle;
            }else {
                left = middle+1;
            }
        }
        return right;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},6));
    }
}
