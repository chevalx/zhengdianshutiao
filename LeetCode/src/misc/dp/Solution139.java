package misc.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution139 {
    private boolean res;
    private HashMap<String, Boolean> memo = new HashMap<>();
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> words = new ArrayList<>();
        words.add("cats");
        words.add("dog");
        words.add("sand");
        words.add("and");
        words.add("cat");
        new Solution139().wordBreak(s, words);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.startsWith(wordDict.get(i))) {
                String subStr = s.substring(wordDict.get(i).length());
                res = wordBreak(subStr, wordDict);
                if (res) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}
