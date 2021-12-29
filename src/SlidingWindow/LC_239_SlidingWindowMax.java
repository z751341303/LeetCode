package SlidingWindow;

/*
239.滑动窗口最大值
https://leetcode-cn.com/problems/sliding-window-maximum/
 */

import java.util.Deque;
import java.util.LinkedList;

public class LC_239_SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0, i = 0;
        for (int right = 0; right < nums.length; right++) {
            // 将不在滑动窗口中的元素删除
            while (!queue.isEmpty() && queue.peekFirst() < left) {
                queue.removeFirst();
            }
            // 当前考察元素大于队尾元素对应的数就弹出队尾元素
            while (!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // 将当前考察元素下标添加到队尾
            queue.addLast(right);
            // 如果窗口长度达到k，则队首元素即为此窗口的最大值
            if (right - left >= k - 1) {
                left++;
                res[i++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
