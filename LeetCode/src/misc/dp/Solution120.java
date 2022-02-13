package misc.dp;

import java.util.Collections;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> singleLevel = triangle.get(i);
            for (int j = 0; j < singleLevel.size(); j++) {
                if (j == 0) {
                    singleLevel.set(0, singleLevel.get(0) + triangle.get(i - 1).get(0));
                } else if (j == singleLevel.size() - 1) {
                    singleLevel.set(j, singleLevel.get(j) + triangle.get(i - 1).get(singleLevel.size() - 2));
                } else {
                    singleLevel.set(j, Math.min(singleLevel.get(j) + triangle.get(i - 1).get(j),
                            singleLevel.get(j) + triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        return Collections.max(triangle.get(triangle.size() - 1));
    }
}
