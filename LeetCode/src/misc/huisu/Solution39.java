package misc.huisu;

import annotations.HuiSu;
import misc.HuaDongChuangKou.Solution3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@HuiSu
public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        solution39.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> integers : solution39.res) {
            System.out.println("----");
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        }
    }
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(candidates, target, combination, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, LinkedList<Integer> combination, int startIndex) {
        int sum = 0;
        for (Integer integer : combination) {
            sum += integer;
        }
        if (sum == target) {
            res.add(new LinkedList<>(combination));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target, combination, i);
            combination.removeLast();
        }
    }
}
