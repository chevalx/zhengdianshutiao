package array.medium;


import annotations.ErFenChaZhao;
import annotations.HuaDongCK;
import annotations.QianZhuiHe;

import java.util.Arrays;

public class SolutionJZOfferZXTJ008 {
    @QianZhuiHe
    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] >= target) {
                    minLength = Math.min(minLength, j - i);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    @QianZhuiHe
    @ErFenChaZhao
    public int erFen(int target, int[] nums) {
        // 能用二分搜索是因为递增（有序）
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            int toFind = target + preSum[i-1]; // 注意 i - 1
            int searchedPoint = Arrays.binarySearch(preSum, toFind);
            if (searchedPoint < 0) {
                // 没找到
                searchedPoint = -searchedPoint - 1;
            }
            if (searchedPoint <= nums.length) {
                minLength = Math.min(minLength, searchedPoint - i + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        new SolutionJZOfferZXTJ008().erFen(15, new int[]{1, 2, 3, 4, 5});
    }

    @HuaDongCK
    public int slidingWindows(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int subSum = 0;
        while (right < nums.length) {
            subSum += nums[right];
            right++;
            while (subSum >= target) {
                int subLength = right - left;
                minLength = Math.min(subLength, minLength);
                subSum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
