package misc.huisu;

import java.util.LinkedList;
import java.util.List;

public class SolutionJZOfferZXTJ84 {
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        int length = nums.length;
        LinkedList<Integer> tmp = new LinkedList<>();
        boolean[] used = new boolean[length];
        backtrack(nums, length,  tmp, used);
        return res;
    }

    private void backtrack(int[] nums, int length, LinkedList<Integer> tmp, boolean[] used) {
        if (tmp.size() == length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 同子树去重
            if (used[i]) {
                continue;
            }
            // 异子树去重，注意排序
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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
