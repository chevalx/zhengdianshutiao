package array.medium;

import java.util.HashMap;

public class Solution240 {
    private boolean res = false;
    private HashMap<String, Boolean> memo = new HashMap<>();
    public boolean searchMatrix(int[][] matrix, int target) {
        search(matrix, 0, 0, target);
        return res;
    }

    public void search(int[][] matrix, int p, int q, int target) {
        if (p + 1 > matrix.length) {
            return;
        }
        if (q + 1 > matrix[0].length) {
            return;
        }
        if (matrix[p][q] == target) {
            res = true;
            return;
        }
        if (memo.containsKey(p + "+" + q)) {
            return;
        }

        if (matrix[p][q] > target) {
            return;
        }
        if (matrix[p + 1][q] > target) {
            return;
        }
        if (matrix[p][q + 1] > target) {
            return;
        }
        search(matrix, p + 1, q, target);
        search(matrix, p, q + 1, target);
        if (!res) {
            memo.put(p + "+" + q, false);
        }
    }

    public boolean searchMatrixBetter(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            }
        }
        return false;
    }

}
