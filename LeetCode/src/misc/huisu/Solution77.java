package misc.huisu;

import annotations.HuiSu;

import java.util.*;

@HuiSu
public class Solution77 {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> list = new Solution77().combine(n, k);
        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    private List<List<Integer>> res = new LinkedList<>();


    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        LinkedList<Integer> combination = new LinkedList<>();
        backtrack(nums, 0, combination, k);
        return res;
    }

    public void backtrack(int[] nums, int begin, LinkedList<Integer> combination, int k) {
        if (combination.size() == k) {
            res.add(new LinkedList<>(combination));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            combination.add(nums[i]);
            backtrack(nums, i + 1, combination, k);
            combination.removeLast();
        }
    }
}
