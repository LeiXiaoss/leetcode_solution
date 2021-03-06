package com.leixiao.forjob;

import java.util.Stack;

//两个栈模拟队列
public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void offer(int num) {
        stack1.push(num);
    }

    public int poll() {
        if (stack1.isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int num = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return num;
    }

    public int peek() {
        if (stack1.isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int num = stack2.peek();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return num;
    }
}
