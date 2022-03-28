package misc.HuaDongChuangKou;

import java.util.HashMap;
import java.util.Objects;

public class SolutionJZOfferZXTJ14 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0, right = 0;
        int windowSize = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int length = s2.length();
        while (right < length) {
            char c = s2.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            while (right - left >= windowSize) {
                if (valid == need.entrySet().size()) {
                    return true;
                }
                char d = s2.charAt(left);
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
        }
        return false;
    }
}
