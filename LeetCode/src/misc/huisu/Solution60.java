package misc.huisu;

import annotations.HuiSu;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
 */
@HuiSu
public class Solution60 {

    public static void main(String[] args) {
        Solution60 solution = new Solution60();
        String result = solution.getPermutation(4, 9);
        System.out.println(result);
    }

    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> target = new LinkedList<>();
    private int k = 0;
    private boolean found = false;


    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        this.k = k;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : target) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            target = new LinkedList<>(track);
            found = true;
//            count++;
//            if (k == count) {
//                target = new LinkedList<>(track);
//            }
            return;
        }
        if (!found) {
            for (int i = 0; i < nums.length; i++) {
                if (track.contains(nums[i])) {
                    continue;
                }
                int remaining = nums.length - track.size() - 1;
                int leaves = factorialUsingForLoop(remaining);
                if (k > leaves) {
                    k -= leaves;
                    continue;
                }
                track.add(nums[i]);
                backtrack(nums, track);
                track.removeLast();
            }
        }

    }

    public int factorialUsingForLoop(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
