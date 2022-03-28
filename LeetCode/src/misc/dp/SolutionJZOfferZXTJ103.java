package misc.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionJZOfferZXTJ103 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ103().coinChange(new int[]{1, 2, 5}, 11);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 初始化，要凑的是0的时候，是没有这样一个方法的
        Arrays.fill(dp[0], amount + 1);
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 0;
        }

        // 迭代
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i - 1] < 0) {
                    // 不选该枚硬币的情况下，凑出j所需要的硬币数
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 对比“不选该枚硬币的情况下，凑出j所需要的硬币数”与“选该枚硬币的情况下，凑出j所需的硬币数是凑出j-coins[i-1]所需要的硬币数+1”
                    // 哪个小选哪个
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        // dp[coins.length][amount] == amount+1
        return dp[coins.length][amount] == amount+1?-1:dp[coins.length][amount];
    }
}
