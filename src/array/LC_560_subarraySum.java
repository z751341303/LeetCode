package array;

import java.util.HashMap;

public class LC_560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // 表示当前前缀和
        int pre = 0;
        // 存放出现过的前缀和次数
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
