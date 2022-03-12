package misc.dp;

public class SolutionJZOfferZXTJ90 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ90().rob(new int[]{1, 9, 1, 9, 1});
    }

    public int rob(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        // 分类讨论，偷第一个，不偷第一个
        // 偷第一个，那么最后一个不应该偷
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (i == nums.length - 1) {
                dp[i] = dp[i - 1];
            } else{
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
        }

        // 不偷第一个，那么最后一个看情况偷
        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }
        return Math.max(dp[nums.length - 1], dp2[nums.length - 1]);
    }
}
