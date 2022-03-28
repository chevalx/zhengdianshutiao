package misc.huisu;

import annotations.HuiSu;

import java.util.*;

@HuiSu
public class Solution47 {

    public static void main(String[] args) {
        List<List<Integer>> results = new Solution47().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> result : results) {
            for (Integer integer : result) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    private List<List<Integer>> res = new LinkedList<>();
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        LinkedList<Integer> permutation = new LinkedList<>();
        backtrack(nums, permutation);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> permutation) {
        if (permutation.size() == nums.length) {
            res.add(new LinkedList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, permutation);
            used[i] = false;
            permutation.removeLast();
        }
    }
}
