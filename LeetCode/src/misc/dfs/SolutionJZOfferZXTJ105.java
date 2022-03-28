package misc.dfs;

import annotations.Hash;

import java.util.HashMap;

public class SolutionJZOfferZXTJ105 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ105().maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}});
    }

    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i<m;i++) {
            for (int j = 0;j<n;j++) {
                dfs(grid, visited, i, j, area);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, boolean[][] visited, int i, int j, int area) {
        if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
//        area++;
        int res = 0;
//        maxArea = Math.max(area, maxArea);
        for (int k = 0; k < directions.length; k++) {
            res += dfs(grid, visited, i + directions[k][0], j + directions[k][1], area);
        }
        return 1+ res;
    }
}
