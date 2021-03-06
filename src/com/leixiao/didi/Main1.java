package com.leixiao.didi;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] array = new int[n];

        Arrays.sort(array);
        for (int i=0;i<n;i++) {
            array[i] = in.nextInt();
        }

        int min = Integer.MAX_VALUE;

        for (int i=m-1;i<n;i++) {
            int sum = 0;
            for (int j=m;j>0;j--) {
                sum += array[i-j+1];
            }
            min = Math.min(sum,min);
        }

        System.out.println(min);
    }
}
