package misc.DanDiaoZhan;

import java.util.Deque;
import java.util.LinkedList;

public class Solution402 {
    public static void main(String[] args) {
        String s = "10";
        String result = new Solution402().removeKdigits(s, 2);
        System.out.println(result);
    }

    public String removeKdigits(String num, int k) {
        if (k > num.length()) {
            return null;
        }
        if (k == 1 && num.length()==1) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        int poppedCount = 0;
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c) {
                if (poppedCount < k) {
                    stack.pop();
                    poppedCount++;
                } else {
                    break;
                }
            }
            stack.push(c);
        }
        if (poppedCount < k) {
            for (int i = poppedCount; i < k; i++) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character character = stack.pop();
            sb.append(character);
        }
        String s = sb.reverse().toString();
        if (s.equals("")) {
            return "0";
        }
        int p = 0;
        while (p < s.length() && s.charAt(p) == '0') {
            p++;
        }
        String res = s.substring(p);
        if (res.equals("")) {
            return "0";
        } else {
            return res;
        }
    }
}
