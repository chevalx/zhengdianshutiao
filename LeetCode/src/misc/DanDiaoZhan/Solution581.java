package misc.DanDiaoZhan;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return 0;
        }
        int min = nums[nums.length - 1];
        int max = nums[0];
        int begin = 0, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[nums.length - i - 1] > min) {
                begin = nums.length - i - 1;
            } else {
                min = nums[nums.length - i - 1];
            }
        }
        return end - begin + 1;
    }
}
