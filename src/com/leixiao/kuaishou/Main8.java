package com.leixiao.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
    public static void length(int[] nums){
        if (nums == null || nums.length == 0){
            System.out.println(0);
            return;
        }
        if (nums.length == 1) {
            System.out.println(1);
            return;
        }

        Arrays.sort(nums);

        int diffMax = nums[nums.length - 1] - nums[0];
        int max = 1;

        int[][] dp = new int[nums.length][diffMax + 1];

        //初始化动态规划数组
        for(int i = 0; i < nums.length; i++)
            for(int j = 0; j <= diffMax; j++)
                dp[i][j] = 1;

        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                int temp = nums[i] - nums[j];
                dp[i][temp] = dp[j][temp] + 1;
                max = Math.max(max, dp[i][temp]);
            }
        }

        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i=0;i<n;i++) {
            nums[i] = in.nextInt();
        }

        length(nums);

    }
}
