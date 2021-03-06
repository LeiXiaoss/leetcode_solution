package com.leixiao.wangyi;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = in.nextInt();
        }

        for (int i=0;i<n;i++) {
            System.out.println(findMin(array[i]));
        }

    }

    public static String findMin(int n) {
        int nineCount = n/9;
        int small = n%9;

        StringBuilder sb = new StringBuilder();
        if (small != 0) {
            sb.append(small);
        }

        for (int i=0;i<nineCount;i++) {
            sb.append(9);
        }

        return sb.toString();
    }
}
