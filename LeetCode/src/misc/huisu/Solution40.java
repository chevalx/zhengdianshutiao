package misc.huisu;

import annotations.HuiSu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 */
@HuiSu
public class Solution40 {
    private List<List<Integer>> res;

    public static void main(String[] args) {
        List<List<Integer>> result = new Solution40().combinationSum2(
                new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,
                27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12}, 27);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, target, combination, 0, used);
        return res;
    }

    public void backtrack(int[] candidates, int target, LinkedList<Integer> combination, int startIndex,
                          boolean[] used) {
        int sum = 0;
        for (int integer : combination) {
            sum += integer;
        }
        if (sum == target) {
            res.add(new LinkedList<>(combination));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // !used[i-1]表示没有用过i-1，即当前的i是新开始遍历以i为根的树而遍历到的，而不是在i-1那棵树下遍历到的
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            combination.add(candidates[i]);
            backtrack(candidates, target, combination, i + 1, used);
            used[i] = false;
            combination.removeLast();
        }
    }
}
