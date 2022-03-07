package misc.dp;

public class Solution647 {
    public static void main(String[] args) {
        new Solution647().countSubstrings("aaa");
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        for (int i = 0; i < s.length() -1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
                int left = i-1;
                int right = i+2;
                while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                }
            }
        }
        return count;
    }
}
