package misc.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        new Solution15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) {
            return new ArrayList<>();
        }
        int target = 0;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twos = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> two : twos) {
                two.add(nums[i]);
                res.add(new ArrayList<>(two));
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    // target 是目标数
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            int loHiSum = nums[lo] + nums[hi];
            int tempHi = nums[hi];
            int tempLo = nums[lo];
            if (loHiSum > target) {
                while (nums[hi] == tempHi && lo < hi) hi--;
            } else if (loHiSum < target) {
                while (nums[lo] == tempLo && lo < hi) lo++;
            } else {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[lo]);
                pair.add(nums[hi]);
                res.add(new ArrayList<>(pair));
                while (nums[hi] == tempHi && lo <= hi) hi--;
                while (nums[lo] == tempLo && lo <= hi) lo++;
            }
        }
        return res;
    }
}
