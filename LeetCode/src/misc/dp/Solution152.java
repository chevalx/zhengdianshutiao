package misc.dp;

// 维护两个dp数组分别代表最大乘积和最小乘积
// https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/
public class Solution152 {
    public int maxProduct(int[] nums) {
        int[] maxProducts = new int[nums.length];
        int[] minProducts = new int[nums.length];
        maxProducts[0] = nums[0];
        minProducts[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxProducts[i] = Math.max(nums[i], Math.max(maxProducts[i - 1] * nums[i], minProducts[i - 1] * nums[i]));
            minProducts[i] = Math.min(nums[i], Math.min(maxProducts[i - 1] * nums[i], minProducts[i - 1] * nums[i]));
        }
        int res = maxProducts[0];
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(maxProducts[i], res);
        }
        return res;
    }
}
