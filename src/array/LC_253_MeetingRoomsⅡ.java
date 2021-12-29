package array;

import java.util.Arrays;

/*
253. 会议室 II
https://leetcode-cn.com/problems/meeting-rooms-ii/
 */

public class LC_253_MeetingRoomsⅡ {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0, using = 0, res = 0;
        while(i < intervals.length && j < intervals.length) {
            if(start[i] < end[j]) {
                using++;
                i++;
            }else {
                using--;
                j++;
            }
            res = Math.max(using, res);
        }
        return res;
    }
}
