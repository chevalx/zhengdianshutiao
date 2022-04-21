package misc.dfs;

public class Solution1254 {

    public static void main(String[] args) {
        int res = new Solution1254().closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}});
        System.out.println(res);
    }
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int count = 0;

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            processBound(grid, i, 0);
            processBound(grid, i, grid[i].length - 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            processBound(grid, 0, i);
            processBound(grid, grid.length - 1, i);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
        }
        for (int k = 0; k < directions.length; k++) {
            dfs(grid, i + directions[k][0], j + directions[k][1]);
        }
    }


    public void processBound(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
        }
        for (int k = 0; k < directions.length; k++) {
            processBound(grid, i + directions[k][0], j + directions[k][1]);
        }
    }
}
