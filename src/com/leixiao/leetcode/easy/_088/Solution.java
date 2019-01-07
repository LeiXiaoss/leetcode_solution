package com.leixiao.leetcode.easy._088;

import java.util.Arrays;

public class Solution {
    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    //
    //说明:
    //
    //初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    //你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    //示例:
    //
    //输入:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //输出: [1,2,2,3,5,6]

    public void merge(int[] nums1,int m,int[] nums2,int n){
        for (int i=m;i<m+n;i++){
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);
    }

    //两个数组均有序，可以用双指针
    public void merge1(int[] nums1,int m,int[] nums2,int n){
        int first = m-1;
        int second = n-1;

        if(m==0){
            for (int i=0;i<nums1.length;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        while (first>=0&&second>=0){
            if(nums1[first] < nums2[second]){
                nums1[m+n-1] = nums2[second];
                second--;
                n--;
            }else {
                nums1[m+n-1] = nums1[first];
                first--;
                m--;
            }
        }
        if (second>=0){
            for (int i=second;i>=0;i--){
                nums1[m+n-1] = nums2[i];
                n--;
            }
        }
    }
}
