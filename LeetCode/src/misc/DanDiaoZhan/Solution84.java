package misc.DanDiaoZhan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 这题考的基础模型其实就是：在一维数组中对每一个数找到第一个比自己小的元素。
 * 这类“在一维数组中找第一个满足某种条件的数”是单调栈的典型应用场景
 *
 * 序号	题目
 * 1	42. 接雨水（困难）	            暴力解法、优化、双指针、单调栈
 * 2	739. 每日温度（中等）	        暴力解法 + 单调栈
 * 3	496. 下一个更大元素 I（简单）	暴力解法、单调栈
 * 4	316. 去除重复字母（困难）	    栈 + 哨兵技巧（Java、C++、Python）
 * 5	901. 股票价格跨度（中等）	    「力扣」第 901 题：股票价格跨度（单调栈）
 * 6	402. 移掉K位数字
 * 7	581. 最短无序连续子数组
 *
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int right_sentinel = heights.length;
        int[] left_side = new int[heights.length];
        int[] right_side = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                Integer top = stack.pop();
            }
            left_side[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int top = stack.pop();
            }
            right_side[i] = stack.isEmpty() ? right_sentinel : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (right_side[i] - left_side[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,4};
        new Solution84().largestRectangleArea(heights);
    }
}
