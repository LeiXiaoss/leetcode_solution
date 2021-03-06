package com.leixiao.webank;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        if (n == 0 || n == 1) {
            System.out.println(n);
        }

        BigInteger result = bigNumber(n);


        result = result.mod(new BigInteger("1000003"));

        System.out.println(result);
    }
    public static synchronized BigInteger bigNumber(int num){
        BigInteger nextfact = new BigInteger("1");

        for (int i = 1; i <= num; i++) {
            BigInteger lastfact = nextfact;
            nextfact = lastfact.multiply(BigInteger.valueOf(i));
            nextfact = nextfact.mod(new BigInteger("1000003"));
        }
        return nextfact;

    }
}
