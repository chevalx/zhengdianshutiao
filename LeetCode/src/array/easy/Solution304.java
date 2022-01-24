package array.easy;

public class Solution304 {
    public static void main(String[] args) {
//        NumMatrix m = new NumMatrix(new int[][]{{3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
//        m.sumRegion(2, 1, 4, 3);
//        m.sumRegion(1, 1, 2, 2);
//        m.sumRegion(1, 2, 2, 4);
        NumMatrix m = new NumMatrix(new int[][]{{-4, -5}});
        m.sumRegion(0, 0, 0, 0);
        m.sumRegion(0, 0, 0, 1);
        m.sumRegion(0, 1, 0, 1);
    }
}

class NumMatrix {

    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            preSum[i][0] = 0;
            for (int j = 1; j <= matrix[0].length; j++) {
                preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += preSum[i][col2 + 1] - preSum[i][col1];
        }
        return sum;
    }
}
