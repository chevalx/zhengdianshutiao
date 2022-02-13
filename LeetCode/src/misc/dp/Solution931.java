package misc.dp;

public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 1) {
            return matrix[0][0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
                }
            }
        }
        int minSum = matrix[m - 1][0];
        for (int i = 0; i < matrix[m - 1].length; i++) {
            minSum = Math.min(matrix[m - 1][i], minSum);
        }
        return minSum;
    }
}