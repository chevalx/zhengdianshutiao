package misc.sort;

import annotations.Sort;

@Sort
public class Solution75 {
    // 题目要求原地排序
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(nums, lo, hi);
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = nums[lo];
        while (true) {
            while (nums[++i] < pivot) {
                if (i >= hi) break;
            }
            while (nums[--j] > pivot) {
                if (j <= lo) break;
            }
            if (i >= j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[j];
        nums[j] = pivot;
        nums[lo] = tmp;
        return j;
    }
}
