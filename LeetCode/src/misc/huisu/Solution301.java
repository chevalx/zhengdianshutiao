package misc.huisu;

import java.util.ArrayList;
import java.util.List;


// 题解 https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/shan-chu-wu-xiao-de-gua-hao-by-leetcode-9w8au/
public class Solution301 {
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        // 最多可去除的左括号的数量
        int lremove = 0;
        // 最多可去除的右括号的数量
        int rremove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }

        backtrack(s, 0, lremove, rremove);
        return res;
    }

    public void backtrack(String s, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (lremove + rremove > s.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && s.charAt(i) == '(') {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && s.charAt(i) == ')') {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
