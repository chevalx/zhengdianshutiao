package misc;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 使用了栈或者递归，暂时不知道归于何类
// 用到栈的思路是列清楚遍历到某个索引时有哪些情况，什么情况下出栈，什么情况下压栈
public class Solution394 {
    private int ptr = 0;

    public static void main(String[] args) {
        new Solution394().decodeString("abc3[cd]xyz");
    }

    private String getDigits(String s) {
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr));
            ptr++;
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        StringBuffer res = new StringBuffer();
        Deque<String> stack = new LinkedList<>();
        while (ptr < s.length()) {
            if (Character.isDigit(s.charAt(ptr))) {
                String num = getDigits(s);
                stack.push(num);
            } else if (Character.isLetter(s.charAt(ptr)) || s.charAt(ptr) == '[') {
                stack.push(String.valueOf(s.charAt(ptr)));
                ptr++;
            } else {
                StringBuffer sb = new StringBuffer();
                while (!stack.peek().equals("[")) {
                    String pop = stack.pop();
                    sb.insert(0, pop);
                }
                stack.pop();
                int rep = Integer.parseInt(stack.pop());
                while (rep > 0) {
                    stack.push(sb.toString());
                    rep--;
                }
                ptr++;
            }
        }
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
