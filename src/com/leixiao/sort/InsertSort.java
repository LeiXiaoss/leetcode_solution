package com.leixiao.sort;

public class InsertSort {

    public void sort(int[] array){
        int length = array.length;
        if (length <= 1) return;

        for (int i=1;i<length;i++){
            int j = i-1;
            int x = array[i];

            while (j >= 0 && array[j] > x){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = x;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,6,5,3,7,2,1};

        InsertSort insertSort = new InsertSort();
        insertSort.sort(array);
        return;
    }
}
