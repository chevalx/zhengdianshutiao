package misc.dp;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // base case
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < m) {
                    dp[i][0] = 0;
                    i++;
                }
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                while (i < n) {
                    dp[0][i] = 0;
                    i++;
                }
            } else {
                dp[0][i] = 1;
            }
        }

        // dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
