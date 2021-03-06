package com.leixiao.duxiaoman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main0 {
    static class Train implements Comparable {
        public int high;
        public int low;

        public Train(int low, int high) {
            this.high = high;
            this.low = low;
        }

        @Override
        public int compareTo(Object o) {
            Train train = (Train)o;
            if (this.high > train.high) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Train> trainList = new ArrayList<>(n);
        for (int i=0;i<n;i++) {
            trainList.add(new Train(in.nextInt(), in.nextInt()));
        }

        Collections.sort(trainList);

        if (trainList.isEmpty()) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[trainList.get(0).high];

        for (Train train : trainList) {
            for (int i=train.high-1;i>=train.low;i--) {
                dp[i] += 1;
            }
        }

        int max = 0;
        for (int m : dp) {
            max = Math.max(m,max);
        }

        System.out.println(max);

    }
}
