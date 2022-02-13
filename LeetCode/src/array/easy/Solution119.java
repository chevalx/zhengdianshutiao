package array.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            if (i == 0) {
                level.add(1);
                triangle.add(level);
                continue;
            }
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    level.add(triangle.get(i - 1).get(j));
                } else if (j == i) {
                    level.add(triangle.get(i - 1).get(j - 1));
                } else {
                    level.add(triangle.get(i - 1).get(j) + triangle.get(i - 1).get(j - 1));
                }
            }
            triangle.add(level);
        }
        return triangle;
    }
}
