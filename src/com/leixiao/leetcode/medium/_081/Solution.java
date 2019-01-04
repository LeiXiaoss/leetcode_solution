package com.leixiao.leetcode.medium._081;

public class Solution {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
    //
    //编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
    //
    //示例 1:
    //
    //输入: nums = [2,5,6,0,0,1,2], target = 0
    //输出: true
    //示例 2:
    //
    //输入: nums = [2,5,6,0,0,1,2], target = 3
    //输出: false
    //进阶:
    //
    //这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
    //这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int middle;

        while (start<=end){
            //如果出现左右相同，直接退化为线性查找
            if (nums[start] == nums[end]){
                for (int i=start;i<=end;i++){
                    if (nums[i] == target) return true;
                }
                return false;
            }

            middle = (start+end)/2;
            if(nums[middle] == target) return true;
            else if(nums[middle] >= nums[start]){
                if(nums[start] <= target && nums[middle] >= target) end = middle-1;
                else start = middle+1;
            }else {
                if(nums[middle] <= target && nums[end] >= target) start = middle+1;
                else end = middle-1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{2,2,2,0,2,2},0));
    }
}
