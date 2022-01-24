package array.easy;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        new Solution560().subarraySum(new int[]{1,1,1}, 2);
    }

    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        preSum[0] = 0;
        map.put(preSum[0], 1);
        int sum0_j = 0;
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            sum0_j = preSum[i] - k;
            if (map.containsKey(sum0_j))
                count+=map.get(sum0_j);
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return count;
    }
}
