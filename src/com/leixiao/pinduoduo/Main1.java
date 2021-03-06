package com.leixiao.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    static class Section {
        public int left;
        public int right;

        Section(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        boolean[] dp = new boolean[n];

        int m = in.nextInt();

        List<Section> list = new ArrayList<>(m);
        for (int i=0;i<m;i++) {
            list.add(new Section(in.nextInt(), in.nextInt()));
        }
        long sum = 0;

        for (Section section : list) {
            for (int i=section.left-1;i<section.right;i++) {
                if (!dp[i]) {
                    dp[i] = true;
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}
