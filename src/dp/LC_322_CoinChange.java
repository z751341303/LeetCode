package dp;

import java.util.Arrays;

/*
322.零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */

public class LC_322_CoinChange {
    //dp[i]表示总金额为i时所需的最少硬币个数

    //暴力递归
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            // 计算子问题结果
            int subProblem = coinChange(coins, amount - coin);
            // 子问题无结果则跳过
            if(subProblem == -1) continue;;
            // 选择最优子问题解
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    // dp_a
    public int coinChangeA(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        //base case
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 0; i < amount + 1; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                } else {
                    continue;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // dp_b
    public int coinChangeB(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount+1];
        //base case
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 0; i < amount + 1; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    if(dp[i - coins[j]] + 1 != Integer.MIN_VALUE)
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    else
                        continue;
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        LC_322_CoinChange test = new LC_322_CoinChange();
        int[] coins = new int[]{1, 2, 5};
        System.out.println(test.coinChange(coins, 11));
    }
}
