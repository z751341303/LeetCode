package dp;

import java.util.Arrays;
/*
300.最长递增子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */

public class LC_300_LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        //dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度
        int[] dp = new int[n];
        int ans = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC_300_LIS test = new LC_300_LIS();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(test.lengthOfLIS(nums));
    }
}
