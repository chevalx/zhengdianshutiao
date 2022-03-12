package misc.dp;

public class Solution97 {
    public static void main(String[] args) {
        new Solution97().isInterleave("db",
                "b",
                "cbb");
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s2.length();
        int n = s1.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        if (s3.equals("")) {
            return true;
        }
        if (s3.length() != m + n) {
            return false;
        }
        // 初始化
        for (int i = 1; i <= n; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[0][i] = true;
            else
                break;
        }
        for (int i = 1; i <= m; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = true;
            else
                break;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(j + i - 1))
                        || (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}
