package misc.HuaDongChuangKou;

import java.util.HashMap;

public class SolutionJZOfferZXTJ009 {
    public static void main(String[] args) {
        int res = new SolutionJZOfferZXTJ009().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        System.out.println(res);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int length = nums.length;
        int res = 0;
        int product = 1;
        while (right < length) {
            product *= nums[right];
            right++;
            while (product >= k && left < right) {
                product /= nums[left];
                left++;
            }
            res += (right - left);
        }
        return res;
    }
}
