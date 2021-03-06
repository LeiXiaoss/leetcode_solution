package com.leixiao.kuaishou;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = in.nextInt();
        }

        int left = 0, right = n-1;
        long leftSum=0,rightSum = 0;
        while (left <= right) {
            if (leftSum > rightSum) {
                rightSum += array[right--];
            } else if (leftSum < rightSum) {
                leftSum += array[left++];
            } else {
                leftSum += array[left++];
                rightSum += array[right--];
            }
        }

        System.out.println(Math.abs(leftSum-rightSum));
    }
}
