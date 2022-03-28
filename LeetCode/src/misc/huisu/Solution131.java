package misc.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }
        char[] charArray = s.toCharArray();
        LinkedList<String> subStrings = new LinkedList<>();
        backtrack(charArray, subStrings, 0);
        return res;
    }

    public void backtrack(char[] charArray, LinkedList<String> subStrings, int start) {
        if (start == charArray.length) {
            res.add(new LinkedList<>(subStrings));
            return;
        }
        for (int i = start; i < charArray.length; i++) {
            // i是字符串的索引
            if (!isValid(charArray, start, i)) {
                continue;
            }
            subStrings.add(new String(charArray, start, i + 1 - start));
            backtrack(charArray, subStrings, i + 1);
            subStrings.removeLast();
        }
    }

    public boolean isValid(char[] string, int i, int j) {
        while (i < j) {
            if (string[i] != string[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
