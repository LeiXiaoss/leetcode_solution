package com.leixiao.tencent_2019;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] rooms = new int[n];
        for (int i=0 ; i<n ; i++) {
            rooms[i] = in.nextInt();
        }

        int[] dp = new int[n];
        int num = m;

        for (int i=0;i<n;i++) {
            dp[i] = rooms[i]/num+i+1;
            num = rooms[i]%num;
        }

    }
}
