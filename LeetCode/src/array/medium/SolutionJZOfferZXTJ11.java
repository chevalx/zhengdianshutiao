package array.medium;

import annotations.QianZhuiHe;

import java.util.HashMap;

//https://leetcode-cn.com/problems/contiguous-array/solution/525lian-xu-shu-zu-qian-zhui-he-hashbiao-riqe2/
public class SolutionJZOfferZXTJ11 {
    public static void main(String[] args) {
        new SolutionJZOfferZXTJ11().findMaxLength(new int[]{0,1,0,1});
    }
    @QianZhuiHe
    public int findMaxLength(int[] nums) {
        int preSum = 0;
        HashMap<Integer, Integer> preMap = new HashMap<>();
        int res = 0;
        preMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==0) preSum--;
            else preSum++;
            int preIndex = preMap.getOrDefault(preSum, i);
            if (preIndex == i) {
                preMap.put(preSum, i);
            } else {
                res = Math.max(i - preIndex, res);
            }
        }
        return res;
    }
}
