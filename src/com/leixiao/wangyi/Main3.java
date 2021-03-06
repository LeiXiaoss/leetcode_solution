package com.leixiao.wangyi;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = in.nextInt();
        }

        int sum  = 0;
        for (int i=0;i<n;i++) {
            int left = array[i];
            for (int j=i+1;j<n;j++) {
                if (array[j] < left) {
                    sum += (j-i);
                }
            }
        }
        System.out.println(sum);
    }
}
