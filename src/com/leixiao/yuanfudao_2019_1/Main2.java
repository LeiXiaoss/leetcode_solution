package com.leixiao.yuanfudao_2019_1;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.println(spiralOrder(matrix));

    }
    public static String spiralOrder(int[][] matrix){

        StringBuilder sb = new StringBuilder(" ");
        if(matrix.length==0||matrix[0].length==0) return null;

        int left=0,right=matrix[0].length-1,up=0,down=matrix.length-1;
        while (left<=right&&up<=down){
            for (int i=up;i<=down&&left<=right;i++){
                sb.append(matrix[i][left]);
                sb.append(" ");
            }
            left++;

            for (int i=left;i<=right&&up<=down;i++){
                sb.append(matrix[down][i]);
                sb.append(" ");
            }
            down--;

            for (int i=down;i>=up&&left<=right;i--){
                sb.append(matrix[i][right]);
                sb.append(" ");
            }
            right--;

            for (int i=right;i>=left&&up<=down;i--){
                sb.append(matrix[up][i]);
                sb.append(" ");
            }
            up++;
        }
        return sb.toString().trim();
    }
}
