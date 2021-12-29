package dp;

/*
55.跳跃游戏
https://leetcode-cn.com/problems/jump-game/
 */

public class LC_55_JumpGame1 {
    // 贪心算法：每次都往尽可能远的地方跳，不断更新所能到达的最远距离
    public boolean canJumpA(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

    // dp
    public boolean canJumpB(int[] nums) {
        // dp[i] 表示能否跳到位置i
        boolean[] dp = new boolean[nums.length];
        // base case
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
