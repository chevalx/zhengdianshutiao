package array.easy;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            } else if (target < sum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
