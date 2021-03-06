package com.leixiao.bytedance_2019;

import java.util.Scanner;
import java.util.Stack;

public class Main0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputs = new int[n];
        for(int i=0; i<n; i++){
            inputs[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && inputs[i]>inputs[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                dp[stack.peek()]++;
            }
            stack.push(i);
        }
        int index = 0;
        for(int i=1; i<n; i++){
            if(dp[index]<dp[i]){
                index = i;
            }
        }

        System.out.println(inputs[index]);
    }
}
