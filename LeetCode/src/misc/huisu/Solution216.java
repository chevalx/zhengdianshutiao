package misc.huisu;

import annotations.HuiSu;

import java.util.LinkedList;
import java.util.List;

@HuiSu
public class Solution216 {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList<Integer> combination = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(k, n, nums, combination, 0, used);
        return res;
    }

    private void backtrack(int k, int n, int[] nums, LinkedList<Integer> combination, int startIndex, boolean[] used) {
        int sum = 0;
        for (Integer integer : combination) {
            sum += integer;
        }
        if (sum == n && combination.size() == k) {
            res.add(new LinkedList<>(combination));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            combination.add(nums[i]);
            used[i] = true;
            backtrack(k, n, nums, combination, i + 1, used);
            used[i] = false;
            combination.removeLast();
        }
    }
}
