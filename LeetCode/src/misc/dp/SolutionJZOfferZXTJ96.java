package misc.dp;

// https://leetcode-cn.com/problems/IY6buf/solution/jian-zhi-offer-2-mian-shi-ti-96-shu-zhon-5kc7/
public class SolutionJZOfferZXTJ96 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length() && s1.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= s2.length() && s2.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[0][i] = true;
        }
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j-1);
                dp[i][j] = ((c1 == c3 && dp[i - 1][j]) || (c2 == c3 && dp[i][j - 1]));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
