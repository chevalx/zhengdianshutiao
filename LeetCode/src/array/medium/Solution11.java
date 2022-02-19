package array.medium;

import jdk.nashorn.internal.ir.WhileNode;
import sun.nio.cs.ext.MS874;

public class Solution11 {
    public static void main(String[] args) {
        new Solution11().maxAreaBetter(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int maxLength = height.length - 1;
        int maxCapacity = 0;
        for (int i = 1; i <= maxLength; i++) {
            int iLengthMaxArea = 0;
            for (int j = 0; j <= height.length - 1 - i; j++) {
                int left = j;
                int right = j + i;
                int area = (right - left) * Math.min(height[right], height[left]);
                iLengthMaxArea = Math.max(area, iLengthMaxArea);
            }
            maxCapacity = Math.max(iLengthMaxArea, maxCapacity);
        }
        return maxCapacity;
    }
//  题解  https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
    public int maxAreaBetter(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(area, res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
