package com.leixiao.forjob;

import java.util.Scanner;
import java.util.Stack;

//栈排序
public class StackSort {
    //链接：https://www.nowcoder.com/questionTerminal/ff8cba64e7894c5582deafa54cca8ff2
    //来源：牛客网
    //
    //一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，
    // 但不能申请额外的数据结构。如何完成排序？
    //
    //输入描述:
    //
    //第一行输入一个N，表示栈中元素的个数
    //第二行输入N个整数aia_iai​表示栈顶到栈底的各个元素
    //
    //
    //
    //输出描述:
    //
    //输出一行表示排序后的栈中栈顶到栈底的各个元素。
    //
    //示例1
    //输入
    //
    //5
    //5 8 4 3 6
    //
    //输出
    //
    //8 6 5 4 3

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int lenght = in.nextInt();

        Stack<Integer> first = new Stack<>();
        for (int i = 0 ; i < lenght ; i++) {
            first.add(in.nextInt());
        }

        Stack<Integer> second = new Stack<>();

        while (!first.isEmpty()) {
            int temp = first.pop();

            if (second.isEmpty()) {
                second.push(temp);
            } else {
                while ( !second.isEmpty() && second.peek() > temp) {
                    first.push(second.pop());
                }
                second.push(temp);
            }
        }

        second.stream().forEach(num -> System.out.print(num));
    }
}
