package misc.huisu;

import annotations.HuiSu;

import java.util.*;

@HuiSu
public class Solution47 {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && used[i] == used[i-1] && !used[i-1]) {
                continue;
            }
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
