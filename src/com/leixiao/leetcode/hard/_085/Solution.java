package com.leixiao.leetcode.hard._085;

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
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else {
                    height[j] += 1;
                }
            }
            result = Math.max(result,new com.leixiao.leetcode.hard._084.Solution().largestRectangleArea(height));
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
