package com.leixiao.sort;

public class ShellSort {

    //插入时采用交换法
    public void sort(int[] array){
        for (int gap=array.length/2;gap>0;gap/=2){
            for (int i=gap;i<array.length;i++){
                int j = i;

                while (j-gap>=0 && array[j] < array[j-gap]){
                    swap(array,j,j-gap);
                    j = j-gap;
                }
            }
        }
    }

    //插入时采用移动法
    public void sort1(int[] array){
        for (int gap=array.length/2;gap>0;gap/=2){
            for (int i=gap;i<array.length;i++){
                int j = i;
                int temp = array[j];

                if (array[j] < array[j-gap]){
                    while (j-gap >= 0 && temp < array[j-gap]){
                        array[j] = array[j-gap];
                        j = j-gap;
                    }
                    array[j] = temp;
                }
            }
        }
    }

    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,6,5,3,7,2,1};

        ShellSort shellSort =  new ShellSort();
        shellSort.sort1(array);

        return;
    }
}
