package misc.dp;

/**
 * 转化为0-1背包问题
 */
public class Solution416 {
    public static void main(String[] args) {
        new Solution416().canPartition(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，无法放入第i件物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
