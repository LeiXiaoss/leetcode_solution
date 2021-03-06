package com.leixiao.yuanfudao_2019_1;

import java.util.*;

public class Main0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int peopleNum = in.nextInt();
        int carSize = in.nextInt();

        int[] line = new int[peopleNum];
        for (int i=0;i<peopleNum;i++) {
            line[i] = in.nextInt();
        }

        Stack<List<Integer>> stack = new Stack<>();

        for (int i=0;i<peopleNum;) {
            Integer[] temp = new Integer[3];
            for (int j=0;j<carSize&&i<peopleNum;j++,i++) {
                temp[j] = line[i];
            }
            stack.push(Arrays.asList(temp));
        }

        while (!stack.isEmpty()) {
            List temp = stack.pop();
            temp.forEach(n -> {
                if (n != null) {
                    System.out.print(n + " ");
                }
            });
        }
    }
}
