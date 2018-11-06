package com.leixiao.leetcode.medium._033;

public class Solution {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //
    //搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //
    //你可以假设数组中不存在重复的元素。
    //
    //你的算法时间复杂度必须是 O(log n) 级别。(二分查找)
    //
    //示例 1:
    //
    //输入: nums = [4,5,6,7,0,1,2], target = 0
    //输出: 4
    //
    //示例 2:
    //
    //输入: nums = [4,5,6,7,0,1,2], target = 3
    //输出: -1

    public int search(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int middle;

        while (start<=end){
            middle = (start+end)/2;
            if(nums[middle] == target) return middle;
            else if(nums[middle] >= nums[start]){
                if(nums[start] <= target && nums[middle] >= target) end = middle-1;
                else start = middle+1;
            }else {
                if(nums[middle] <= target && nums[end] >= target) start = middle+1;
                else end = middle-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(new Solution().search(new int[]{5,1,3},3));
    }
}
