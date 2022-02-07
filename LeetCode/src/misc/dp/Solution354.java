package misc.dp;

import java.util.Arrays;
import java.util.Comparator;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return maxSubLength(height);
    }

    private int maxSubLength(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            int maxLength = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxLength = Math.max(maxLength, dp[j]);
                }
            }
            dp[i] = Math.max(maxLength+1, dp[i]);
        }
        int res = dp[0];
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
