package com.leixiao.pangpang;

public class Submit2 {
    public static int getMaxPaper(int i1, int i2) {
        if(i1 < i2){
            int temp = i1;
            i1 = i2;
            i2 = temp;

        }
        int temp = 0;
        while(i1%i2 != 0){
            temp = i1%i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
}
