package com.leixiao.structure;

//使用数组模拟栈
public class ArrayStack {
    private Integer[] arr;
    private Integer index;

    //初始化
    public ArrayStack(Integer stackSize){
        if (stackSize < 0){
            throw new IllegalArgumentException("初始化大小不能小于0");
        }

        arr = new Integer[stackSize];
        index = 0;
    }

    //压栈
    public void push(Integer num){
        if(index == arr.length){
            throw new IllegalArgumentException("栈已满");
        }

        arr[index] = num;
        index++;
    }

    //出栈
    public int pop(){
        if(index == 0){
            throw new IllegalArgumentException("栈为空");
        }

        return arr[--index];
    }

    //查看栈顶元素
    public Integer peek(){
        if (index == 0){
            return null;
        }
        return arr[index-1];
    }
}
