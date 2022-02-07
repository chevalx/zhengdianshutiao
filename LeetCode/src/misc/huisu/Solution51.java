package misc.huisu;

import annotations.HuiSu;
import misc.HuaDongChuangKou.Solution438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@HuiSu
public class Solution51 {
    private List<List<String>> solutions = new LinkedList<>();

    public static void main(String[] args) {
        new Solution51().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        backtrack(board, 0);
        return solutions;
    }

    private void backtrack(int[][] board, int row) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                char[] chars = new char[board.length];
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1) {
                        chars[j] = 'Q';
                    } else {
                        chars[j] = '.';
                    }
                }
                String s = String.valueOf(chars);
                solution.add(s);
            }
            solutions.add(solution);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board[row][i] = 1;
            backtrack(board, row + 1);
            board[row][i] = 0;
        }
    }

    private boolean isValid(int[][] board, int row, int col) {
        // 检查该列是否有皇后
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // 检查左上是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // 检查右上是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
