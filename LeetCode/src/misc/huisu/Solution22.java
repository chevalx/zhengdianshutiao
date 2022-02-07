package misc.huisu;

import annotations.HuiSu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@HuiSu
public class Solution22 {
    private char leftBracket = '(';
    private char rightBracket = ')';
    private List<String> res = new LinkedList<>();
    private char[] LRbrackets = new char[]{leftBracket, rightBracket};

    public static void main(String[] args) {
        LinkedList<Character> chars = new LinkedList<>();
        chars.add('(');
        chars.add('(');
        chars.add(')');
        chars.add('(');
        chars.add(')');
        chars.add(')');
        boolean res = new Solution22().isValid(chars);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        LinkedList<Character> brackets = new LinkedList<>();
        backtrack(n, 0, brackets);
        return res;
    }


    public void backtrack(int n, int slotIndex, LinkedList<Character> brackets) {
        if (slotIndex == 2 * n) {
            if (isValid(brackets)) {
                StringBuilder sb = new StringBuilder();
                for (Character bracket : brackets) {
                    sb.append(bracket);
                }
                res.add(sb.toString());
                return;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            brackets.add(LRbrackets[i]);
            backtrack(n, slotIndex + 1, brackets);
            brackets.removeLast();
        }
    }

    public boolean isValid(LinkedList<Character> brackets) {
        if (brackets.get(0).equals(')')) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < brackets.size(); i++) {
            Character bracket = brackets.get(i);
            if (bracket.equals('(')) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
