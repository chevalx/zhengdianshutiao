package misc.HuaDongChuangKou;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int start = 0, length = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            // 寻找最长应该在内循环外头更新答案
            if (length < right - left) {
                length = right - left;
            }
        }
        return length==Integer.MIN_VALUE ? 0 : length;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}
