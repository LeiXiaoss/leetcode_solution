package com.leixiao.forjob;

import java.util.Scanner;

public class PrintArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int row = in.nextInt();
        int col = in.nextInt();

        int[][] array = new int[row][col];
        for (int i = 0 ; i < row ; i++) {
            for (int j = 0 ; j < col ; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int left = 0;
        int right = col - 1;
        int up = 0;
        int down = row - 1;

        while (left <= right || up <= down) {
            if (up <= down) {
                for (int i = left ; i <= right ; i++) {
                    System.out.println(array[up][i]);
                }
                up++;
            }

            if (left <= right) {
                for (int i = up ; i <= down ; i++) {
                    System.out.println(array[i][right]);
                }
                right--;
            }

            if (up <= down) {
                for (int i = right ; i >= left ; i--) {
                    System.out.println(array[down][i]);
                }
                down--;
            }

            if (left <= right) {
                for (int i = down ; i >= up ; i--) {
                    System.out.println(array[i][down]);
                }
                left++;
            }
        }
    }
}

