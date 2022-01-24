package array.easy;

public class Solution1094 {
    public static void main(String[] args) {
        int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};
        new Solution1094().carPooling(trips, 3);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        // 先遍历得到终点
        int maxEnd = 0;
        for (int i = 0; i < trips.length; i++) {
            int end = trips[i][2];
            maxEnd = Math.max(maxEnd, end);
        }
        // 该数组表示第[i]站时，乘客的数量
        int[] diff = new int[maxEnd + 1];
        for (int i = 0; i < trips.length; i++) {
            int passengers = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            diff[start] += passengers;
            if (end < maxEnd) {
                diff[end] -= passengers;
            }
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        int maxPassengerNum = diff[0];
        for (int i = 0; i < diff.length; i++) {
            maxPassengerNum = Math.max(maxPassengerNum, diff[i]);
        }
        if (maxPassengerNum > capacity) {
            return false;
        }
        return true;
    }
}
