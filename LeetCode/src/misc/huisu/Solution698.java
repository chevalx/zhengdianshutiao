package misc.huisu;

import annotations.HuiSu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@HuiSu
public class Solution698 {
    HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 若总和不为k的整数倍，则一定不能划分
        if (sum % k != 0) {
            return false;
        }
        int subArrayUpper = sum / k;
        int used = 0;
        return backtrack(nums, 0, k, nums[0], subArrayUpper, used);
    }

    public boolean backtrack(int[] nums, int currentSubArraySum, int k, int start, int target, int used) {
        if (k == 0) {
            return true;
        }
        if (currentSubArraySum == target) {
            boolean res = backtrack(nums, 0, k - 1, nums[0], target, used);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }
        for (int i = 0; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (currentSubArraySum + nums[i] > target) {
                continue;
            }
            used |= 1 << i;
            currentSubArraySum += nums[i];
            if (backtrack(nums, currentSubArraySum, k, i + 1, target, used)) {
                return true;
            }
            currentSubArraySum -= nums[i];
            used ^= 1 << i;
        }
        return false;
    }
}

class Solution698_2 {
    HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 若总和不为k的整数倍，则一定不能划分
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int[] bucket = new int[k];
        int target = sum / k;
        return backtrack(nums, 0, bucket, target);
    }

    public boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }
}
