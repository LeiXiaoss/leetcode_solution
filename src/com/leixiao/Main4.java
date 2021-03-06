package com.leixiao;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] temp = new int[n];
        for (int i=0;i<n;i++){
            temp[i] = in.nextInt();
        }

        int[] dp = new int[n];
        boolean[] visited = new boolean[m];

        int count=0;
        int times = 0;
        for (int i=0;i<n-m+1;i++){
            for (int j=i;j<n;j++){
                times++;
                if(temp[j] == 0) continue;
                if(visited[temp[j]-1] == false){
                    count++;
                    visited[temp[j]-1] = true;
                }
                if(count == m){
                    dp[i] = times;
                    break;
                }
            }
            visited = new boolean[m];
            count = 0;
            times = 0;
        }

        int small = dp[0];
        for (int i=0;i<n;i++){
            if(dp[i] < small && dp[i] != 0){
                small = dp[i];
            }
        }

        System.out.println(small);
    }
}
