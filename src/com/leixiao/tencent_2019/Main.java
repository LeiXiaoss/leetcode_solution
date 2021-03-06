package com.leixiao.tencent_2019;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();


        int boxOdd = 0;
        int boxEven = 0;
        int keyOdd = 0;
        int keyEven =0;

        for (int i=0;i<n;i++) {
            int temp = in.nextInt();
            if (temp/2 == 0) {
                boxEven++;
            }else {
                boxOdd++;
            }
        }

        for (int j=0;j<m;j++) {
            int temp = in.nextInt();
            if (temp/2 == 0) {
                keyEven++;
            } else {
                keyOdd++;
            }
        }

        System.out.println(Math.min(boxEven,keyOdd)+Math.min(boxOdd,keyEven));
    }
}
