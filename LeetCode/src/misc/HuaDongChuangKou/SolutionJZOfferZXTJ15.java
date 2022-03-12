package misc.HuaDongChuangKou;

import java.util.ArrayList;
import java.util.List;

public class SolutionJZOfferZXTJ15 {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (right <= s.length()) {
            right++;
            while (right-left>3) {
                left++;
            }
            res.add(left);
            left = right;
        }
        return null;
    }
}
