package backtrack;

import java.util.Arrays;

/*
698. 划分为k个相等的子集
https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
public class LC_698_KSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        if (k == 1) return true;
        // 令每个子集的和为sum
        sum /= k;
        Arrays.sort(nums);
        // 把k个子集看作k个桶，bucket[i] 表示桶的剩余容量
        int[] bucket = new int[k];
        Arrays.fill(bucket, sum);
        // 从最后一个数（经过排序之后是最大的数）开始，如果最大的数大于sum，则可以直接得出false
        return backtrack(nums, k, bucket, nums.length-1);
    }
    boolean backtrack(int[] nums, int k, int[] bucket, int index) {
        // 如果走到头，则表示全部分配完了
        if (index < 0) return true;
        for (int i = 0; i < k; i++) {
            // 对于当前桶，两种情况可以放入：数nums[index]刚好能放入，或者放入之后剩余空间还足够放其他数，排序后nums[0]是最小数
            if (bucket[i] == nums[index] || bucket[i] - nums[index] >= nums[0]) {
                bucket[i] -= nums[index];
                if (backtrack(nums, k, bucket, index - 1)) return true;
                // 撤销选择
                bucket[i] += nums[index];
            }
        }
        return false;
    }
}
