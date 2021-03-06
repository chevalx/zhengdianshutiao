package misc.HuaDongChuangKou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionJZOfferZXTJ15 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0, right = 0;
        int windowSize = s.length();
        for (int i = 0; i < s.length(); i++) {
            need.put(s.charAt(i), need.getOrDefault(s.charAt(i), 0) + 1);
        }
        int length = p.length();
        while (right < length) {
            char c = p.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;
            while (right - left >= windowSize) {
                if (valid == need.entrySet().size()) {
                    res.add(left);
                }
                char d = p.charAt(left);
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
        }
        return res;
    }
}
