package misc.dp;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
public class Solution32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        char[] charArray = s.toCharArray();
        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            if (charArray[i] == ')') {
                if (charArray[i - 1] == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + dp[i];
                    }
                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && charArray[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if ((i - dp[i - 1] - 2) >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}
