package misc.HuaDongChuangKou;

public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int limit = 1;
        int left = 0, right = 0;
        int oneCount = 0, zeroCount = 0;
        int n = nums.length;
        int maxLength = 0;
        while (right < n) {
            if (nums[right] == 1) oneCount++;
            else zeroCount++;
            right++;
            if (zeroCount > limit) {
                if (nums[left] == 1) oneCount--;
                else zeroCount--;
                left++;
            }
            maxLength = Math.max(right - left, maxLength);
        }
        return maxLength;
    }
}
