package misc.dp;

public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        // 第i天可获得的最大利润
        // 1代表持有，0代表不持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;   // 第一天就持有等于第一天就买，所以base case是-price[0]
        for (int i = 1; i < dp.length; i++) {
            // 今天不持有 = max(昨天持有今天卖，昨天不持有今天也不买)
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            // 今天持有 = max(前天不持有今天买，昨天持有今天不卖)
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee, dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
