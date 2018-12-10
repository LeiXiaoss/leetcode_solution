package com.leixiao.leetcode.medium._059;

public class Solution {
    //给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
    //
    //示例:
    //
    //输入: 3
    //输出:
    //[
    // [ 1, 2, 3 ],
    // [ 8, 9, 4 ],
    // [ 7, 6, 5 ]
    //]

    public int[][] generateMatrix(int n){
        int[] array = new int[n*n];
        for (int i=0;i<n*n;i++){
            array[i] = i+1;
        }

        int left = 0,right = n-1,up = 0,down = n-1;
        int[][] matrix = new int[n][n];

        int index = 0;
        while (left<=right&&up<=down&&index<n*n){
            for (int i=left;i<=right&&left<=right;i++){
                matrix[up][i] = array[index++];
            }
            up++;

            for (int i=up;i<=down&&up<=down;i++){
                matrix[i][right] = array[index++];
            }
            right--;

            for (int i=right;i>=left&&left<=right;i--){
                matrix[down][i] = array[index++];
            }
            down--;

            for (int i=down;i>=up&&up<=down;i--){
                matrix[i][left] = array[index++];
            }
            left++;
        }
         return matrix;
    }

    public static void main(String[] args){
        System.out.println(new Solution().generateMatrix(3));
    }
}
