package misc.dp;

import annotations.DP;

import java.util.HashMap;
import java.util.Map;

@DP
public class Solution10 {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }



    public boolean dp(String s, int sIndex, String p, int pIndex) {
        // base case
        int m = s.length();
        int n = p.length();
        if (pIndex == n) {
            return sIndex == m;
        }
        if (sIndex == m) {
            if ((n - pIndex) % 2 == 1) {
                return false;
            }
            for (; pIndex+1 < n; pIndex += 2) {
                if (p.charAt(pIndex + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String key = sIndex + "," + pIndex;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean res = false;
        // 选择
        if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') {
            // 匹配
            if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
                // 通配符匹配0次或多次
                res = dp(s, sIndex + 1, p, pIndex) || dp(s, sIndex, p, pIndex + 2);
            } else {
                // 无通配符，普通匹配1次
                res = dp(s, sIndex + 1, p, pIndex + 1);
            }
        } else {
            // 不匹配
            if (pIndex < p.length() + 1 && p.charAt(pIndex + 1) == '*') {
                // 有通配符，只能匹配0次
                res = dp(s, sIndex, p, pIndex + 2);
            } else {
                // 普通匹配不成功
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
