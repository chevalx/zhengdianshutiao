package misc.huisu;

import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ80 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ80().combine(4, 2);
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        boolean[] used = new boolean[n];
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(nums, used, combination, k, 0);
        return res;
    }

    public void backtrack(int[] nums, boolean[] used, LinkedList<Integer> combination, int k, int start) {
        if (combination.size() == k) {
            res.add(new LinkedList<>(combination));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            combination.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, combination, k, i);
            combination.removeLast();
            used[i] = false;
        }
    }
}
