package misc.HuaDongChuangKou;

public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;
        int res = 0;
        int oneCount = 0;
        int zeroCount = 0;
        while (right < n) {
            if (nums[right] == 1) oneCount++;
            else zeroCount++;
            right++;
            if (zeroCount > k) {
                if (nums[left] == 1) oneCount--;
                else zeroCount--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
