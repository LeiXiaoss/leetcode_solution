package com.leixiao.kuaishou;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = in.nextInt();
        }

        long leftSum = array[0];
        long rightSum = array[n-1];
        long max = 0;
        int left = 0,right = n-1;

        while (left < right){
            if (leftSum == rightSum) {
                max = Math.max(max,leftSum);
                leftSum += array[++left];
                rightSum += array[--right];
            } else if (leftSum < rightSum) {
                leftSum += array[++left];
            } else if (leftSum > rightSum) {
                rightSum += array[--right];
            }
        }
        System.out.println(max);
    }
}
