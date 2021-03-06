package com.leixiao.yuanfudao_2019_1;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int s = in.nextInt();

        int[] nums = new int[n];

        for (int i=0;i<n;i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(max(nums, s));
    }

    public static int max(int[] nums, int k) {
        int max = 0;
        for (int i=0;i<nums.length;) {
            int sum = 0;
            int last = i;
            for (int j=i;j<nums.length;j++) {
                sum += nums[j];
                last = j;
                if (sum > k) {
                    max = Math.max(j-i,max);
                    break;
                } else if (sum == k) {
                    max = Math.max(j-i+1,max);
                    break;
                }
            }
            i = last+1;
        }
        return max;
    }
}
