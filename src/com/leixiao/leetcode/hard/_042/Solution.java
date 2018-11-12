package com.leixiao.leetcode.hard._042;

import java.util.Stack;

public class Solution {
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //
    //示例:
    //
    //输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出: 6

    //对于每根柱子，求左右的最大值，计算这根柱子对应的储水量
    //进行了3次遍历
    public int trap0(int[] height){
        if(height == null || height.length <= 2) return 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int leftTemp=0;
        int rightTemp=0;
        int count = 0;
        for (int i=0;i<height.length;i++){
            if(i==0){
                leftMax[i] = 0;
                continue;
            }
            leftTemp = Math.max(leftTemp,height[i-1]);
            leftMax[i] = leftTemp;
        }
        for (int i=height.length-1;i>=0;i--){
            if(i==height.length-1){
                rightMax[i] = 0;
                continue;
            }
            rightTemp = Math.max(rightTemp,height[i+1]);
            rightMax[i] = rightTemp;
        }

        for (int i=1;i<height.length-1;i++){
            if(height[i]>=rightMax[i]||height[i]>=leftMax[i]){
                continue;
            }
            count = (leftMax[i]>rightMax[i]?rightMax[i]:leftMax[i]) - height[i] + count;
        }
        return count;
    }

    //求左右区间最大值，可以对两个循环做一个合并，遍历次数变为2次
    public int trap1(int[] height){
        if(height == null || height.length<=2) return 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int leftTemp=0;
        int rightTemp=0;
        int count = 0;

        for (int i=0;i<height.length;i++){
            leftTemp = leftMax[i] = Math.max(leftTemp,height[i]);
            rightTemp = rightMax[height.length-i-1] = Math.max(rightTemp,height[height.length-i-1]);
        }

        for (int i=0;i<height.length;i++){
            count += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return count;
    }

    //横向分割累加计算盛水量
    public int trap2(int[] height){
        int length = height.length;
        int current=0,result=0;

        Stack<Integer> stack = new Stack<>();

        while (current<length){
            while (!stack.isEmpty()&&height[current]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }

                int distance = current - stack.peek() - 1;
                int temp = Math.min(height[current],height[stack.peek()]) - height[top];
                result += temp * distance;
            }
            stack.push(current++);
        }
        return result;
    }

    //双指针
    public int trap3(int[] height){
        int left = 0;
        int right = height.length-1;
        int result = 0;
        int leftMax=0,rightMax=0;

        while (left<right){
            if(height[left]<height[right]){
                leftMax = Math.max(leftMax,height[left]);
                result += leftMax - height[left];
                left++;
            }else {
                rightMax = Math.max(rightMax,height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int count = solution.trap3(new int[]{4,3,2,1,0,3});
        System.out.println(count);
    }
}
