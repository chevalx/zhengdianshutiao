package misc.huisu;

import annotations.DP;
import annotations.HuiSu;

@HuiSu
@DP
public class Solution494 {
    private int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, target);
        return count;
    }

    public void backtrack(int[] nums, int i, int rest) {
        if (i == nums.length - 1) {
            if (rest == 0) {
                count++;
            }
            return;
        }

        rest += nums[i];
        backtrack(nums, i + 1, rest);
        rest -= nums[i];

        rest -= nums[i];
        backtrack(nums, i + 1, rest);
        rest += nums[i];
    }
}
