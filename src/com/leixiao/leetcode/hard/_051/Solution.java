package com.leixiao.leetcode.hard._051;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    //n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //每行一个并使其不能互相攻击（同一列、同一行、同一斜行上的皇后都会自动攻击）。
    //
    //给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
    //
    //每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    //
    //示例:
    //
    //输入: 4
    //输出: [
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
    //解释: 4 皇后问题存在两个不同的解法。

    public List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<>();
        int[] queenList = new int[n];
        backtrack(queenList,result,0,n);
        return result;
    }

    private void backtrack(int[] queenList,List result,int row,int n){
        //如果行数到n，说明已经放置完毕，加入List
        if(row == n){
            List<String> list = new ArrayList<>();
            for (int i=0;i<queenList.length;i++){
                StringBuilder sb = new StringBuilder();
                for (int j=0;j<n;j++){
                    if(queenList[i] == j){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for (int i=0;i<n;i++){
            if (isVaild(queenList,row,i)){
                queenList[row] = i;
                backtrack(queenList,result,row+1,n);
            }
        }
    }

    private boolean isVaild(int[] queenList,int row,int col){
        for (int i=0;i<row;i++){
            int queenLocation = queenList[i];
            if(col == queenLocation){
                return false;
            }
            if(queenLocation-row+i==col){
                return false;
            }
            if(queenLocation+row-i==col){
                return false;
            }
        }
        return true;
    }
}
