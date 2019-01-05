package com.leixiao.leetcode.hard._084;

import java.util.Stack;

public class Solution {
    //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    //
    //求在该柱状图中，能够勾勒出来的矩形的最大面积。
    //示例:
    //
    //输入: [2,1,5,6,2,3]
    //输出: 10

    public int largestRectangleArea(int[] heights){
        Stack<Integer> index = new Stack<>();
        int n = heights.length;

        int result = 0;
        for (int i=0;i<=n;i++){
            if(i==n){
                while (!index.isEmpty()){
                    int t = index.peek();
                    index.pop();
                    int leftIndex = index.isEmpty()?-1:index.peek();
                    result = Math.max(result,heights[t]*(i-leftIndex-1));
                }
            }else {
                while (!index.isEmpty()&&heights[i]<=heights[index.peek()]){
                    int t = index.peek();
                    index.pop();
                    int leftindex = index.isEmpty()?-1:index.peek();
                    result = Math.max(result,heights[t]*(i-leftindex-1));
                }
            }
            index.push(i);
        }

        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
