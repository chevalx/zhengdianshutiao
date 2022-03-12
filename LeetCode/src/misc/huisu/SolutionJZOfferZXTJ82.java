package misc.huisu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ82 {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> combination = new LinkedList<>();
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, target, combination, 0, used);
        return res;
    }

    public void backtrack(int[] candidates, int target, LinkedList<Integer> combination, int start, boolean[] used) {
        int sum = 0;
        for (Integer integer : combination) {
            sum += integer;
        }
        if (sum == target) {
            res.add(new LinkedList<>(combination));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            used[i] = true;
            backtrack(candidates, target, combination, i, used);
            used[i] = false;
            combination.removeLast();
        }
    }
}
