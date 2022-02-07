package misc.huisu;

import annotations.HuiSu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 去重需要先对集合排序
 */
@HuiSu
public class Solution90 {
    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        int[] nums = {1, 2, 2};
        solution.subsetsWithDup(nums);
    }


    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> subset = new LinkedList<>();
        backtrack(nums, 0, used, subset);
        return res;
    }

    public void backtrack(int[] nums, int startIndex, boolean[] used, LinkedList<Integer> subset) {
        res.add(new LinkedList<>(subset));
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            subset.add(nums[i]);
            used[i] = true;
            backtrack(nums, i + 1, used, subset);
            used[i] = false;
            subset.removeLast();
        }
    }
}
