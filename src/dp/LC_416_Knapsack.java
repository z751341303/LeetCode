package dp;

/*
416.分割等和子集
https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */

public class LC_416_Knapsack {
    /*
    dp[i][j] = x表示，对于前i个物品，当前背包的容量为j时，若x为true，则说明可以恰好将背包装满，若x为false，则说明不能恰好将背包装满
    sum为集合的合，我们想求的最终答案就是dp[N][sum/2]
    base case: dp[..][0] = true   dp[0][..] = false
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n ; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        boolean[][] dp = new boolean[n + 1][sum/2 + 1];

        // base case
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for(int j = 0; j < sum/2 + 1; j++) {
            dp[0][j] = false;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum/2 + 1; j++) {
                // 如果第i个物品无法正好装满背包，取决于上一个状态
                if(nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    /*
                    否则，装入或不装入，满足任意一种情况即为true
                    不装入：情况同上；
                    装入：对于第i-1个物品，重量为j-nums[i-1]能够恰好装满的话，则重量为j时对第i个物品也能恰好装满
                    */
                    dp[i][j] = dp[i-1][j] | dp[i-1][j - nums[i-1]];
                }
            }
        }

        return dp[n][sum/2];
    }

    public static void main(String[] args) {
        LC_416_Knapsack test = new LC_416_Knapsack();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(test.canPartition(nums));
    }
}
