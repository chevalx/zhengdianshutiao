package array.medium;

import java.util.HashMap;

public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt = 0;
        HashMap<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int s = preSum - goal;
            cnt += preMap.getOrDefault(s, 0);
            preMap.put(preSum, preMap.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
