package com.leixiao.sort;

public class QuickSort {

    public void sort(int[] array,int start,int end){
        if(start < end) {
            int i = start, j = end, x = array[start];

            while (i < j) {
                while (i < j && array[j] >= x) {
                    j--;
                }

                if (i < j) {
                    array[i] = array[j];
                    i++;
                }

                while (i < j && array[i] < x) {
                    i++;
                }

                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = x;
            sort(array, start, i - 1);
            sort(array, i + 1, end);
        }
    }

    //使用随机的分割数，快排的改进
    public void sort1(int[] array,int left,int right){
        if (array.length<1 || left<0 || right>=array.length || left > right){
            return;
        }

        int smallIndex = partition(array,left,right);

        if(smallIndex > left){
            sort1(array,left,smallIndex-1);
        }

        if(smallIndex < right){
            sort1(array,smallIndex+1,right);
        }
    }

    public int partition(int[] array,int left,int right){
        int pivot = (int)(left + Math.random()*(right-left+1));
        int smallIndex = left - 1;
        swap(array,pivot,right);

        for (int i=left;i<right;i++){
            if(array[i] <= array[right]){
                smallIndex++;
                if(i>smallIndex){
                    swap(array,i,smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{9,8,6,5,3,7,2,1};

        quickSort.sort(array,0,array.length-1);
        return;
    }
}
