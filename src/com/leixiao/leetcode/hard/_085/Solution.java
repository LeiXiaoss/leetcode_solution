package com.leixiao.leetcode.hard._085;

import java.util.Stack;

public class Solution {
    //给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
    //
    //示例:
    //
    //输入:
    //[
    //  ["1","0","1","0","0"],
    //  ["1","0","1","1","1"],
    //  ["1","1","1","1","1"],
    //  ["1","0","0","1","0"]
    //]
    //输出: 6

    public int maximalRectangle(char[][] matrix){
        if (matrix.length == 0) return 0;
        int result = 0;
        int[] height = new int[matrix[0].length];

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.println(matrix[i][j]);
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else {
                    height[j] += 1;
                }
            }
            result = Math.max(result,largestRectangleArea(height));
        }
        return result;
    }

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
        System.out.println(solution.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0', '1','1','1'},
                {1,1,1,1,1},
                {1,0,0,1,0}
        }));
    }
}
