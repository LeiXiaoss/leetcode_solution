package com.leixiao.kuaishou;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");
        int[] array = new int[input.length];

        for (int i=0;i<input.length;i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int count = 0;

        for (int i=1;i<array.length;i++) {
            if (array[i] < array[i-1]) {
                count++;
            }
        }

        if (count <= 1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
