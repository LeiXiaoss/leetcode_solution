package com.leixiao.sort;

public class QuickSort {

    //使用第一个数开始作为分割点
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

        int pivot = partition(array,left,right);

        if(pivot > left){
            sort1(array,left,pivot-1);
        }

        if(pivot < right){
            sort1(array,pivot+1,right);
        }
    }

    //选取随机位置的数字作为分割数，并将这个数交换到开头或者结尾，再进行操作
    public int partition(int[] array,int left,int right){
        int pivot = (int)(left + Math.random()*(right-left+1));
        swap(array,pivot,left);

        int i = left, j = right ,x = array[left];

        while (i < j){
            while (i < j && array[j] >= x){
                j--;
            }
            if(i < j){
                array[i++] = array[j];
            }

            while (i < j && array[i] < x){
                i++;
            }
            if (i < j){
                array[j--] = array[i];
            }
        }
        array[i] = x;
        return i;
    }

    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{9,8,6,5,3,7,2,1};

        quickSort.sort1(array,0,array.length-1);
        return;
    }
}
