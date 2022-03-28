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

    public int findKthLargestByPartition(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while (true) {
            if (left >= right) {
                return nums[left];
            }
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index+1;
            } else {
                right = index-1;
            }
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        int pivot = nums[lo];

        while (true) {
            while (nums[++i] < pivot) {
                if (i >= hi) break;
            }
            while (nums[--j]>pivot) {
                if (j <= lo) break;
            }
            if (i >= j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = pivot;
        return j;
    }
}
