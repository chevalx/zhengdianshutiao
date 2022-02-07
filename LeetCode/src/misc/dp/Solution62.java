package misc.dp;

/**
 * leetcode官网图挂了
 * 见https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/medium/62.unique-paths
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] boards = new int[m][n];
        for (int i = 0; i < m; i++) {
            boards[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            boards[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                boards[i][j] = boards[i - 1][j] + boards[i][j - 1];
            }
        }
        return boards[m-1][n-1];
    }
}
