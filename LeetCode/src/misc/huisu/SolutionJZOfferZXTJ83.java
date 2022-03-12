package misc.huisu;

import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ83 {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        int length = nums.length;
        LinkedList<Integer> tmp = new LinkedList<>();
        boolean[] used = new boolean[length];
        backtrack(nums, length,  tmp, used);
        return res;
    }

    private void backtrack(int[] nums, int length,LinkedList<Integer> tmp, boolean[] used) {
        if (tmp.size() == length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            backtrack(nums, length, tmp, used);
            tmp.removeLast();
            used[i] = false;
        }
    }
}
