package misc.huisu;

import annotations.HuiSu;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@HuiSu
public class Solution78 {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(nums, combination, 0);
        LinkedList<Integer> allSet = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            allSet.add(nums[i]);
        }
        res.add(new LinkedList<>(allSet));
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> combination, int begin) {
        res.add(new LinkedList<>(combination));
        if (combination.size() == nums.length - 1) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            combination.add(nums[i]);
            backtrack(nums, combination, i+1);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> subsets = solution.subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
