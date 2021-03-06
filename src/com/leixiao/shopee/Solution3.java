package com.leixiao.shopee;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution3 {
    private int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.close();

        if (m == 0 || n == 0) {
            System.out.println(0);
            return;
        }

        BigInteger[][] dp = new BigInteger[m][n];
        for (int i=0;i<m;i++) {
            dp[i][0] = new BigInteger("1");
        }
        for (int i=0;i<n;i++) {
            dp[0][i] = new BigInteger("1");
        }

        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j].add(dp[i][j-1]);
            }
        }
        System.out.println(dp[m-1][n-1].toString());
    }
}
