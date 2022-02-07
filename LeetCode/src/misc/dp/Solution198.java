package misc.dp;

public class Solution198 {
    public static void main(String[] args) {
        new Solution198().rob(new int[]{1, 2, 3, 1});
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] curCouldSteal = new int[nums.length];
        curCouldSteal[0] = nums[0];
        curCouldSteal[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int i1 = nums[i] + curCouldSteal[i - 2];
            if (i1 < curCouldSteal[i - 1]) {
                curCouldSteal[i] = curCouldSteal[i - 1];
            } else {
                curCouldSteal[i] = nums[i] + curCouldSteal[i - 2];
            }
        }
        return curCouldSteal[curCouldSteal.length - 1];
    }
}
