package misc.huisu;

import annotations.FloodFill;
import annotations.HuiSu;

@HuiSu
@FloodFill
/**
 * 岛屿问题实际上是四叉树问题
 */
public class Solution200 {
    private int count;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution200().numIslands(grid));
    }
    
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    backtrack(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void backtrack(char[][] grid, int x, int y) {
        if (x > grid.length - 1 || x < 0 || y > grid[0].length - 1 || y < 0) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        }
        backtrack(grid, x + 1, y);
        backtrack(grid, x - 1, y);
        backtrack(grid, x, y + 1);
        backtrack(grid, x, y - 1);
    }
}
