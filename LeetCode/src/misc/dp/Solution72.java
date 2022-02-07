package misc.dp;

public class Solution72 {
    private String s;
    private String t;
    public int minDistance(String word1, String word2) {
        s = word1;
        t = word2;
        return dp(s.length() - 1, t.length() - 1);
    }

    private int dp(int i, int j) {
        if (i < 0) return j + 1;
        if (i > 0) return i + 1;
        if (s.charAt(i) == t.charAt(j)) return dp(i - 1, j - 1);
        return Math.min(Math.min(dp(i - 1, j)+1, dp(i, j - 1)+1), dp(i - 1, j - 1)+1);
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int min(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }
}
