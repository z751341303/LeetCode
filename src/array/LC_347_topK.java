package array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
347. 前 K 个高频元素
https://leetcode-cn.com/problems/top-k-frequent-elements/
 */

public class LC_347_topK {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1);
        }
        int[] res = new int[k];
        // 建立一个最小优先队列(小顶堆)
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashmap.get(o1) - hashmap.get(o2);
            }
        });
        // 最小优先队列中存放k
        for (int key : hashmap.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (hashmap.get(key) > hashmap.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        while (!pq.isEmpty()) {
            k--;
            res[k] = pq.remove();
        }
        return res;
    }
}
