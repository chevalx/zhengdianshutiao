package misc.dp;

import array.hard.Solution56;

public class Solution96 {
    public static void main(String[] args) {
        new Solution96().numTrees(5);
    }

    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = 2*dp[i-1];
            for (int j = 2; j <= i-1; j++) {
                // 以j为根的树的数量
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
