package com.leixiao.leetcode.medium._056;

import com.leixiao.leetcode.structure.Interval;

import java.util.*;

public class Solution {
    //给出一个区间的集合，请合并所有重叠的区间。
    //
    //示例 1:
    //
    //输入: [[1,3],[2,6],[8,10],[15,18]]
    //输出: [[1,6],[8,10],[15,18]]
    //解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //示例 2:
    //
    //输入: [[1,4],[4,5]]
    //输出: [[1,5]]
    //解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> mergeList = new ArrayList<>();
        for (Interval interval : intervals){

        }

        return null;
    }
}
