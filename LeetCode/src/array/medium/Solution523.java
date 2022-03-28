package array.medium;

import annotations.QianZhuiHe;

import java.util.HashMap;
import java.util.HashSet;

public class Solution523 {
    public static void main(String[] args) {
        new Solution523().checkSubarraySum(new int[]{1, 1}, 1);
    }

    // https://leetcode-cn.com/problems/continuous-subarray-sum/solution/leetcode-523-lian-xu-de-zi-shu-zu-he-by-4psaf/
    // 同余定理
    @QianZhuiHe
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        if (k == 0) return false;
        if (k < 0) k = -k;

        // K = 当前和对k的模值
        // V = 当前模值的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int mod = preSum %k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, map.getOrDefault(mod, 0));
            }
        }
        return false;
    }
}
