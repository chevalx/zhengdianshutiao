package topic.huiwen;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class SolutionJZOfferZXTJ18 {
    public static void main(String[] args) {
        StringBuffer input = new StringBuffer();
        for (int i = 0; i <= 1000000; i++) {
            input.append(0);
        }
        for (int i = 1000000; i >= 0; i--) {
            input.append(0);
        }
        System.out.println(new SolutionJZOfferZXTJ18().isPalindrome(input.toString()));
    }

    public boolean isPalindrome(String s) {
        String removed = remove(s);
        long start = System.currentTimeMillis();
        boolean a = solution1(removed);
        System.out.println("cost1: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        boolean b = solution2(removed);
        System.out.println("cost2: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        boolean c = solution3(removed);
        System.out.println("cost3: " + (System.currentTimeMillis() - start));
        return a && b && c;
    }

    private String remove(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                buffer.append(c);
            }
        }
        return buffer.toString().toLowerCase();
    }

    private boolean solution1(String s) {
        // reverse 最简单的方法
        String split = "";
        StringBuffer reversed = new StringBuffer(s).reverse();
        return s.equals(reversed.toString());
    }

    // 用栈，仅限于已知长度，最慢
    // 先入栈一半，看剩下一半是否与栈里的相同
    private boolean solution2(String s) {
        Deque<Character> stack = new LinkedList<>();
        int pivot = s.length() / 2;
        for (int i = 0; i < pivot; i++) {
            stack.push(s.charAt(i));
        }
        for (int i = (s.length() % 2 == 1) ? (pivot + 1): pivot; i < s.length(); i++) {
            Character popped = stack.pop();
            if (popped != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // 双指针从中间到两头遍历，最快
    public boolean solution3(String s) {
        int left = 0;
        int right = 0;
        if (s.length() % 2 == 1) {
            left = s.length() / 2 - 1;
            right = s.length() / 2 + 1;
        } else {
            left = s.length() / 2 - 1;
            right = s.length() / 2;
        }
        while (left >= 0) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
