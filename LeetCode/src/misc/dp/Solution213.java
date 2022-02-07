package misc.dp;

public class Solution213 {
    public static void main(String[] args) {
        System.out.println(new Solution213().rob(new int[]{1,2,3}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int emitBoth = robRange(nums, 1, nums.length - 2);
        int emitStart = robRange(nums, 1, nums.length - 1);
        int emitEnd = robRange(nums, 0, nums.length - 2);
        return Math.max(emitBoth, Math.max(emitEnd, emitStart));
    }

    // [start...end]
    public int robRange(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        int[] curCouldSteal = new int[end - start + 1];
        curCouldSteal[0] = nums[start];
        curCouldSteal[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < curCouldSteal.length; i++) {
            int i1 = nums[i+start] + curCouldSteal[i - 2];
            if (i1 < curCouldSteal[i - 1]) {
                curCouldSteal[i] = curCouldSteal[i - 1];
            } else {
                curCouldSteal[i] = nums[i+start] + curCouldSteal[i - 2];
            }
        }
        return curCouldSteal[curCouldSteal.length - 1];
    }
}
