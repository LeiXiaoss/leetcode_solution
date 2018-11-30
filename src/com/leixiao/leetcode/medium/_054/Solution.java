package com.leixiao.leetcode.medium._054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    //
    //示例 1:
    //
    //输入:
    //[
    // [ 1, 2, 3 ],
    // [ 4, 5, 6 ],
    // [ 7, 8, 9 ]
    //]
    //输出: [1,2,3,6,9,8,7,4,5]
    //示例 2:
    //
    //输入:
    //[
    //  [1, 2, 3, 4],
    //  [5, 6, 7, 8],
    //  [9,10,11,12]
    //]
    //输出: [1,2,3,4,8,12,11,10,9,5,6,7]

    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> matrList = new ArrayList<>();

        if(matrix.length==0||matrix[0].length==0) return matrList;

        int left=0,right=matrix[0].length-1,up=0,down=matrix.length-1;
        while (left<=right&&up<=down){
            for (int i=left;i<=right&&up<=down;i++){
                matrList.add(matrix[up][i]);
            }
            up++;

            for (int i=up;i<=down&&left<=right;i++){
                matrList.add(matrix[i][right]);
            }
            right--;

            for (int i=right;i>=left&&up<=down;i--){
                matrList.add(matrix[down][i]);
            }
            down--;

            for (int i=down;i>=up&&left<=right;i--){
                matrList.add(matrix[i][left]);
            }
            left++;
        }
        return matrList;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List list = solution.spiralOrder(new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                {7, 8, 9 }
        });

        System.out.println(list);
    }
}
