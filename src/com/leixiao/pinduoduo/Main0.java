package com.leixiao.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);

        long sum = 0;
        for (int i=0,j=2*m-1;i<j;i++,j--) {
            sum += array[i] * array[j];
        }

        System.out.println(sum);
    }
}
