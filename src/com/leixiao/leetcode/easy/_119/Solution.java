package com.leixiao.leetcode.easy._119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> result = new ArrayList<>(rowIndex+1);
        result.add(pre);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                int temp = result.get(j);
                result.set(j, pre + result.get(j));
                pre = temp;
            }
            result.add(1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getRow(4);
        return;
    }
}
