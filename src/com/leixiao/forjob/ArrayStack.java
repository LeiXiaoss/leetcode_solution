package com.leixiao.forjob;

//一个数组实现两个栈
public class ArrayStack {
    private int size;
    private int[] array = new int[size];
    private int firstSize;
    private int secondSize;

    public ArrayStack(int size) {
        this.size = size;
        this.firstSize = -1;
        this.secondSize = size;
    }

    public boolean pushFist(int num) {
        if (Math.abs(firstSize-secondSize) == 1) {
            return false;
        }

        if (firstSize == -1) {
            array[++firstSize] = num;
        } else {
            for (int i = firstSize ; i >= 0 ; i--) {
                array[i+1] = array[i];
            }
            array[0] = num;
            firstSize++;
        }
        return true;
    }

    public boolean pushLast(int num) {
        if (Math.abs(firstSize-secondSize) == 1) {
            return false;
        }

        if (secondSize == size) {
            array[--secondSize] = num;
        } else {
            for (int i = secondSize ; i<size ; i++) {
                array[i-1] = array[i];
            }
            array[size-1] = num;
            secondSize--;
        }
        return true;
    }

    public int popFirst() {
        if (firstSize == -1) {
            throw new IllegalArgumentException("栈为空");
        }

        int value = array[0];
        for (int i = 0 ; i < firstSize ; i++) {
            array[i] = array[i+1];
        }
        firstSize--;
        return value;
    }

    public int popSecond() {
        if (secondSize == size) {
            throw new IllegalArgumentException("栈为空");
        }

        int value = array[size-1];
        for (int i = size-1 ; i > secondSize ; i--) {
            array[i] = array[i-1];
        }
        secondSize++;
        return value;
    }
}
