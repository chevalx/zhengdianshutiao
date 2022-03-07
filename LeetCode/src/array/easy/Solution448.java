package array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] != 1) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                return list;
            } else {
                return new ArrayList<>();
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(i+1);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        return new ArrayList<>(set);
    }
}
