package com.leixiao.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        List<Integer[]> list = new ArrayList<>();
        for (int i=0;i<t;i++) {
            int n = in.nextInt();
            Integer[] temp = new Integer[n];
            for (int j=0;j<n;j++) {
                temp[j] = in.nextInt();
            }
            list.add(temp);
        }

        for (int i=0;i<t;i++) {
            System.out.println(getLength(list.get(i)));
        }

    }

    public static int getLength(Integer[] array) {
        int sum = 0;
        int max = 0;

        for (int i=0;i<array.length; ) {
            sum = array[i];
            int length = 1;
            for (int j=i+1;j<array.length;j++) {
                if (array[j] < array[j-1]) {
                    i = j;
                    break;
                }

                if (sum > array[j]) {
                    i++;
                    break;
                }
                sum += array[j];
                length++;
            }
            max = Math.max(length,max);
            if (i+length >= array.length) {
                break;
            }
        }
        return max;
    }
}
