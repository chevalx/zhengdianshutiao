package misc.dp;

import java.util.Arrays;
import java.util.HashMap;

public class Solution55 {
    private HashMap<Integer, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
//        return dp(nums, 0);
        return dp2(nums, new boolean[nums.length]);
    }

    public boolean dp(int[] nums, int curPos) {
        if (curPos == nums.length - 1) {
            return true;
        }

        if (curPos >= nums.length) {
            return false;
        }

        if (nums[curPos] == 0) {
            return false;
        }
        if (memo.containsKey(curPos)) {
            return memo.get(curPos);
        }
        boolean res = false;
        for (int i = 1; i <= nums[curPos]; i++) {
            if (i > nums.length - curPos) {
                break;
            }
            res |= dp(nums, curPos + i);
        }
        memo.put(curPos, res);
        return res;
    }

    public boolean dp2(int[] nums, boolean[] canJumpToThis) {
        Arrays.fill(canJumpToThis, false);
        canJumpToThis[0] = true;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] > nums.length) {
                return true;
            }

            for (int j = 1; j <= nums[i]; j++) {
                if (nums[i] == 0) {
                    continue;
                }
                if (canJumpToThis[i] && (i + j) < nums.length) {
                    canJumpToThis[i + j] = true;
                }
            }
        }
        return canJumpToThis[nums.length - 1];
    }
}
