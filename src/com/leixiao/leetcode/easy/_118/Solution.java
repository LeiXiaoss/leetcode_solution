package com.leixiao.leetcode.easy._118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] temp = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = temp[i-1][j] + temp[i-1][j-1];
                }
            }
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                if (temp[i][j] != 0) {
                    list.add(temp[i][j]);
                }
            }
            result.add(new ArrayList<>(list));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.generate(5);
    }
}
