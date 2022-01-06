package jzoffer;

import java.util.Deque;
import java.util.LinkedList;

public class jzoffer_59_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> que = new LinkedList<>();
        for (int i = k, index = 1; i < nums.length; i++) {
            // 维护单调队列
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()]) {
                que.pollLast();
            }
            // 如果队首元素不在滑动窗口的范围内，则移除
            if (!que.isEmpty() && i - que.peekFirst() >= k) {
                que.pollFirst();
            }
            que.addLast(i);
            // 当窗口长度满足要求后才开始统计
            if (i - k + 1 >= 0) {
                res[index++] = nums[que.peekFirst()];
            }
        }
        return res;
    }
}
