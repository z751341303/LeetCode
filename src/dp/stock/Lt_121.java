package dp.stock;

/*
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 */

public class Lt_121 {
    /*
        a.
        dp[i][0]表示不持股：前一天也不持股或前一天持股当天卖出
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        dp[i][1]表示持股：前一天也持股或前一天不持股当天买入
        dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
    */

    public int maxProfitA(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // -prices[i]:只允许交易一次，因此手上的现金数就是当天的股价的相反数
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    //b. dp[i] = max(res, prices[i] - 前面几天的最小值)
    public int maxProfitB(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[] dp = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            dp[i] = Math.max(dp[i-1], prices[i]-min);
        }
        return dp[prices.length-1];
    }
}
