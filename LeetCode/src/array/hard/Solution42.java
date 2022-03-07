package array.hard;

public class Solution42 {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = height[i];
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = height[i];
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int minHeight = Math.min(leftMax, rightMax);
            res += (minHeight - height[i]);
        }
        return res;
    }

    public int trapBetter(int[] height) {
        int res = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = height.length-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++)
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        return res;
    }
}
