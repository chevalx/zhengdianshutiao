package misc.DanDiaoZhan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 题解
 * https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        int[] count = new int[256];
        boolean[] isInStack = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;
            if (isInStack[c]) continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                Character popped = stack.pop();
                isInStack[popped] = false;
            }

            stack.push(c);
            isInStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
