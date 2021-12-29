package dp.stock;

/*
你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */

public class Lt_122 {
    /*
        dp[i][0]表示不持股：前一天也不持股或当天卖出
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        dp[i][1]表示持股：前一天也持股或当天买入
        dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
    */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; ++i){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    // b. 只要后一天的价格高于前一天的价格就把差值算上
}
