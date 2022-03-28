package array.medium;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution974 {
    public static void main(String[] args) {
        int out = new Solution974().subarraysDivByK(new int[]{-7,2,3,0,-9}, 3);
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(4);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    //同余定理
    public int subarraysDivByK(int[] nums, int k) {
        int preSum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 比如-3 % 7 = -3, 4 % 7 = 4。 -3 和 4应该记到一组里面，因为 4 - (-3) = 7, 7 % 7 = 0; 就得把-3 转成正数的余数4
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int mod = (preSum % k + k) %k;
            if (map.containsKey(mod)) {
                res += map.get(mod);
                map.put(mod, map.get(mod) + 1);
            } else {
                map.put(mod, 1);
            }
        }
        return res;
    }
}
