package misc.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionJZOfferZXTJ85 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int leftRemain = 3;
        int rightRemain = 3;
        int length = 2 * n;
        StringBuffer start = new StringBuffer();
        dfs(leftRemain, rightRemain, length, start);
        return res;
    }

    public void dfs(int leftRemain, int rightRemain, int length, StringBuffer parenthesisString) {
        if (leftRemain == 0 && rightRemain == 0 && parenthesisString.length() == length && isValid(parenthesisString.toString())) {
            res.add(parenthesisString.toString());
            return;
        }
        if (leftRemain != 0) {
            leftRemain--;
            parenthesisString.append("(");
            dfs(leftRemain, rightRemain, length, parenthesisString);
            leftRemain++;
            parenthesisString.deleteCharAt(parenthesisString.length() - 1);
        }
        if (rightRemain != 0) {
            rightRemain--;
            parenthesisString.append(")");
            dfs(leftRemain, rightRemain, length, parenthesisString);
            rightRemain++;
            parenthesisString.deleteCharAt(parenthesisString.length() - 1);
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}
