package array.easy;

/**
 * 前缀和
 * 前缀和主要适用的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和。
 * 303. 区域和检索 - 数组不可变（简单）
 * 304. 二维区域和检索 - 矩阵不可变（中等）
 * 560. 和为K的子数组（中等）
 */
public class Solution303 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
        numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
        numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }
}

class NumArray {

    int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
