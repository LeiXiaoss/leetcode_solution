package com.leixiao.code2019.netease;

import java.util.Scanner;

public class Topic2 {

//    题目描述
//
//    小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
//
//    并且小Q对于能否被3整除这个性质很感兴趣。
//
//    小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
//    输入描述:
//
//    输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
//
//    输出描述:
//
//    输出一个整数, 表示区间内能被3整除的数字个数。
//
//    示例1
//            输入
//
//
//2 5
//
//    输出
//
//
//3
//
//    说明
//
//12, 123, 1234, 12345...
//    其中12, 123, 12345能被3整除。


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int end = in.nextInt();

        int count = 0;
        int num = 0;

        for (int i = 1 ; i <= start ; i++) {
            num += i;
        }

        if (num % 3 == 0) {
            count++;
            num = 0;
        }

        for (int i = start+1 ; i<= end ; i++) {
            num += i;
            if (num % 3 != 0) {
                num = num % 3;
            } else {
                count++;
                num = 0;
            }
        }

        System.out.println(count);
    }
}
