package com.leixiao.sort;

public class BubbleSort {
    public void sort(int[] array,int length){
        if(length == 0) return;

        for (int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[]{9,8,6,5,3,7,2,1};

        bubbleSort.sort(array,array.length);
        return;
    }
}
