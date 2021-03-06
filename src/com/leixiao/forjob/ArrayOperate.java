package com.leixiao.forjob;

import java.util.*;

public class ArrayOperate {
    //一个n位的数，去掉其中的k位，问怎样去掉使得留下来的那个（n-k）位的数最小？
    //最优解是删除出现的第一个左边>右边的数，因为删除之后高位减小
    public static String removeKForSmall(String str, int k) {
        if (k > str.length()) {
            throw new IllegalArgumentException("k大于数字位数");
        }
        if (k == str.length()) return "";

        int j = 0;
        while (j < k) {
            boolean rise = true;
            for (int i = 0 ; i < str.length()-1 ; i++) {
                if (Integer.parseInt(str.substring(i,i+1)) >
                        Integer.parseInt(str.substring(i+1,i+2))) {
                    str = str.substring(0,i) + str.substring(i+1);
                    j++;
                    rise = false;
                    break;
                }
            }
            while (rise == true) {
                str = str.substring(0,str.length()-k);
                j = k;
            }
        }

        return str;
    }

    //找出来数组中每个元素后边第一个比它大的值
    public static Integer[] getLargest(int[] nums) {
        Integer[] result = new Integer[nums.length];

        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i ; j< nums.length ; j++) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        return result;
    }


    //两个有序数组交集、并集
    //并集
    public static int[] arraySum(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        int i=0, j=0;
        int index = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                result[index++] = array1[i++];
                j++;
            } else if (array1[i] < array2[j]) {
                result[index++] = array1[i++];
            } else {
                result[index++] = array2[j++];
            }
        }

        while (i < array1.length) {
            result[index++] = array1[i++];
        }
        while (j < array2.length) {
            result[index++] = array2[j++];
        }
        return result;
    }

    //交集
    public static int[] arraySet(int[] array1, int[] array2) {
        int[] result = new int[Math.min(array1.length, array2.length)];

        int i=0,j=0;
        int index = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                result[index++] = array1[i++];
                j++;
            } else if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    //有序数组查找重复元素个数
    public static int sameNumSize(int[] array) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(array.length);

        for (int i = 0 ; i < array.length ; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i],map.get(array[i])+1);
            } else {
                map.put(array[i],1);
            }
        }

        for (int i : array) {
            if (map.get(i) == 1) {
                count += map.get(i);
            }
        }
        return array.length-count;
    }

    //快排
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int x = array[start];
            int i = start;
            int j = end;

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
            quickSort(array, start, i-1);
            quickSort(array, i+1, end);
        }
    }

    //一个无序有正有负数组，求乘积最大的三个数的乘积
    public static int threeMaxMultiply(int[] array) {
        if (array.length < 3) {
            throw new IllegalArgumentException("输入数组大小小于3");
        }

        int[] maxArray = new int[3];
        boolean hasZero = false;
        int j = 0;

        for (int i = 0 ; i < array.length && j < 3 ; i++) {
            if (array[i] != 0) {
                maxArray[j] = array[i];
                j++;
            } else {
                hasZero = true;
            }
        }

        int max = maxArray[0] * maxArray[1] * maxArray[2];
        int max1;
        int max2;
        int max3;

        for (; j < array.length ; j++) {
            if (array[j] == 0) {
                hasZero = true;
                continue;
            }

            max = maxArray[0] * maxArray[1] * maxArray[2];
            max1 = maxArray[0] * maxArray[1] * array[j];
            max2 = maxArray[1] * maxArray[2] * array[j];
            max3 = maxArray[0] * maxArray[2] * array[j];

            if (max1 > max) {
                max = max1;
            }
            if (max2 > max) {
                max = max2;
            }
            if (max3 > max) {

            }

            if (max == max1) {
                maxArray[2] = array[j];
            } else if (max == max2) {
                maxArray[0] = array[j];
            } else if (max == max3) {
                maxArray[1] = array[j];
            }
        }

        if (max < 0 && hasZero) {
            return 0;
        }
        return max;
    }


    //单调不递减数组，给一个target，找出大于等于target的下标index
    public static int getLargeThanTarget(int[] array, int target) {
        int left = 0;
        int right = array.length-1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        return right;
    }




}
