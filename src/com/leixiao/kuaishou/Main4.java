package com.leixiao.kuaishou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //保存积木的宽高的二维数组
        int[][] bricks = new int[n][2];
        String[] strs;
        for (int i = 0; i < n; i++) {
            strs = bf.readLine().split(" ");
            bricks[i][0] = Integer.parseInt(strs[0]);
            bricks[i][1] = Integer.parseInt(strs[1]);
        }
        if (n==1){
            System.out.println(1);
            return;
        }
        //按照宽进行排序,然后求长度的最长上升子序列
        Arrays.sort(bricks, (a, b) -> a[0] - b[0]);
        /**
         * 我们按照宽度从小到大对 bricks 进行了排序
         * dp数组中存储的数积木的长度，它是一个上升的数组，这样才能保证积木的层叠
         */
        int[] dp = new int[n];
        int count = 0;//层数
        for (int i = 0; i < n; i++) {
            if (count == 0 || bricks[i][1] >= dp[count - 1]) {
                //当当前积木的长度 >= dp数组中保存的最大积木长度，那我们就将它加入到 dp 数组中,并且层数加一
                dp[count] = bricks[i][1];
                count++;
            }else {
                /**
                 * 这里解释一下：当我们加入的积木 bricks[i][1],它的长度小于dp中的最大长度
                 * 我们需要在数组dp中找到 <= bricks[i][1] 最接近的值的索引 index，将它替换成现在的长度 bricks[i][1]
                 * 为什么要替换: dp数组中积木的宽度都是小于 bricks[i]的，积木bricks[i]的宽度比dp[index]宽度大，
                 * 而且bricks[i]的长度 >= dp[index],在堆积木情况下，当然是优先选择宽度和长度更大的积木。
                 */
                int index = lowerBound(dp, 0, count, bricks[i][1]);
                dp[index] = bricks[i][1];
            }
        }
        System.out.println(count);
    }
    /**
     * C++中存在的两个方法，用java实现一下
     * ower_bound算法要求在已经按照非递减顺序排序的数组中找到第一个大于等于给定值key的那个数的索引，
     * 其基本实现原理是二分查找
     */
    public static int lowerBound(int[] nums,int l,int r,int target){
        while(l<r){
            int m = (l+r)/2;
            if(nums[m]>=target) r= m;
            else    l = m +1;
        }
        return l;
    }

    /**
     * upper_bound函数要求在按照非递减顺序排好序的数组中找到第一个大于给定值key的那个数索引，
     * 其基本实现原理是二分查找
     */
    public static int upperBound(int []nums ,int l,int r, int target){
        while(l<r){
            int m = (l+r)/2;
            if(nums[m]<=target) l = m+1;
            else    r = m;
        }
        return l;
    }
}
