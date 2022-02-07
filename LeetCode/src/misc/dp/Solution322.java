package misc.dp;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    /**
     * 暴力递归
     *
     * @param coins
     * @param amount
     * @return
     */
    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dp(coins, amount - coins[i]);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 带备忘录的递归
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp2(coins, amount, memo);
    }

    public int dp2(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dp2(coins, amount - coins[i], memo);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
