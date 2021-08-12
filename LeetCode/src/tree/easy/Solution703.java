package tree.easy;

import java.util.*;

public class Solution703 {
    private PriorityQueue<Integer> elems = new PriorityQueue<>();
    private int k;

    public Solution703(int k, int[] nums) {
        for (int num : nums) {
            elems.offer(num);
        }
        this.k = k;
    }

    public int add(int val) {
        elems.offer(val);
        while (elems.size() > k) {
            elems.poll();
        }
        return elems.peek();
    }
}
