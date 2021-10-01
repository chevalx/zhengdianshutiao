package misc.DanDiaoZhan;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 0) {
            return null;
        }
        if (nums2.length == 1) {
            return new int[]{-1};
        }
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                Integer top = stack.pop();
                nextGreaterMap.put(nums2[top], nums2[i]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            nextGreaterMap.put(nums2[top], -1);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums2 = {1, 3, 4, 2};
        int[] nums1 = {4, 1, 2};
        new Solution496().nextGreaterElement(nums1, nums2);
    }
}
