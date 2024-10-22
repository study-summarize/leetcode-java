package org.github.fourth.leetcode;

import org.github.fourth.Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
@Top100
public class LeetCode_056_merge {

    /**
     * 对数组左区间进行排序
     * 然后就只需要判断 pre[1] next[0]大小关系即可
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }

        // 按照数组左端点进行排序
        Arrays.sort(intervals, (x, y) -> {
            return x[0] - y[0];
        });

        List<int[]> result = new ArrayList<>();
        // 这个为了防止intervals长度为1
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = result.get(result.size() - 1);
            // 不能合并
            if (currentInterval[1] < intervals[i][0]) {
                result.add(intervals[i]);
            }
            else {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
