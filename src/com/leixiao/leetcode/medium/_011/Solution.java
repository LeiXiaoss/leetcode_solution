package com.leixiao.leetcode.medium._011;

public class Solution {
    //给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
    // 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    // 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //
    //说明：你不能倾斜容器，且 n 的值至少为 2。
    //
    //图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水
    // （表示为蓝色部分）的最大值为 49。
    //
    //
    //
    //示例:
    //
    //输入: [1,8,6,2,5,4,8,3,7]
    //输出: 49

    //假设 am与an间的乘积最大，则m的左边不存在比am大的值，n右边不存在比an大的值
    public int maxArea(int[] height) {
        if(height.length == 2){
            return height[0]>height[1]?height[1]:height[0];
        }

        int start = 0,end = height.length-1;
        int maxValue = 0;

        while (start<end){
            maxValue = Math.max((end-start)*
                    Math.min(height[start],height[end]),maxValue);

            if(height[start]>height[end]){
                end--;
            }else {
                start++;
            }
        }

        return maxValue;
    }
}
