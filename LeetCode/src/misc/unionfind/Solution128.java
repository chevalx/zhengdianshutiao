package misc.unionfind;

import java.util.Arrays;

public class Solution128 {
    public static void main(String[] args) {
        new Solution128().longestConsecutive(new int[]{1,2,3,4,5,6,7});
        String str = " as";
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int res = 1;
        for (int i = 0; i <= nums.length - 1; i++) {
            int consecutive = 1;
            int j = i;
            for (; j <= nums.length - 1; j++) {
                if (j == nums.length - 1) {
                    break;
                }
                if (nums[j] + 1 == nums[j + 1]) {
                    consecutive++;
                } else {
                    break;
                }
            }
            res = Math.max(consecutive, res);
            i = j;
        }
        return res;
    }
}
