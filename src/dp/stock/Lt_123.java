package dp.stock;

/*
你最多可以完成 两笔 交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */

public class Lt_123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int k = 2;
        //dp[i][k][0 or 1] 到第i天最多进行k次交易，1表示持有，0表示不持有
        int[][][] dp = new int[len][k+1][2];

        for(int i = 0; i < len; i++){
            for(int j = 1; j <= k; j++){
                if (i == 0){
                    //第i天，还有j次，手里没有股票，当i=0，手里没股票，最大利润为0
                    dp[i][j][0] = 0;
                    //当i=0，手里有股票，因为还没有盈利，最大利润为 -prices[i]
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                //今天手里没股票，比较MAX（前一天可能没股票 or 前一天有股票但是今天卖出去了，卖出去就有利润，所以+prices[i]）
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                //今天手里有股票，比较MAX（前一天可能有股票 or 前一天没股票但是今天买了，买了就有成本，所以-prices[i]）
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}
