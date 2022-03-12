package misc.huisu;

import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ79 {
    private List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        new SolutionJZOfferZXTJ79().subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> subset = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, subset, used, 0);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> subset, boolean[] used, int start) {
        res.add(new LinkedList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            subset.add(nums[i]);
            used[i] = true;
            backtrack(nums, subset, used, i);
            subset.removeLast();
            used[i] = false;
        }
    }
}
