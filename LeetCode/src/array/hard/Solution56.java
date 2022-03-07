package array.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Solution56 {

    public static void main(String[] args) {
        new Solution56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty()) {
                stack.push(intervals[i]);
            } else {
                int[] interval = intervals[i];
                int[] stackTop = stack.peek();
                if (canMerge(stackTop, interval)) {
                    int[] merged = mergeTwo(stackTop, interval);
                    stack.pop();
                    stack.push(merged);
                } else {
                    stack.push(interval);
                }
            }
        }
        int[][] res = new int[stack.size()][2];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }

    private int[] mergeTwo(int[] interval1, int[] interval2) {
        int[] res = new int[2];
        res[0] = Math.min(interval1[0], interval2[0]);
        res[1] = Math.max(interval1[1], interval2[1]);
        return res;
    }

    private boolean canMerge(int[] interval1, int[] interval2) {
        if (interval1[1] < interval2[0]) {
            return false;
        }
        return true;
    }
}
