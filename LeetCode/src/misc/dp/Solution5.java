package misc.dp;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            int maxLength = 1;
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String subString = s.substring(j, i + 1);
                    boolean palindrome = isPalindrome(subString);
                    if (palindrome) {
                        int length = i - j + 1;
                        if (length > maxLength) {
                            dp[i] = length;
                        }
                    }
                }
            }
        }
        int maxLongestIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxLongestIndex]) {
                maxLongestIndex = i;
            }
        }
        return s.substring(maxLongestIndex - dp[maxLongestIndex]+1, maxLongestIndex + 1);
    }

    private boolean isPalindrome(String s) {
        String reversed = new StringBuilder().append(s).reverse().toString();
        return s.equals(reversed);
    }
}
