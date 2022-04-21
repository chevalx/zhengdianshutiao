package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionJZOfferZXTJ035 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ035().findMinDifference(new ArrayList<>(Arrays.asList("00:00", "23:59", "12:25")));
    }
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            String s1 = timePoints.get(i);
            String s2 = timePoints.get((i + 1) % timePoints.size());
            res = Math.min(res, getDifferenceMinute(s1, s2));
        }
        return res;
    }

    private int getDifferenceMinute(String s1, String s2) {
        // s1 < s2
        int s1Minute = Integer.parseInt(s1.substring(0, 2)) * 60 + Integer.parseInt(s1.substring(3));
        int s2Minute = Integer.parseInt(s2.substring(0, 2)) * 60 + Integer.parseInt(s2.substring(3));
        int difference =  Math.abs(s2Minute-s1Minute);
        return Math.min(difference, 24 * 60 - difference);
    }
}
