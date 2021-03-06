package com.leixiao.qunawang;

import java.util.Scanner;

public class Main0 {

    public static int n;
    public static long[][] metrix;
    public static long result = Long.MIN_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=Integer.parseInt(sc.nextLine());

        metrix = new long[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                metrix[i][j] = sc.nextLong();

        for (int start = 0; start < n; start++) {
            long[] ring = new long[n];
            long[] dp = new long[n];

            for (int end = start; end < n; end++) {
                for (int j = 0; j < n; j++)
                    ring[j] += metrix[end][j];
                result = Math.max(result, ring[0]);
                dp[0] = ring[0];
                for (int j = 1; j < n; j++) {
                    if (dp[j - 1] < 0)
                        dp[j] = ring[j];
                    else
                        dp[j] = dp[j - 1] + ring[j];
                    result = Math.max(result, dp[j]);
                }
            }
        }

        System.out.println(result);
    }
}
