package misc.dp;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionJZOfferZXTJ107 {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new LinkedList<>();
        // 将所有0的位置添加到初始队列中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.pollFirst();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; d++) {
                // 朝 4 个方向进行搜索
                int ni = i + directions[d][0];
                int nj = j + directions[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    res[ni][nj] = res[i][j] + 1;
                    visited[ni][nj] = true;
                    queue.addLast(new int[]{ni, nj});
                }
            }
        }
        return res;
    }
}
