package misc.dfs;

import annotations.HuaDongCK;

import java.util.Arrays;

public class Solution395 {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] count = new int[26];
        for (int i = l; i <= r; i++) {
            count[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) break;
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

    @HuaDongCK
    public int longestSubstringBetter(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        int res = 0;
        for (int curKind = 1; curKind <= 26; curKind++) {
            int left = 0, right = 0;
            Arrays.fill(cnt, 0);
            int totalKind = 0;
            int sumKind = 0;
            while (right < n) {
                int rightIndex = chars[right] - 'a';
                cnt[rightIndex]++;
                if (cnt[rightIndex] == 1) totalKind++;
                if (cnt[rightIndex] == k) sumKind++;
                while (totalKind > curKind) {
                    int leftIndex = chars[left] - 'a';
                    if (cnt[leftIndex] == 1) totalKind--;
                    if (cnt[leftIndex] == k) sumKind--;
                    cnt[leftIndex]--;
                    left++;
                }
                if (totalKind == sumKind) res = Math.max(res, right - left + 1);
                right++;
            }
        }
        return res;
    }

}
