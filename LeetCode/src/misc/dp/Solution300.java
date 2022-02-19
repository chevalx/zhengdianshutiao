package misc.dp;

import annotations.DP;

import java.util.Arrays;

@DP
public class Solution300 {
    public static void main(String[] args) {
        System.out.println(new Solution300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        // dp[i]代表以nums[i]为结尾的最长子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            int maxLength = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    maxLength = Math.max(maxLength, dp[j]);
            }
            dp[i] = Math.max(dp[i], maxLength + 1);
        }

        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
