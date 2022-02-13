package misc.dp;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 第i天可获得的最大利润
        // k 代表可以交易几次
        // 1代表持有，0代表不持有
        int maxK = k;
        int[][][] dp = new int[prices.length][maxK + 1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int ik = maxK; ik >= 1; ik--) {
                if (i - 1 < 0) {
                    dp[i][ik][0] = 0;
                    dp[i][ik][1] = -prices[i];
                    continue;
                }
                // 今天不持有 = max(昨天持有今天卖，昨天不持有今天也不买)
                dp[i][ik][0] = Math.max(dp[i - 1][ik][1] + prices[i], dp[i - 1][ik][0]);
                // 今天持有 = max(昨天不持有今天买，昨天持有今天不卖)
                dp[i][ik][1] = Math.max(dp[i - 1][ik - 1][0] - prices[i], dp[i - 1][ik][1]);
            }
        }
        return dp[prices.length - 1][maxK][0];
    }
}
