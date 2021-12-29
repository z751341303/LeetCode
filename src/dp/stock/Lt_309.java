package dp.stock;

/*
在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */

public class Lt_309 {
    /*
    dp[i][0]第i天手上有股票
    dp[i][1]第i天手上没有股票,且不为冷却期
    dp[i][2]第i天为冷却期
    */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        if(n == 0) return 0;

        dp[0][0] = -prices[0];
        for(int i = 1; i < n; i++){
            //持股：第i-1天已经持有 or 当天买入的
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);

            //不持股且不为冷却期:第i-1天也不持股
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2]);

            //不持股且为冷却期:第i-1天卖出
            dp[i][2] = dp[i-1][0] + prices[i];
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
