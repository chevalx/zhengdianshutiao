package misc.dp;

import annotations.DP;

@DP
// LCS 问题
public class Solution1143 {
    public static void main(String[] args) {


        System.out.println(new Solution1143().longestCommonSubsequence("abcde", "acf"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == (text2.charAt(j-1))) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    private int max(int i1, int i2, int i3) {
        return Math.max(Math.max(i1, i2), i3);
    }
}
