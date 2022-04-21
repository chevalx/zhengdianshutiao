package misc.dfs;

import java.util.Scanner;

public class Solution1905 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();


        //        int res = new Solution1905().countSubIslands(
//                new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}},
//                new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}});
//        System.out.println(res);
    }

    private int count;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean isInGrid1 = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j);
                    if (isInGrid1) {
                        count++;
                    }
                    isInGrid1 = true;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i > grid2.length - 1 || j < 0 || j > grid2[0].length - 1 || grid2[i][j] == 0) {
            return;
        }
        if (grid2[i][j] == 1) {
            if (grid1[i][j] != 1) {
                isInGrid1 = false;
            }
            grid2[i][j] = 0;
        }
        for (int k = 0; k < directions.length; k++) {
            dfs(grid1, grid2, i + directions[k][0], j + directions[k][1]);
        }
    }
}
