package com.leixiao.leetcode;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 0,m = 0;

        while (in.hasNextInt()){
            n = in.nextInt();
            m = in.nextInt();
            break;
        }

        int size = 0;

        while (m > 0){
            if(m >= n){
                size = m/n + size;
                m = m%n;
            }else {
                n = n-1;
            }
        }

        System.out.println(size);
    }
}
