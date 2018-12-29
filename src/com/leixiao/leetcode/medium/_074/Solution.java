package com.leixiao.leetcode.medium._074;

public class Solution {
    //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    //
    //每行中的整数从左到右按升序排列。
    //每行的第一个整数大于前一行的最后一个整数。
    //示例 1:
    //
    //输入:
    //matrix = [
    //  [1,   3,  5,  7],
    //  [10, 11, 16, 20],
    //  [23, 30, 34, 50]
    //]
    //target = 3
    //输出: true
    //示例 2:
    //
    //输入:
    //matrix = [
    //  [1,   3,  5,  7],
    //  [10, 11, 16, 20],
    //  [23, 30, 34, 50]
    //]
    //target = 13
    //输出: false

    //整个数组升序排列，二分法
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = 0;
        if(row!=0){
            col = matrix[0].length;
        }else return false;

        int left = 0;
        int right = row*col-1;

        while (left<=right){
            int mid = (left+right)/2;
            int m = mid/col;
            int n = mid%col;

            if(matrix[m][n]<target){
                left = mid+1;
            }else if(matrix[m][n]>target){
                right = mid-1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix1 = new int[][]{};

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix1,31));
    }
}
