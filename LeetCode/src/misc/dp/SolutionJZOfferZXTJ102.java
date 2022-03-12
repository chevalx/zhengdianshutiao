package misc.dp;

public class SolutionJZOfferZXTJ102 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (((target + sum) & 1) != 0 || sum < target) {
            return 0;
        }
        int p = (sum + target) / 2;
        if (p < 0) {
            return 0;
        }
        // 转化为0-1背包问题，凑出p
        int[][] dp = new int[nums.length + 1][p+1];
        // 初始化
        // 在没有元素的情况下，除了0无法凑出任何数
        for (int j = 1; j <= p; j++) {
            dp[0][j] = 0;
        }
        // 在有了一个元素的情况下，只有一种方法凑出0，就是不选这个数
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }

        // 迭代
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= p; j++) {
                if (j - nums[i-1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 在选nums[i]的情况下，考察没有nums[i]的时候的凑的方法的数目
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i-1]];
                }
            }
        }
        return dp[nums.length][p];
    }
}
