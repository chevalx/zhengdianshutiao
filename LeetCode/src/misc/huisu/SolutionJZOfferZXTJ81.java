package misc.huisu;

import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ81 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ81().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(candidates, target, combination, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, LinkedList<Integer> combination, int start) {
        int sum = 0;
        for (Integer integer : combination) {
            sum += integer;
        }
        if (sum == target) {
            res.add(new LinkedList<>(combination));
            return;
        }
        if (sum >= target) {
            return;
        }
        for(int i = start;i<candidates.length;i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target, combination, i);
            combination.removeLast();
        }
    }
}
