package misc.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ87 {

    public static void main(String[] args) {
        LinkedList<Integer> dots = new LinkedList<>();
        dots.add(2);
        dots.add(4);
        dots.add(6);
        new SolutionJZOfferZXTJ87().restoreIpAddresses("25525511135");
    }

    LinkedList<LinkedList<Integer>> validDots = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        LinkedList<Integer> dots = new LinkedList<>();
        backtrack(s, dots, 1);
        for (LinkedList<Integer> dotSet : validDots) {
            StringBuffer sb = new StringBuffer(s);
            for (int i = 0; i < dotSet.size(); i++) {
                sb.insert(dotSet.get(i) + i, ".");
            }
            results.add(sb.toString());
        }
        return results;
    }

    public void backtrack(String s, LinkedList<Integer> dots, int start) {
        if (dots.size() == 3 && isValid(s, dots)) {
            validDots.add(new LinkedList<>(dots));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // i是字符串的索引
//            if (i <= dots.getLast()) {
//                continue;
//            }
            dots.add(i);
            backtrack(s, dots, i+1);
            dots.removeLast();
        }
    }

    private boolean isValid(String s, LinkedList<Integer> dots) {
        if (dots.size() < 3) {
            return false;
        }
        String sub1 = s.substring(0, dots.get(0));
        String sub2 = s.substring(dots.get(0), dots.get(1));
        String sub3 = s.substring(dots.get(1), dots.get(2));
        String sub4 = s.substring(dots.get(2));
        String[] subs = new String[]{sub1, sub2, sub3, sub4};
        for (int i =0;i<subs.length;i++) {
            String subIP = String.valueOf(subs[i]);
            if (subIP.length() > 1 && subIP.charAt(0) == '0') {
                return false;
            }
            if (subIP.length() <=0 || subIP.length()>3 || Integer.parseInt(subIP)>255) {
                return false;
            }
        }
        return true;
    }
}
