package com.leixiao.structure;

//使用数组模拟一个队列
public class ArrayQueue {
    private Integer[] arr;
    private Integer size;
    private Integer first;
    private Integer last;

    //初始化队列
    public ArrayQueue(int queueSize){
        if(queueSize < 0){
            throw new IllegalArgumentException("初始化大小不能小于0");
        }

        arr = new Integer[queueSize];
        size = 0;
        first = 0;
        last = 0;
    }

    //插入数据
    public void push(int num){
        if(size == arr.length){
            throw new IllegalArgumentException("队列已满");
        }

        arr[last] = num;
        size++;

        if(last == arr.length-1){
            last = 0;
        }else {
            last++;
        }
    }

    //删除数据
    public Integer poll(){
        if (size == 0){
            throw new IllegalArgumentException("队列为空");
        }

        int temp = first;
        size--;

        if(first == arr.length-1){
            first = 0;
        }else {
            first++;
        }
        return arr[temp];
    }

    //查看队头
    public Integer peek(){
        if (size == 0){
            return null;
        }
        return arr[first];
    }


}
