package misc.DanDiaoZhan;

import java.util.Deque;
import java.util.LinkedList;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) {
            return null;
        }
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer top = stack.pop();
                ans[top] = i - top;
            }
            stack.push(i);
        }


//        int[] ans = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            int dayCount = 0;
//            for (int j = i; j < temperatures.length && temperatures[j] <= temperatures[i]; j++) {
//                dayCount++;
//                if (j == temperatures.length - 1) {
//                    dayCount = 0;
//                }
//            }
//            ans[i] = dayCount;
//        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] counts = new Solution739().dailyTemperatures(t);
        for (int i = 0; i < counts.length; i++) {
            System.out.print(counts[i] + " ");
        }
    }
}
