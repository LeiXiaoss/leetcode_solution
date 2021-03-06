package com.leixiao.kuaishou;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] preStr = in.nextLine().split(" ");
        String[] midStr = in.nextLine().split(" ");

        int[] pre = new int[preStr.length];
        int[] mid = new int[midStr.length];

        for (int i=0;i<pre.length;i++) {
            pre[i] = Integer.parseInt(preStr[i]);
            mid[i] = Integer.parseInt(midStr[i]);
        }
        if (midStr.length <= 0 ){
            System.out.println("0");
        }

        int[] midSum = new int[midStr.length];
        getMidSum(mid, midSum, 0, mid.length-1);
        StringBuilder sb = new StringBuilder(" ");
        for (int num : midSum) {
            sb.append(num);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void getMidSum(int[] mid, int[] midSum, int left, int right) {
        if (left == right) {
            midSum[left] = 0;
            return;
        }

        int midIndex = (left+right)/2;
        midSum[midIndex] = getSum(mid, left, midIndex-1) + getSum(mid, midIndex+1, right);
        getMidSum(mid, midSum, left, midIndex-1);
        getMidSum(mid, midSum, midIndex+1, right);
    }

    public static int getSum(int[] mid, int start, int end) {
        int result = 0;
        for (int i=start;i<=end;i++) {
            result += mid[i];
        }
        return result;
    }
}
