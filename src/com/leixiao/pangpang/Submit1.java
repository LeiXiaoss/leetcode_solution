package com.leixiao.pangpang;

import java.util.Arrays;

public class Submit1 {
    public static int getExternalDistribution(int[] need, int[] product) {
        Arrays.sort(need);
        Arrays.sort(product);

        int count = 0;
        for (int i = 0, j = 0 ; i < need.length && j < product.length ;) {
            if (need[i] <= product[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;

    }
}
