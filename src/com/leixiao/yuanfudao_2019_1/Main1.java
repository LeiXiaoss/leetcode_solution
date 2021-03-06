package com.leixiao.yuanfudao_2019_1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        char[] chars = in.nextLine().toCharArray();

        int m = (2 * n + 1) / 3;

        int left=0,right=m-1;
        int index = 0;

        for (int i=0;i<m;i++) {
            for (int j=0;j<m;j++) {
                if (i<m/2) {
                    if (j==left) {
                        System.out.print(chars[index++]);
                    } else if (j == right) {
                        System.out.print(chars[index++]);
                        break;
                    } else {
                        System.out.print(' ');
                    }
                } else {
                    if (j == m/2) {
                        System.out.print(chars[index++]);
                        break;
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            left++;
            right--;
            System.out.println();
        }
    }
}
