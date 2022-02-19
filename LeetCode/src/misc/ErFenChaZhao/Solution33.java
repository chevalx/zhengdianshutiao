package misc.ErFenChaZhao;

public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pivot = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i + 1;
                break;
            }
        }
        if (pivot == -1) {
            // 没旋转
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        } else if (target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, pivot, nums.length - 1);
        } else {
            return -1;
        }
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
