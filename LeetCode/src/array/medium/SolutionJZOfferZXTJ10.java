package array.medium;

import java.util.HashMap;

public class SolutionJZOfferZXTJ10 {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }
        int cnt = 0;
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 将前缀和存放在哈希表里，<K, V> 分别为 <preSum, preSum出现的次数>
    // 由于不保证数组是正数，因此preSum出现的次数可能是大于1的，此时会出现两个和为target，而终点一样但是起点不一样的子数组。
    public int hashMap(int[] nums, int k) {
        int preSum = 0;
        HashMap<Integer, Integer> preMap = new HashMap<>();
        int res = 0;
        for (int num:nums) {
            preSum += num;
            res += preMap.getOrDefault(preSum - k, 0);
            preMap.put(preSum, preMap.getOrDefault(preSum - k, 0) + 1);
        }
        return res;
    }
}
