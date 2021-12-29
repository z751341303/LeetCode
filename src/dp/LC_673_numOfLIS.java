package dp;

import java.util.Arrays;

/*
673.最长上升子序列的个数
https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 */

public class LC_673_numOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // dp[i]表示以nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[n];
        // combination[i]记录nums[i]结尾的子序列的数量
        int[] comb = new int[n];
        // base case : 非空数组的默认最长上升子序列长度为1
        int len = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(comb, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        // 最长上升子序列的长度增加了，个数没有变
                        dp[i] = dp[j] + 1;
                        comb[i] = comb[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        // 出现了之前的最长长度加上当前项与当前最长长度相等的情况，个数增多
                        comb[i] += comb[j];
                    }
                }
            }
            len = Math.max(len, dp[i]);
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == len)
                num += comb[i];
        }

        return num;
    }
}
