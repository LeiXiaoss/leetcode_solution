package com.leixiao.leetcode.hard._057;

import com.leixiao.leetcode.structure.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给出一个无重叠的 ，按照区间起始端点排序的区间列表。
    //
    //在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
    //
    //示例 1:
    //
    //输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
    //输出: [[1,5],[6,9]]
    //示例 2:
    //
    //输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //输出: [[1,2],[3,10],[12,16]]
    //解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

    public List<Interval> insert(List<Interval> intervals,Interval newInterval){
        List<Interval> result = new ArrayList();

        for (Interval item : intervals){
            if(newInterval == null || item.end < newInterval.start){
                result.add(item);
            }else if(item.start > newInterval.end){
                result.add(newInterval);
                result.add(item);
                newInterval = null;
            }else {
                newInterval.start = Math.min(newInterval.start,item.start);
                newInterval.end = Math.max(newInterval.end,item.end);
            }
        }

        if(newInterval != null){
            result.add(newInterval);
        }
        return result;
    }

    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));

        Interval newInterval = new Interval(2,5);

        Solution solution = new Solution();
        List<Interval> result = solution.insert(intervals,newInterval);
        System.out.println(result);
    }
}
