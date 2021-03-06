package com.leixiao.keep;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        String[] nums = line.split(" ");

        char[] num1 = nums[0].toCharArray();
        char[] num2 = nums[1].toCharArray();

        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        for (int i=num1.length-1,j=num2.length-1;i>=0&&j>=0;i--,j--) {
            int temp = Character.getNumericValue(num1[i]) + Character.getNumericValue(num2[j]) + (flag?1:0);

            if (temp/10 != 0) {
                flag = true;
            }else {
                flag = false;
            }
            sb.insert(0,temp%10);
        }

        if (num1.length > num2.length) {
            for (int i=num1.length-num2.length-1;i>=0;i--) {
                int temp = Character.getNumericValue(num1[i]) + (flag?1:0);
                if (temp/10 != 0) {
                    flag = true;
                }else {
                    flag = false;
                }
                sb.insert(0,temp%10);
            }
        } else if (num1.length < num2.length) {
            for (int i=num2.length-num1.length-1;i>=0;i--) {
                int temp = Character.getNumericValue(num2[i]) + (flag?1:0);
                if (temp/10 != 0) {
                    flag = true;
                }else {
                    flag = false;
                }
                sb.insert(0,temp%10);
            }
        } else if (num1.length == num2.length) {
            if (flag == true) {
                sb.insert(0,1);
            }
        }

        System.out.println(sb.toString());
    }
}
