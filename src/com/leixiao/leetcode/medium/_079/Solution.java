package com.leixiao.leetcode.medium._079;

public class Solution {
    //给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    //
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，
    // 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    //
    //示例:
    //
    //board =
    //[
    //  ['A','B','C','E'],
    //  ['S','F','C','S'],
    //  ['A','D','E','E']
    //]
    //
    //给定 word = "ABCCED", 返回 true.
    //给定 word = "SEE", 返回 true.
    //给定 word = "ABCB", 返回 false.

    public boolean exist(char[][] board,String word){
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(backtrack(board,word,visited,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board,String word,boolean[][] visited,
                              int index,int row,int col){
        if(index == word.length()){
            return true;
        }

        boolean hasPath = false;
        if(check(board,word,visited,index,row,col)){
            visited[row][col] = true;
            index++;
            hasPath = backtrack(board,word,visited,index,row+1,col)||
                    backtrack(board,word,visited,index,row-1,col)||
                    backtrack(board,word,visited,index,row,col+1)||
                    backtrack(board,word,visited,index,row,col-1);

            if (!hasPath){
                visited[row][col] = false;
                index--;
            }
        }
        return hasPath;
    }

    private boolean check(char[][] board,String word,boolean[][] visited,
                          int index,int row,int col){
        return row>=0&&row<board.length&&
                col>=0&&col<board[0].length&&
                visited[row][col]==false&&
                board[row][col]==word.charAt(index);
    }
}
