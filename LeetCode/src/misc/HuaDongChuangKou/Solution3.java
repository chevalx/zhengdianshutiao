package misc.HuaDongChuangKou;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int right = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        while (right < n) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(right - left, res);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}
