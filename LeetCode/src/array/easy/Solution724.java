package array.easy;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length+1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < preSum.length; i++) {
            int leftSum = preSum[i-1] - preSum[0];
            int rightSum = preSum[preSum.length - 1] = preSum[i];
            if (leftSum == rightSum) return i-1;
        }
        return -1;
    }
}
