package misc.dp;

//https://labuladong.gitee.io/algo/1/12/
public class Solution121 {
    public static void main(String[] args) {
        int res = new Solution121().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 1 代表持有
        // 0 代表不持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1;i < prices.length; i++) {
            // 昨天持有今天卖，昨天不持有今天也不买
            dp[i][0] = Math.max(prices[i] + dp[i-1][1], dp[i-1][0]);
            // 昨天持有今天不卖，昨天不持有今天买
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }
}
