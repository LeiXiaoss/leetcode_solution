package com.leixiao.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    static class Switch {
        public int A;
        public int B;
        public int p;
        public int q;

        Switch(int A, int B, int p, int q) {
            this.A = A;
            this.B = B;
            this.p = p;
            this.q = q;
        }

        public int getTimes() {
            int times = 0;
            while (B-A > p) {
                p = p * q;
                times++;
            }
            return ++times;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Switch> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            list.add(new Switch(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        }

        for (int i=0;i<n;i++) {
            System.out.println(list.get(i).getTimes());
        }
    }
}
