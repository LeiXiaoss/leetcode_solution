package com.leixiao.shopee;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] verArray = in.nextLine().trim().split(",");
        if (verArray == null || verArray.length <= 1) {
            System.out.println("0");
            return;
        }

        if (verArray[0] == null || verArray[0].trim().length() == 0) {
            System.out.println("-1");
            return;
        }
        String[] before = verArray[0].trim().split("\\.");
        if (verArray[1] == null || verArray[1].trim().length() == 0) {
            System.out.println("1");
            return;
        }
        String[] after = verArray[1].trim().split("\\.");

        for (int i = 0 ; i < before.length ; i++) {
            if (Integer.valueOf(before[i]) > Integer.valueOf(after[i])) {
                System.out.println("1");
                return;
            } else if (Integer.valueOf(before[i]) < Integer.valueOf(after[i])) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println("0");
    }
}
