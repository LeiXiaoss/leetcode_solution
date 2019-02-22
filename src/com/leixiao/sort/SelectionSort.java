package com.leixiao.sort;

public class SelectionSort {
    public void sort(int[] array){
        int length = array.length;

        for (int i=0;i<length;i++){
            int min = array[i];
            int x = i;
            for (int j=i+1;j<length;j++){
                if(min > array[j]){
                    min = array[j];
                    x = j;
                }
            }
            swap(array,x,i);
        }
    }

    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,6,5,3,7,2,1};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
        return;
    }
}
