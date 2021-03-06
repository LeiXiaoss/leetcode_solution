package com.leixiao.webank;

import java.math.BigInteger;
import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if (n == 0 || n == 1) {
            System.out.println(1);
            return;
        }

        if (n < 0) {
            n = Math.abs(n);
        }

        BigInteger mult = new BigInteger("1");

        for (int i=n;i>0;i--) {
            mult = mult.multiply(new BigInteger(i+""));
        }

        char[] result = String.valueOf(mult).toCharArray();
        for (int i=result.length-1;i>=0;i--) {
            if (result[i] != '0') {
                System.out.println(result[i]);
                return;
            }
        }
    }
}
