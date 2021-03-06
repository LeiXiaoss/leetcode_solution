package com.leixiao.newleetcode._657;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0,y=0;
        for(int i= 0;i<moves.length();i++){
            switch(moves.charAt(i)){
                case 'U':y-=1;break;
                case 'D':y+=1;break;
                case 'L':x-=1;break;
                case 'R':x+=1;break;
            }
        }
        return x==0&&y==0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.judgeCircle("UD");
    }
}
