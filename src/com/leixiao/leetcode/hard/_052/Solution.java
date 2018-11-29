package com.leixiao.leetcode.hard._052;

public class Solution {
    //n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //给定一个整数 n，返回 n 皇后不同的解决方案的数量。
    //
    //示例:
    //
    //输入: 4
    //输出: 2
    //解释: 4 皇后问题存在如下两个不同的解法。
    //[
    // [".Q..",  // 解法 1
    //  "...Q",
    //  "Q...",
    //  "..Q."],
    //
    // ["..Q.",  // 解法 2
    //  "Q...",
    //  "...Q",
    //  ".Q.."]
    //]

    public int totalNQueens(int n){
        int count = 0;
        int[] queensArray = new int[n];
        count = backTrack(count,queensArray,0,n);
        return count;
    }

    private int backTrack(int count,int[] queensArray,int rows,int n){

        if(n == rows){
            count ++;
            return count;
        }

        for(int i=0;i<n;i++){
            if(isvaild(queensArray,rows,i)){
                queensArray[rows] = i;
                count = backTrack(count,queensArray,rows+1,n);
            }
        }
        return count;
    }

    private boolean isvaild(int[] queensArray,int row,int col){
        for (int i=0;i<row;i++){
            int queenLocation = queensArray[i];

            if(queenLocation == col){
                return false;
            }
            if(queenLocation-row+i == col){
                return false;
            }
            if(queenLocation+row-i == col){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }
}
