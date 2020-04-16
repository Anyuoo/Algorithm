package com.anyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。。
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return intervals;

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        for (int right = 1; right < intervals.length; right++) {
            //存在交集
            if (intervals[left][1] >= intervals[right][0]) {
                //将尾值更新
                intervals[left][1] = Math.max(intervals[right][1], intervals[left][1]);
            } else {
                list.add(intervals[left]);
                left = right;
            }
        }
        list.add(intervals[left]);
        return list.toArray(new int[list.size()][2]);
    }
}
