package misc.dp;

public class SolutionJZOfferZXTJ99 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ99().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }

    public int minPathSum(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];
        // 初始化
        matrix[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            matrix[i][0] = matrix[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = grid[i][j] + Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
        return matrix[grid.length - 1][grid[0].length - 1];
    }
}
