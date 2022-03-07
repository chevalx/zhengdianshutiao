package array.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution215 {
    public static void main(String[] args) {
        int kthLargest = new Solution215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int num : nums) {
            maxHeap.offer(num);
        }
        for (int i = 0; i < k-1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
