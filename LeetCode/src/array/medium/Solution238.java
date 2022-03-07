package array.medium;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] zhengXu = new int[nums.length + 1];
        zhengXu[0] = 1;
        for (int i = 1; i < zhengXu.length; i++) {
            zhengXu[i] = zhengXu[i - 1] * nums[i - 1];
        }

        int[] niXu = new int[nums.length + 1];
        niXu[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            niXu[i] = niXu[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = zhengXu[i] * niXu[i + 1];
        }
        return res;
    }
}
