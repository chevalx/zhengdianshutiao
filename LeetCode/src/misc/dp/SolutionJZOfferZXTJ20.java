package misc.dp;

public class SolutionJZOfferZXTJ20 {
    public static void main(String[] args) {
        int res = new SolutionJZOfferZXTJ20().countSubstrings("aaa");
        System.out.println(res);
    }

    public int countSubstrings(String s) {
        int count = 0;
        // 奇数长度
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }
        // 偶数长度
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int left = i;
                int right = i+1;
                while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                }
            }
        }
        return count;
    }
}
