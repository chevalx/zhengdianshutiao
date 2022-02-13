package misc.dp;

public class Solution45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int minJump = i;
            for (int j = i-1; j >= 0; j--) {
                if (i - j <= nums[j]) {
                    // 才有可能从j一次跳到i
                    minJump = Math.min(minJump, dp[j]+1);
                }
            }
            dp[i] = minJump;
        }
        return dp[nums.length - 1];
    }
}
