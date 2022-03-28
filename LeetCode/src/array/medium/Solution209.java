package array.medium;

import annotations.ErFenChaZhao;
import annotations.QianZhuiHe;

import java.util.Arrays;
import java.util.HashMap;

public class Solution209 {
    @ErFenChaZhao
    @QianZhuiHe
    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int minLength  = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            int s = target + preSum[i];
            int searchedPoint = Arrays.binarySearch(preSum, s);
            if (searchedPoint < 0) {
                searchedPoint = -searchedPoint-1;
            }
            if (searchedPoint <= nums.length) {
                minLength = Math.min(minLength, searchedPoint - i);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
