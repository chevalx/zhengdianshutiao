package misc.huisu;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution139 {
    private HashMap<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("pen");
        new Solution139().wordBreak("applepenapple", words);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        String substring = "";
        for (int i = 0; i < wordDict.size(); i++) {
            boolean res = false;
            if (s.startsWith(wordDict.get(i))) {
                substring = s.substring(wordDict.get(i).length());
                res = wordBreak(substring, wordDict);
            }
            if (res) {
                memo.put(substring, true);
                return true;
            }
        }
        memo.put(substring, false);
        return false;
    }
}
