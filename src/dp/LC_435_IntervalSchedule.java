package dp;

/*
435.无重叠区间
https://leetcode-cn.com/problems/non-overlapping-intervals/
 */

import java.util.Arrays;
import java.util.Comparator;

public class LC_435_IntervalSchedule {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        //按每个区间的结束值升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        //不重叠的区间最大数量，至少为1
        int count = 1;
        int end = intervals[0][1];
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
