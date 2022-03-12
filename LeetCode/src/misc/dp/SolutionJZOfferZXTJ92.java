package misc.dp;

// https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/solution/zui-gui-fan-de-dong-tai-gui-hua-xie-fa-d-82le/
public class SolutionJZOfferZXTJ92 {
    public static void main(String[] args) {
        System.out.println(new SolutionJZOfferZXTJ92().minFlipsMonoIncr("0101100011"));
    }

    public int minFlipsMonoIncr(String s) {
//        定义dp[i][0], dp[i][0]表示前i个元素递增且第i个元素为0的最小翻转次数，
//        定义dp[i][1]， dp[i][1]表示前i个元素递增且第i个元素为1的最小翻转次数。
        int[][] dp = new int[s.length()][2];
        dp[0][0] = (s.charAt(0) == '0') ? 0 : 1;
        dp[0][1] = (s.charAt(0) == '1') ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = (dp[i][0] + s.charAt(i) == '0' ? 0 : 1);
            dp[i][1] = (Math.min(dp[i][0], dp[i][1]) + (s.charAt(i) == '1' ? 0 : 1));
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}
