package array.medium;

public class SolutionJZOfferZXTJ12 {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }


        for (int i = 1; i < preSum.length; i++) {
            int leftSum, rightSum;
//            if (i == 0) {
//                leftSum = 0;
//                rightSum = preSum[preSum.length-1] - preSum[0];
//                if (leftSum==rightSum) return 0;
//            }
            leftSum = preSum[i-1] - preSum[0];
            rightSum = preSum[preSum.length-1] - preSum[i];
            if (leftSum == rightSum) return i-1;
        }
        return -1;
    }
}
