package com.leixiao.huawei_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputStr = in.nextLine();
        String[] strs = inputStr.split(" ");

        int inputLength = Integer.parseInt(strs[0], 16);
        int outputLength = 1;

        for (int i = 1; i < inputLength; i++) {
            if (strs[i].equals("A") || strs[i].equals("B")) {
                outputLength = outputLength + 2;
            } else {
                outputLength++;
            }
        }

        List<String> outputList = new ArrayList<>();

        outputList.add(String.valueOf(outputLength));

        for (int i = 1; i < inputLength; i++) {
            if (strs[i].equals("A")) {
                outputList.add("12 34");
            } else if (strs[i].equals("B")) {
                outputList.add("AB CD");
            } else {
                outputList.add(strs[i]);
            }
        }

        StringBuilder sb = new StringBuilder(outputList.get(0));
        outputList.remove(0);
        for (String s : outputList) {
            sb.append(" ");
            sb.append(s);
        }

        System.out.println(sb.toString());
    }
}
