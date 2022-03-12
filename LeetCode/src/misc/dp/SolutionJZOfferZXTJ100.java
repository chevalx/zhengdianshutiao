package misc.dp;

import java.util.List;

public class SolutionJZOfferZXTJ100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int levelNum = triangle.size();
        for (int i = 1; i < levelNum; i++) {
            List<Integer> curLevel = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    curLevel.set(0, curLevel.get(0) + triangle.get(i - 1).get(0));
                } else if (j == i) {
                    curLevel.set(j, curLevel.get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    curLevel.set(j, curLevel.get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
            triangle.set(i, curLevel);
        }
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            res = Math.min(res, triangle.get(triangle.size() - 1).get(i));
        }
        return res;
    }
}
