package misc.dp;

public class SolutionJZOfferZXTJ104 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
