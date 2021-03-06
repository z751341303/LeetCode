import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println('z');
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!que.isEmpty() && nums[i] >= nums[que.peekLast()]) {
                que.pollLast();
            }
            que.addLast(i);
        }
        res[0] = nums[que.peekFirst()];
        for (int i = k, index = 1; i < nums.length; i++) {
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()]) {
                que.pollLast();
            }
            que.addLast(i);
            if (!que.isEmpty() && i - que.peekFirst() >= k) {
                que.pollFirst();
            }
            res[index++] = nums[que.peekFirst()];
        }
        return res;
    }
}