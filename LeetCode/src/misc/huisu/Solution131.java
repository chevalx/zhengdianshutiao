package misc.huisu;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    public List<List<String>> partition(String s) {
        return null;
    }

    public void backtrack(String s, int start, StringBuffer buffer) {
        if (isValid(buffer)) {

        }
    }

    public boolean isValid(StringBuffer buffer) {
        return buffer.toString().equals(buffer.reverse().toString());
    }
}
