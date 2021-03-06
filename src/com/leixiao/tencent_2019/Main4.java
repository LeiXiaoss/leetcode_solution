package com.leixiao.tencent_2019;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] scores = new int[n];

        for (int i=0 ; i<n ; i++) {
            scores[i] = in.nextInt();
        }

        int max = 0;
        int[] plus = new int[n];
        for (int i=0;i<n;i++) {
            int left = 0;
            int right = n-1;
            for (int j=0;j<=i;j++) {
                if (scores[i] > scores[j]) {
                    left = j;
                }
            }
            for (int k=i;k<n;k++) {
                if (scores[i] > scores[k]) {
                    right = k;
                    break;
                }
            }
            for (int start = left;start<right;start++) {
                plus[i] += scores[start];
            }
            plus[i] *= scores[i];
            max = Math.max(max,plus[i]);
        }

        System.out.println(max);
    }
}
