package misc.huisu;

import annotations.HuiSu;

@HuiSu
public class Solution79 {
    public static void main(String[] args) {
        Solution79 solution = new Solution79();
        char[][] boards = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean abcced = solution.exist(boards, "ABC");
        System.out.println(abcced);
    }


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int wordIndex, int x, int y) {
        if (x >= board.length || x < 0 || y < 0 || y >= board[0].length || board[x][y] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '\0';
        boolean res = backtrack(board, word, wordIndex + 1, x - 1, y)
                || backtrack(board, word, wordIndex + 1, x + 1, y)
                || backtrack(board, word, wordIndex + 1, x, y - 1)
                || backtrack(board, word, wordIndex + 1, x, y + 1);
        board[x][y] = temp;
        return res;
    }
}

//    private List<Pair> findAdjacent(char[][] board, int x, int y) {
//        List<Pair> adjacents = new ArrayList<>();
//        int maxX = board.length - 1;
//        int maxY = board[x].length - 1;
//        for (int dx = (x > 0 ? -1 : 0); dx <= (x < maxX ? 1 : 0); ++dx) {
//            for (int dy = (y > 0 ? -1 : 0); dy <= (dy < maxY ? 1 : 0); ++dy) {
//                if ((dx == 0 || dy == 0) && (dx + dy != 0)) {
//                    adjacents.add(new Pair(x + dx, y + dy));
//                }
//            }
//        }
//        return adjacents;
//    }
